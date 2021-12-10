package org.altervista.ultimaprovaprimadi.ciromelody.big_nerd_kotlin_android_4th_edition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import org.altervista.ultimaprovaprimadi.ciromelody.big_nerd_kotlin_android_4th_edition.capitolo_4.Capitolo_4
import org.altervista.ultimaprovaprimadi.ciromelody.big_nerd_kotlin_android_4th_edition.capitolo_5.Capitolo_5
import org.altervista.ultimaprovaprimadi.ciromelody.big_nerd_kotlin_android_4th_edition.capitolo_6.Capitolo_6

class MainActivity : AppCompatActivity() {
    private lateinit var toastButton: Button
    private lateinit var quizButton: Button
    private lateinit var capitolo2Button: Button
    private lateinit var capitolo3Button: Button
    private lateinit var capitolo4Button: Button
    private lateinit var capitolo5Button: Button
    private lateinit var capitolo6Button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        capitolo6Button=findViewById(R.id.button_capitolo_6)
        capitolo5Button=findViewById(R.id.button_capitolo_5)
        capitolo4Button=findViewById(R.id.button_capitolo_4)
        capitolo3Button=findViewById(R.id.button_capitolo_3)
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
        capitolo3Button.setOnClickListener {
            val intent = Intent(this@MainActivity,Android_and_ModelView_Controller_capitolo_2::class.java)
            intent.putExtra("Username","Landscape")
             startActivity(intent) }
        capitolo4Button.setOnClickListener {
            val intent = Intent(this@MainActivity, Capitolo_4::class.java)
            intent.putExtra("Username","Landscape")
            startActivity(intent) }
        capitolo5Button.setOnClickListener {
            val intent = Intent(this@MainActivity, Capitolo_5::class.java)
            intent.putExtra("Username","Landscape")
            startActivity(intent) }
        capitolo6Button.setOnClickListener {
            val intent = Intent(this@MainActivity, Capitolo_6::class.java)
            intent.putExtra("Username","Landscape")
            startActivity(intent) }
    }
}