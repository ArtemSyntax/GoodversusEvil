package model

/**
 * Die `Seraphim`-Klasse repräsentiert einen spielbaren Helden vom Typ Seraphim.
 *
 * @property name Der Name des Helden.
 * @property hp Die Gesundheit (Hit Points) des Helden.
 * @property schaden Der maximale Schaden, den der Held verursachen kann.
 */
class Seraphim : Held("Seraphim", 85.0, 50) {

    /**
     * Führt eine Schwertattacke auf einen Gegner aus.
     *
     * @param gegner Der Gegner, auf den die Attacke ausgeführt wird.
     * @return Der verursachte Schaden.
     */
    fun schwertAttacke(gegner: Gegner): Int {
        val schaden = this.schaden
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
        val schaden = this.schaden
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
        val schaden = this.schaden
        gegner.hp -= schaden
        return schaden
    }

    /**
     * Aktiviert den Himmlischen Schutz, erhöht die HP um 20%.
     */
    fun himmlischerSchutz(){
        // Erhöhe die HP um 20%
        hp *= 1.2
    }

    override fun handleAngriff(schaden: Int) {
        hp -= schaden
    }

    override fun zeigeAktionen() {
        println("Aktionen für $name:")
        println("1. Schwertattacke (Schaden: $schaden)")
        println("2. Messerattacke (Schaden: $schaden)")
        println("3. Klingeangriff (Schaden: $schaden)")
        println("4. Himmlischer Schutz (Erhöht HP um 20%)")
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
                himmlischerSchutz()
                println("$name aktiviert den Himmlischen Schutz und erhöht die HP um 20%.")
                println("$name hat jetzt $hp HP")
            }

            else -> println("$name führt keine Aktion aus.")
        }
    }
}
