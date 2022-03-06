package com.avocadochif.spannabledsl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.avocadochif.spannabledsl.library.extensions.spannable

class SpannableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spannable)

        findViewById<TextView>(R.id.helloTV).spannable {
            text("Hello")
            text(" ")
            text(R.string.world)
        }
    }

}