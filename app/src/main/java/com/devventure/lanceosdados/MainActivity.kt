package com.devventure.lanceosdados

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dado1 = findViewById<ImageView>(R.id.dado_1)
        val dado2 = findViewById<ImageView>(R.id.dado_2)
        val btn = findViewById<Button>(R.id.botao_gerar)
        val text = findViewById<TextView>(R.id.welcomeMsg)
        val shareButton = findViewById<FloatingActionButton>(R.id.ShareButton)

        val playerNome = intent.getStringExtra("playerName")

        val message = "${resources.getString(R.string.welcomeMsg)} $playerNome"
        text.text = message

        val dices = listOf(R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3, R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6)

        btn.setOnClickListener{
            dado1.setImageResource(dices.random())
            dado2.setImageResource(dices.random())

        }

        shareButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, "Você é sortudo!!!")
            intent.setPackage("com.whatsapp")
            intent.type = "text/plain"

            if(intent.resolveActivity(this.packageManager) != null){
                startActivity(intent)
            } else {
                Toast.makeText(this, "você não tem o whatsapp instalado!", Toast.LENGTH_LONG).show()
            }

        }
    }
}