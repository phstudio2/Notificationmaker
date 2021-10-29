package com.phstudio.notificationmaker

import android.annotation.SuppressLint
import android.app.*
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.phstudio.notificationmaker.R.*
import com.phstudio.notificationmaker.R.drawable.*
import com.phstudio.notificationmaker.another.AnotherActivity
import com.phstudio.notificationmaker.broadcast.AlarmBroadcast
import com.phstudio.notificationmaker.color.ColorActivity
import com.phstudio.notificationmaker.dialog.DialogActivity
import com.phstudio.notificationmaker.icon.IconActivity
import com.phstudio.notificationmaker.image.ImageActivity
import java.io.File
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    var timeselectedbutton = 0
    var timeTonotify: String? = null
    var dateTonotify: String? = null
    var small_icon = (ic001)
    var big_icon = (ic001)
    var nextsmall_icon = (ic001)
    var nextbig_icon = (ic001)
    var color_text = (color.black)
    var notify_color: Boolean = true
    var typenotify = "default"
    var imageUri: Bitmap? = null
    var string1: String = ""
    var string2: String = ""
    var remove: Boolean = false
    var nextstring1: String = ""
    var nextstring2: String = ""
    var nextremove: Boolean = false
    var formatedtime_time = ""
    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelId = "notification"
    private val description = "Default"
    var notificationId = 0
    lateinit var btn_send: Button
    lateinit var text_label: EditText
    lateinit var text_title: EditText
    lateinit var newIdCheckBox: CheckBox
    lateinit var removeCheckBox: CheckBox
    lateinit var time_btn: Button
    lateinit var button_style: ToggleButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        val sharedPreferences = getSharedPreferences(
            resources.getString(string.app_package),
            Context.MODE_PRIVATE
        )
        val editor = getSharedPreferences(
            resources.getString(string.app_package),
            Context.MODE_PRIVATE
        ).edit()

        val btn_selectcolor = findViewById<Button>(id.btn_selectcolor)
        btn_send = findViewById(id.btn_send)
        text_title = findViewById(id.text_title)
        text_label = findViewById(id.text_label)
        newIdCheckBox = findViewById(id.create_new_id_checkbox)
        removeCheckBox = findViewById(id.remove)
        time_btn = findViewById(id.time)
        button_style = findViewById(id.button_style)

        if (sharedPreferences.getString("text_title", "") != null) {
            text_title.setText(sharedPreferences.getString("text_title", ""))
        }
        if (sharedPreferences.getString("text_label", "") != null) {
            text_label.setText(sharedPreferences.getString("text_label", ""))
        }
        if (sharedPreferences.getString("time_btn", "") != "") {
            time_btn.text = sharedPreferences.getString("time_btn", "")
            dateTonotify = sharedPreferences.getString("dateTonotify", "")
            timeTonotify = sharedPreferences.getString("timeTonotify", "")
            timeselectedbutton = 1
        } else {
            time_btn.text = getString(string.select_time)
            timeselectedbutton = 0
        }
        newIdCheckBox.isChecked = sharedPreferences.getBoolean("newIdCheckBox", true)
        removeCheckBox.isChecked = sharedPreferences.getBoolean("removeCheckBox", true)
        button_style.isChecked = sharedPreferences.getBoolean("button_style", true)

        val imagepicture = sharedPreferences.getString("picture", "")

        val changepicture = findViewById<ImageButton>(id.changepicture)
        val view9 = findViewById<View>(id.view9)
        val picturetext = findViewById<TextView>(id.picturetext)

        if (!button_style.isChecked) {
            val filenameandress = File(
                Environment.getExternalStorageDirectory().toString(),
                getString(string.app_name) + "/${imagepicture}.jpg"
            )
            imageUri = if (filenameandress.exists()) {
                val filename = (File(
                    Environment.getExternalStorageDirectory().toString(),
                    getString(string.app_name) + "/${imagepicture}.jpg"
                )).toString()
                val bitmap: Bitmap = BitmapFactory.decodeFile(filename)
                (bitmap)
            } else {
                BitmapFactory.decodeResource(resources, (pic001))
            }
            view9.visibility = View.VISIBLE
            picturetext.visibility = View.VISIBLE
            changepicture.visibility = View.VISIBLE
            changepicture.setImageBitmap(imageUri)
        } else {
            view9.visibility = View.GONE
            picturetext.visibility = View.GONE
            changepicture.visibility = View.GONE
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val colored = sharedPreferences.getBoolean("colored", false)

            if (colored) {
                val setBackgroundResource = sharedPreferences.getInt("setBackgroundResource", 0)
                val backgroundTintList = sharedPreferences.getInt("backgroundTintList", 0)
                btn_selectcolor.setBackgroundResource(setBackgroundResource)
                btn_selectcolor.backgroundTintList =
                    ColorStateList.valueOf(resources.getColor(backgroundTintList))
                color_text = resources.getColor(backgroundTintList)
            } else {
                val White = sharedPreferences.getString("White", "")
                when (White) {
                    "White" -> {
                        btn_selectcolor.setBackgroundResource(white_ring)
                        btn_selectcolor.backgroundTintList = (null)
                        color_text = resources.getColor(color.White)
                    }
                    "Custom" -> {

                        btn_selectcolor.setBackgroundResource(text_color)
                        val custom = sharedPreferences.getString("custom", "")
                        color_text = Color.parseColor(custom)
                        btn_selectcolor.backgroundTintList =
                            ColorStateList.valueOf(Color.parseColor(custom))
                    }
                    else -> {
                        btn_selectcolor.setBackgroundResource(ic_none)
                        btn_selectcolor.backgroundTintList =
                            ColorStateList.valueOf(resources.getColor(color.Black))
                    }
                }
            }
        }

        val small = sharedPreferences.getInt("small", 0)

        small_icon = when (small) {
            0 -> {
                (ic001)
            }
            else -> {
                (small)
            }
        }

        val selectsmall = findViewById<ImageButton>(id.btn_selectsmallicon)
        selectsmall.setImageResource(small_icon)

        val big = sharedPreferences.getInt("big", 0)

        big_icon = when (big) {
            0 -> {
                (ic001)
            }
            else -> {
                (big)
            }
        }

        val selectbig = findViewById<ImageButton>(id.btn_selectbigicon)
        selectbig.setImageResource(big_icon)

        val fb_another = findViewById<FloatingActionButton>(id.history)
        fb_another.setOnClickListener {
            val data = sharedPreferences.getString("data", "")
            val send = sharedPreferences.getString("send", "")

            if (data == "Yes") {
                if (send == "No") {
                    val anotherclass: AnotherActivity by lazy {
                        AnotherActivity()
                    }
                    anotherclass.nextdialog(this@MainActivity)
                } else if (send == "Yes") {
                    donthavenotify()
                }
            } else {
                donthavenotify()
            }
        }

        val fb_dialog = findViewById<FloatingActionButton>(id.fb_dialog)
        fb_dialog.setOnClickListener {
            val dialogclass: DialogActivity by lazy {
                DialogActivity()
            }
            dialogclass.dialog(this@MainActivity)
        }

        if (imageUri == null) {
            imageUri = BitmapFactory.decodeResource(this.resources, (pic001))
        }

        button_style.setOnClickListener {
            if (button_style.isChecked) {
                val animationGone = AnimationUtils.loadAnimation(this, anim.visiblegone)
                view9.startAnimation(animationGone)
                picturetext.startAnimation(animationGone)
                changepicture.startAnimation(animationGone)
                Handler().postDelayed({
                    view9.visibility = View.GONE
                    picturetext.visibility = View.GONE
                    changepicture.visibility = View.GONE
                }, 500)
            } else {
                view9.visibility = View.VISIBLE
                picturetext.visibility = View.VISIBLE
                changepicture.visibility = View.VISIBLE
                val animationView = AnimationUtils.loadAnimation(this, anim.visible)
                view9.startAnimation(animationView)
                picturetext.startAnimation(animationView)
                changepicture.startAnimation(animationView)
            }
        }

        changepicture.setOnClickListener {
            textbackup()
            val intent = Intent(this@MainActivity, ImageActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }

        time_btn.setOnClickListener {
            timeselectedbutton++
            selectDate()
        }

        btn_selectcolor.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                textbackup()
                val intent = Intent(this@MainActivity, ColorActivity::class.java)
                startActivity(intent)
                overridePendingTransition(0, 0)
            } else {
                Toast.makeText(this, getString(R.string.notsupport), Toast.LENGTH_SHORT).show()
            }
        }

        selectsmall.setOnClickListener {
            textbackup()
            val intent = Intent(this@MainActivity, IconActivity::class.java)
            intent.putExtra("size", "small")
            startActivity(intent)
            overridePendingTransition(0, 0)
        }

        selectbig.setOnClickListener {
            textbackup()
            val intent = Intent(this@MainActivity, IconActivity::class.java)
            intent.putExtra("size", "big")
            startActivity(intent)
            overridePendingTransition(0, 0)
        }

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        btn_send.setOnClickListener {
            string1 = text_title.text.toString()
            string2 = text_label.text.toString()
            remove = !removeCheckBox.isChecked

            if (timeselectedbutton > 0) {
                nextsmall_icon = small_icon
                nextbig_icon = big_icon
                nextstring1 = text_title.text.toString()
                nextstring2 = text_label.text.toString()
                nextremove = !removeCheckBox.isChecked

                editor.putString("data", "Yes")
                editor.putInt("nextsmall_icon", nextsmall_icon)
                editor.putInt("nextbig_icon", nextbig_icon)
                editor.putString("nextstring1", nextstring1)
                editor.putString("nextstring2", nextstring2)
                editor.putBoolean("nextremove", nextremove)
                editor.putInt("color", color_text)
                editor.putBoolean("notify_color", notify_color)
                editor.putString("send", "No")
                editor.putString("save", "Yes")

                val White = sharedPreferences.getString("White", "")
                val custom = sharedPreferences.getString("custom", "")

                editor.putString("nextWhite", White).apply()
                editor.putString("nextcustom", custom).apply()

                if (button_style.isChecked) {
                    typenotify = "bigtext"
                    editor.putString("nextbutton_style", typenotify).apply()
                } else {
                    typenotify = "picture"
                    editor.putString("nextbutton_style", typenotify).apply()
                }
                val help_PictureName = sharedPreferences.getString("picture", "")
                editor.putString("nextpicture", help_PictureName).apply()
                setAlarm()
            }

            if (timeselectedbutton <= 0) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    if (notify_color) {
                        val intent = Intent(this, MainActivity::class.java)
                        val pendingIntent =
                            PendingIntent.getActivity(
                                this,
                                0,
                                intent,
                                PendingIntent.FLAG_UPDATE_CURRENT
                            )
                        notificationChannel = NotificationChannel(
                            channelId,
                            description,
                            NotificationManager.IMPORTANCE_HIGH
                        )
                        notificationChannel.enableLights(true)
                        notificationChannel.lightColor = color_text
                        notificationChannel.enableVibration(true)
                        notificationManager.createNotificationChannel(notificationChannel)
                        typenotify = if (button_style.isChecked) {
                            "bigtext"
                        } else {
                            "picture"
                        }

                        if (typenotify == "bigtext") {
                            builder = Notification.Builder(this, channelId)
                                .setOngoing(remove)
                                .setContentTitle(string1)
                                .setContentText(string2)
                                .setAutoCancel(true)
                                .setOnlyAlertOnce(true)
                                .setStyle(Notification.BigTextStyle().bigText(string2))
                                .setColor(color_text)
                                .setColorized(true)
                                .setSmallIcon(small_icon)
                                .setLargeIcon(
                                    BitmapFactory.decodeResource(
                                        this.resources,
                                        (big_icon)
                                    )
                                ).setContentIntent(pendingIntent)
                        }
                        if (typenotify == "picture") {
                            builder = Notification.Builder(this, channelId)
                                .setOngoing(remove)
                                .setContentTitle(string1)
                                .setContentText(string2)
                                .setAutoCancel(true)
                                .setOnlyAlertOnce(true)
                                .setStyle(Notification.BigPictureStyle().bigPicture((imageUri)))
                                .setColor(color_text)
                                .setColorized(true)
                                .setSmallIcon(small_icon)
                                .setLargeIcon(
                                    BitmapFactory.decodeResource(
                                        this.resources,
                                        (big_icon)
                                    )
                                ).setContentIntent(pendingIntent)
                        }

                        if (newIdCheckBox.isChecked) {
                            notificationManager.notify(notificationId++, builder.build())
                            ToastOkay()
                        } else {
                            notificationManager.notify(notificationId, builder.build())
                            ToastOkay()
                        }
                    } else {
                        val intent = Intent(this, MainActivity::class.java)
                        val pendingIntent =
                            PendingIntent.getActivity(
                                this,
                                0,
                                intent,
                                PendingIntent.FLAG_UPDATE_CURRENT
                            )
                        notificationChannel = NotificationChannel(
                            channelId,
                            description,
                            NotificationManager.IMPORTANCE_HIGH
                        )
                        notificationChannel.enableLights(true)
                        notificationChannel.lightColor = color_text
                        notificationChannel.enableVibration(true)
                        notificationManager.createNotificationChannel(notificationChannel)

                        builder = Notification.Builder(this, channelId)
                            .setOngoing(remove)
                            .setContentTitle(string1)
                            .setContentText(string2)
                            .setAutoCancel(true)
                            .setOnlyAlertOnce(true)
                            .setSmallIcon(small_icon)
                            .setLargeIcon(
                                BitmapFactory.decodeResource(
                                    this.resources,
                                    (big_icon)
                                )
                            ).setContentIntent(pendingIntent)


                        if (newIdCheckBox.isChecked) {
                            notificationManager.notify(notificationId++, builder.build())
                            ToastOkay()
                        } else {
                            notificationManager.notify(notificationId, builder.build())
                            ToastOkay()
                        }
                    }
                } else {
                    val text_send = findViewById<TextView>(id.text_send)
                    text_send.text = getString(string.notime)
                    text_send.setCompoundDrawablesWithIntrinsicBounds(ic036, 0, 0, 0)
                    text_send.visibility = View.VISIBLE
                    val animationSend = AnimationUtils.loadAnimation(this, anim.send_slide_up)
                    text_send.startAnimation(animationSend)
                    Handler().postDelayed({
                        text_send.visibility = View.GONE
                    }, 1000)
                }
            }
            timeselectedbutton = 0
        }
    }

    @SuppressLint("ResourceType")
    private fun ToastOkay() {
        val changepicture = findViewById<ImageButton>(id.changepicture)
        val btn_selectcolor = findViewById<Button>(id.btn_selectcolor)
        textreset()
        text_title.setText("")
        text_label.setText("")
        time_btn.text = (resources.getString(string.select_time))
        imageUri = BitmapFactory.decodeResource(this.resources, (pic001))
        changepicture.setImageBitmap(imageUri)
        color_text = resources.getColor(color.Black)
        btn_selectcolor.setBackgroundResource(text_color)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            btn_selectcolor.backgroundTintList =
                ColorStateList.valueOf(resources.getColor(color.Black))
        }
        val text_send = findViewById<TextView>(id.text_send)
        text_send.text = getString(string.successful)
        text_send.setCompoundDrawablesWithIntrinsicBounds(ic035, 0, 0, 0)
        text_send.visibility = View.VISIBLE
        val animationSend = AnimationUtils.loadAnimation(this, anim.send_slide_up)
        text_send.startAnimation(animationSend)
        Handler().postDelayed({
            text_send.visibility = View.GONE
        }, 1000)
    }

    private fun setAlarm() {
        val am = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(applicationContext, AlarmBroadcast::class.java)
        val notify_id: Int = if (newIdCheckBox.isChecked) {
            notificationId++
        } else {
            notificationId
        }
        typenotify = if (button_style.isChecked) {
            "bigtext"
        } else {
            "picture"
        }
        intent.putExtra("title", string1)
        intent.putExtra("label", string2)
        intent.putExtra("small_icon", small_icon)
        intent.putExtra("big_icon", big_icon)
        intent.putExtra("notificationId", notify_id)
        intent.putExtra("remove", remove)
        intent.putExtra("colored", notify_color)
        intent.putExtra("color", color_text)
        intent.putExtra("style", typenotify)

        val pendingIntent =
            PendingIntent.getBroadcast(applicationContext, 0, intent, PendingIntent.FLAG_ONE_SHOT)
        val dateandtime = "$dateTonotify $timeTonotify"
        val formatter: DateFormat = SimpleDateFormat("d-M-yyyy HH:mm")
        try {
            val date1 = formatter.parse(dateandtime)
            am[AlarmManager.RTC_WAKEUP, date1!!.time] = pendingIntent
            ToastOkay()
        } catch (e: ParseException) {
            Toast.makeText(this, e.printStackTrace().toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun textbackup() {
        val editor = getSharedPreferences(
            resources.getString(string.app_package),
            Context.MODE_PRIVATE
        ).edit()
        editor.putString("text_title", text_title.text.toString()).apply()
        editor.putString("text_label", text_label.text.toString()).apply()
        editor.putString("time_btn", time_btn.text.toString()).apply()
        editor.putBoolean("newIdCheckBox", newIdCheckBox.isChecked).apply()
        editor.putBoolean("removeCheckBox", removeCheckBox.isChecked).apply()
        editor.putBoolean("button_style", button_style.isChecked).apply()
    }

    private fun textreset() {
        val editor = getSharedPreferences(
            resources.getString(string.app_package),
            Context.MODE_PRIVATE
        ).edit()
        editor.putString("text_title", null).apply()
        editor.putString("text_label", null).apply()
        editor.putString("time_btn", getString(string.select_time)).apply()
        editor.putBoolean("newIdCheckBox", true).apply()
        editor.putBoolean("removeCheckBox", true).apply()
        editor.putBoolean("button_style", true).apply()
    }

    private fun selectTime() {
        val sharedPreferences = getSharedPreferences(
            resources.getString(string.app_package),
            Context.MODE_PRIVATE
        )
        val editor = getSharedPreferences(
            resources.getString(string.app_package),
            MODE_PRIVATE
        ).edit()
        val timeformated = sharedPreferences.getString("TimeFormat", "")
        var viewTime = true
        if (timeformated == "10PM") {
            viewTime = false
        } else if (timeformated == "22:00") {
            viewTime = true
        }
        val calendar = Calendar.getInstance()
        val hour = calendar[Calendar.HOUR_OF_DAY]
        val minute = calendar[Calendar.MINUTE]
        val timePickerDialog =
            TimePickerDialog(this, { _, i, i1 ->
                timeTonotify = "$i:$i1"
                editor.putString("timeTonotify", "$i:$i1").apply()
                if (viewTime) {
                    formatedtime_time = FormatTime24(i, i1)
                } else {
                    formatedtime_time = FormatTime(i, i1)
                }
            }, hour, minute, viewTime)
        timePickerDialog.show()
    }

    private fun selectDate() {
        val calendar = Calendar.getInstance()
        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH]
        val day = calendar[Calendar.DAY_OF_MONTH]
        val datePickerDialog = DatePickerDialog(
            this,
            { datePicker, year, month, day ->
                dateTonotify = day.toString() + "-" + (month + 1) + "-" + year
                time_btn.text =
                    (day.toString() + "." + (month + 1) + "." + year + " - " + formatedtime_time)
                val editor = getSharedPreferences(
                    resources.getString(string.app_package),
                    MODE_PRIVATE
                ).edit()
                editor.putString("next_date", time_btn.text.toString()).apply()
                editor.putString("dateTonotify", dateTonotify).apply()
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
        selectTime()
    }

    fun FormatTime(hour: Int, minute: Int): String {
        val time: String
        val formattedMinute: String
        formattedMinute = if (minute / 10 == 0) {
            "0$minute"
        } else {
            "" + minute
        }
        time = if (hour == 0) {
            "12:$formattedMinute " + resources.getString(string.AM)
        } else if (hour < 12) {
            "$hour:$formattedMinute " + resources.getString(string.AM)
        } else if (hour == 12) {
            "12:$formattedMinute " + resources.getString(string.PM)
        } else {
            val temp = hour - 12
            "$temp:$formattedMinute " + resources.getString(string.PM)
        }
        return time
    }

    fun FormatTime24(hour: Int, minute: Int): String {
        val formattedMinute: String
        formattedMinute = if (minute / 10 == 0) {
            "0$minute"
        } else {
            "" + minute
        }
        val formattedHour: String
        formattedHour = if (hour / 10 == 0) {
            "0$hour"
        } else {
            "" + hour
        }
        return "$formattedHour:$formattedMinute"
    }

    private fun donthavenotify() {
        val text_send = findViewById<TextView>(R.id.text_send)
        text_send.text = getString(string.Donthave)
        text_send.setCompoundDrawablesWithIntrinsicBounds(ic033, 0, 0, 0)
        text_send.visibility = View.VISIBLE
        val animationSend = AnimationUtils.loadAnimation(this, anim.send_slide_up)
        text_send.startAnimation(animationSend)
        Handler().postDelayed({
            text_send.visibility = View.GONE
        }, 1000)
    }

    override fun onBackPressed() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setIcon(mipmap.ic_launcher_round)
        dialogBuilder.setMessage(resources.getString(string.close_app))
            .setCancelable(false)
            .setPositiveButton(
                resources.getString(string.Yes)
            ) { _, _ ->
                finishAffinity()
            }
            .setNegativeButton(
                resources.getString(string.No)
            ) { dialog, _ ->
                dialog.cancel()
            }
        val alert = dialogBuilder.create()
        alert.setTitle(resources.getString(string.Exit_app))
        alert.show()
    }
}