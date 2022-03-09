package com.avocadochif.spannabledsl.library.models.spannable

import android.content.Context
import android.os.Build
import android.text.SpannableStringBuilder
import com.avocadochif.spannabledsl.library.R
import com.avocadochif.spannabledsl.library.enums.TextDecorationType
import com.avocadochif.spannabledsl.library.extensions.*
import com.avocadochif.spannabledsl.library.models.span.DrawableSpan
import com.avocadochif.spannabledsl.library.models.span.Span
import com.avocadochif.spannabledsl.library.models.span.TextSpan

data class Spannable(val context: Context, val spans: List<Span>) {

    fun toSpannableString(): CharSequence {
        return SpannableStringBuilder().apply {
            spans.forEach { span ->
                when (span) {
                    is TextSpan -> {

                        append(span.text)

                        val start: Int = indexOf(span.text)
                        val end: Int = indexOf(span.text) + span.text.length

                        if (span.style.fontResId != -1) {
                            setTypefaceSpan(context, span.style.fontResId, start, end)
                        }

                        if (span.style.textColorResId != -1) {
                            setForegroundColorSpan(context, span.style.textColorResId, start, end)
                        }

                        if (span.style.backgroundColorResId != -1) {
                            setBackgroundColorSpan(context, span.style.backgroundColorResId, start, end)
                        }

                        when (span.style.decoration.type) {
                            TextDecorationType.UNDERLINE -> {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                                    if (span.style.decoration.lineColorResId != -1) {
                                        if (span.style.decoration.underlineThicknessResId != -1) {
                                            setUnderlineSpan(context, span.style.decoration.lineColorResId, span.style.decoration.underlineThicknessResId, start, end)
                                        } else {
                                            setUnderlineSpan(context, span.style.decoration.lineColorResId, R.dimen.default_underline_thickness, start, end)
                                        }
                                    } else {
                                        setUnderlineSpan(start, end)
                                    }
                                } else {
                                    setUnderlineSpan(start, end)
                                }
                            }
                            TextDecorationType.STRIKETHROUGH -> setStrikethroughSpan(start, end)
                            TextDecorationType.NONE -> {}
                        }

                    }
                    is DrawableSpan -> {}
                }
            }
        }
    }

}
