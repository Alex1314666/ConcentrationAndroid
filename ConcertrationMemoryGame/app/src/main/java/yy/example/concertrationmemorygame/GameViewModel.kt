package yy.example.concertrationmemorygame

import android.util.Log
import android.widget.ImageButton
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel:ViewModel() {

    public lateinit var buttonFirstClick:ImageButton
    public lateinit var buttonSecondClick:ImageButton

    public var imageIndexEnd:Int = 38
    public var count:Int = 0
    public var imageButtonMap: HashMap<ImageButton,Int> = hashMapOf()
    public var buttonList: MutableList<ImageButton> = mutableListOf()
    public var drawableMap:  HashMap<Int,Int> = hashMapOf()
    public var drawableList: MutableList<Int> = mutableListOf()
    // lifecycle
    init {
        Log.i("GameViewModel","init")

    }

    fun isFirstClick():Boolean{
//        return count_.value!!.rem(2) == 0
        return count % 2 == 0
    }
    fun onIncrementCount(){
        count++
    }

    public fun gameEnd():Boolean{
        if(imageButtonMap.isEmpty()){
            return true
        }
        return false
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "onCleared")
    }
}