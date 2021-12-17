package com.example.ep_codev1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth         //firebase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()        //firebase   Original: auth = Firebase.auth


        val keinAccount= findViewById<Button>(R.id.buttonKeinAccount)    // on click event

        keinAccount.setOnClickListener {
        startActivity(Intent(this, SignUpActivity :: class.java))
        }
    }

    //Ist user schon eingeloggt
    public override fun onStart() {             //firebase
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser       //if(currentUser != null){
            updateUI(currentUser)               //  reload(); }
    }

    fun updateUI(currentUser : FirebaseUser?){     //musste hinzugefügt werden
    }
}