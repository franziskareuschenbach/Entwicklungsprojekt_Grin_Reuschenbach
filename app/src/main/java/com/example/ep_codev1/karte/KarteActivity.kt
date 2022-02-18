package com.example.ep_codev1.karte
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.ep_codev1.R
import com.example.ep_codev1.karte.KarteAdapter
import com.example.ep_codev1.karte.KarteItem
import kotlinx.android.synthetic.main.activity_rvkarte.*

class KarteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_rvkarte)

        val kartend = GespeicherteKarten.karten

        rvKarte.layoutManager = LinearLayoutManager(this)
        rvKarte.adapter = KarteAdapter(kartend)

        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rvKarte)
    }

    //Die Kartenliste
    object GespeicherteKarten{
        val karten = mutableListOf(
            KarteItem("Kauen und Schlucken", "Haben Sie nach Ihrem Schlaganfall Probleme mit dem Kauen und Schlucken?",
                "- Verschlucken\n- Aufstoßen\n- Anstregungen beim Kauen oder Schlucken", "ICF:b510"),
            KarteItem("Stabilität in Armen und Beinen", "Haben Sie nach Ihrem Schlaganfall Probleme mit der Stabilität in Ihren Armen oder Beinen?",
                "- Wegknicken der Beine beim Stehen oder Gehen\n- Instabilität der Schulter beim Abstützen", "ICF:b715"),
            KarteItem("Schlaf", "Haben Sie nach Ihrem Schlaganfall Probleme mit Ihrem Schlaf?",
                "- Probleme beim Einschlafen\n- Probleme beim Durchschlafen", "ICF:b134"),
            KarteItem("Gefühle", "Haben Sie nach Ihrem Schlaganfall Probleme mit Ihren Gefühlen?",
                "- Gedrückte Stimmung\n- Traurigkeit \n- Anspannung", "ICF:b152"),
            KarteItem("Schmerz", "Haben Sie nach Ihrem Schlaganfall Probleme mit Schmerzen?",
                "- Schmerzen in der Schulter\n- Kopfschmerzen \n- Muskelschmerzen \n- Migräne", "ICF:b280")
        )

        fun karteloeschen(karteItem: KarteItem){
            karten.remove(karteItem)
        }
    }
}