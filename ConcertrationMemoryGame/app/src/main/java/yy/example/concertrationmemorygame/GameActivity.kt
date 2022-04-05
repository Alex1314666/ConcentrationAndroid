package yy.example.concertrationmemorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import org.intellij.lang.annotations.Identifier
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    private lateinit var gameViewModel: GameViewModel
    //declaring a map of integer(id) to UIButton
//    private var imageIndexEnd:Int = 38
//    private var imageButtonMap: HashMap<ImageButton,Int> = hashMapOf()
//    private var buttonList: MutableList<ImageButton> = mutableListOf()
 //   private var pair:Int = 0
//    private var count:Int = 0
//    private lateinit var buttonFirstClick:ImageButton
//    private lateinit var buttonSecondClick:ImageButton
    private lateinit var countScoreTextView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        gameViewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        countScoreTextView= findViewById(R.id.GameTextViewCountScore)
        setUpGame()


    }


    private fun setImageBack(button1:ImageButton, button2:ImageButton){
       button1.setImageResource(R.drawable.card_background)
       button2.setImageResource(R.drawable.card_background)
    }

    private fun setImageFront(button:ImageButton,identifier: Int){
        when(identifier){
            0->{
                button.setImageResource(R.drawable.card_00)
            }
            1->{
                button.setImageResource(R.drawable.card_01)
            }
            2->{
                button.setImageResource(R.drawable.card_02)
            }
            3->{
                button.setImageResource(R.drawable.card_03)
            }
            4->{
                button.setImageResource(R.drawable.card_04)
            }
            5->{
                button.setImageResource(R.drawable.card_05 )
            }
            6->{
                button.setImageResource(R.drawable.card_06)
            }
            7->{
                button.setImageResource(R.drawable.card_07)
            }
            8->{
                button.setImageResource(R.drawable.card_08)
            }
            9->{
                button.setImageResource(R.drawable.card_09)
            }
            10->{
                button.setImageResource(R.drawable.card_10)
            }
            11->{
                button.setImageResource(R.drawable.card_11)
            }
            12->{
                button.setImageResource(R.drawable.card_12)
            }
            13->{
                button.setImageResource(R.drawable.card_13)
            }
            14->{
                button.setImageResource(R.drawable.card_14 )
            }
            15->{
                button.setImageResource(R.drawable.card_15)
            }
            16->{
                button.setImageResource(R.drawable.card_16)
            }
            17->{
                button.setImageResource(R.drawable.card_17)
            }
            18->{
                button.setImageResource(R.drawable.card_18)
            }
            19->{
                button.setImageResource(R.drawable.card_19)
            }
            20->{
                button.setImageResource(R.drawable.card_20)
            }
            21->{
                button.setImageResource(R.drawable.card_21)
            }
            22->{
                button.setImageResource(R.drawable.card_22)
            }
            23->{
                button.setImageResource(R.drawable.card_23)
            }
            24->{
                button.setImageResource(R.drawable.card_24)
            }
            25->{
                button.setImageResource(R.drawable.card_25)
            }
            26->{
                button.setImageResource(R.drawable.card_26)
            }
            27->{
                button.setImageResource(R.drawable.card_27)
            }
            28->{
                button.setImageResource(R.drawable.card_28)
            }
            29->{
                button.setImageResource(R.drawable.card_29)
            }
            30->{
                button.setImageResource(R.drawable.card_30)
            }
            31->{
                button.setImageResource(R.drawable.card_31)
            }
            32->{
                button.setImageResource(R.drawable.card_32)
            }
            33->{
                button.setImageResource(R.drawable.card_33)
            }
            34->{
                button.setImageResource(R.drawable.card_34)
            }
            35->{
                button.setImageResource(R.drawable.card_35)
            }
            36->{
                button.setImageResource(R.drawable.card_36)
            }
            37->{
                button.setImageResource(R.drawable.card_37)
            }
            38->{
                button.setImageResource(R.drawable.card_38)
            }
        }
    }

    private fun initialMap(){
        val identifier = (0..gameViewModel.imageIndexEnd).random()
        gameViewModel.imageButtonMap[pickRandomFromList()] = identifier
        gameViewModel.imageButtonMap[pickRandomFromList()] = identifier
    }

    private fun pickRandomFromList(): ImageButton {
        var pick = gameViewModel.buttonList.random()
        gameViewModel.buttonList.remove(pick)
        return pick
    }

    private fun setUpGame(){
        var button00:ImageButton = findViewById(R.id.GameImageButton00)
        var button01:ImageButton = findViewById(R.id.GameImageButton01)
        var button02:ImageButton = findViewById(R.id.GameImageButton02)
        var button03:ImageButton = findViewById(R.id.GameImageButton03)

        var button10:ImageButton = findViewById(R.id.GameImageButton10)
        var button11:ImageButton = findViewById(R.id.GameImageButton11)
        var button12:ImageButton = findViewById(R.id.GameImageButton12)
        var button13:ImageButton = findViewById(R.id.GameImageButton13)

        var button20:ImageButton = findViewById(R.id.GameImageButton20)
        var button21:ImageButton = findViewById(R.id.GameImageButton21)
        var button22:ImageButton = findViewById(R.id.GameImageButton22)
        var button23:ImageButton = findViewById(R.id.GameImageButton23)

        var button30:ImageButton = findViewById(R.id.GameImageButton30)
        var button31:ImageButton = findViewById(R.id.GameImageButton31)
        var button32:ImageButton = findViewById(R.id.GameImageButton32)
        var button33:ImageButton = findViewById(R.id.GameImageButton33)

        var button40:ImageButton = findViewById(R.id.GameImageButton40)
        var button41:ImageButton = findViewById(R.id.GameImageButton41)
        var button42:ImageButton = findViewById(R.id.GameImageButton42)
        var button43:ImageButton = findViewById(R.id.GameImageButton43)

        var button50:ImageButton = findViewById(R.id.GameImageButton50)
        var button51:ImageButton = findViewById(R.id.GameImageButton51)
        var button52:ImageButton = findViewById(R.id.GameImageButton52)
        var button53:ImageButton = findViewById(R.id.GameImageButton53)
        gameViewModel.buttonList.add(button00)
        gameViewModel.buttonList.add(button01)
        gameViewModel.buttonList.add(button02)
        gameViewModel.buttonList.add(button03)

        gameViewModel.buttonList.add(button10)
        gameViewModel.buttonList.add(button11)
        gameViewModel.buttonList.add(button12)
        gameViewModel.buttonList.add(button13)

        gameViewModel.buttonList.add(button20)
        gameViewModel.buttonList.add(button21)
        gameViewModel.buttonList.add(button22)
        gameViewModel.buttonList.add(button23)

        gameViewModel.buttonList.add(button30)
        gameViewModel.buttonList.add(button31)
        gameViewModel.buttonList.add(button32)
        gameViewModel.buttonList.add(button33)

        gameViewModel.buttonList.add(button40)
        gameViewModel.buttonList.add(button41)
        gameViewModel.buttonList.add(button42)
        gameViewModel.buttonList.add(button43)

        gameViewModel.buttonList.add(button50)
        gameViewModel.buttonList.add(button51)
        gameViewModel.buttonList.add(button52)
        gameViewModel.buttonList.add(button53)

        while(gameViewModel.buttonList.isNotEmpty()){
            initialMap()
        }
    }


    fun onCardButtonClick(view: View) {
        gameViewModel.count++

        // if it is the first click of a round
        if(gameViewModel.count % 2 == 1){
            gameViewModel.buttonFirstClick = findViewById(view.id)
            val identifier = gameViewModel.imageButtonMap[gameViewModel.buttonFirstClick]!!
            setImageFront(gameViewModel.buttonFirstClick,identifier)

        }
        else if(gameViewModel.count % 2 == 0){
            gameViewModel.buttonSecondClick = findViewById(view.id)
            if(gameViewModel.buttonFirstClick != gameViewModel.buttonSecondClick) {
                var identifier = gameViewModel.imageButtonMap[gameViewModel.buttonSecondClick]!!
                setImageFront(gameViewModel.buttonSecondClick,identifier)

                if (gameViewModel.imageButtonMap[gameViewModel.buttonFirstClick] == gameViewModel.imageButtonMap[gameViewModel.buttonSecondClick]) {

                    gameViewModel.foundPair()
                    Handler().postDelayed({
                        //doSomethingHere()
                        gameViewModel.buttonFirstClick.isVisible = false
                        gameViewModel.buttonSecondClick.isVisible = false
                    }, 300)
                    // pop from map
                    gameViewModel.imageButtonMap.remove(gameViewModel.buttonFirstClick)
                    gameViewModel.imageButtonMap.remove(gameViewModel.buttonSecondClick)
                }
                else{
                    Handler().postDelayed({
                        //doSomethingHere()
                        setImageBack(gameViewModel.buttonFirstClick,gameViewModel.buttonSecondClick)
                    }, 350)
                }
            }
            else{
                gameViewModel.count--
            }
        }
        countScoreTextView.text = gameViewModel.count.toString()
    }

}