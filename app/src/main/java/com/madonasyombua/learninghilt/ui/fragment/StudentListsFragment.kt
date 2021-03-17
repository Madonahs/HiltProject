package com.madonasyombua.learninghilt.ui.fragment

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.madonasyombua.learninghilt.data.StudentData
import com.madonasyombua.learninghilt.data.helpers.Permission
import com.madonasyombua.learninghilt.data.helpers.PermissionsRationaleDialog
import com.madonasyombua.learninghilt.data.helpers.SendToSettingDialog
import com.madonasyombua.learninghilt.databinding.StudentListsFragmentBinding
import com.madonasyombua.learninghilt.util.TimeProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class StudentListsFragment : Fragment(), PermissionsRationaleDialog.PermissionListener {

    private val viewModel: StudentListsViewModel by viewModels()

    @Inject
    lateinit var timeProvider: TimeProvider
    lateinit var studentListAdapter: StudentAdapter
    private var binding: StudentListsFragmentBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = StudentListsFragmentBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpStudentAdapter()
        viewModel.studentData.observe(viewLifecycleOwner, observer)
    }

    private val observer = Observer<List<StudentData>> { studentList ->
        binding?.studentListRecyler?.visibility =
            if (studentList.isEmpty()) View.GONE else View.VISIBLE
        binding?.noStudentList?.visibility = if (studentList.isEmpty()) View.VISIBLE else View.GONE
        studentListAdapter.studentList = studentList
    }

    private fun setUpStudentAdapter() {
        studentListAdapter = StudentAdapter(timeProvider = timeProvider)
        binding?.studentListRecyler?.adapter = studentListAdapter
    }

    private fun requestPermissions(missingPermission: List<String>){
        val shouldProvideRational = missingPermission.any {
            ActivityCompat.shouldShowRequestPermissionRationale(
                requireActivity(),it
            )
        }

        if(shouldProvideRational){
            handleShowPermissionRationale(missingPermission.toList())
        }else{
            requestPermissions(
                missingPermission.toTypedArray(),
                PERMISSION_REQUEST_CODE

            )
        }
    }

    private fun handleShowPermissionRationale(permissions: List<String>) {
        PermissionsRationaleDialog.newInstance(permissions).show(childFragmentManager,null)
    }

    private fun showPermissionsDialog(permissions: Array<String>, grantResults: IntArray) {

        val missingPermission = grantResults.zip(permissions).filter {
            it.first == PackageManager.PERMISSION_DENIED
        }.map {
            if(it.second == Manifest.permission.RECORD_AUDIO){
                Permission.RECORD_AUDIO
            }else{
                Permission.CAMERA
            }
        }
        SendToSettingDialog.newInstance(missingPermission)
                .show(childFragmentManager, null)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

    }


    companion object{
        const val PERMISSION_REQUEST_CODE = 22
    }

    override fun onRationaleDontAllow(permissions: Array<String>) {
       showPermissionsDialog(permissions,
       permissions.map {
           PackageManager.PERMISSION_DENIED
       }.toIntArray())
    }

    override fun onRationaleAllow(permissions: Array<String>) {
       requestPermissions(
               permissions,
               PERMISSION_REQUEST_CODE
       )
    }
}