package model

import kotlin.random.Random

/**
 * Die `Naga`-Klasse repräsentiert einen spielbaren Helden vom Typ Naga.
 *
 * @property name Der Name des Helden.
 * @property hp Die Gesundheit (Hit Points) des Helden.
 * @property schaden Der maximale Schaden, den der Held verursachen kann.
 */
class Naga : Held("Naga", 120.0, 20){

    /**
     * Führt eine Schwertattacke auf einen Gegner aus.
     *
     * @param gegner Der Gegner, auf den die Attacke ausgeführt wird.
     * @return Der verursachte Schaden.
     */
    fun schwertAttacke(gegner: Gegner): Int {
        val schaden = Random.nextInt(schaden.toInt() - 15, schaden.toInt() + 15) // Zufälliger Schaden um den vordefinierten Schadenswert
        gegner.hp -= schaden
        return schaden
    }

    /**
     * Führt eine Messerattacke auf einen Gegner aus.
     *
     * @param gegner Der Gegner, auf den die Attacke ausgeführt wird.
     * @return Der verursachte Schaden.
     */
    fun messerAttacke(gegner: Gegner): Int {
        val schaden = Random.nextInt(schaden.toInt() - 10, schaden.toInt() + 10) // Zufälliger Schaden um den vordefinierten Schadenswert
        gegner.hp -= schaden
        return schaden
    }

    /**
     * Führt einen Klingeangriff auf einen Gegner aus.
     *
     * @param gegner Der Gegner, auf den die Attacke ausgeführt wird.
     * @return Der verursachte Schaden.
     */
    fun klingenAttacke(gegner: Gegner): Int {
        val schaden = Random.nextInt(schaden.toInt() - 20, schaden.toInt() + 20) // Zufälliger Schaden um den vordefinierten Schadenswert
        gegner.hp -= schaden
        return schaden
    }

    /**
     * Führt eine himmlische Heilung aus, um den Helden zu heilen.
     *
     * @return Die Anzahl der geheilten Hit Points (HP).
     */
    fun himmlischeHeilung() : Int {
        val heilung = Random.nextInt(15, 30) // Zufällige Heilung zwischen 15 und 30 HP
        hp += heilung
        return heilung
    }

    override fun handleAngriff(schaden: Int) {
        hp -= schaden
    }

    override fun zeigeAktionen() {
        println("Aktionen für $name:")
        println("1. Schwertattacke (Schaden: 20 ± 15)")
        println("2. Messerattacke (Schaden: 20 ± 10)")
        println("3. Klingeangriff (Schaden: 20 ± 20)")
        println("4. Himmlische Heilung (Heilung: 15-30 HP)")
    }

    override fun fuehreAktionAus(aktion: Int, gegner: Gegner) {
        when (aktion) {
            1 -> {
                val schaden = schwertAttacke(gegner)
                println("$name führt Schwertattacke aus und verursacht $schaden Schaden.")
            }
            2 -> {
                val schaden = messerAttacke(gegner)
                println("$name führt Messerattacke aus und verursacht $schaden Schaden.")
            }
            3 -> {
                val schaden = klingenAttacke(gegner)
                println("$name führt Klingeangriff aus und verursacht $schaden Schaden.")
            }
            4 -> {
                val heilung = himmlischeHeilung()
                println("$name führt Himmlische Heilung aus und heilt sich um $heilung HP.")
            }
            else -> println("$name führt keine Aktion aus.")
        }
    }
}
