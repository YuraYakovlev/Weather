package com.example.weather

import android.app.AlertDialog
import android.content.Context
import android.widget.EditText

object DialogManager {
    private lateinit var ok: String
    private lateinit var cancel: String
    private lateinit var enLocMessage: String

    fun locationSettingsDialog(context: Context, listener: Listener) {
        initTexts(context)
        val builder = AlertDialog.Builder(context)
        val dialog = builder.create()
        dialog.setTitle(R.string.enable_location_title)
        dialog.setMessage(enLocMessage)
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, ok) { _, _ ->
            listener.onClick(null)
            dialog.dismiss()
        }
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, cancel){_,_ ->
            dialog.dismiss()
        }
        dialog.show()
    }

    fun searchByNameDialog(context: Context, listener: Listener) {
        initTexts(context)
        val builder = AlertDialog.Builder(context)
        val edName = EditText(context)
        builder.setView(edName)
        val dialog = builder.create()
        dialog.setTitle(R.string.city_name)
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, ok) { _, _ ->
            listener.onClick(edName.text.toString())
            dialog.dismiss()
        }
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, cancel){_,_ ->
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun initTexts(context: Context){
        ok = context.getText(R.string.ok) as String
        cancel = context.getText(R.string.cancel) as String
        enLocMessage = context.getText(R.string.enable_location_message) as String
    }

    interface Listener{
        fun onClick(name: String?)
    }
}