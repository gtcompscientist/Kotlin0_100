package co.csadev.kotlinexample.slide4Basics

object Example {
    private lateinit var seuss: Thing

    fun mustCallFirst(thingName: String): String {
        seuss = Thing(thingName)
        return thingName
    }

    //throws an exception because we haven't initialized it if called first
    fun willCrashIfCalledFirst(): Thing {
        return seuss
    }

    fun whatsMyName() = "Seuss Thing has a name of ${seuss.name}, by default: $seuss"

}