package com.avocadochif.spannabledsl.library.models.decoration

import com.avocadochif.spannabledsl.library.enums.TextDecorationType

sealed class Decoration()

data class TextDecoration(
    val type: TextDecorationType
) : Decoration()
