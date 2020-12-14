package com.example.examenmultimediagrupob

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity()  {

    companion object {
        const val PARAM1 = "Hola"
    }

    var listaVocales = listOf("a", "e", "i", "o", "u")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val editText = findViewById<EditText>(R.id.editTextSecondActivity)
        val textView = findViewById<TextView>(R.id.textViewSecondActivity)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)


        val texto = intent.getStringExtra(PARAM1)

        texto?.let {
            textView.text = it.replace(",", "\n")
        }

        button1.setOnClickListener {
            texto?.let {
                textView.text = duplicarTodasLasVolcales(it)
            }
        }

        button2.setOnClickListener {
            texto?.let {
                textView.text = invertirOrden(it)
            }
        }

        button3.setOnClickListener {
            texto?.let {
                textView.text = remplazarVocalPorCaraFeliz(it, editText.text.toString())
            }
        }
    }

    private fun remplazarVocalPorCaraFeliz(texto: String, caracterAReemplazar: String) : String{
        if (texto.isEmpty()){
            return texto
        }
        if (!texto.contains(caracterAReemplazar)){
            return ""
        }
        return texto.replace(caracterAReemplazar, ":)", true)
    }

    private fun invertirOrden(texto: String) : String{
        val lista = texto.toList()
        val listaInvertida = lista.reversed()
        var output = ""
        listaInvertida.forEach {
            output += it
        }
        return output
    }

    private fun duplicarTodasLasVolcales(texto : String) : String {
        var output = texto
        listaVocales.forEach {
            output = output.replace(it, it+it, true)
        }
        return output
    }
}