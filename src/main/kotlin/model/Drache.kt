package model

import kotlin.random.Random
import kotlin.random.nextInt

/**
 * Diese Klasse repräsentiert den Drachen, einen speziellen Gegner im Spiel.
 *
 * @property helferBeschworen Gibt an, ob der Drache bereits einen Helfer beschworen hat.
 */
class Drache : Gegner("Drache", 700.0) {

    private var helferBeschworen: Boolean = false

    // Trifft einen Helden mit einem Feuerball
    private fun wirfFeuerBall(held: Held) {
        val schaden = Random.nextInt(10, 20) // Zufälliger Schaden zwischen 10 und 20
        held.handleAngriff(schaden)
    }

    // Trifft alle Helden mit Feuerspucke
    private fun spuckFeuer(heldenGruppe: HeldenGruppe) {
        for (held: Held in heldenGruppe.helden) {
            val prozentualerAbzug = Random.nextDouble(0.1, 0.2) // Zufälliger prozentualer Abzug zwischen 10% und 20%
            val schaden = (held.hp * prozentualerAbzug).toInt()
            held.handleAngriff(schaden)
        }
    }

    // Krallenangriff auf einen zufälligen Helden im Team
    private fun krallenAttacke(zufallsHeld: Held) {
        val schaden = Random.nextInt(15, 25) // Zufälliger Schaden zwischen 15 und 25
        zufallsHeld.handleAngriff(schaden)
    }

    // Luftangriff auf einen zufälligen Helden im Team
    private fun luftAngriff(zufallsHeld: Held) {
        val schaden = Random.nextInt(20, 30) // Zufälliger Schaden zwischen 20 und 30
        zufallsHeld.handleAngriff(schaden)
    }

    // Laserangriff auf einen zufälligen Helden im Team
    private fun laserAngriff(zufallsHeld: Held) {
        val schaden = Random.nextInt(25, 35) // Zufälliger Schaden zwischen 25 und 35
        zufallsHeld.handleAngriff(schaden)
    }

    /**
     * Der Drache beschwört einen Unterboss, wenn noch kein Helfer beschworen wurde.
     *
     * @param gegnerTeam Das Team der Gegner, zu dem der Drache gehört.
     */
    private fun beschwoereUnterBoss(gegnerTeam: GegnerTeam) {
        if (!helferBeschworen) {
            gegnerTeam.unterboss = Unterboss()
            helferBeschworen = true
            println("Der Drache hat einen Unterboss beschworen!")
        } else {
            println("Ein Helfer wurde bereits beschworen!")
        }
    }

    /**
     * Wählt eine zufällige Aktion für den Drachen und führt sie aus.
     *
     * @param gegnerTeam Das Team der Gegner, zu dem der Drache gehört.
     * @param heldenGruppe Die Gruppe der Helden, gegen die der Drache kämpft.
     */
    fun waehleZufaelligeAktion(gegnerTeam: GegnerTeam, heldenGruppe: HeldenGruppe) {
        val randomAktion = Random.nextInt(0..5) // Wählt eine zufällige Aktion (0 bis 5)

        println("Der Drache bereitet einen Angriff vor: ")
        Thread.sleep(1000)
        when (randomAktion) {
            0 -> {
                val zufallsheld = heldenGruppe.helden.random()
                val schaden = Random.nextInt(10, 20)
                println("Drache wirft einen Feuerball auf ${zufallsheld.name} und verursacht $schaden Schaden.")
                Thread.sleep(1000)
                wirfFeuerBall(zufallsheld)
            }

            1 -> {
                val prozentualerAbzug = Random.nextDouble(0.1, 0.2)
                val schaden = (heldenGruppe.helden.size * (heldenGruppe.helden[0].hp * prozentualerAbzug)).toInt()
                println("Drache spuckt Feuer auf alle Helden und verursacht $schaden Schaden insgesamt.")
                Thread.sleep(1000)
                heldenGruppe.zeigeStatus()
                Thread.sleep(1000)
                spuckFeuer(heldenGruppe)
            }

            2 -> {
                val zufallsheld = heldenGruppe.helden.random()
                val schaden = Random.nextInt(15, 25)
                println("Drache führt einen Krallenangriff auf ${zufallsheld.name} aus und verursacht $schaden Schaden.")
                Thread.sleep(1000)
                println("${zufallsheld.name} hat noch ${zufallsheld.hp} übrig.")
                Thread.sleep(1000)
                krallenAttacke(zufallsheld)
            }

            3 -> {
                val zufallsheld = heldenGruppe.helden.random()
                val schaden = Random.nextInt(20, 30)
                println("Drache führt einen Luftangriff auf ${zufallsheld.name} aus und verursacht $schaden Schaden.")
                Thread.sleep(1000)
                println("${zufallsheld.name} hat noch ${zufallsheld.hp} übrig.")
                Thread.sleep(1000)
                luftAngriff(zufallsheld)
            }

            4 -> {
                val zufallsheld = heldenGruppe.helden.random()
                val schaden = Random.nextInt(25, 35)
                println("Drache führt einen Laserangriff auf ${zufallsheld.name} aus und verursacht $schaden Schaden.")
                Thread.sleep(1000)
                println("${zufallsheld.name} hat noch ${zufallsheld.hp} übrig.")
                Thread.sleep(1000)
                laserAngriff(zufallsheld)
            }

            5 -> {
                if (!helferBeschworen) {
                    println("Drache beschwört einen Unterboss.")
                    Thread.sleep(1000)
                    beschwoereUnterBoss(gegnerTeam)
                } else {
                    println("Der Drache hat versucht noch einen Unterboss zu beschwören.")
                    Thread.sleep(1000)
                    println("Der Drache hat aber bereits einen Helfer beschworen.")
                }
            }
        }
        println()
    }

    override fun toString(): String {
        return name
    }
}
