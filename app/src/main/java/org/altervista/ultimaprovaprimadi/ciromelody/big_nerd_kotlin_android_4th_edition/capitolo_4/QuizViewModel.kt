package org.altervista.ultimaprovaprimadi.ciromelody.big_nerd_kotlin_android_4th_edition.capitolo_4

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import org.altervista.ultimaprovaprimadi.ciromelody.big_nerd_kotlin_android_4th_edition.R
import org.altervista.ultimaprovaprimadi.ciromelody.big_nerd_kotlin_android_4th_edition.capitolo2.Question

private const val TAG="QuizViewModel"
class QuizViewModel:ViewModel() {
    init{
        Log.d(TAG,"ViewModel instanza creata!")

    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG,"ViewModel instanza distrutta!")
    }
    var  currentIndex:Int=0
    private  val questionBank= listOf(
        Question(R.string.domanda_mideast,true),
        Question(R.string.domanda_africa,true),
        Question(R.string.domanda_oceani,true),
        Question(R.string.domanda_americhe,false),
        Question(R.string.domanda_mideast,true),
        Question(R.string.domanda_oceano_indiano,false)

    )
    val size_questionBank=questionBank.size

    val currentQuestionAnswer:Boolean
    get() = questionBank[currentIndex].answer
    val currentQuestionText:Int
    get() = questionBank[currentIndex].textResId
    fun moveToNext(){
        currentIndex=(currentIndex+1)%questionBank.size
    }
  var isCheater=false
}