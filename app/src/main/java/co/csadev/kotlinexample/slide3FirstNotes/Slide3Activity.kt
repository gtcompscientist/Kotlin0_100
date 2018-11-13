package co.csadev.kotlinexample.slide3FirstNotes

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import co.csadev.kotlinexample.R

class Slide3Activity: Activity() {
    var testBool: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide_3)
    }

    fun onClick(v: View?) {
        val example = Example()
        val toastAny = when (v?.id) {
            R.id.returnSomething -> example.thisWillReturnSomething(testBool)
            R.id.returnUnit -> example.thisWillReturnWithoutAnything(testBool)
            R.id.returnOpposite -> example.thisWillReturnTheOpposite(testBool)
            R.id.returnNothing -> example.thisWillReturnNothing(testBool)
            else -> "Oops!"
        }
        Toast.makeText(this, "$toastAny", Toast.LENGTH_SHORT).show()
        testBool = !testBool
    }

}