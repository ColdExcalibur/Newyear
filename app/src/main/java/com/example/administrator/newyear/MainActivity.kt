package com.example.administrator.newyear

import android.app.Activity
import android.app.FragmentManager
import android.net.Uri
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() ,MainFragment.OnFragmentInteractionListener{
    override fun onFragmentInteraction(uri : Uri){

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        //sample_text.text = stringFromJNI()
        fragmentManager.beginTransaction().replace(R.id.for_main_fragment, MainFragment(), "MainFragment").commit()
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
