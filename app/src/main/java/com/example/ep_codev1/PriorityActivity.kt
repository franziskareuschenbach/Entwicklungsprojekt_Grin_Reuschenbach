package com.example.ep_codev1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import com.example.ep_codev1.karte.KarteActivity
import com.example.ep_codev1.liste.ListenItem
import com.example.ep_codev1.meine_box_activities.OkActivity
import com.example.ep_codev1.meine_box_activities.SpaeterActivity

class PriorityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_priority)

        //DringendButton zu Karte zurück mit speichern
        val dringendButton = findViewById<Button>(R.id.buttonDringend)
        dringendButton.setOnClickListener {
            //Dies simuliert, was wir mit den Knöpfen bezwecken wollen
            DringendActivity.DringendListe.addListeDringend(ListenItem("Kauen und Schlucken", "ICF:b510"))
            zurueckZuKarteActivity()
        }

        //ErledigtButton zu Karte zurück mit speichern
        val erledigtButton = findViewById<Button>(R.id.buttonErledigt)
        erledigtButton.setOnClickListener{
            zurueckZuKarteActivity()
        }

        val spaeterButton = findViewById<Button>(R.id.buttonSpäter)
        spaeterButton.setOnClickListener{
            SpaeterActivity.SpaeterListe.addListeSpaeter(ListenItem("Stabilität in Armen und Beinen", "ICF:b715"))
            zurueckZuKarteActivity()
        }

        val okButton = findViewById<Button>(R.id.buttonOk)
        okButton.setOnClickListener{
            OkActivity.OkListe.addListeOk(ListenItem("Schlaf", "ICF:b134"))
            zurueckZuKarteActivity()
        }

        val infoDringend = findViewById<ImageButton>(R.id.frageButtonDringend)

        infoDringend.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Dringend")
            builder.setMessage("Sie sind betroffen und möchten kurzfristig eine Lösung herbeiführen.")

            val alertDialog :AlertDialog = builder.create()
            alertDialog.setCancelable(true)
            alertDialog.show()
        }

        val infoErledigt = findViewById<ImageButton>(R.id.frageButtonErledigt)

        infoErledigt.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Erledigt")
            builder.setMessage("Sie waren mal betroffen, das Problem besteht jedoch nicht mehr.")

            val alertDialog :AlertDialog = builder.create()
            alertDialog.setCancelable(true)
            alertDialog.show()
        }

        val infoSpaeter = findViewById<ImageButton>(R.id.frageButtonSpaeter)

        infoSpaeter.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Später")
            builder.setMessage("Sie sind betroffen, jedoch ist keine kurfristige Lösung möglich oder nötig.")

            val alertDialog :AlertDialog = builder.create()
            alertDialog.setCancelable(true)
            alertDialog.show()
        }

        val infoOk = findViewById<ImageButton>(R.id.frageButtonOk)

        infoOk.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Ok")
            builder.setMessage("Sie sind nicht betroffen.")

            val alertDialog :AlertDialog = builder.create()
            alertDialog.setCancelable(true)
            alertDialog.show()
        }

        val actionBar = supportActionBar

        actionBar!!.title="Priorität"

        actionBar.setDisplayHomeAsUpEnabled(true)

    }
    fun zurueckZuKarteActivity(){
        startActivity(Intent(this, KarteActivity :: class.java))
    }
}