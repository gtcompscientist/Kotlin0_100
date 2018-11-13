@file:Suppress("unused")

package co.csadev.kotlinexample.slide2Migration

import java.util.ArrayList

class ExampleKlass(var isAvailable: Boolean = false,
                   private var maxClasses: Int = 10,
                   private var classList: ArrayList<String> = ArrayList()) {

    //v1
//    internal val listeners = ArrayList<Updater>()
//    fun addListener(updater: Updater) {
//        listeners.add(updater)
//    }
//    interface Updater {
//        fun newClass(clazz: String): Boolean
//        fun classRemoved(clazz: String): Boolean
//    }


    //v2
    private val newClassList = ArrayList<(String) -> Boolean>()
    private val classRemovedList = ArrayList<(String) -> Boolean>()
    fun addListener(newClass: (String) -> Boolean, classRemoved: (String) -> Boolean) {
        newClassList.add(newClass)
        classRemovedList.add(classRemoved)
    }


    //v1
    fun addClass(clazz: String): Boolean {
        if (maxClasses == classList.size)
            return false

        classList.add(clazz)
//        for (l in listeners) {
//            l.newClass(clazz)
//        }
        return true
    }

    //v2
//    fun addClass(clazz: String): Boolean {
//        if (classList.size == maxClasses)
//            return false
//
//        classList.add(clazz)
//        listeners.forEach { it.newClass(clazz) }
//        return true
//    }

    // v3
//    fun addClass(clazz: String)
//          = when (classList.size) {
//            maxClasses -> false
//            else -> {
//                classList.add(clazz)
//                listeners.forEach { it.newClass(clazz) }
//                true
//            }
//        }

    fun removeClass(clazz: String): Boolean {
        if (!classList.contains(clazz))
            return false

        classList.remove(clazz)
        //v1
//        listeners.forEach { it.classRemoved(clazz) }
        //v2
//        classRemovedList.forEach { it.invoke(clazz) }
        return true
    }

}

