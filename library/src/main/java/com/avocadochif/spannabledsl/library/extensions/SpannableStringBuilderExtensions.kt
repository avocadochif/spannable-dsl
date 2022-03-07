package com.avocadochif.spannabledsl.library.extensions

import android.content.Context
import android.os.Build
import android.text.SpannableStringBuilder
import android.text.Spanned
import androidx.annotation.FontRes
import androidx.core.content.res.ResourcesCompat
import com.avocadochif.spannabledsl.library.TypefaceSpan

fun SpannableStringBuilder.setTypefaceSpan(
    context: Context,
    @FontRes fontResId: Int,
    start: Int,
    end: Int
) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val typeface = context.resources.getFont(fontResId)
        setSpan(TypefaceSpan(typeface), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    } else {
        ResourcesCompat.getFont(context, fontResId)?.let {
            setSpan(it, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
    }
}