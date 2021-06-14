package com.devventure.lanceosdados

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.devventure.lanceosdados.databinding.FragmentCadastroBinding


class CadastroFragment : Fragment() {
    private var binding: FragmentCadastroBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCadastroBinding.inflate(inflater, container, false)
        val playerName = binding?.playerName
        val btn = binding?.botaoCadastrar

        btn?.setOnClickListener{
            val player = playerName?.text.toString()
            findNavController().navigate(R.id.action_cadastroFragment_to_lanceOsDadosFragment, bundleOf("nomeJogador" to player))
        }
        return binding?.root

    }




}