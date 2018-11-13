package co.csadev.kotlinexample.slide4Basics

import co.csadev.kotlinexample.slide2Migration.ExampleKlass

class KonstructThings {

    val constructedClass: ExampleKlass
        get() = ExampleKlass(true).apply {
                addClass("Test123")
                addListener({
                    println("Class Added: $it")
                    return@addListener true
                },{
                    println("Class Added: $it")
                    return@addListener true
                })
            }

}
