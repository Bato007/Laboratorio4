package com.example.guatemalalaboratorio4


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.guatemalalaboratorio4.databinding.InformationLayoutBinding

/**
 * A simple [Fragment] subclass.
 */
@Suppress("DEPRECATION")
class InformationFragment : Fragment() {

    // Variables necesarias para el programa
    private var model: Communicator? = null
    lateinit var mBinding: InformationLayoutBinding

    // La informacion de los lugares
    private val infoPlaces: MutableList<String> = mutableListOf(
        "Xetulul",
        "Xetutul is a theme park in Guatemala. It is located in the Retalhuleu Department in the southwest of the country. Opening in 2002,\n" +
        "Xetutul is the third largest amusement park in Latin America, after Beto Carrero World in Penha, Santa Catarina, Brazil and Six Flags México near Mexico City,\n" +
        "Mexico. Xetutul is associated with the nearby Xocomil waterpark, which opened in 1997, and together the two parks receive over one million visitors every year,\n" +
        "making the parks the most popular tourist attraction in the country.\n" +
        "\nXetulul and Xocomil are operated by the Institute for the Recreation of Guatemalan Private Industry Workers (IRTRA)—a private company that operates several\n" +
        "other parks in Guatemala, as well as nearby hotels and restaurants.",

        "Antigua Guatemala",
        "Antigua Guatemala, commonly referred to as just Antigua or la Antigua, is a city in the central highlands of Guatemala known for its preserved Spanish Baroque-influenced\n" +
        "architecture as well as a number of ruins of colonial churches. It served as the capital of the Kingdom of Guatemala. It has been designated a UNESCO World Heritage site.\n" +
        "\n Antigua Guatemala serves as the municipal seat for the surrounding municipality of the same name. It also serves as the departmental capital of Sacatepéquez Department.\n",

        "Río Dulce",
        "The Dulce River is located in the department of Izabal, between Lake Izabal and Amatique Bay. About 43 kilometers long, the Dulce River is the gateway to the Caribbean Sea.\n" +
        "\nThe canyon at the mouth of the river on the bay offers a scenic beauty unique for its vegetation, and for being a refuge for various native and migratory birds. To travel\n" +
        "the 16 kilometers between the “Golfete” (small gulf) and the ocean, the waters of the river enter through an enormous canyon that separates the mountains where high walls of\n" +
        "limestone rock with lush vegetation make the journey an adventure. This river has a depth of 30 to 50 meters, and a width of approximately 200 meters. During the tour, you\n" +
        "will get to see cays and islets of different sizes.\n" +
        "\nThe Dulce River is located within the “Río Dulce National Park,” area that protects the Guatemalan ecosystem since 1955, containing a great diversity of fauna, among which\n" +
        "are manatees and crocodiles.\n" +
        "\nFor the visit, it is recommended to use the water transportation services available in the docks of Fronteras, El Relleno and Livingston. In the area, there is a diversity\n" +
        "of accommodations, food services, and community tourism, among others."
    )


    // Creacion del fragment
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater,
            R.layout.information_layout, container, false)

        // Dnadole valores a los atributos
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        model = ViewModelProviders.of(activity!!).get(Communicator::class.java)

        // Consiguiendo la informacion mandada y utilizarla para mostra datos
        model!!.message.observe(this,
            Observer<Any> { o -> setInformation(o!!.toString()) })

        // Mandandole la información a una actividad
        mBinding.commentBut.setOnClickListener{view: View ->
            model!!.setMsgCommunicator(mBinding.inputText.text.toString())
            view.findNavController().navigate(R.id.action_informationFragment_to_commentary)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        return mBinding.root
    }



    // Dandole los valores a la informacion
    private fun setInformation(location: String) {
        when(location) {
            "1" -> {mBinding.titleText.text = infoPlaces.get(index = 0)
                mBinding.scrollText.text = infoPlaces.get(index = 1)}
            "2" -> {mBinding.titleText.text = infoPlaces.get(index = 2)
                mBinding.scrollText.text = infoPlaces.get(index = 3)}
            else -> {mBinding.titleText.text = infoPlaces.get(index = 4)
                mBinding.scrollText.text = infoPlaces.get(index = 5)}
        }
    }

}
