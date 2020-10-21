package sheridan.kananid.midterm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import sheridan.kananid.midterm.R
import sheridan.kananid.midterm.databinding.FragmentInputBinding
import sheridan.kananid.midterm.model.StudentInfo

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class InputFragment : Fragment() {
    private val viewModel : StudentViewModel by activityViewModels()

    private lateinit var binding: FragmentInputBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInputBinding.inflate(inflater, container, false)
        binding.submitButton.setOnClickListener { showOutput() }
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    private fun showOutput() {
        val studentName = binding.nameInput.text.toString().trim()
        val isinternational: Boolean = binding.internationalCheckBox.isChecked
        if(studentName.isEmpty()){
            val required = getString(R.string.required)
            binding.nameInput.error = required
            Toast.makeText(context, required, Toast.LENGTH_LONG).show()
        }else{
            val programList = resources.getStringArray(R.array.program_list)
            val program = programList[binding.programInput.selectedItemPosition]
            val studentInfo = StudentInfo(studentName, program,isinternational)
            viewModel.submit(studentInfo)
            findNavController().navigate(R.id.action_input_to_output)
        }
    }

}