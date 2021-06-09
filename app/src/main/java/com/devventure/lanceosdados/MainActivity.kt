package com.devventure.lanceosdados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dado1 = findViewById<TextView>(R.id.dado_1)
        val dado2 = findViewById<TextView>(R.id.dado_2)
        val botao = findViewById<Button>(R.id.botao_gerar)

        botao.setOnClickListener{
        dado1.text = gerarNumero().toString()
        dado2.text = gerarNumero().toString()
        }
    }

    private fun gerarNumero() : Int {
        return (1..6).random()
    }
}