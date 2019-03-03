package com.jokopriyono.eudeka.mvvm.viewmodel

import android.content.Context
import android.text.TextUtils
import com.jokopriyono.eudeka.mvvm.model.User
import com.jokopriyono.eudeka.mvvm.view.team.TeamActivity
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class UserViewModel(val context: Context, val user: User) {
    companion object {
        const val TOAST_MESSAGE_SUCCESS: String = "Login Success"
        const val TOAST_MESSAGE_FAILED: String = "Login Failed"
    }

    fun updateModel(email: String, password: String) {
        user.email = email
        user.password = password
    }

    fun validLogin() {
        var isValid = true

        if (TextUtils.isEmpty(user.email)) isValid = false
        if (TextUtils.isEmpty(user.password)) isValid = false
        if (isValid) {
            showToast(TOAST_MESSAGE_SUCCESS)
            intentToTeam()
        } else {
            showToast(TOAST_MESSAGE_FAILED)
        }
    }

    private fun intentToTeam() {
        context.startActivity<TeamActivity>()
    }

    private fun showToast(message: String) {
        context.toast(message)
    }
}