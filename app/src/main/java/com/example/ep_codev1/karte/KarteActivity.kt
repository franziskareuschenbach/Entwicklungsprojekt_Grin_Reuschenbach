package com.example.ep_codev1.karte
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.ep_codev1.R
import kotlinx.android.synthetic.main.activity_rvkarte.*

class KarteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_rvkarte)

        val listOfCards = SavedCards.cards

        rvCard.layoutManager = LinearLayoutManager(this)
        rvCard.adapter = CardAdapter(listOfCards)

        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rvCard)
    }

    //Die Kartenliste
    object SavedCards{
        val cards = mutableListOf(
            CardItem("Kauen und Schlucken", "Haben Sie nach Ihrem Schlaganfall Probleme mit dem Kauen und Schlucken?",
                "- Verschlucken\n- Aufstoßen\n- Anstregungen beim Kauen oder Schlucken", "ICF:b510"),
            CardItem("Stabilität in Armen und Beinen", "Haben Sie nach Ihrem Schlaganfall Probleme mit der Stabilität in Ihren Armen oder Beinen?",
                "- Wegknicken der Beine beim Stehen oder Gehen\n- Instabilität der Schulter beim Abstützen", "ICF:b715"),
            CardItem("Schlaf", "Haben Sie nach Ihrem Schlaganfall Probleme mit Ihrem Schlaf?",
                "- Probleme beim Einschlafen\n- Probleme beim Durchschlafen", "ICF:b134"),
            CardItem("Gefühle", "Haben Sie nach Ihrem Schlaganfall Probleme mit Ihren Gefühlen?",
                "- Gedrückte Stimmung\n- Traurigkeit \n- Anspannung", "ICF:b152"),
            CardItem("Schmerz", "Haben Sie nach Ihrem Schlaganfall Probleme mit Schmerzen?",
                "- Schmerzen in der Schulter\n- Kopfschmerzen \n- Muskelschmerzen \n- Migräne", "ICF:b280")
        )

        fun deleteCard(cardItem: CardItem){
            cards.remove(cardItem)
        }
    }
}