package com.example.guatemalalaboratorio4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.guatemalalaboratorio4.databinding.ActivityMainBinding
import org.w3c.dom.Text
import java.net.URL

class MainActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Dando el intent del deep link

    }

}
