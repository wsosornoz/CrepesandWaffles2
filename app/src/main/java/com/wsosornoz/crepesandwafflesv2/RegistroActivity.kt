package com.wsosornoz.crepesandwafflesv2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_registro.*

class RegistroActivity : AppCompatActivity() {

    private var correor = ""
    private var pass1r = ""
    private var pass2r = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        bnRegistrar.setOnClickListener {
            correor = etCorreo.text.toString()
            pass1r = etContraseña.text.toString()
            pass2r = etConfcontraseña.text.toString()

            if (pass1r != "" && pass2r != "") {

                if(pass1r.length>=6){

                    if (pass1r == pass2r) {

                        Toast.makeText(this, "Usuario creado ", Toast.LENGTH_SHORT).show()
                        var intent = Intent()
                        intent.putExtra("correo",correor)
                        intent.putExtra("contraseña",pass2r)
                        setResult(Activity.RESULT_OK,intent)
                        finish()

                    } else {
                        Toast.makeText(this, "Las contraseñas NO coinciden ", Toast.LENGTH_LONG).show()

                    }}
                else {
                    Toast.makeText(this, "Minimo 6 dígitos en Contraseña", Toast.LENGTH_LONG).show()
                }

            }
        }

    }
}
