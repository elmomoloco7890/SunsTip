package ay.artemis.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import ay.artemis.myapplication.R
import ay.artemis.myapplication.databinding.FragmentSummaryBinding
import ay.artemis.myapplication.models.TipViewModel

//the summary fragment class where I just setup for using functions to display the information. Similar layout for all of them.
class SummaryFragment : Fragment() {

    private var binding:FragmentSummaryBinding? = null
    private val sharedViewModel: TipViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentSummaryBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return binding!!.root
        /*inflater.inflate(R.layout.fragment_summary, container, false)*/
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            summaryFragment = this@SummaryFragment

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}