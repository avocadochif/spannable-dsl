package com.avocadochif.spannabledsl.library.builders

import com.avocadochif.spannabledsl.library.enums.TextDecorationType
import com.avocadochif.spannabledsl.library.models.decoration.TextDecoration

class TextDecorationBuilder(
    var type: TextDecorationType = TextDecorationType.NONE
) {

    fun build(): TextDecoration {
        return TextDecoration(type)
    }

    @Suppress("UNUSED_PARAMETER")
    @Deprecated(
        level = DeprecationLevel.ERROR,
        message = "TextDecoration can't be nested."
    )
    fun textDecoration(init: TextDecorationBuilder.() -> Unit = {}) {

    }

}