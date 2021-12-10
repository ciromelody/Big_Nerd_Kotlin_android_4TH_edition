package org.altervista.ultimaprovaprimadi.ciromelody.big_nerd_kotlin_android_4th_edition.capitolo_6

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.view.GravityCompat.apply
import org.altervista.ultimaprovaprimadi.ciromelody.big_nerd_kotlin_android_4th_edition.R
 const val KEY_HA_VISTO_LA_RISPOSTA="SCHIACCIATOILBOTTONE"
 const val EXSTRA_ANSWER_SHOWN="org.altervista.ultimaprovaprimadi.ciromelody.big_nerd_kotlin_android_4th_edition.capitolo_6"
class CheatActivity : AppCompatActivity() {
    private  var ha_premuto_il_bottone=false
    private var answerIsTrue=false
    lateinit var answerTextView: TextView
    lateinit var showAnswerButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)
        //challenge:Closing Loopholes for Cheaters
        ha_premuto_il_bottone= savedInstanceState?.getBoolean(KEY_HA_VISTO_LA_RISPOSTA,false)?:ha_premuto_il_bottone
        answerIsTrue=intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false)
        answerTextView= findViewById(R.id.answer_text_view)
        showAnswerButton=findViewById(R.id.show_answer_button)
        showAnswerButton.setOnClickListener {
            val answerText=when{
                answerIsTrue->R.string.true_button
                else->R.string.false_button
            }
            answerTextView.setText(answerText)
            //creiamo qui una funzione per lo startActivityForResult per capire se ha
            //premuto il bottone per conoscere la risposta esatta
            ha_premuto_il_bottone=true
            setAnswerShownResult(true)
        }
    }

    private fun setAnswerShownResult(isAnswerShown: Boolean) {
       val data= Intent().apply{
         putExtra(EXSTRA_ANSWER_SHOWN,isAnswerShown)
       }
      //qui passiamo l'intent all'activity chiamante molto importante perchè nell'intent
      // possiamo passare anche dati piu' strutturati
      //i dati saranno ricevuti dal chiamante in onActivityResult
      setResult(Activity.RESULT_OK,data)
  }
    //challenge:Closing Loopholes for Cheaters
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // il valore viene salvato per impedire che un cambiamento di stato resetti
        //cancelli l'operazione dell imbroglione
        outState.putBoolean(KEY_HA_VISTO_LA_RISPOSTA, ha_premuto_il_bottone)
        Log.d("KOT","onSaveInstanceState called")
    }
}