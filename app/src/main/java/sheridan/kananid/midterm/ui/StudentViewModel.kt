package sheridan.kananid.midterm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import sheridan.kananid.midterm.model.StudentInfo

class StudentViewModel : ViewModel(){

    private val _studentInfoData: MutableLiveData<StudentInfo> = MutableLiveData()
    val studentInfoData: LiveData<StudentInfo> = _studentInfoData

    fun submit(studentInfo: StudentInfo){
        _studentInfoData.value = studentInfo
    }

}