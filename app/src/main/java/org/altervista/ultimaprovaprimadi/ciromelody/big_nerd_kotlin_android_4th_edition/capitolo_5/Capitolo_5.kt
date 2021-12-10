package org.altervista.ultimaprovaprimadi.ciromelody.big_nerd_kotlin_android_4th_edition.capitolo_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.altervista.ultimaprovaprimadi.ciromelody.big_nerd_kotlin_android_4th_edition.R
import java.lang.Exception

class Capitolo_5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capitolo_5)
       // throw Errore("errore simulato")
        Log.d("DEB","errore simulato",Exception())
        finish()
    }
}