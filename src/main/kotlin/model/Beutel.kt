package model

/**
 * Die Beutel-Klasse repräsentiert einen Behälter, der verschiedene Gegenstände für die Helden-Gruppe enthält.
 */
class Beutel {
    private val gegenstaende: MutableList<Gegenstand> = mutableListOf()

    /**
     * Der Konstruktor für die Beutel-Klasse. Initialisiert den Beutel mit einigen standardmäßigen Gegenständen.
     */
    init {
        gegenstaende.add(Heiltrank())
        gegenstaende.add(Heiltrank())
        gegenstaende.add(Heiltrank())
        gegenstaende.add(Vitamine())
    }
}
