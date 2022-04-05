package yy.example.concertrationmemorygame

import android.util.Log
import android.widget.ImageButton
import androidx.lifecycle.ViewModel

class GameViewModel:ViewModel() {

    public lateinit var buttonFirstClick:ImageButton
    public lateinit var buttonSecondClick:ImageButton
    private var foundPair: Int = 0
    public var successPair: Int = 12
    public var count:Int = 0
    public var imageIndexEnd:Int = 38
    public var imageButtonMap: HashMap<ImageButton,Int> = hashMapOf()
    public var buttonList: MutableList<ImageButton> = mutableListOf()
    // lifecycle
    init {
        Log.i("GameViewModel","init")

    }


    public fun foundPair(){
        foundPair++
    }

    public fun getPair():Int{
        return foundPair
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "onCleared")
    }
}