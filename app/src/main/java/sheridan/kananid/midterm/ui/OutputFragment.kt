package sheridan.kananid.midterm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import sheridan.kananid.midterm.R
import sheridan.kananid.midterm.databinding.FragmentOutputBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class OutputFragment : Fragment() {
    private val viewModel : StudentViewModel by activityViewModels()
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentOutputBinding.inflate(inflater, container, false)

        viewModel.studentInfoData.observe(viewLifecycleOwner){
            binding.nameOutput.text = it.studentName
            binding.programOutput.text = it.programName
            binding.internationalOutput.text = it.internationalStudent
        }

        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_output_to_input)
        }
        return binding.root

    }


}