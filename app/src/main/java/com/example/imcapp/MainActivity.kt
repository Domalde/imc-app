package com.example.imcapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnCalcular = btn_calc
        val resultado = result
        val limparEdit = btn_limpar

        btnCalcular.setOnClickListener {
            if (TextUtils.isEmpty(edit_height.text.toString()) || TextUtils.isEmpty(edit_weight.text.toString())){
                Toast.makeText(this, "Insira todas as informações!", Toast.LENGTH_SHORT).show()
            }
            else{
                val altura = (edit_height.text.toString()).toDouble()
                val peso = (edit_weight.text.toString()).toDouble()
                val imc = peso/(altura*altura/10000)

                val imc2 = Math.round(imc*100)/100.0

                if (imc<18.5){
                    resultado.text = "Seu IMC é: ${imc2.toString()}\nAbaixo do peso ideal"
                    resultado.setTextColor(Color.GRAY)
                }
                else if (imc<25){
                    resultado.text = "Seu IMC é: ${imc2.toString()}\nPeso normal"
                    resultado.setTextColor(Color.GRAY)

                }
                else if (imc<30){
                    resultado.text = "Seu IMC é: ${imc2.toString()}\nSobrepeso"
                    resultado.setTextColor(Color.GRAY)

                }
                else if (imc<40){
                    resultado.text = "Seu IMC é: ${imc2.toString()}\nObesidade"
                    resultado.setTextColor(Color.GRAY)

                }
                else{
                    resultado.text = "Seu IMC é: ${imc2.toString()}\nObesidade grave"
                    resultado.setTextColor(Color.GRAY)

                }
            }

        }

        limparEdit.setOnClickListener {
            edit_height.setText("")
            edit_weight.setText("")
            result.setText("")

        }
    }
}