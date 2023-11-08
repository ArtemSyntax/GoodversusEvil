package model

import kotlin.random.Random

class Griffin : Held("Griffin", 100.0, 25) {

    private var schutzSchild: Boolean = false;

    // Trifft den Gegner mit einem Feuerball und gibt den verursachten Schaden zurück.
    fun feuerBall(gegner: Gegner): Int {
        val schaden =
            Random.nextInt(schaden - 5, schaden + 10).toInt() // Zufälliger Schaden um den vordefinierten Schadenswert
        gegner.hp -= schaden
        return schaden
    }

    // Trifft den Gegner mit Feuerregen und gibt den verursachten Schaden zurück.
    fun feuerRegen(gegner: Gegner): Int {
        val schaden =
            Random.nextInt(schaden - 15, schaden + 5).toInt() // Zufälliger Schaden um den vordefinierten Schadenswert
        gegner.hp -= schaden
        return schaden
    }

    // Trifft den Gegner mit Feuerpfeilen und gibt den verursachten Schaden zurück.
    fun feuerPfeile(gegner: Gegner): Int {
        val schaden =
            Random.nextInt(schaden - 20, schaden + 15).toInt() // Zufälliger Schaden um den vordefinierten Schadenswert
        gegner.hp -= schaden
        return schaden
    }

    // Aktiviert den Schutzschild.
    fun aktiviereSchutzschild() {
        schutzSchild = true
    }

    // Diese Funktion wird aufgerufen, wenn der Endgegner angreift
    override fun handleAngriff(schaden: Int) {
        if (schutzSchild) {
            // Der himmlische Schutz ist aktiv, reduziere den Schaden um 50%
            val reduzierterSchaden = schaden / 2
            hp -= reduzierterSchaden
            schutzSchild = false // Deaktiviere den Schutz nach einem Angriff
            println()
            println("$name aktiviert das Schutzschild und reduziert den erlittenen Schaden um 50%.")
            println("$name erleidet $schaden Schaden.")
        } else {
            hp -= schaden
            println("$name erleidet $schaden Schaden.")
        }
    }

    // Zeigt die verfügbaren Aktionen für den Griffin.
    override fun zeigeAktionen() {
        println("Aktionen für $name:")
        println("1. Feuerball - Verursacht Schaden zwischen ${schaden - 10} und ${schaden + 15}")
        println("2. Feuerregen - Verursacht Schaden zwischen ${schaden - 15} und ${schaden + 10}")
        println("3. Feuerpfeile - Verursacht Schaden zwischen ${schaden - 20} und ${schaden + 25}")
        println("4. Aktiviere Schutzschild")
    }

    // Führt die ausgewählte Aktion für den Griffin aus und gibt Informationen über die ausgeführte Aktion aus.
    override fun fuehreAktionAus(aktion: Int, gegner: Gegner) {
        when (aktion) {
            1 -> {
                val schaden = feuerBall(gegner)
                println("$name führt Feuerball aus und verursacht $schaden Schaden.")
            }
            2 -> {
                val schaden = feuerRegen(gegner)
                println("$name führt Feuerregen aus und verursacht $schaden Schaden.")
            }
            3 -> {
                val schaden = feuerPfeile(gegner)
                println("$name führt Feuerpfeile aus und verursacht $schaden Schaden.")
            }
            4 -> {
                aktiviereSchutzschild()
                println("$name aktiviert das Schutzschild.")
            }
            else -> println("$name führt keine Aktion aus.")
        }
        println()
    }
}
