package com.avocadochif.spannabledsl.library.builders

import com.avocadochif.spannabledsl.library.anotations.TextSpanDSL
import com.avocadochif.spannabledsl.library.enums.TextDecorationType
import com.avocadochif.spannabledsl.library.models.span.TextSpan
import com.avocadochif.spannabledsl.library.models.style.TextStyle

@TextSpanDSL
class TextSpanBuilder(private val text: String) {

    private var style: TextStyle = provideDefaultTextStyle()

    fun build(): TextSpan {
        return TextSpan(text, style)
    }

    @TextSpanDSL
    fun style(init: TextStyleBuilder.() -> Unit) {
        style = TextStyleBuilder().apply(init).build()
    }

    private fun provideDefaultTextStyle(): TextStyle {
        return TextStyle(
            fontResId = -1,
            textColorResId = -1,
            backgroundColorResId = -1,
            decoration = TextDecorationType.NONE
        )
    }

}