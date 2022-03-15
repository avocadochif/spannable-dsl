package com.avocadochif.spannabledsl.library.extensions

import android.content.Context
import android.os.Build
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.*
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.FontRes
import androidx.core.content.ContextCompat
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

fun SpannableStringBuilder.setForegroundColorSpan(
    context: Context,
    @ColorRes textColorResId: Int,
    start: Int,
    end: Int
) {
    setSpan(
        ForegroundColorSpan(ContextCompat.getColor(context, textColorResId)),
        start,
        end,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )
}

fun SpannableStringBuilder.setAbsoluteSizeSpan(
    context: Context,
    @DimenRes textSizeResId: Int,
    start: Int,
    end: Int
) {
    setSpan(
        AbsoluteSizeSpan(context.resources.getDimensionPixelSize(textSizeResId), false),
        start,
        end,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )
}

fun SpannableStringBuilder.setBackgroundColorSpan(
    context: Context,
    @ColorRes backgroundColorResId: Int,
    start: Int,
    end: Int
) {
    setSpan(
        BackgroundColorSpan(ContextCompat.getColor(context, backgroundColorResId)),
        start,
        end,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )
}

fun SpannableStringBuilder.setUnderlineSpan(
    start: Int,
    end: Int
) {
    setSpan(
        UnderlineSpan(),
        start,
        end,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )
}

fun SpannableStringBuilder.setStrikethroughSpan(
    start: Int,
    end: Int
) {
    setSpan(
        StrikethroughSpan(),
        start,
        end,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )
}

fun SpannableStringBuilder.setQuoteSpan(
    start: Int,
    end: Int
) {
    setSpan(
        QuoteSpan(),
        start,
        end,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )
}

fun SpannableStringBuilder.setBulletSpan(
    start: Int,
    end: Int
) {
    setSpan(
        BulletSpan(),
        start,
        end,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )
}