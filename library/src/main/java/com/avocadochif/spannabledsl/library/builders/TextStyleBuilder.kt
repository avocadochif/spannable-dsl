package com.avocadochif.spannabledsl.library.builders

import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.FontRes
import com.avocadochif.spannabledsl.library.anotations.LineDecorationDSL
import com.avocadochif.spannabledsl.library.anotations.TextDecorationDSL
import com.avocadochif.spannabledsl.library.anotations.TextStyleDSL
import com.avocadochif.spannabledsl.library.enums.LineDecorationType
import com.avocadochif.spannabledsl.library.enums.TextDecorationType
import com.avocadochif.spannabledsl.library.models.decoration.LineDecoration
import com.avocadochif.spannabledsl.library.models.decoration.TextDecoration
import com.avocadochif.spannabledsl.library.models.style.TextStyle

@TextStyleDSL
@TextDecorationDSL
@LineDecorationDSL
class TextStyleBuilder(
    @FontRes var fontResId: Int = -1,
    @ColorRes var textColorResId: Int = -1,
    @DimenRes var textSizeResId: Int = -1,
    @ColorRes var backgroundColorResId: Int = -1,
) {

    private var textDecoration: TextDecoration = provideDefaultTextDecoration()
    private var lineDecoration: LineDecoration = provideDefaultLineDecoration()

    fun build(): TextStyle {
        return TextStyle(
            fontResId,
            textColorResId,
            textSizeResId,
            backgroundColorResId,
            textDecoration,
            lineDecoration
        )
    }

    @TextDecorationDSL
    fun textDecoration(init: TextDecorationBuilder.() -> Unit) {
        textDecoration = TextDecorationBuilder().apply(init).build()
    }

    @LineDecorationDSL
    fun lineDecoration(init: LineDecorationBuilder.() -> Unit) {
        lineDecoration = LineDecorationBuilder().apply(init).build()
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

    private fun provideDefaultLineDecoration(): LineDecoration {
        return LineDecoration(
            type = LineDecorationType.NONE
        )
    }

}