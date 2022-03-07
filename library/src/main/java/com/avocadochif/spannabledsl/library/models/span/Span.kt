package com.avocadochif.spannabledsl.library.models.span

import android.graphics.drawable.Drawable
import com.avocadochif.spannabledsl.library.models.style.TextStyle

sealed class Span(val type: SpanType)

data class TextSpan(
    val text: String,
    val style: TextStyle
) : Span(type = SpanType.TEXT)

data class DrawableSpan(val drawable: Drawable) : Span(type = SpanType.DRAWABLE)
