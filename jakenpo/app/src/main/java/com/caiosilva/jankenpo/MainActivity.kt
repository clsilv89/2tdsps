package com.caiosilva.jankenpo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.caiosilva.jankenpo.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private val opcoes: List<String> = listOf("Papel", "Pedra", "Tesoura")
    private val imagens = listOf(R.drawable.papel, R.drawable.pedra, R.drawable.tesoura)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.imageViewPadrao.setOnClickListener {
        }

        binding.imageViewPapel.setOnClickListener {
            binding.textViewResult.text = checkWinner(0, onOptionClicked())
        }

        binding.imageViewPedra.setOnClickListener {
            binding.textViewResult.text = checkWinner(1, onOptionClicked())
        }

        binding.imageViewTesoura.setOnClickListener {
            binding.textViewResult.text = checkWinner(2, onOptionClicked())
        }
    }

    private fun onOptionClicked(): Int {
        val escolhaComputador: Int = Random.nextInt(3)
        binding.imageViewPadrao.setImageDrawable(getDrawable(imagens[escolhaComputador]))
        return escolhaComputador
    }

    private fun checkWinner(escolhaDoUsuario: Int, escolhaDoApp: Int): String {
        val result = arrayOf(
            arrayOf(
                getString(R.string.draw, opcoes[escolhaDoApp]),
                getString(R.string.app_loses, opcoes[escolhaDoApp]),
                getString(R.string.app_wins, opcoes[escolhaDoApp])
            ),
            arrayOf(
                getString(R.string.app_wins, opcoes[escolhaDoApp]),
                getString(R.string.draw, opcoes[escolhaDoApp]),
                getString(R.string.app_loses, opcoes[escolhaDoApp])
            ),
            arrayOf(
                getString(R.string.app_loses, opcoes[escolhaDoApp]),
                getString(R.string.app_wins, opcoes[escolhaDoApp]),
                getString(R.string.draw, opcoes[escolhaDoApp])
            )
        )
        return result[escolhaDoUsuario][escolhaDoApp]
    }
}
