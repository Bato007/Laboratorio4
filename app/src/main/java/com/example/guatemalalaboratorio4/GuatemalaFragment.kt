package com.example.guatemalalaboratorio4

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.guatemalalaboratorio4.databinding.GuatemalaFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
@Suppress("DEPRECATION")
class GuatemalaFragment : Fragment() {

    private var model: Communicator? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<GuatemalaFragmentBinding>(inflater,
            R.layout.guatemala_fragment, container, false)

        // Cambiando visibilidad y texto
        binding.imageButton.setOnClickListener{
            //Cambiando textos
            binding.copyText.text = binding.writeText.text

            // Cambiando visibilidades
            if(binding.nameText.visibility == 0){
                binding.nameText.visibility = View.GONE
                binding.writeText.visibility = View.GONE
                binding.copyText.visibility = View.VISIBLE
            } else {
                binding.nameText.visibility = View.VISIBLE
                binding.writeText.visibility = View.VISIBLE
                binding.copyText.visibility = View.GONE
            }

        }

        model = ViewModelProviders.of(activity!!).get(Communicator::class.java)
        val fragmentTransaction = fragmentManager!!.beginTransaction()

        // Cambiando a otro fragmento y mandandole esta informacion
        binding.xetululBut.setOnClickListener{view: View ->
            model!!.setMsgCommunicator("1")


            view.findNavController().navigate(R.id.action_guatemalaFragment2_to_informationFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        binding.oldGuatemalaBut.setOnClickListener{view: View ->
            model!!.setMsgCommunicator("2")
            view.findNavController().navigate(R.id.action_guatemalaFragment2_to_informationFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        binding.rioDulceBut.setOnClickListener{view: View ->
            model!!.setMsgCommunicator("3")
            view.findNavController().navigate(R.id.action_guatemalaFragment2_to_informationFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    // Metodos para poder mostrar el menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }
}
