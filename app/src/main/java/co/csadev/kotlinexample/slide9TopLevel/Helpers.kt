@file:Suppress("NOTHING_TO_INLINE", "unused")

package co.csadev.kotlinexample.slide9TopLevel

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes

lateinit var appContext: Context

fun List<*>.exampleCount() = this.count { it != null }

inline fun Activity.find(@IdRes id: Int): View? = findViewById(id)

var View?.text: CharSequence
    get() {
        return (this as? TextView)?.text ?: ""
    }
    set(value) {
        (this as? TextView ?: return).text = value
    }
