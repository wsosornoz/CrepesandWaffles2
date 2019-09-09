package com.wsosornoz.crepesandwafflesv2


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private var primervez = 0

    private var userl = ""
    private var passl = ""
    private var userr: String? = ""
    private var passr: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if (primervez == 1) {
            primervez = 1
            etConstraseña.text.clear()
            etUsuario.text.clear()
            var intent = Intent(this, RegistroActivity::class.java)
            intent.putExtra("usuario", "prueba")
            intent.putExtra("password", "1234")
            startActivityForResult(intent, 1)
        }



        bnIniciar.setOnClickListener {
            userl = etUsuario.text.toString()
            passl = etConstraseña.text.toString()

            if (userl == userr && passl == passr && userl != "" && passl != "" ) {

                Toast.makeText(this, "Usuario y Contraseña correctos ", Toast.LENGTH_SHORT).show()
                etConstraseña.text.clear()
                var intent = Intent(this, Main2Activity::class.java)
                intent.putExtra("user",userl)
                startActivityForResult(intent, 55)

            } else
                Toast.makeText(this, "Error en Usuario o Contraseña", Toast.LENGTH_LONG).show()

        }


        bnRegistro.setOnClickListener {

            etConstraseña.text.clear()
            etUsuario.text.clear()
            var intent = Intent(this, RegistroActivity::class.java)

            startActivityForResult(intent, 1)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                userr = data!!.extras?.getString("correo")
                passr = data!!.extras?.getString("contraseña")
            }

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}

