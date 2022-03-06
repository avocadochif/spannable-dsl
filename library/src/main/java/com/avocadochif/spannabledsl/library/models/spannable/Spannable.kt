package com.avocadochif.spannabledsl.library.models.spannable

import android.content.Context
import android.text.SpannableStringBuilder
import com.avocadochif.spannabledsl.library.models.span.DrawableSpan
import com.avocadochif.spannabledsl.library.models.span.Span
import com.avocadochif.spannabledsl.library.models.span.TextSpan

data class Spannable(val context: Context, val spans: List<Span>) {

    fun toSpannableString(): CharSequence {
        return SpannableStringBuilder().apply {
            spans.forEach { span ->
                when (span) {
                    is TextSpan -> append(span.text)
                    is DrawableSpan -> {}
                }
            }
        }
    }

}
