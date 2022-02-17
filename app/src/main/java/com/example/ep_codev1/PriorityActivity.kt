package com.example.ep_codev1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
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
            //KarteActivity.GespeicherteKarten.karteloeschen(
            //    KarteItem("Kauen und Schlucken", "Haben Sie nach Ihrem Schlaganfall Probleme mit dem Kauen und Schlucken?",
            //        "- Verschlucken\n- Aufstoßen\n- Anstregungen beim Kauen oder Schlucken", "ICF:b510")
            //)
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
            // KarteActivity.GespeicherteKarten.karteloeschen(
            //     KarteItem("Stabilität in Armen und Beinen", "Haben Sie nach Ihrem Schlaganfall Probleme mit der Stabilität in Ihren Armen oder Beinen?",
            //         "- Wegknicken der Beine beim Stehen oder Gehen\n- Instabilität der Schulter beim Abstützen", "ICF:b715")
            // )
            zurueckZuKarteActivity()
        }

        val okButton = findViewById<Button>(R.id.buttonOk)
        okButton.setOnClickListener{
            OkActivity.OkListe.addListeOk(ListenItem("Schlaf", "ICF:b134"))
            zurueckZuKarteActivity()
        }

        val actionBar = supportActionBar

        actionBar!!.title="Priorität"

        actionBar.setDisplayHomeAsUpEnabled(true)

    }
    fun zurueckZuKarteActivity(){
        startActivity(Intent(this, KarteActivity :: class.java))
    }
}