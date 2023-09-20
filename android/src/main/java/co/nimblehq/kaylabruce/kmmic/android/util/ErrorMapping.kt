package co.nimblehq.kaylabruce.kmmic.android.util

import android.content.Context
import co.nimblehq.kaylabruce.kmmic.android.R

fun Throwable.genericError(context: Context): String =
    message ?: context.getString(R.string.error_message)
