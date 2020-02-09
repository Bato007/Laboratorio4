package com.example.guatemalalaboratorio4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import com.example.guatemalalaboratorio4.databinding.ActivityCommentaryBinding


class Commentary : AppCompatActivity() {

    private var model = Communicator()

    // Agregando binding
    lateinit var dBinding: ActivityCommentaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dBinding = DataBindingUtil.setContentView(this, R.layout.activity_commentary)

        // Consiguiendo la info del Fragment
        val manager =  supportFragmentManager
 
    }

    // Iniciando el intento para poder compartirlo con otras aplicaciones
    fun share(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        val sharedBody = "Comment"
        val sharedSub: String = dBinding.commentaryCopyText.text.toString()
        intent.putExtra(Intent.EXTRA_SUBJECT, sharedSub)
        intent.putExtra(Intent.EXTRA_TEXT, sharedBody)
        startActivity(Intent.createChooser(intent, "Share Using"))
    }


}
