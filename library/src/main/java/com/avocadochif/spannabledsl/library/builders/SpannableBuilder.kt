package com.avocadochif.spannabledsl.library.builders

import android.content.Context
import androidx.annotation.StringRes
import com.avocadochif.spannabledsl.library.anotations.SpannableDSL
import com.avocadochif.spannabledsl.library.anotations.TextSpanDSL
import com.avocadochif.spannabledsl.library.extensions.addIf
import com.avocadochif.spannabledsl.library.models.span.Span
import com.avocadochif.spannabledsl.library.models.spannable.Spannable

@SpannableDSL
class SpannableBuilder(private val context: Context) {

    private val spans = mutableListOf<Span>()

    fun build(): Spannable {
        return Spannable(context, spans)
    }

    @SpannableDSL
    @TextSpanDSL
    fun text(text: String = "", init: TextSpanBuilder.() -> Unit = {}) {
        spans.addIf(
            TextSpanBuilder(text).apply(init).build(),
            text.isNotEmpty()
        )
    }

    @SpannableDSL
    @TextSpanDSL
    fun text(@StringRes textResId: Int = -1, init: TextSpanBuilder.() -> Unit = {}) {
        spans.addIf(
            TextSpanBuilder(context.getString(textResId)).apply(init).build(),
            textResId != -1
        )
    }

    @Suppress("UNUSED_PARAMETER")
    @Deprecated(
        level = DeprecationLevel.ERROR,
        message = "SpannableBuilder can't be nested."
    )
    fun spannable(init: SpannableBuilder.() -> Unit = {}) {

    }

}