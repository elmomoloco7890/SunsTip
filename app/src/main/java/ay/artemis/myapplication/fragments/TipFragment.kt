package ay.artemis.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import ay.artemis.myapplication.R
import ay.artemis.myapplication.models.TipViewModel
import ay.artemis.myapplication.databinding.FragmentTipBinding


class TipFragment : Fragment() {

    // the tip fragment.

    private val sharedViewModel : TipViewModel by activityViewModels()
     private var binding: FragmentTipBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTipBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            tipFragment = this@TipFragment
        }

    }



    //this is where I get the calculation of everything
    fun allCalculated(){

    }

    fun displaySubTotal(){
        sharedViewModel.subTotalOnInput
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}