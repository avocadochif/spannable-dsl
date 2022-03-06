package com.avocadochif.spannabledsl.library.extensions

import android.widget.TextView
import com.avocadochif.spannabledsl.library.builders.SpannableBuilder

fun TextView.spannable(init: SpannableBuilder.() -> Unit) {
    text = SpannableBuilder(this.context).apply(init).build().toSpannableString()
}