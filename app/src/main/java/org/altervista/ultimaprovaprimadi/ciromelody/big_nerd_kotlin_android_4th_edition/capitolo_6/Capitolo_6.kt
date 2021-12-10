package org.altervista.ultimaprovaprimadi.ciromelody.big_nerd_kotlin_android_4th_edition.capitolo_6

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import org.altervista.ultimaprovaprimadi.ciromelody.big_nerd_kotlin_android_4th_edition.R
import org.altervista.ultimaprovaprimadi.ciromelody.big_nerd_kotlin_android_4th_edition.capitolo2.Question
import org.altervista.ultimaprovaprimadi.ciromelody.big_nerd_kotlin_android_4th_edition.capitolo_4.QuizViewModel

private const val KEY_INDEX="index"
private const val REQUEST_CODE_CHEAT=0

const  val EXTRA_ANSWER_IS_TRUE="org.altervista.ultimaprovaprimadi.ciromelody.big_nerd_kotlin_android_4th_edition.answer_is_true"
class Capitolo_6 : AppCompatActivity(){
    private val TAG="KOT"

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var  nextButton: Button
    private lateinit var  sxButton: Button
    private lateinit var  nextButton_vettore_dx: Button
    private lateinit var  testoDomanda: TextView
    private lateinit var  cheatButton: Button

    private val quizViewModel: QuizViewModel by lazy {
        ViewModelProviders.of(this).get(QuizViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //se il sistema killa l'activity
        val indiceCorrente=savedInstanceState?.getInt(KEY_INDEX,0)?:0
        quizViewModel.currentIndex=indiceCorrente
        setContentView(R.layout.activity_capitolo_6)
        //addizioniamo ViewModel

        val provider:ViewModelProvider= ViewModelProviders.of(this)
        val quizViewModel=provider.get(QuizViewModel::class.java)
        Log.d(TAG,"Vai a QuizViewModel: $quizViewModel")
////////////////////////////////////////
        sxButton=findViewById(R.id.bn_vettore_sx)
        nextButton=findViewById(R.id.bn_next)
        nextButton_vettore_dx = findViewById(R.id.bn_vettore_dx)
        trueButton=findViewById(R.id.bn_vero_cap2)
        falseButton=findViewById(R.id.bn_falso_cap2)
        testoDomanda=findViewById(R.id.tx_titolo_quiz_cap2)
        cheatButton=findViewById(R.id.bn_cheat_button)
        trueButton.setOnClickListener {
                view: View? ->  //visualizza_il_dato_ricevuto(R.string.correct_toast.toString())
            checkAnswer(true)
        }
        falseButton.setOnClickListener {
                view: View? ->  //visualizza_il_dato_ricevuto(R.string.incorrect_toast.toString())
            checkAnswer(false)

        }
        sxButton.setOnClickListener {view: View -> vai_a_domandaPrecedente()
        }
        nextButton.setOnClickListener {view: View -> vai_a_prossimaDomanda()
        }
        nextButton_vettore_dx.setOnClickListener {view: View -> vai_a_prossimaDomanda()
        }
        cheatButton.setOnClickListener { view: View? ->
            //start cheatActivity
            val intent= Intent(this,CheatActivity::class.java)
            intent.putExtra(EXTRA_ANSWER_IS_TRUE,quizViewModel.currentQuestionAnswer)
            //startActivity(intent)
            //oppure
            startActivityForResult(intent,REQUEST_CODE_CHEAT)

        }
        upDateQuestion()
        /*val questionTextREsId= quizViewModel.currentQuestionText
        testoDomanda.setText(questionTextREsId)*/
        // val questionTextREsId=questionBank[currentIndex].textResId
        //  testoDomanda.setText(questionTextREsId)
        val profileName=intent.getStringExtra("Username")
        if(profileName=="Landscape"){
            visualizza_il_dato_ricevuto(profileName)
            ruota_il_dispositivo()}


    }

    private fun upDateQuestion() {
        val questionTextREsId= quizViewModel.currentQuestionText
        testoDomanda.setText(questionTextREsId)
    }

/*
    private  val questionBank= listOf(
        Question(R.string.domanda_mideast,true),
        Question(R.string.domanda_africa,true),
        Question(R.string.domanda_oceani,true),
        Question(R.string.domanda_americhe,false),
        Question(R.string.domanda_mideast,true),
        Question(R.string.domanda_oceano_indiano,false)

    )
*/
    //conserviamo currentIndex in QuizViewModel
    //private var currentIndex=0


    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_INDEX,quizViewModel.currentIndex)
        Log.d("KOT","onSaveInstanceState called")
    }
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.d("KOT","onSaveInstanceState called")

    }

    override fun isChangingConfigurations(): Boolean {
        Log.d("KOT","Change configuration")
        return super.isChangingConfigurations()
    }

    private fun ruota_il_dispositivo() {
        ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    private fun vai_a_domandaPrecedente() {

        /*if(currentIndex==0){currentIndex=1}
        currentIndex=(currentIndex-1)%questionBank.size
        Log.i("KOT","Indice corrente precedente:"+currentIndex.toString())
        val questionTextREsId=questionBank[currentIndex].textResId
        testoDomanda.setText(questionTextREsId)*/

    }

    private fun checkAnswer(userAnswer:Boolean) {
        val correctAnswer=quizViewModel.currentQuestionAnswer
        val messageResId=when{
            quizViewModel.isCheater->R.string.haibarato_toast
            userAnswer==correctAnswer->R.string.correct_toast
            else->R.string.incorrect_toast
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show()

        /*if(quizViewModel.currentQuestionAnswer==userAnswer){
            visualizza_il_dato_ricevuto("Bravo!")} else{
            visualizza_il_dato_ricevuto("Sbagliato!")        *//*if(questionBank[currentIndex].answer==bool){visualizza_il_dato_ricevuto("Bravo!")} else{
            visualizza_il_dato_ricevuto("Sbagliato!")   *//*

        }*/
    }

    private fun vai_a_prossimaDomanda() {
        Log.i("KOT",quizViewModel.size_questionBank.toString())
        quizViewModel.moveToNext()
        //currentIndex=(currentIndex+1)%questionBank.size
        Log.i("KOT","Indice corrente:"+quizViewModel.currentIndex.toString())
        val questionTextREsId=quizViewModel.currentQuestionText
        testoDomanda.setText(questionTextREsId)
        //non sempre il candidato imbroglia
        quizViewModel.isCheater=false
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
    //chiamata->startActivityForResult(intent,REQUEST_CODE_CHEAT)
    //risposta-> setResult(Activity.RESULT_OK,data)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode!=Activity.RESULT_OK){
            //significa che qualcosa è andato storto
            return
        }
        if(requestCode==REQUEST_CODE_CHEAT){
            //se il codice di richiesta è nostro allora estraiamo i dati dall'Intent
            quizViewModel.isCheater=data?.getBooleanExtra(EXSTRA_ANSWER_SHOWN,false)?:false
           //Toast.makeText(applicationContext,quizViewModel.isCheater,Toast.LENGTH_LONG).show()
            Log.d("TORN",quizViewModel.isCheater.toString())
        }

    }
}