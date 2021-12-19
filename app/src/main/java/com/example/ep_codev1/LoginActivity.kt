package com.example.ep_codev1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth         //firebase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()
        //onStart()

        // Kein Account Button zu SignUp
        val keinAccount = findViewById<Button>(R.id.buttonKeinAccount)
        keinAccount.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        //LogIn Button - funktion login wird ausgefuehrt
        val logIn = findViewById<Button>(R.id.buttonAnmelden)
        logIn.setOnClickListener {
            login()
        }

    }

    fun login() {
        //Check ob email leer
        val email = findViewById<EditText>(R.id.editTextTextEmailAddress)
        if (email.text.toString().isEmpty()) {       //kein user name
            Toast.makeText(baseContext, "Bitte email eintragen",
                Toast.LENGTH_SHORT).show()
            return
        }

        //Check ob Passwort leer
        val passwort = findViewById<EditText>(R.id.editTextTextPassword)
        if (passwort.text.toString().isEmpty()) {
            Toast.makeText(baseContext, "Bitte Passwort eintragen",
                Toast.LENGTH_SHORT).show()
            return
        }

        //Einloggen mit den gegebenen Daten
        auth.signInWithEmailAndPassword(email.text.toString(), passwort.text.toString())
            //Wenn task erfolgreich, dann uebergang zu MainActivity
            .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            //Bei Fail (falsches Passwort) gibts eine Nachricht basierend auf dem Fehler
        }.addOnFailureListener { exeption ->
            Toast.makeText(
                baseContext, exeption.localizedMessage,
                Toast.LENGTH_SHORT).show()
        }
    }

    /**Eine Funktion die gedacht ist, aber noch nicht funktioniert**/
    ////Ist user schon eingeloggt
    //public override fun onStart() {
    //    super.onStart()
    //    // Check if user is signed in (non-null) and update UI accordingly.
    //    val currentUser = auth.currentUser
    //    if(currentUser != null){
    //        reload()
    //    }
    //}
//
    //private fun reload() {
    //    TODO("Not yet implemented")
    //}

}