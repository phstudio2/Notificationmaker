package com.phstudio.notificationmaker.color

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.phstudio.notificationmaker.MainActivity
import com.phstudio.notificationmaker.R
import java.util.*

class ColorActivity : AppCompatActivity() {


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_color)

        val editor = getSharedPreferences(
            resources.getString(R.string.app_package),
            Context.MODE_PRIVATE
        ).edit()

        val btDismiss = findViewById<Button>(R.id.cancel_button)
        btDismiss.setOnClickListener {
            start()
        }
        val btn_color_Black = findViewById<Button>(R.id.btn_color_Black)
        val btn_color_White = findViewById<Button>(R.id.btn_color_White)
        val btn_color_Red = findViewById<Button>(R.id.btn_color_Red)
        val btn_color_Lime = findViewById<Button>(R.id.btn_color_Lime)
        val btn_color_Blue = findViewById<Button>(R.id.btn_color_Blue)
        val btn_color_Yellow = findViewById<Button>(R.id.btn_color_Yellow)
        val btn_color_Pink = findViewById<Button>(R.id.btn_color_Pink)
        val btn_color_Gray = findViewById<Button>(R.id.btn_color_Gray)
        val btn_color_Cyan = findViewById<Button>(R.id.btn_color_Cyan)
        val btn_color_Select = findViewById<Button>(R.id.btn_color_Select)
        val btn_color_None = findViewById<Button>(R.id.btn_color_None)

        btn_color_Black.setOnClickListener {
            editor.putBoolean("colored", true).apply()

            editor.putInt("setBackgroundResource", R.drawable.text_color).apply()
            editor.putInt("backgroundTintList", (R.color.Black)).apply()
            start()
        }
        btn_color_White.setOnClickListener {
            editor.putBoolean("colored", false).apply()
            editor.putString("White", "White").apply()

            start()
        }
        btn_color_Red.setOnClickListener {
            editor.putBoolean("colored", true).apply()
            editor.putInt("setBackgroundResource", R.drawable.text_color).apply()
            editor.putInt("backgroundTintList", (R.color.Red)).apply()
            start()
        }
        btn_color_Lime.setOnClickListener {
            editor.putBoolean("colored", true).apply()
            editor.putInt("setBackgroundResource", R.drawable.text_color).apply()
            editor.putInt("backgroundTintList", (R.color.Lime)).apply()
            start()
        }
        btn_color_Blue.setOnClickListener {
            editor.putBoolean("colored", true).apply()
            editor.putInt("setBackgroundResource", R.drawable.text_color).apply()
            editor.putInt("backgroundTintList", (R.color.Blue)).apply()
            start()
        }
        btn_color_Yellow.setOnClickListener {
            editor.putBoolean("colored", true).apply()
            editor.putInt("setBackgroundResource", R.drawable.text_color).apply()
            editor.putInt("backgroundTintList", (R.color.Yellow)).apply()
            start()
        }
        btn_color_Pink.setOnClickListener {
            editor.putBoolean("colored", true).apply()
            editor.putInt("setBackgroundResource", R.drawable.text_color).apply()
            editor.putInt("backgroundTintList", (R.color.Pink)).apply()
            start()
        }
        btn_color_Gray.setOnClickListener {
            editor.putBoolean("colored", true).apply()
            editor.putInt("setBackgroundResource", R.drawable.text_color).apply()
            editor.putInt("backgroundTintList", (R.color.Gray)).apply()
            start()
        }
        btn_color_Cyan.setOnClickListener {
            editor.putBoolean("colored", true).apply()
            editor.putInt("setBackgroundResource", R.drawable.text_color).apply()
            editor.putInt("backgroundTintList", (R.color.Cyan)).apply()
            start()
        }

        btn_color_None.setOnClickListener {
            editor.putBoolean("colored", false).apply()
            editor.putString("White", "None").apply()
            start()
        }

        val colorSelector = findViewById<RelativeLayout>(R.id.colorSelector)
        val colorOkBtn = findViewById<Button>(R.id.colorOkBtn)
        val colorCancelBtn = findViewById<Button>(R.id.colorCancelBtn)
        val colorA = findViewById<SeekBar>(R.id.colorA)
        val colorR = findViewById<SeekBar>(R.id.colorR)
        val colorG = findViewById<SeekBar>(R.id.colorG)
        val colorB = findViewById<SeekBar>(R.id.colorB)
        val strColor = findViewById<EditText>(R.id.strColor)
        val btnColorPreview = findViewById<Button>(R.id.btnColorPreview)
        val MainselectorLayout =
            findViewById<ConstraintLayout>(R.id.MainselectorLayout)

        btn_color_Select.setOnClickListener {
            MainselectorLayout.visibility = View.GONE
            colorSelector.visibility = View.VISIBLE
        }

        strColor.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                if (s.length == 6) {
                    colorA.progress = 255
                    colorR.progress = Integer.parseInt(s.substring(0..1), 16)
                    colorG.progress = Integer.parseInt(s.substring(2..3), 16)
                    colorB.progress = Integer.parseInt(s.substring(4..5), 16)
                } else if (s.length == 8) {
                    colorA.progress = Integer.parseInt(s.substring(0..1), 16)
                    colorR.progress = Integer.parseInt(s.substring(2..3), 16)
                    colorG.progress = Integer.parseInt(s.substring(4..5), 16)
                    colorB.progress = Integer.parseInt(s.substring(6..7), 16)
                }
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int,
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int,
            ) {

            }
        })

        colorA.max = 255
        colorA.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(
                seekBar: SeekBar, progress: Int,
                fromUser: Boolean,
            ) {
                var a = Integer.toHexString(((255 * colorA.progress) / colorA.max))
                if (a.length == 1) a = "0$a"
                var r = Integer.toHexString(((255 * colorR.progress) / colorR.max))
                if (r.length == 1) r = "0$r"
                var g = Integer.toHexString(((255 * colorG.progress) / colorG.max))
                if (g.length == 1) g = "0$g"
                var b = Integer.toHexString(((255 * colorB.progress) / colorB.max))
                if (b.length == 1) b = "0$b"
                val colorStr = "#$a$r$g$b"
                strColor.setText(colorStr.replace("#", "").uppercase(Locale.getDefault()))
                btnColorPreview.setBackgroundColor(Color.parseColor(colorStr))
            }
        })

        colorR.max = 255
        colorR.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(
                seekBar: SeekBar, progress: Int,
                fromUser: Boolean,
            ) {
                var a = Integer.toHexString(((255 * colorA.progress) / colorA.max))
                if (a.length == 1) a = "0$a"
                var r = Integer.toHexString(((255 * colorR.progress) / colorR.max))
                if (r.length == 1) r = "0$r"
                var g = Integer.toHexString(((255 * colorG.progress) / colorG.max))
                if (g.length == 1) g = "0$g"
                var b = Integer.toHexString(((255 * colorB.progress) / colorB.max))
                if (b.length == 1) b = "0$b"
                val colorStr = "#$a$r$g$b"
                strColor.setText(colorStr.replace("#", "").uppercase(Locale.getDefault()))
                btnColorPreview.setBackgroundColor(Color.parseColor(colorStr))
            }
        })

        colorG.max = 255
        colorG.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(
                seekBar: SeekBar, progress: Int,
                fromUser: Boolean,
            ) {
                var a = Integer.toHexString(((255 * colorA.progress) / colorA.max))
                if (a.length == 1) a = "0$a"
                var r = Integer.toHexString(((255 * colorR.progress) / colorR.max))
                if (r.length == 1) r = "0$r"
                var g = Integer.toHexString(((255 * colorG.progress) / colorG.max))
                if (g.length == 1) g = "0$g"
                var b = Integer.toHexString(((255 * colorB.progress) / colorB.max))
                if (b.length == 1) b = "0$b"
                val colorStr = "#$a$r$g$b"
                strColor.setText(colorStr.replace("#", "").uppercase(Locale.getDefault()))
                btnColorPreview.setBackgroundColor(Color.parseColor(colorStr))
            }
        })

        colorB.max = 255
        colorB.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(
                seekBar: SeekBar, progress: Int,
                fromUser: Boolean,
            ) {
                var a = Integer.toHexString(((255 * colorA.progress) / colorA.max))
                if (a.length == 1) a = "0$a"
                var r = Integer.toHexString(((255 * colorR.progress) / colorR.max))
                if (r.length == 1) r = "0$r"
                var g = Integer.toHexString(((255 * colorG.progress) / colorG.max))
                if (g.length == 1) g = "0$g"
                var b = Integer.toHexString(((255 * colorB.progress) / colorB.max))
                if (b.length == 1) b = "0$b"
                val colorStr = "#$a$r$g$b"
                strColor.setText(colorStr.replace("#", "").uppercase(Locale.getDefault()))
                btnColorPreview.setBackgroundColor(Color.parseColor(colorStr))
            }
        })

        colorCancelBtn.setOnClickListener {
            MainselectorLayout.visibility = View.VISIBLE
            colorSelector.visibility = View.GONE
        }

        colorOkBtn.setOnClickListener {
            var a = Integer.toHexString(((255 * colorA.progress) / colorA.max))
            if (a.length == 1) a = "0$a"
            var r = Integer.toHexString(((255 * colorR.progress) / colorR.max))
            if (r.length == 1) r = "0$r"
            var g = Integer.toHexString(((255 * colorG.progress) / colorG.max))
            if (g.length == 1) g = "0$g"
            var b = Integer.toHexString(((255 * colorB.progress) / colorB.max))
            if (b.length == 1) b = "0$b"
            val colorStr = "#$a$r$g$b"
            MainselectorLayout.visibility = View.VISIBLE
            colorSelector.visibility = View.GONE

            //val colorStr = "#$a$r$g$b"
            strColor.setText(colorStr.replace("#", "").uppercase(Locale.getDefault()))

            editor.putBoolean("colored", false).apply()
            editor.putInt("setBackgroundResource", R.drawable.text_color).apply()
            editor.putString("White", "Custom").apply()
            editor.putString("custom", colorStr).apply()

            start()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        start()
    }

    private fun start() {
        this@ColorActivity.startActivity(
            Intent(
                this@ColorActivity,
                MainActivity::class.java
            )
        )
        overridePendingTransition(0, 0)
    }
}