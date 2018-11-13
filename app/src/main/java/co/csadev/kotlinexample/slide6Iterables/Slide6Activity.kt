package co.csadev.kotlinexample.slide6Iterables

import android.app.Activity
import android.os.Bundle
import android.view.View
import co.csadev.kotlinexample.R
import co.csadev.kotlinexample.slide9TopLevel.find
import co.csadev.kotlinexample.slide4Basics.Thing
import co.csadev.kotlinexample.slide9TopLevel.text

@Suppress("UNCHECKED_CAST")
class Slide6Activity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide_6)
    }

    fun onClick(v: View?) {
        val toastAny: Iterable<*> = when (v?.id ?: return) {
            R.id.basicRange -> Example.basicRange
            R.id.halfRange -> Example.halfClosedRange
            R.id.steppedRange -> Example.steppedRange
            R.id.countdownRange -> Example.countdownRange
            R.id.basicList -> Example.basicList
            R.id.mutableList -> {
                Example.mutableList.apply {
                    add(Thing("NewThing$size", size))
                }
            }
            R.id.generatedList -> Example.generatedList
            R.id.youngList -> Example.youngList
            R.id.testList -> Example.testList
            else -> throw IndexOutOfBoundsException("What the heck was that!?")
        }
        find(R.id.listOutput).text = toastAny.fold("") { acc, item -> "$acc${if(acc.isNotBlank()) ", " else ""}$item" }
        if (toastAny is List<*>)
            Example.testList = toastAny as? List<Thing> ?: return
    }

}