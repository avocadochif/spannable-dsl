package com.avocadochif.spannabledsl.library.builders

import com.avocadochif.spannabledsl.library.anotations.LineDecorationDSL
import com.avocadochif.spannabledsl.library.enums.LineDecorationType
import com.avocadochif.spannabledsl.library.models.decoration.LineDecoration

@LineDecorationDSL
class LineDecorationBuilder(
    var type: LineDecorationType = LineDecorationType.NONE
) {

    fun build(): LineDecoration {
        return LineDecoration(type)
    }

    @Suppress("UNUSED_PARAMETER")
    @Deprecated(
        level = DeprecationLevel.ERROR,
        message = "LineDecoration can't be nested."
    )
    fun lineDecoration(init: LineDecorationBuilder.() -> Unit = {}) {

    }

}