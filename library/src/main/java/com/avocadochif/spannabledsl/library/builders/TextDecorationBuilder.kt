package com.avocadochif.spannabledsl.library.builders

import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import com.avocadochif.spannabledsl.library.enums.TextDecorationType
import com.avocadochif.spannabledsl.library.models.decoration.TextDecoration

class TextDecorationBuilder(
    var type: TextDecorationType = TextDecorationType.NONE,
    @ColorRes var lineColorResId: Int = -1,
    @DimenRes var underlineThicknessResId: Int = -1
) {

    fun build(): TextDecoration {
        return TextDecoration(type, lineColorResId, underlineThicknessResId)
    }

    @Suppress("UNUSED_PARAMETER")
    @Deprecated(
        level = DeprecationLevel.ERROR,
        message = "TextDecoration can't be nested."
    )
    fun decoration(init: TextDecorationBuilder.() -> Unit = {}) {

    }

}