package com.example.cesarencrypt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cesarencrypt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"valio kk", Toast.LENGTH_LONG).show()

    }

    override fun onBackPressed() {
        return
    }

//Para que no se salga el perro
    /*
        override fun onBackPressed() {
        return

    }
     */
    fun initUI(){
        binding.encripto.setOnClickListener{
            val texto = binding.texto.text.toString()
            val intento = Intent(this,CesarActivity::class.java).apply {
                putExtra("cadena",texto)
            }
            startActivity(intento)
        }
    }
}