package com.avocadochif.spannabledsl.library.models.style

import androidx.annotation.ColorRes
import androidx.annotation.FontRes

sealed class Style

data class TextStyle(
    @FontRes val fontResId: Int,
    @ColorRes val textColorResId: Int,
    @ColorRes val backgroundColorResId: Int
) : Style()
