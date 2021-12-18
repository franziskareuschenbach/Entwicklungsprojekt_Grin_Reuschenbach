package com.example.ep_codev1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth         //firebase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        onStart()

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()        //firebase   Original: auth = Firebase.auth


        val keinAccount = findViewById<Button>(R.id.buttonKeinAccount)    // on click event

        keinAccount.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        //LogIn Button
        val logIn = findViewById<Button>(R.id.buttonAnmelden)
        logIn.setOnClickListener {
            login()
        }

    }

    fun login() { //Noch Problem: Crash bei falschem LogIn,
        val email = findViewById<EditText>(R.id.editTextTextEmailAddress)
        if (email.text.toString().isEmpty()) {       //kein user name
            Toast.makeText(baseContext, "Bitte email eintragen",
                Toast.LENGTH_SHORT).show()
            return
        }

        val passwort = findViewById<EditText>(R.id.editTextTextPassword)
        if (passwort.text.toString().isEmpty()) {
            Toast.makeText(baseContext, "Bitte Passwort eintragen",
                Toast.LENGTH_SHORT).show()
            return
        }

        auth.signInWithEmailAndPassword(email.text.toString(), passwort.text.toString()).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }

        }.addOnFailureListener { exeption ->
            Toast.makeText(
                baseContext, exeption.localizedMessage,
                Toast.LENGTH_SHORT).show()
        }
    }

    ////Ist user schon eingeloggt
    //public override fun onStart() {             //firebase
    //    super.onStart()
    //    // Check if user is signed in (non-null) and update UI accordingly.
    //    val currentUser = auth.currentUser       //if(currentUser != null){
    //    updateUI(currentUser)               //  reload(); }
    //}
    //fun updateUI(currentUser: FirebaseUser?) {     //musste hinzugefügt werden
    //}
}