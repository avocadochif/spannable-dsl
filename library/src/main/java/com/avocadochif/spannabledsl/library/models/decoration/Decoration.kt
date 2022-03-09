package com.avocadochif.spannabledsl.library.models.decoration

import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import com.avocadochif.spannabledsl.library.enums.TextDecorationType

sealed class Decoration

data class TextDecoration(
    val type: TextDecorationType,
    @ColorRes val lineColorResId: Int,
    @DimenRes val underlineThicknessResId: Int
) : Decoration()
