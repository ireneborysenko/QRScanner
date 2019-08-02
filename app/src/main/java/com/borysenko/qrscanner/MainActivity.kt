package com.borysenko.qrscanner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import me.dm7.barcodescanner.zxing.ZXingScannerView
import android.view.View
import com.google.zxing.Result


class MainActivity : AppCompatActivity(), ZXingScannerView.ResultHandler{

    private var zXingScannerView: ZXingScannerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun scan(view: View) {
        zXingScannerView = ZXingScannerView(applicationContext)
        setContentView(zXingScannerView)
        zXingScannerView!!.setResultHandler(this)
        zXingScannerView!!.startCamera()

    }

    override fun onPause() {
        super.onPause()
        zXingScannerView!!.stopCamera()
    }

    override fun handleResult(result: Result) {
        Toast.makeText(applicationContext, result.text, Toast.LENGTH_SHORT).show()
        zXingScannerView!!.resumeCameraPreview(this)

    }
}
