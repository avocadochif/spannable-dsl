package com.avocadochif.spannabledsl

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.avocadochif.spannabledsl.library.enums.LineDecorationType
import com.avocadochif.spannabledsl.library.enums.TextDecorationType
import com.avocadochif.spannabledsl.library.extensions.spannable

class SpannableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spannable)

        findViewById<TextView>(R.id.helloTV).spannable {
            text("Hello") {
                style {
                    backgroundColorResId = R.color.teal_200
                    textDecoration {
                        type = TextDecorationType.UNDERLINE
                    }
                }
            }
            text(" ")
            text(R.string.world) {
                style {
                    fontResId = R.font.fredoka_bold
                    textColorResId = R.color.purple_200
                    textSizeResId = R.dimen.world_text_size
                    backgroundColorResId = R.color.teal_200
                    textDecoration {
                        type = TextDecorationType.STRIKETHROUGH
                    }
                }
            }
            text("!!!") {
                style {
                    fontResId = R.font.fredoka_bold
                }
            }
            text(R.string.new_line)
            text("underline text") {
                style {
                    textSizeResId = R.dimen.underline_text_size
                    textDecoration {
                        type = TextDecorationType.UNDERLINE
                    }
                }
            }
            text(R.string.new_line)
            text("strikethrough text") {
                style {
                    textSizeResId = R.dimen.strikethrough_text_size
                    textDecoration {
                        type = TextDecorationType.STRIKETHROUGH
                    }
                }
            }
            text(R.string.new_line)
            text("line with bullet line decoration") {
                style {
                    textDecoration {
                        type = TextDecorationType.STRIKETHROUGH
                    }
                    lineDecoration {
                        type = LineDecorationType.BULLET
                    }
                }
            }
            text(R.string.new_line)
            text("line with quote line decoration") {
                style {
                    lineDecoration {
                        type = LineDecorationType.QUOTE
                    }
                }
            }
        }
    }

}