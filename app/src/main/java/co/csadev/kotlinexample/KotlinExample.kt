package co.csadev.kotlinexample

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import co.csadev.kotlinexample.slide10Coroutines.Slide10Activity
import co.csadev.kotlinexample.slide3FirstNotes.Slide3Activity
import co.csadev.kotlinexample.slide4Basics.Slide4Activity
import co.csadev.kotlinexample.slide6Iterables.Slide6Activity
import co.csadev.kotlinexample.slide9TopLevel.appContext

class KotlinExample : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        appContext = applicationContext
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_example)
    }

    fun onClick(v: View?) {
        startActivity(
            Intent(
                this,
                when (v?.id ?: return) {
                    R.id.slide3 -> Slide3Activity::class.java
                    R.id.slide4 -> Slide4Activity::class.java
                    R.id.slide6 -> Slide6Activity::class.java
                    R.id.slide10 -> Slide10Activity::class.java
                    else -> throw IllegalArgumentException("Unknown button")
                }
            )
        )
    }
}
