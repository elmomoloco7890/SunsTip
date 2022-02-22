package ay.artemis.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ay.artemis.myapplication.R
import ay.artemis.myapplication.databinding.FragmentHomeBinding
import ay.artemis.myapplication.models.TipViewModel

class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null



    //my home fragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentHomeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        binding = fragmentBinding
        return fragmentBinding.root
    }

    //the on view created method
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.homeFragment = this


    }

    //my launch calculator button method
    fun launchCalculator(){
        //possibly something here
        findNavController().navigate(R.id.action_homeFragment_to_tipFragment)
    }

}