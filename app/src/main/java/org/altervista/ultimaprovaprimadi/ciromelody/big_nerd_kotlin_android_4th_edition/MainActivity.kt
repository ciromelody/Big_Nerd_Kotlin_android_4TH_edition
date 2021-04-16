package org.altervista.ultimaprovaprimadi.ciromelody.big_nerd_kotlin_android_4th_edition

import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var toastButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toastButton=findViewById(R.id.button_toast)
        toastButton.setOnClickListener{view :
                                       View->Toast.makeText(this,
                                          "Toast:hai cliccato il bottone",Toast.LENGTH_LONG).show()}
    }
}