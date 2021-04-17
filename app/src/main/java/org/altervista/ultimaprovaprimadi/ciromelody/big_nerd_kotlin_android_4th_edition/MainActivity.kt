package org.altervista.ultimaprovaprimadi.ciromelody.big_nerd_kotlin_android_4th_edition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var toastButton: Button
    private lateinit var quizButton: Button
    private lateinit var capitolo2Button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        capitolo2Button=findViewById(R.id.button_android_viewmodel)
        toastButton=findViewById(R.id.button_toast)
        quizButton=findViewById(R.id.button_two_button)
        toastButton.setOnClickListener{view :
                                       View->Toast.makeText(this,
                                          "Toast:hai cliccato il bottone",Toast.LENGTH_LONG).show()}
        quizButton.setOnClickListener {
            val intent = Intent(this@MainActivity,Two_button_GeoQuiz::class.java)
            intent.putExtra("Username","John Doe")
            startActivity(intent) }
        capitolo2Button.setOnClickListener {
            val intent = Intent(this@MainActivity,Android_and_ModelView_Controller_capitolo_2::class.java)
            var b = Bundle()
            b.putBoolean("isActive", true)
            intent.putExtras(b)
            startActivity(intent) }
    }
}