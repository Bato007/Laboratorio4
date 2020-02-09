package com.example.guatemalalaboratorio4


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.guatemalalaboratorio4.databinding.ActivityCommentaryBinding

/**
 * A simple [Fragment] subclass.
 */
class CommentaryFragment : Fragment() {

    private var model: Communicator? = null
    lateinit var dBinding: ActivityCommentaryBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        dBinding = DataBindingUtil.inflate(inflater,
            R.layout.activity_commentary, container,false)


        // Recibiendo la informacion de otro fragment
        model = ViewModelProviders.of(activity!!).get(Communicator::class.java)

        // Consiguiendo la informacion mandada y utilizarla para mostra datos
        model!!.message.observe(this,
            Observer { o -> dBinding.commentaryCopyText.text = o.toString() })


        // Boton para regresar al inicio
        dBinding.backBut.setOnClickListener{view: View ->
            view.findNavController().navigate(R.id.action_commentaryFragment_to_guatemalaFragment2)
        }

        // Dandole share al comentario
        dBinding.shareButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            val sharedBody = dBinding.commentaryCopyText.text.toString()
            intent.putExtra(Intent.EXTRA_TEXT, sharedBody)
            startActivity(Intent.createChooser(intent, "Share Using"))
        }

        return dBinding.root

    }

}
