package com.avocadochif.spannabledsl.library.models.style

import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.FontRes
import com.avocadochif.spannabledsl.library.models.decoration.LineDecoration
import com.avocadochif.spannabledsl.library.models.decoration.TextDecoration

data class TextStyle(
    @FontRes val fontResId: Int,
    @ColorRes val textColorResId: Int,
    @DimenRes val textSizeResId: Int,
    @ColorRes val backgroundColorResId: Int,
    val textDecoration: TextDecoration,
    val lineDecoration: LineDecoration
)
