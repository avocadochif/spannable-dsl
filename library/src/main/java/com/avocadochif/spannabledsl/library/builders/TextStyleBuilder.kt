package com.avocadochif.spannabledsl.library.builders

import androidx.annotation.ColorRes
import androidx.annotation.FontRes
import com.avocadochif.spannabledsl.library.anotations.TextStyleDSL
import com.avocadochif.spannabledsl.library.models.style.TextStyle

@TextStyleDSL
class TextStyleBuilder(
    @FontRes var fontResId: Int = -1,
    @ColorRes var textColorResId: Int = -1
) {

    fun build(): TextStyle {
        return TextStyle(fontResId, textColorResId)
    }

    @Suppress("UNUSED_PARAMETER")
    @Deprecated(
        level = DeprecationLevel.ERROR,
        message = "Style can't be nested."
    )
    fun style(init: TextStyleBuilder.() -> Unit = {}) {

    }

}