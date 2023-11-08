package model

/**
 * Diese offene Klasse repräsentiert einen Gegner im Spiel.
 *
 * @property name Der Name des Gegners.
 * @property hp Die Gesundheitspunkte (HP) des Gegners.
 */
open class Gegner(val name: String, var hp: Double) {

    /**
     * Überprüft, ob der Gegner noch lebendig ist (HP größer als 0).
     *
     * @return `true`, wenn der Gegner lebendig ist, andernfalls `false`.
     */
    fun istLebendig(): Boolean {
        return hp > 0
    }
}
