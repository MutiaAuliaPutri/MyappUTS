package com.example.myapputs.ui.PP

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.util.Linkify
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.myapputs.R
import com.example.myapputs.ui.dialog.CustomDialogFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [pp.newInstance] factory method to
 * create an instance of this fragment.
 */
class pp : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_pp, container, false)
        val textViewMapsLink = rootView.findViewById<TextView>(R.id.txt_maps)

        textViewMapsLink.setOnClickListener {
            val uri = "https://maps.app.goo.gl/MbNym9HpSDd2qNqi9"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            val linkText = "Kp.Sindang Sari RT.01 RW.02, Ds. Mandalamukti\nKab. Bandung Barat, Jawa Barat"

            textViewMapsLink.text = linkText
            Linkify.addLinks(textViewMapsLink, Linkify.WEB_URLS)
            textViewMapsLink.linksClickable = true
            textViewMapsLink.setLinkTextColor(Color.BLUE)

            startActivity(intent)
        }

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnIG = view.findViewById<View>(R.id.btnInstagram)
        val btnWA = view.findViewById<View>(R.id.btnWhatsapp)
        val btnEM = view.findViewById<View>(R.id.btnEmail)
        val showDialogButton = view.findViewById<Button>(R.id.showDialogButton)
        showDialogButton.setOnClickListener {
            showCustomDialog()
        }

        btnIG.setOnClickListener {
            openSocialMedia("https://instagram.com/aulliaaaaaa__?igshid=MzRlODBiNWFlZA==")
        }
        btnWA.setOnClickListener {
            openWhatsApp()
        }
        btnEM.setOnClickListener {
            openEmail()
        }

    }
    private fun showCustomDialog() {
        val dialogFragment = CustomDialogFragment()
        dialogFragment.show(parentFragmentManager, "CustomDialogFragment")
    }

    private fun openSocialMedia(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
    private fun openWhatsApp() {
        val phoneNumber = "+62 857-5985-4627" // Nomor telepon yang akan diarahkan ke WhatsApp
        val url = "https://api.whatsapp.com/send?phone=+62 857-5985-4627"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
    private fun openEmail() {
        val email = "mutia.10120242@mahasiswa.unikom.ac.id" // Alamat email yang akan dituju
        val subject = "Subject email" // Subjek email
        val uri = Uri.parse("mailto:$email?subject=${Uri.encode(subject)}")
        val intent = Intent(Intent.ACTION_SENDTO, uri)
        startActivity(intent)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment pp.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            pp().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}