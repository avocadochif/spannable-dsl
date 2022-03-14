package com.avocadochif.spannabledsl.library.builders

import com.avocadochif.spannabledsl.library.anotations.TextSpanDSL
import com.avocadochif.spannabledsl.library.anotations.TextStyleDSL
import com.avocadochif.spannabledsl.library.enums.TextDecorationType
import com.avocadochif.spannabledsl.library.models.decoration.TextDecoration
import com.avocadochif.spannabledsl.library.models.span.TextSpan
import com.avocadochif.spannabledsl.library.models.style.TextStyle

@TextSpanDSL
@TextStyleDSL
class TextSpanBuilder(private val text: String) {

    private var style: TextStyle = provideDefaultTextStyle()

    fun build(): TextSpan {
        return TextSpan(text, style)
    }

    @TextSpanDSL
    @TextStyleDSL
    fun style(init: TextStyleBuilder.() -> Unit) {
        style = TextStyleBuilder().apply(init).build()
    }

    private fun provideDefaultTextStyle(): TextStyle {
        return TextStyle(
            fontResId = -1,
            textColorResId = -1,
            textSizeResId = -1,
            backgroundColorResId = -1,
            decoration = TextDecoration(
                type = TextDecorationType.NONE
            )
        )
    }

}