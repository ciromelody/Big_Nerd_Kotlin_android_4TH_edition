package org.altervista.ultimaprovaprimadi.ciromelody.big_nerd_kotlin_android_4th_edition

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast

class Two_button_GeoQuiz : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_button)
        trueButton=findViewById(R.id.bn_vero)
        falseButton=findViewById(R.id.bn_falso)

        trueButton.setOnClickListener { 
            view: View? ->  visualizza_il_dato_ricevuto(R.string.correct_toast.toString())
        }
        falseButton.setOnClickListener {
                view: View? ->  visualizza_il_dato_ricevuto(R.string.incorrect_toast.toString())
        }
        val profileName=intent.getStringExtra("Username")
        visualizza_il_dato_ricevuto(profileName)
    }

    public fun visualizza_il_dato_ricevuto(profileName: String?) {

        var toast = Toast.makeText(
            this,
            profileName,
            Toast.LENGTH_SHORT
        )
        toast.setGravity(Gravity.TOP or Gravity.RIGHT, 21, 34)
        toast.show()
    }
}