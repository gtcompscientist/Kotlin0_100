package co.csadev.kotlinexample.slide10Coroutines

import android.app.Activity
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AlertDialog
import co.csadev.kotlinexample.R
import co.csadev.kotlinexample.slide9TopLevel.find
import co.csadev.kotlinexample.slide9TopLevel.text
import kotlinx.coroutines.*
import kotlin.coroutines.resume

@Suppress("UNCHECKED_CAST")
class Slide10Activity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide_10)
    }

    var counterJob: Job? = null

    fun onClick(v: View?) {
        when (v?.id ?: return) {
            R.id.goButton -> {
                if (counterJob != null) {
                    counterJob?.cancel()
                    counterJob = null
                    return
                }
                counterJob = GlobalScope.launch(Dispatchers.Main) {
                    (0..10_000).forEach {
                        delay(10)
                        find(R.id.listOutput).text = "$it"
                    }
                }
            }
            R.id.showDialog -> {
                GlobalScope.launch(Dispatchers.Main) {
                    find(R.id.listOutput).text = showPrompt()
                }
            }
        }
    }

    suspend fun showPrompt() = suspendCancellableCoroutine<String>  { cont ->
        val listener = DialogInterface.OnClickListener { dialog, which ->
            when (which) {
                DialogInterface.BUTTON_NEGATIVE -> {
                    dialog.cancel()
                    cont.resumeWith(Result.success("Canceled"))
                }
                DialogInterface.BUTTON_NEUTRAL -> {
                    dialog.dismiss()
                    cont.resume("Indecisive?")
                }
                DialogInterface.BUTTON_POSITIVE -> {
                    dialog.dismiss()
                    cont.resume("YAY!")
                }
            }
        }
        AlertDialog.Builder(this)
            .setTitle("Dialog from Coroutine")
            .setMessage("Click a button, any button")
            .setPositiveButton("Good", listener)
            .setNegativeButton("Bad", listener)
            .setNeutralButton("Indifferent", listener)
            .create()
            .show()
    }

}