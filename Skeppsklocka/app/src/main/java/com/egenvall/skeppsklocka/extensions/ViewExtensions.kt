package com.egenvall.skeppsklocka.extensions

import android.content.Context
import android.support.annotation.ColorInt
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import org.jetbrains.anko.AnkoComponent

fun ViewGroup.hide() {
    visibility = View.GONE
}

fun Context.inflateLayout(layoutResId: Int): View {
    return inflateView(this, layoutResId, null, false)
}

fun Context.inflateLayout(layoutResId: Int, parent: ViewGroup): View {
    return inflateLayout(layoutResId, parent, true)
}

fun Context.inflateLayout(layoutResId: Int, parent: ViewGroup, attachToRoot: Boolean): View {
    return inflateView(this, layoutResId, parent, attachToRoot)
}

private fun inflateView(context: Context, layoutResId: Int, parent: ViewGroup?, attachToRoot: Boolean): View {
    return LayoutInflater.from(context).inflate(layoutResId, parent, attachToRoot)
}

fun View.showSnackbar(message: String, length: Int = Snackbar.LENGTH_LONG, f: (Snackbar.() -> Unit) = {}) {
    val snack = Snackbar.make(this, message, length)
    snack.f()
    snack.show()
}

fun View.showSnackbar(@StringRes message: Int, length: Int = Snackbar.LENGTH_LONG, f: (Snackbar.() -> Unit) = {}) {
    showSnackbar(resources.getString(message), length, f)
}

fun Snackbar.action(action: String, @ColorInt color: Int? = null, listener: (View) -> Unit) {
    setAction(action, listener)
    color?.let { setActionTextColor(color) }
}
