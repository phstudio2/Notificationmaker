package com.phstudio.notificationmaker.another

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.phstudio.notificationmaker.R
import java.io.File

class AnotherActivity : Activity() {
    @SuppressLint("ResourceType")
    fun nextdialog(context: Context) {
        val sharedPreferences =
            context.getSharedPreferences(
                context.resources.getString(R.string.app_package),
                Context.MODE_PRIVATE
            )

        val inflater = LayoutInflater.from(context)
        val dialogView = inflater.inflate(R.layout.layout_next, null)
        val customDialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .show()

        val btDismiss = dialogView.findViewById<Button>(R.id.cancel_button)
        val text_title = dialogView.findViewById<TextView>(R.id.textView)
        val text_label = dialogView.findViewById<TextView>(R.id.textView2)
        val text_date = dialogView.findViewById<TextView>(R.id.textView3)
        val ic_small = dialogView.findViewById<ImageView>(R.id.imageView)
        val ic_big = dialogView.findViewById<ImageView>(R.id.imageView2)
        val viewcolor = dialogView.findViewById<Button>(R.id.viewcolor)
        val imagepicture = dialogView.findViewById<ImageView>(R.id.imagepicture)

        val nextstring1 = sharedPreferences.getString("nextstring1", "")
        val nextstring2 = sharedPreferences.getString("nextstring2", "")
        val nextsmall_icon = sharedPreferences.getInt("nextsmall_icon", 0)
        val nextbig_icon = sharedPreferences.getInt("nextbig_icon", 0)
        val next_date = sharedPreferences.getString("next_date", "")
        val color_text2 = sharedPreferences.getInt("color", 0)
        val nextcustom = sharedPreferences.getString("nextWhite", "")
        val button_style_ok = sharedPreferences.getString("button_style", "")
        val notify_color = sharedPreferences.getBoolean("notify_color", true)
        val imagepicture2 = sharedPreferences.getString("nextpicture", "")

        when (button_style_ok) {
            "picture" -> {
                imagepicture.visibility = View.VISIBLE
                val filenameandress = File(
                    Environment.getExternalStorageDirectory().toString(),
                    context.getString(R.string.app_name) + "/${imagepicture2}.jpg"
                )
                if (filenameandress.exists()) {
                    val filename = (File(
                        Environment.getExternalStorageDirectory().toString(),
                        context.getString(R.string.app_name) + "/${imagepicture2}.jpg"
                    )).toString()
                    val bitmap: Bitmap = BitmapFactory.decodeFile(filename)
                    imagepicture.setImageBitmap(bitmap)
                } else {
                    val pic001 =
                        BitmapFactory.decodeResource(context.resources, (R.drawable.pic001))
                    imagepicture.setImageBitmap(pic001)
                }
            }
            "bigtext" -> {
                imagepicture.visibility = View.GONE
            }
            else -> {
                customDialog.dismiss()
            }
        }

        text_title.text = nextstring1
        text_label.text = nextstring2
        text_date.text = next_date
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (notify_color) {
                viewcolor.setBackgroundResource(R.drawable.text_color)
                viewcolor.backgroundTintList = ColorStateList.valueOf(color_text2)
            } else {
                when (nextcustom) {
                    "White" -> {
                        viewcolor.setBackgroundResource(R.drawable.white_ring)
                        viewcolor.backgroundTintList = (null)
                    }
                    "Custom" -> {
                        viewcolor.setBackgroundResource(R.drawable.text_color)
                        viewcolor.backgroundTintList = ColorStateList.valueOf(color_text2)
                    }
                    else -> {
                        viewcolor.setBackgroundResource(R.drawable.ic_none)
                        viewcolor.backgroundTintList =
                            ColorStateList.valueOf(context.resources.getColor(R.color.Black))
                    }
                }
            }

            ic_small.setImageResource(nextsmall_icon)
            ic_big.setImageResource(nextbig_icon)

            btDismiss.setOnClickListener {
                customDialog.dismiss()
            }

        }
    }
}