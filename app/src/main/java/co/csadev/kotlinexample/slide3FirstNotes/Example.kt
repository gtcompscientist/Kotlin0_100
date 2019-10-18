package co.csadev.kotlinexample.slide3FirstNotes

import java.lang.IllegalArgumentException

@Suppress("unused", "RedundantSemicolon", "RedundantUnitReturnType")
class Example {
    val thisCantBeChanged: Int = 0;
    var thisCanBeChanged = "Editable"

    fun thisWillReturnSomething(b: Boolean): Any {
        //Note the "lifted" return, and that in this case an `if` *MUST* have an `else`
        return if (b) thisCanBeChanged else thisCantBeChanged
    }

    //The return type of Unit here is redundant, and simply demonstrative
    fun thisWillReturnWithoutAnything(b: Boolean?) {
        //Note that the `if` clause is comparing to `true` because we've passed in a potentially null Boolean
        println(if (b == true) thisCanBeChanged else thisCantBeChanged)
    }

    fun thisWillReturnNothing(b: Boolean?): Nothing {
        if (b == null)
            throw NullPointerException("I mean, what did you expect?")

        throw IllegalArgumentException("The Nothing has gotten you!")
    }

    fun thisWillReturnTheOpposite(b: Boolean) = !b
}