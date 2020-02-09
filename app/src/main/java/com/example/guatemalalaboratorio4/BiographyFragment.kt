package com.example.guatemalalaboratorio4


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.guatemalalaboratorio4.databinding.BiographyFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class BiographyFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
       val sBinding = DataBindingUtil.inflate<BiographyFragmentBinding>(inflater,
           R.layout.biography_fragment, container, false)


        return sBinding.root
    }


}
