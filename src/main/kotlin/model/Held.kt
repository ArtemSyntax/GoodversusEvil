package model

/**
 * Die `Held`-Klasse ist eine abstrakte Basisklasse für spielbare Helden.
 *
 * @property name Der Name des Helden.
 * @property hp Die Gesundheit (Hit Points) des Helden.
 * @property schaden Der Schaden, den der Held verursacht.
 * @property hatFluch Gibt an, ob der Held unter einem Fluch steht.
 */
abstract class Held(val name: String, var hp: Double, var schaden: Int) {

    var hatFluch: Boolean = false

    /**
     * Übernimmt den Schaden, den der Held durch einen Angriff erleidet.
     *
     * @param schaden Der erlittene Schaden.
     */
    abstract fun handleAngriff(schaden: Int)

    /**
     * Überprüft, ob der Held noch lebendig ist (positive Gesundheit).
     *
     * @return `true`, wenn der Held noch lebendig ist, andernfalls `false`.
     */
    fun istLebendig(): Boolean {
        return hp > 0
    }

    /**
     * Zeigt die verfügbaren Aktionen für den Helden an.
     */
    abstract fun zeigeAktionen()

    /**
     * Führt eine ausgewählte Aktion des Helden gegen einen Gegner aus.
     *
     * @param aktion Die ausgewählte Aktion.
     * @param gegner Der Gegner, auf den die Aktion angewendet wird.
     */
    abstract fun fuehreAktionAus(aktion: Int, gegner: Gegner)
}
