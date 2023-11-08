package model

/**
 * Die Klasse `GegnerTeam` repräsentiert das Team der Gegner im Spiel, bestehend aus einem Drachen und optional einem Unterboss.
 *
 * @property drache Der Drache im Gegner-Team.
 * @property unterboss Der optionale Unterboss im Gegner-Team.
 */
class GegnerTeam {

    val drache: Drache = Drache()
    var unterboss: Unterboss? = null

    /**
     * Überprüft, ob das Gegner-Team lebendig ist, indem es den Zustand des Drachens und des Unterbosses berücksichtigt.
     *
     * @return `true`, wenn das Gegner-Team lebendig ist, andernfalls `false`.
     */
    fun istLebendig(): Boolean {
        return drache.istLebendig() || (unterboss != null && unterboss!!.istLebendig())
    }

    /**
     * Lässt die Gegner im Team zufällige Aktionen auswählen und auf die Helden-Gruppe anwenden.
     *
     * @param heldenGruppe Die Gruppe der Helden im Spiel.
     */
    fun waehleZufaelligeAktionen(heldenGruppe: HeldenGruppe) {
        if (drache.istLebendig()) {
            drache.waehleZufaelligeAktion(this, heldenGruppe)
        }
        if (unterboss != null && unterboss!!.istLebendig()) {
            unterboss!!.waehleZufaelligeAktion(heldenGruppe, drache)
        }
    }

    /**
     * Zeigt den Status des Gegner-Teams, einschließlich der HP (Gesundheitspunkte) des Drachens und des Unterbosses (falls vorhanden).
     */
    fun zeigeStatus() {
        println("Gegner-Team:")
        println("1. Drache - HP: ${drache.hp}")
        if (unterboss != null && unterboss!!.istLebendig()) {
            println("2. Unterboss - HP: ${unterboss!!.hp}")
        }
        println()
    }
}
