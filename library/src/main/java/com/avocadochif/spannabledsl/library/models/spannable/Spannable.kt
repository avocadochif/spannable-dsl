package com.avocadochif.spannabledsl.library.models.spannable

import android.content.Context
import android.text.SpannableStringBuilder
import com.avocadochif.spannabledsl.library.extensions.setBackgroundColorSpan
import com.avocadochif.spannabledsl.library.extensions.setForegroundColorSpan
import com.avocadochif.spannabledsl.library.extensions.setTypefaceSpan
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
                        if (span.style.fontResId != -1) {
                            setTypefaceSpan(context, span.style.fontResId, indexOf(span.text), indexOf(span.text) + span.text.length)
                        }
                        if (span.style.textColorResId != -1) {
                            setForegroundColorSpan(context, span.style.textColorResId, indexOf(span.text), indexOf(span.text) + span.text.length)
                        }
                        if (span.style.backgroundColorResId != -1) {
                            setBackgroundColorSpan(context, span.style.backgroundColorResId, indexOf(span.text), indexOf(span.text) + span.text.length)
                        }
                    }
                    is DrawableSpan -> {}
                }
            }
        }
    }

}
