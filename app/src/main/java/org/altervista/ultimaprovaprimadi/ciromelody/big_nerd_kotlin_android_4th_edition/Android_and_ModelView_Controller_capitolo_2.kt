package org.altervista.ultimaprovaprimadi.ciromelody.big_nerd_kotlin_android_4th_edition

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.altervista.ultimaprovaprimadi.ciromelody.big_nerd_kotlin_android_4th_edition.capitolo2.Question
import org.altervista.ultimaprovaprimadi.ciromelody.big_nerd_kotlin_android_4th_edition.capitolo2.Utility

class Android_and_ModelView_Controller_capitolo_2 : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var  nextButton: Button
    private lateinit var  testoDomanda: TextView
    private  val questionBank= listOf(
        Question(R.string.domanda_mideast,true),
        Question(R.string.domanda_africa,true),
        Question(R.string.domanda_oceani,true),
        Question(R.string.domanda_americhe,false),
        Question(R.string.domanda_mideast,true),
        Question(R.string.domanda_oceano_indiano,false)

    )
    private var currentIndex=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_and__model_view__controller)
        nextButton=findViewById(R.id.bn_next)
        trueButton=findViewById(R.id.bn_vero_cap2)
        falseButton=findViewById(R.id.bn_falso_cap2)
        testoDomanda=findViewById(R.id.tx_titolo_quiz_cap2)
        trueButton.setOnClickListener {
                view: View? ->  //visualizza_il_dato_ricevuto(R.string.correct_toast.toString())
                checkAnswer(true)
        }
        falseButton.setOnClickListener {
                view: View? ->  //visualizza_il_dato_ricevuto(R.string.incorrect_toast.toString())
                checkAnswer(false)

        }
        nextButton.setOnClickListener {view:View-> vai_a_prossimaDomanda()
        }
        val questionTextREsId=questionBank[currentIndex].textResId
            testoDomanda.setText(questionTextREsId)
      }

    private fun checkAnswer(bool:Boolean) {
        if(questionBank[currentIndex].answer==bool){visualizza_il_dato_ricevuto("Bravo!")} else{
            visualizza_il_dato_ricevuto("Sbagliato!")                }
    }

    private fun vai_a_prossimaDomanda() {
        Log.i("KOT",questionBank.size.toString())

        currentIndex=(currentIndex+1)%questionBank.size
        Log.i("KOT","Indice corrente:"+currentIndex.toString())
        val questionTextREsId=questionBank[currentIndex].textResId
        testoDomanda.setText(questionTextREsId)
    }

    private fun visualizza_il_dato_ricevuto(profileName: String?) {

        var toast = Toast.makeText(
            this,
            profileName,
            Toast.LENGTH_SHORT
        )
        toast.setGravity(Gravity.TOP or Gravity.RIGHT, 21, 34)
        toast.show()
    }

}