package co.csadev.kotlinexample.slide4Basics

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import co.csadev.kotlinexample.R

class Slide4Activity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide_4)
    }

    fun onClick(v: View?) {
        val toastAny: Any = when (v?.id ?: return) {
            R.id.callFirst -> Example.mustCallFirst("Thing 1")
            R.id.crashFirst -> Example.willCrashIfCalledFirst()
            R.id.name -> Example.whatsMyName()
            else -> "Oops!"
        }
        Toast.makeText(this, "$toastAny", Toast.LENGTH_SHORT).show()
        if (toastAny is Thing)
            v.setBackgroundColor(toastAny.color)
    }

}