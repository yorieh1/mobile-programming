package com.example.kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var panjang : EditText
    private lateinit var  lebar : EditText
    private lateinit var tinggi : EditText
    private lateinit var hasil : TextView
    private lateinit var btn : Button

    companion object {
        private const val STATE_VALUE = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        panjang = findViewById(R.id.edt_lenght)
        lebar = findViewById(R.id.edt_width)
        tinggi = findViewById(R.id.edt_height)
        hasil = findViewById(R.id.result)
        btn= findViewById(R.id.result)

        btn.setOnClickListener(this)

        if (savedInstanceState !=null){
            hasil.text = savedInstanceState.getString(STATE_VALUE)
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putString(STATE_VALUE, hasil.text.toString())
    }
    override fun onClick(p0: View) {
        if (p0?.id==R.id.btn_result) {
            var tinggi = tinggi.text.toString().trim()
            var panjang = panjang.text.toString().trim()
            var lebar = lebar.text.toString().trim()
            var volume = tinggi.toDouble() * panjang.toDouble()
            hasil.text = volume.toString()
        }
    }
}