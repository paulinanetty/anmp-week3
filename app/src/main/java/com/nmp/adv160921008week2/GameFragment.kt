package com.nmp.adv160921008week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.nmp.adv160921008week2.databinding.FragmentGameBinding
import kotlin.random.Random

class GameFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var binding: FragmentGameBinding
    private var score = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentGameBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateEquation()

        binding.btnback.setOnClickListener {
            checkAnswer()
        }

        if(arguments != null){
            val name = GameFragmentArgs.fromBundle(requireArguments()).playerName

            binding.txtTurn.text = "$name's turn"



        }




    }
    private fun updateEquation() {
        val randomInt1 = Random.nextInt(1, 10)
        val randomInt2 = Random.nextInt(1, 10)
        binding.txtQuestion.text = "$randomInt1 + $randomInt2"
    }

    private fun checkAnswer() {
        val answer = binding.txtAnswer.text.toString().trim()

        val randomInt1 = binding.txtQuestion.text.split("+")[0].trim().toInt()
        val randomInt2 = binding.txtQuestion.text.split("+")[1].trim().toInt()
        val sum = (randomInt1 + randomInt2).toString()

        if (answer == sum) {
            // Correct answer
            score += 1
        } else {
            // Incorrect answer
            val scoretotal = score
            val action = GameFragmentDirections.actionGameFragmentToResultFragment(scoretotal)
            Navigation.findNavController(requireView()).navigate(action)
        }

        // Update the equation for the next round
        updateEquation()

        // Clear the player's input
        binding.txtAnswer.text.clear()
    }


}