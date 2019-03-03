package com.jokopriyono.eudeka.mvvm.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jokopriyono.eudeka.mvvm.R
import com.jokopriyono.eudeka.mvvm.model.User
import com.jokopriyono.eudeka.mvvm.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userViewModel = UserViewModel(this, User(null, null))
        btn_login.setOnClickListener {
            userViewModel.updateModel(edt_email.text.toString(), edt_password.text.toString())
            userViewModel.validLogin()
        }
    }
}
