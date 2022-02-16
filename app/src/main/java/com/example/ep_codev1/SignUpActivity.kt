package com.example.ep_codev1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_sign_up)

        //Gibt auth die Infos
        auth = FirebaseAuth.getInstance()

        // Wenn man auf Anmelden klickt wird die funktion register ausgeführt
        val anmelden = findViewById<Button>(R.id.buttonAnmelden)
        anmelden.setOnClickListener {
            //startActivity(Intent(this, Tutorial :: class.java))  //15.02 //Acticity gibt es noch nicht???
            startActivity(Intent(this, Tutorial :: class.java))  //15.02
            register()}


        //Action Bar zurück zum Login
        val actionBar = supportActionBar
        actionBar!!.title="Sign-Up"
        actionBar.setDisplayHomeAsUpEnabled(true)
    }


    fun register(){
        //Check ob Email eingetragen wurde
        val email = findViewById<EditText>(R.id.editTextTextEmailAddress)
        if (email.text.toString().isEmpty()) {       //kein user name
            Toast.makeText(baseContext, "Bitte email eintragen",
                Toast.LENGTH_SHORT).show()
            return
        }
        //Check ob Email den vorgegebenen Patterns entspricht
        if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()) {
            Toast.makeText(baseContext, "Bitte eine gültige E-Mail eintragen",
                Toast.LENGTH_SHORT).show()
            return
        }
        //Check ob Passwort einegtragen wurde
        val passwort = findViewById<EditText>(R.id.editTextTextPassword)
        if (passwort.text.toString().isEmpty()) {
            Toast.makeText(baseContext, "Bitte Passwort eintragen",
                Toast.LENGTH_SHORT).show()
            return
        }

        //Mit den eingegebenen Daten wird ein neuer User erstellt
        auth.createUserWithEmailAndPassword(email.text.toString(),passwort.text.toString())
            //Wenn task erfolgreich, dann uebergang zu MainActivity
            .addOnCompleteListener { task ->
            if (task.isSuccessful){

                startActivity(Intent(this, Tutorial :: class.java)) //15.02 //Acticity gibt es noch nicht???
                finish()
            }
            //Bei Fail gibts eine Nachricht basierend auf Fehler
        }.addOnFailureListener{ exeption ->
            Toast.makeText(baseContext, exeption.localizedMessage,
                Toast.LENGTH_SHORT).show()
        }
    }
}
