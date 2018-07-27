package com.example.kannyf.anjirrapps.fragment


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.kannyf.anjirrapps.R
import com.example.kannyf.anjirrapps.`interface`.Service
import com.example.kannyf.anjirrapps.model.UserModel
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.user_data.*
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class AccountFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val progressBar : ProgressBar = view?.findViewById(R.id.progressBar)


        progressBar.showContextMenu()
        //initialise gson

        val gson = GsonBuilder().create()

        //initial retrofit

        val retrofit : Retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://api.github.com")
                .build()

        val service : Service = retrofit.create(Service::class.java)

        //get data from github by username


        service.getUser("kannyfmr")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            user ->
                            getUser(user)
                        },
                        {
                            error ->
                            Log.e("error", error.message)
                        }
                )
    }

    private fun getUser(user: UserModel?) {

        val image = view?.findViewById<ImageView>(R.id.imageGithub)

        Glide.with(activity as Context).load(user?.avatarUrl).into(image)
        tvName.text = user?.name
        tvEmail.text = user?.company
    }

}
