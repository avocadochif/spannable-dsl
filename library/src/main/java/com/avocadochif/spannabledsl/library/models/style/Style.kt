package com.avocadochif.spannabledsl.library.models.style

import androidx.annotation.FontRes

sealed class Style

data class TextStyle(@FontRes val fontResId: Int): Style()
