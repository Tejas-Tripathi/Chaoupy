package com.example.chaoupy

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.chaquo.python.PyObject
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.example.chaoupy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    lateinit var binding:ActivityMainBinding
    lateinit var encryption: PyObject
    lateinit var decryption: PyObject
    lateinit var pandasversion:PyObject
    lateinit var scanoutput:PyObject
    lateinit var pyObj: PyObject
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)


        if (! Python.isStarted()) {
            Python.start(AndroidPlatform(this))
        }

        var py=Python.getInstance()
        pyObj = py.getModule("firstScript")
        encryption=pyObj.callAttr("encryption","tejas", "keyss")
        decryption=pyObj.callAttr("decryption",encryption.toString(), "keyss")
        pandasversion=pyObj.callAttr("pandasversion")


        try
        {
            scanoutput=pyObj.callAttr("scanfromnmap", "192.168.1.5")
            binding.tvDecryption.text=scanoutput.toString()
        }
        catch (e:Exception){
            binding.tvDecryption.text=e.toString()
            var Tag="error"
            Log.e(Tag, e.toString())
            print(e.toString())
    }




        binding.tvGettext.text=encryption.toString()


    }
}