package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLanzar: Button = findViewById(R.id.btnLanzar)

        btnLanzar.setOnClickListener {
            tiempo()
        }
        rollDice()
    }

    private  fun  rollDice(){
        var numero: Int = lanzar(6)
        val txtResult : TextView = findViewById(R.id.txtRelsultado)
        txtResult.text = numero.toString()
        //Toast.makeText(this, numero.toString(), Toast.LENGTH_LONG ).show()

        val imagen =when(numero){
            1 -> R.drawable.pne
            2 -> R.drawable.thow
            3 -> R.drawable.thre
            4 -> R.drawable.four
            5 -> R.drawable.five
            else -> R.drawable.six
        }
        val imgDado : ImageView = findViewById(R.id.imgDado)
        imgDado.setImageResource(imagen)
    }

    private  fun lanzar(max: Int): Int{
        return (1..max).random()
    }

    private  fun tiempo (){
        object : CountDownTimer( 3000, 150) {
            override fun onTick(p0: Long) {
                rollDice()
            }
            override fun onFinish() {
            }
        }.start()
    }
}