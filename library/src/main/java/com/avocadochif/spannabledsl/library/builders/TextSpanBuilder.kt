package com.avocadochif.spannabledsl.library.builders

import com.avocadochif.spannabledsl.library.anotations.TextSpanDSL
import com.avocadochif.spannabledsl.library.models.span.TextSpan

@TextSpanDSL
class TextSpanBuilder(private val text: String) {

    fun build(): TextSpan {
        return TextSpan(text)
    }

}