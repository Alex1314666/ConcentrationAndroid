package yy.example.concertrationmemorygame

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import org.intellij.lang.annotations.Identifier
import yy.example.concertrationmemorygame.databinding.ActivityGameBinding
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    private lateinit var gameViewModel: GameViewModel

    private lateinit var countScoreTextView:TextView
    private lateinit var binding:ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // not using the old setContentView, need to use the binding version
        // setContentView(R.layout.activity_game)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_game)
        binding.viewModel = GameViewModel()
        binding.executePendingBindings()
        binding.lifecycleOwner = this

        gameViewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        countScoreTextView= findViewById(R.id.GameTextViewCountScore)
        countScoreTextView.text = gameViewModel.count.toString()
//        // binding.count = gameViewModel.count
        setUpGame()
        Log.i("In onCreate", "Test")
    }

    private fun setImageBack(button:ImageButton){
       button.setImageResource(R.drawable.card_background)
    }
    private fun setImageFront(button:ImageButton,identifier: Int){
        button.setImageResource(gameViewModel.drawableMap[identifier]!!)
    }

    private fun initialMap(){
        var identifier = gameViewModel.drawableList.random()
        gameViewModel.drawableList.remove(identifier)
        gameViewModel.imageButtonMap[pickRandomFromList()] = identifier
        gameViewModel.imageButtonMap[pickRandomFromList()] = identifier

    }
//    private fun initDrawableMap(){
//        var identifier = 0
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_00
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_01
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_02
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_03
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_04
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_05
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_06
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_07
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_08
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_09
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_10
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_11
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_12
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_13
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_14
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_15
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_16
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_17
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_18
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_19
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_20
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_21
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_22
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_23
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_24
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_25
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_26
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_27
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_28
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_29
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_30
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_31
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_32
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_33
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_34
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_35
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_36
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_37
//        gameViewModel.drawableMap[identifier++] = R.drawable.card_38
//    }

    private fun pickRandomFromList(): ImageButton {
        var pick = gameViewModel.buttonList.random()
        gameViewModel.buttonList.remove(pick)
        return pick
    }
    private fun initDrawableList(){
        gameViewModel.drawableList.add(R.drawable.card_00)
        gameViewModel.drawableList.add(R.drawable.card_01)
        gameViewModel.drawableList.add(R.drawable.card_02)
        gameViewModel.drawableList.add(R.drawable.card_03)
        gameViewModel.drawableList.add(R.drawable.card_04)
        gameViewModel.drawableList.add(R.drawable.card_05)
        gameViewModel.drawableList.add(R.drawable.card_06)
        gameViewModel.drawableList.add(R.drawable.card_07)
        gameViewModel.drawableList.add(R.drawable.card_08)
        gameViewModel.drawableList.add(R.drawable.card_09)
        gameViewModel.drawableList.add(R.drawable.card_10)
        gameViewModel.drawableList.add(R.drawable.card_11)
        gameViewModel.drawableList.add(R.drawable.card_12)
        gameViewModel.drawableList.add(R.drawable.card_13)
        gameViewModel.drawableList.add(R.drawable.card_14)
        gameViewModel.drawableList.add(R.drawable.card_15)
        gameViewModel.drawableList.add(R.drawable.card_16)
        gameViewModel.drawableList.add(R.drawable.card_17)
        gameViewModel.drawableList.add(R.drawable.card_18)
        gameViewModel.drawableList.add(R.drawable.card_19)
        gameViewModel.drawableList.add(R.drawable.card_20)
        gameViewModel.drawableList.add(R.drawable.card_21)
        gameViewModel.drawableList.add(R.drawable.card_22)
        gameViewModel.drawableList.add(R.drawable.card_23)
        gameViewModel.drawableList.add(R.drawable.card_24)
        gameViewModel.drawableList.add(R.drawable.card_25)
        gameViewModel.drawableList.add(R.drawable.card_26)
        gameViewModel.drawableList.add(R.drawable.card_27)
        gameViewModel.drawableList.add(R.drawable.card_28)
        gameViewModel.drawableList.add(R.drawable.card_29)
        gameViewModel.drawableList.add(R.drawable.card_30)
        gameViewModel.drawableList.add(R.drawable.card_31)
        gameViewModel.drawableList.add(R.drawable.card_32)
        gameViewModel.drawableList.add(R.drawable.card_33)
        gameViewModel.drawableList.add(R.drawable.card_34)
        gameViewModel.drawableList.add(R.drawable.card_35)
        gameViewModel.drawableList.add(R.drawable.card_36)
        gameViewModel.drawableList.add(R.drawable.card_37)
        gameViewModel.drawableList.add(R.drawable.card_38)
    }
    private fun initButtonList(){
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
        initButton()
    }
    private fun initButton(){
        for (button in gameViewModel.buttonList){
            setImageBack(button)
            button.isVisible = true
            button.isEnabled = true
        }
    }
    private fun setUpGame(){
        gameViewModel.buttonList.clear()
        gameViewModel.drawableList.clear()
        gameViewModel.imageButtonMap.clear()

        initButtonList()
        initDrawableList()
        while(gameViewModel.buttonList.isNotEmpty()){
            initialMap()
        }
        gameViewModel.count = 0
        countScoreTextView.text = gameViewModel.count.toString()
    }


    fun onCardButtonClick(view: View) {
        // if it is the first click of a round
        if(gameViewModel.isFirstClick()){
            gameViewModel.buttonFirstClick = findViewById(view.id)
            val identifier = gameViewModel.imageButtonMap[gameViewModel.buttonFirstClick]!!
            gameViewModel.buttonFirstClick.setImageResource(identifier)
            gameViewModel.onIncrementCount()
        }
        else{
            gameViewModel.buttonSecondClick = findViewById(view.id)
            if(gameViewModel.buttonFirstClick != gameViewModel.buttonSecondClick) {
                var identifier = gameViewModel.imageButtonMap[gameViewModel.buttonSecondClick]!!
                gameViewModel.buttonSecondClick.setImageResource(identifier)

                if (gameViewModel.imageButtonMap[gameViewModel.buttonFirstClick] == gameViewModel.imageButtonMap[gameViewModel.buttonSecondClick]) {

                    Handler().postDelayed({
                        //doSomethingHere()
                        gameViewModel.buttonFirstClick.isVisible = false
                        gameViewModel.buttonSecondClick.isVisible = false
                        gameViewModel.buttonFirstClick.isEnabled = false
                        gameViewModel.buttonSecondClick.isEnabled = false
                    }, 300)
                    // pop from map
                    gameViewModel.imageButtonMap.remove(gameViewModel.buttonFirstClick)
                    gameViewModel.imageButtonMap.remove(gameViewModel.buttonSecondClick)
                }
                else{
                    Handler().postDelayed({
                        //doSomethingHere()
                        setImageBack(gameViewModel.buttonFirstClick)
                        setImageBack(gameViewModel.buttonSecondClick)
                    }, 350)
                }
                gameViewModel.onIncrementCount()
            }
        }
        countScoreTextView.text = gameViewModel.count.toString()
        if(gameViewModel.gameEnd()){
            showGameAlertDialog()
        }

    }

    private fun showGameAlertDialog(){
        // build alert dialog
        val dialogBuilder = AlertDialog.Builder(this)

        // set message of alert dialog
        dialogBuilder.setTitle("Congrats!")
            .setMessage("You have tried ${gameViewModel.count} times!")
            // if the dialog is cancelable
            .setCancelable(false)
            // positive button text and action
            .setPositiveButton("RESTART", DialogInterface.OnClickListener {
                    dialog, id -> setUpGame()
            })
            // negative button text and action
            .setNegativeButton("CANCEL", DialogInterface.OnClickListener {
                    dialog, id -> finish()
            })

        // create dialog box
        val alert = dialogBuilder.create()
        // show alert dialog
        alert.show()
    }

}