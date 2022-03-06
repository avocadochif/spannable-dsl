package com.avocadochif.spannabledsl.library.extensions

fun <E> MutableList<E>.addIf(item: E, condition: Boolean) {
    if (condition) add(item)
}