package com.avocadochif.spannabledsl.library.builders

import androidx.annotation.ColorRes
import androidx.annotation.FontRes
import com.avocadochif.spannabledsl.library.anotations.TextStyleDSL
import com.avocadochif.spannabledsl.library.enums.TextDecorationType
import com.avocadochif.spannabledsl.library.models.style.TextStyle

@TextStyleDSL
class TextStyleBuilder(
    @FontRes var fontResId: Int = -1,
    @ColorRes var textColorResId: Int = -1,
    @ColorRes var backgroundColorResId: Int = -1,
    var decoration: TextDecorationType = TextDecorationType.NONE
) {

    fun build(): TextStyle {
        return TextStyle(fontResId, textColorResId, backgroundColorResId, decoration)
    }

    @Suppress("UNUSED_PARAMETER")
    @Deprecated(
        level = DeprecationLevel.ERROR,
        message = "Style can't be nested."
    )
    fun style(init: TextStyleBuilder.() -> Unit = {}) {

    }

}