package com.devventure.lanceosdados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dado1 = findViewById<ImageView>(R.id.dado_1)
        val dado2 = findViewById<ImageView>(R.id.dado_2)
        val btn = findViewById<Button>(R.id.botao_gerar)
        val text = findViewById<TextView>(R.id.welcomeMsg)

        val playerNome = intent.getStringExtra("playerName")

        val message = "${resources.getString(R.string.welcomeMsg)} $playerNome"
        text.text = message

        val dices = listOf(R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3, R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6)

        btn.setOnClickListener{
            dado1.setImageResource(dices.random())
            dado2.setImageResource(dices.random())

        }
    }

}