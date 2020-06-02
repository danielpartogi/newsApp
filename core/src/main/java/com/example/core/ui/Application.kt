package com.example.core.ui

import android.app.Activity
import android.app.Application
import android.app.Service
import android.content.Context
import androidx.fragment.app.Fragment
import com.example.core.di.CoreComponent
import com.example.core.di.DaggerCoreComponent

class App : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.create()
    }

    companion object {
        lateinit var appContext: Context

        @JvmStatic
        fun coreComponent(context: Context) =
            (context.applicationContext as App).coreComponent
    }
}

fun Activity.coreComponent() =
    App.coreComponent(this)
fun Fragment.coreComponent() =
    App.coreComponent(requireContext())
fun Service.coreComponent() =
    App.coreComponent(this)