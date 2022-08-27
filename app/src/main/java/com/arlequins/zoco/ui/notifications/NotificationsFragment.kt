package com.arlequins.zoco.ui.notificatios

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.arlequins.zoco.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {
    private var _notificationsBinding:FragmentNotificationsBinding? = null
    private val notificationsBinding get()= _notificationsBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel = ViewModelProvider(this)[NotificationsViewModel::class.java]

        _notificationsBinding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = notificationsBinding.root

        val textView: TextView = notificationsBinding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner){
            textView.text = it
        }
        return root
    }
    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar!!.show()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _notificationsBinding = null
    }

}