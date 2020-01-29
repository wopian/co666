package me.wopian.module.hatayama

import android.content.Context
import android.content.res.Resources

fun getFlagResource(context: Context?, code: String?): Int {
    val resId = context?.resources?.getIdentifier("flag_$code", "drawable", "me.wopian.module.hatayama")
    return resId as Int
}

fun getFlagResource(resource: Resources, code: String?): Int {
    return resource.getIdentifier("flag_$code", "drawable", "me.wopian.module.hatayama")
}