package model

/**
 * Die `HeldenGruppe`-Klasse repräsentiert die Gruppe von spielbaren Helden im Spiel.
 *
 * @property beutel Der Beutel, der Gegenstände für die Helden enthält.
 * @property helden Die Liste der Helden in der Gruppe.
 */
class HeldenGruppe() {
    val beutel: Beutel = Beutel()
    val helden: List<Held> = mutableListOf(Griffin(), Naga(), Seraphim())

    /**
     * Zeigt den aktuellen Status der Helden in der Gruppe an, einschließlich ihrer Gesundheit (HP).
     */
    fun zeigeStatus() {
        println("Heldengruppe:")
        for ((index, held) in helden.withIndex()) {
            println("${index + 1}. ${held.name} - HP: ${held.hp}")
        }
        println()
    }

    /**
     * Überprüft, ob mindestens ein Held in der Gruppe noch lebendig ist (positive Gesundheit).
     *
     * @return `true`, wenn mindestens ein Held noch lebendig ist, andernfalls `false`.
     */
    fun istLebendig(): Boolean {
        return helden.any { it.istLebendig() }
    }

    /**
     * Überprüft, ob alle Helden in der Gruppe tot sind (keine lebendigen Helden mehr).
     *
     * @return `true`, wenn alle Helden tot sind, andernfalls `false`.
     */
    fun alleTot(): Boolean {
        return !istLebendig()
    }

    /**
     * Ermöglicht den Helden, Aktionen gegen einen Gegner auszuwählen und auszuführen.
     *
     * @param gegner Der Gegner, gegen den die Aktionen ausgeführt werden.
     */
    fun waehleAktionen(gegner: Gegner) {
        for (held in helden) {
            Thread.sleep(1000)
            println("${held.name}, du bist an der Reihe und kämpfst gegen $gegner.")
            Thread.sleep(1000)
            println("Wähle deine Aktion:")
            println()
            Thread.sleep(1000)
            held.zeigeAktionen()
            println()
            val gewaehlteAktion = readlnOrNull()?.toIntOrNull() ?: 0
            if (gewaehlteAktion in 1..4) {
                held.fuehreAktionAus(gewaehlteAktion, gegner)
                println("Der $gegner hat jetzt ${gegner.hp} Leben übrig")
                println()
            } else {
                println("Ungültige Auswahl. $held führt keine Aktion aus.")
            }
        }
    }
}
