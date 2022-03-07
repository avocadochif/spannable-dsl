package com.avocadochif.spannabledsl

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.avocadochif.spannabledsl.library.extensions.spannable

class SpannableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spannable)

        findViewById<TextView>(R.id.helloTV).spannable {
            text("Hello")
            text(" ")
            text(R.string.world) {
                style {
                    fontResId = R.font.fredoka_bold
                    textColorResId = R.color.purple_200
                }
            }
            text("!!!") {
                style {
                    fontResId = R.font.fredoka_bold
                }
            }
        }
    }

}