package co.csadev.kotlinexample.slide6Iterables

import co.csadev.kotlinexample.slide4Basics.Thing

@Suppress("unused", "MemberVisibilityCanBePrivate")
object Example {

    val basicRange = (0..100)
    val halfClosedRange = (0 until 100)
    val steppedRange = (1 until 100 step 2)
    val countdownRange = (100 downTo 0)

    val basicList = listOf(
        Thing("Thing1"),
        Thing("Thing2")
    )
    val mutableList = mutableListOf(
        Thing("Thing1"),
        Thing("Thing2")
    )

    val generatedList = basicRange.map { Thing("Thing$it", it) }

    val youngList = generatedList.filter { it.age < 21 }

    var testList: List<Thing> = mutableList
        set(value) { field = value.filter { it.age % 2 == 0 } }
}