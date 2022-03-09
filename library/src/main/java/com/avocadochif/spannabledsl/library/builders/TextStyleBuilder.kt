package com.avocadochif.spannabledsl.library.builders

import androidx.annotation.ColorRes
import androidx.annotation.FontRes
import com.avocadochif.spannabledsl.library.anotations.TextDecorationDSL
import com.avocadochif.spannabledsl.library.anotations.TextStyleDSL
import com.avocadochif.spannabledsl.library.enums.TextDecorationType
import com.avocadochif.spannabledsl.library.models.decoration.TextDecoration
import com.avocadochif.spannabledsl.library.models.style.TextStyle

@TextStyleDSL
@TextDecorationDSL
class TextStyleBuilder(
    @FontRes var fontResId: Int = -1,
    @ColorRes var textColorResId: Int = -1,
    @ColorRes var backgroundColorResId: Int = -1,
) {

    private var decoration: TextDecoration = provideDefaultTextDecoration()

    fun build(): TextStyle {
        return TextStyle(fontResId, textColorResId, backgroundColorResId, decoration)
    }

    @TextDecorationDSL
    fun decoration(init: TextDecorationBuilder.() -> Unit) {
        decoration = TextDecorationBuilder().apply(init).build()
    }

    @Suppress("UNUSED_PARAMETER")
    @Deprecated(
        level = DeprecationLevel.ERROR,
        message = "Style can't be nested."
    )
    fun style(init: TextStyleBuilder.() -> Unit = {}) {

    }

    private fun provideDefaultTextDecoration(): TextDecoration {
        return TextDecoration(
            type = TextDecorationType.NONE
        )
    }

}