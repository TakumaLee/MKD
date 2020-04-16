package idv.kuma.interview.mkd.utils

import android.content.res.Resources

fun Int.dp(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()
fun Int.px(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()