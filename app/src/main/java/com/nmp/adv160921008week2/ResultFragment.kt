package com.nmp.adv160921008week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.nmp.adv160921008week2.databinding.FragmentGameBinding
import com.nmp.adv160921008week2.databinding.FragmentResultBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentResultBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null) {
            val scoretotal = ResultFragmentArgs.fromBundle(requireArguments()).Score
            binding.txtScore.text = "Your Score is $scoretotal"
        }
        binding.btnBackToMain.setOnClickListener{


            val action = ResultFragmentDirections.actionResultFragmentToMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }



}