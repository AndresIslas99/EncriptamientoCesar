package com.example.cesarencrypt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cesarencrypt.databinding.ActivityCesarBinding

class CesarActivity : AppCompatActivity() {
    lateinit var binding: ActivityCesarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCesarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }
    fun initUI(){
        val cadena= intent.getStringExtra("cadena")
        binding.textView.text=cadena
        binding.textView2.text = Cesar.encripto(cadena!!,6 )
    }
    object Cesar{
        fun encripto(cadena:String, desplazamiento: Int):String{
            val valor = desplazamiento % 26
            if(desplazamiento==0) return cadena
            val encriptado = CharArray(cadena.length)
            var nuevaletra:Char
            for ((index,letra) in cadena.withIndex()){
                if (letra in 'A'..'Z'){
                    nuevaletra = letra + valor
                    if(nuevaletra>'Z') nuevaletra -=26
                }else
                    nuevaletra=letra
                encriptado[index]=nuevaletra
            }
            return encriptado.joinToString("")
        }
    }
}