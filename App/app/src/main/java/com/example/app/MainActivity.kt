package com.example.app

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun calculaMedia(componente: View) {
        var usuario = et_usuario
        var primeiraNota = et_nota1
        var segundaNota = et_nota2


        validaNome(usuario)

        validaCampo(primeiraNota)
        validaCampo(segundaNota)


        if (usuario.length() > 3 && primeiraNota.length() > 0 && segundaNota.length() > 0) {
            tv_invisivel.visibility = View.VISIBLE
            media(usuario.text)

        }else{
            tv_invisivel.visibility = View.INVISIBLE
        }


    }

    fun validaNome(nome: EditText) {

        if (nome.length() <= 3) {
            nome.setError("seu nome precisa ter mais de 3 letras")
        }

    }

    fun validaCampo(campo: EditText) {

        if (campo.length() <= 0) {
            campo.setError("o campo não pode estar vazio")
        }
    }


    fun media(nome: Editable) {

        val total: Double = (et_nota1.text.toString().toDouble() + et_nota2.text.toString().toDouble()) / 2

        if (total < 5) {
            tv_invisivel.setTextColor(Color.parseColor("#FF0000"))
            tv_invisivel.text = "${nome}, sua média é ${total}"
        } else {
            tv_invisivel.setTextColor(Color.parseColor("#00FF00"))
            tv_invisivel.text = "${nome}, sua média é ${total}"
        }

    }








    }
