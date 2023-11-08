package model

import kotlin.random.Random
import kotlin.random.nextInt

/**
 * Die `Unterboss`-Klasse repräsentiert einen untergeordneten Gegner, der als Helfer des Endgegners fungiert.
 *
 * @property name Der Name des Unterbosses.
 * @property hp Die Gesundheit (Hit Points) des Unterbosses.
 */
class Unterboss : Gegner("Helfer", 150.0) {

    /**
     * Führt einen Pistolenangriff auf einen Helden aus und verursacht Schaden.
     *
     * @param held Der Held, der angegriffen wird.
     * @return Der verursachte Schaden.
     */
    fun pistolenAngriff(held: Held): Int {
        val schaden = Random.nextInt(25, 40) // Zufälliger Schaden zwischen 25 und 40
        held.handleAngriff(schaden)
        return schaden
    }

    /**
     * Führt einen Bombenangriff auf einen Helden aus und verursacht Schaden.
     *
     * @param held Der Held, der angegriffen wird.
     * @return Der verursachte Schaden.
     */
    fun bombenAngriff(held: Held): Int {
        val schaden = Random.nextInt(35, 55) // Zufälliger Schaden zwischen 35 und 55
        held.handleAngriff(schaden)
        return schaden
    }

    /**
     * Führt einen Bogenangriff auf einen Helden aus und verursacht Schaden.
     *
     * @param held Der Held, der angegriffen wird.
     * @return Der verursachte Schaden.
     */
    fun bogenangriff(held: Held): Int {
        val schaden = Random.nextInt(20, 30) // Zufälliger Schaden zwischen 20 und 30
        held.handleAngriff(schaden)
        return schaden
    }

    /**
     * Heilt den Drachen und erhöht seine HP.
     *
     * @param drache Der Drache, der geheilt wird.
     * @return Die Heilung, die dem Drachen zugeführt wird.
     */
    fun heileDrache(drache: Drache): Int {
        val heilung = Random.nextInt(20, 40) // Zufällige Heilung zwischen 20 und 40 HP für den Drachen
        drache.hp += heilung
        return heilung
    }

    /**
     * Wählt eine zufällige Aktion aus und führt sie aus.
     *
     * @param heldenGruppe Die Gruppe der Helden, auf die der Unterboss angreift.
     * @param drache Der Drache, der geheilt werden kann.
     */
    fun waehleZufaelligeAktion(heldenGruppe: HeldenGruppe, drache: Drache) {
        val randomAktion = Random.nextInt(0..3) // Wähle eine zufällige Aktion (0 bis 3)

        when (randomAktion) {
            0 -> {
                val zufallsGegner = heldenGruppe.helden.random()
                val schaden = pistolenAngriff(zufallsGegner) // Pistolenangriff auf einen zufälligen Helden
                println("Unterboss führt einen Pistolenangriff auf $zufallsGegner aus.")
            }

            1 -> {
                val zufallsGegner = heldenGruppe.helden.random()
                val schaden = bombenAngriff(zufallsGegner) // Bombenangriff auf einen zufälligen Helden
                println("Unterboss führt einen Bombenangriff auf $zufallsGegner aus.")
                println("Bei dem Angriff wurde ein Schaden von $schaden HP angerichtet.")
            }

            2 -> {
                val zufallsGegner = heldenGruppe.helden.random()
                val schaden = bogenangriff(zufallsGegner) // Bogenangriff auf einen zufälligen Helden
                println("Unterboss führt einen Bogenangriff auf $zufallsGegner aus.")
            }

            3 -> {
                println("Unterboss heilt den Drachen.")
                heileDrache(drache) // Heilung des Drachens
            }
        }
    }
}