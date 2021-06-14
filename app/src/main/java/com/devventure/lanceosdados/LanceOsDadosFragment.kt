package com.devventure.lanceosdados
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.devventure.lanceosdados.databinding.FragmentLanceOsDadosBinding

class LanceOsDadosFragment : Fragment() {
    var binding : FragmentLanceOsDadosBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLanceOsDadosBinding.inflate(inflater, container, false)

        val dado1 = binding?.dado1
        val dado2 = binding?.dado2
        val btn = binding?.botaoGerar
        val welcomeText = binding?.welcomeMsg
        val shareButton = binding?.ShareButton

        welcomeText?.text = "Bem vindo, ${arguments?.getString("nomeJogador")}"

        val dices = listOf(R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3, R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6)

        btn?.setOnClickListener{
            dado1?.setImageResource(dices.random())
            dado2?.setImageResource(dices.random())

        }

        shareButton?.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, "Você é sortudo!!!")
           // intent.setPackage("com.whatsapp")
            intent.type = "text/plain"

            activity?.packageManager?.run {
                if(intent.resolveActivity(this) != null){
                    startActivity(intent)
                } else {
                    Toast.makeText(context, "você não tem o whatsapp instalado!", Toast.LENGTH_LONG).show()
                }
            }

        }

        return binding?.root
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lance_os_dados, container, false)
    }


}