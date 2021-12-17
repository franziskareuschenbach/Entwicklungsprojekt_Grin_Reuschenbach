package com.example.ep_codev1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        auth = FirebaseAuth.getInstance()

        val anmelden = findViewById<Button>(R.id.buttonAnmelden)    // on click event

        anmelden.setOnClickListener {
            signUpUser()
        }
    }

    private fun signUpUser() {
        val email = findViewById<EditText>(R.id.editTextTextEmailAddress)
        if (email.text.toString().isEmpty()) {       //kein user name
            email.error = "Bitte E-Mail eintragen"
            email.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()) {   //keine richtige EMAIL Adresse
            email.error = "Bitte eine gültige E-Mail eintragen"
            email.requestFocus()
            return
        }

        var passwort = findViewById<EditText>(R.id.editTextTextPassword)
        if (passwort.text.toString().isEmpty()) {
            passwort.error = "Bitte Passwort eintragen"
            passwort.requestFocus()
            return
        }

        auth.createUserWithEmailAndPassword(email.text.toString(), passwort.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, LoginActivity :: class.java))
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(baseContext, "Anmeldung fehlgeschlagen",
                        Toast.LENGTH_SHORT).show()
                }
            }



    }
}
