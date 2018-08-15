package com.example.kannyf.anjirrapps.fragment


import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.ceylonlabs.imageviewpopup.ImagePopup
import com.example.kannyf.anjirrapps.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.user_data.*


class AccountFragment : Fragment() {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        uUsername.setText(Html.fromHtml("@"))

        val imagePopup = ImagePopup(activity)
        imagePopup.backgroundColor = Color.BLACK
        imagePopup.isFullScreen = false
        imagePopup.isHideCloseIcon = false
        imagePopup.isImageOnClickClose = true


        val imageUrl = view?.findViewById<ImageView>(R.id.fotoProfil)
        imagePopup.initiatePopup(imageUrl?.drawable)

        imageUrl?.setOnClickListener {
            imagePopup.viewPopup()
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
