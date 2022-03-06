package com.avocadochif.spannabledsl.library.models.span

import android.graphics.drawable.Drawable

sealed class Span(val type: SpanType)

data class TextSpan(val text: String) : Span(type = SpanType.TEXT)
data class DrawableSpan(val drawable: Drawable) : Span(type = SpanType.DRAWABLE)
