package com.devventure.lanceosdados

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val playerName = findViewById<EditText>(R.id.playerName)
        val btn = findViewById<Button>(R.id.botao_cadastrar)

        btn.setOnClickListener{
            val player = playerName.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("playerName", player)
            startActivity(intent)
        }







    }
}