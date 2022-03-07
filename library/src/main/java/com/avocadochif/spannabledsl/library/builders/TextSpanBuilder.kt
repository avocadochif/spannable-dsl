package com.avocadochif.spannabledsl.library.builders

import com.avocadochif.spannabledsl.library.anotations.TextSpanDSL
import com.avocadochif.spannabledsl.library.models.span.TextSpan
import com.avocadochif.spannabledsl.library.models.style.TextStyle

@TextSpanDSL
class TextSpanBuilder(private val text: String) {

    private var style: TextStyle = TextStyle(-1)

    fun build(): TextSpan {
        return TextSpan(text, style)
    }

    @TextSpanDSL
    fun style(init: TextStyleBuilder.() -> Unit) {
        style = TextStyleBuilder().apply(init).build()
    }

}