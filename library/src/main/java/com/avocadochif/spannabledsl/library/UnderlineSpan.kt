package com.avocadochif.spannabledsl.library

import android.os.Build
import android.text.TextPaint
import android.text.style.UnderlineSpan
import androidx.annotation.ColorInt
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.Q)
class UnderlineSpan(
    @ColorInt private val color: Int,
    private val underlineThickness: Float
) : UnderlineSpan() {

    override fun updateDrawState(tp: TextPaint) {
        try {
            TextPaint::class.java.getMethod(
                "setUnderlineText",
                Integer.TYPE,
                java.lang.Float.TYPE
            ).invoke(tp, color, underlineThickness)
        } catch (e: Exception) {
            tp.isUnderlineText = true
        }
    }

}