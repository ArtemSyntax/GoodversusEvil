// Import der benötigten Modelle
import model.Gegner
import model.GegnerTeam
import model.HeldenGruppe

fun main() {

    // Initialisierung der Helden- und Gegnergruppen
    val heldenGruppe: HeldenGruppe = HeldenGruppe()
    val gegnerTeam: GegnerTeam = GegnerTeam()

    // Definierung der Schlafzeit zwischen den Runden
    val SLEEP_TIME = 1000L

    // Begrüßungsnachricht
    println("Willkommen zum epischen Abenteuer! Deine tapferen Helden stehen vor einem gefährlichen Drachen.")

    // Hauptspielschleife, solange sowohl Helden als auch Gegner am Leben sind
    while (gegnerTeam.istLebendig() && heldenGruppe.istLebendig()) {

        // Schlafen für eine Runde
        Thread.sleep(SLEEP_TIME)

        // Anzeige der neuen Runde
        println("\n----- Neue Runde -----\n")

        // Schlafen für eine Runde
        Thread.sleep(SLEEP_TIME)

        // Anzeige des Status der Helden
        heldenGruppe.zeigeStatus()

        // Schlafen für eine Runde
        Thread.sleep(SLEEP_TIME)

        // Anzeige des Status der Gegner
        gegnerTeam.zeigeStatus()

        // Schlafen für eine Runde
        Thread.sleep(SLEEP_TIME)

        // Auswahl und Durchführung von Aktionen für die Helden
        println("Zuerst beginnen deine Helden zu attackieren: \n")
        val aktuellerGegner: Gegner = if (!gegnerTeam.drache.istLebendig() && gegnerTeam.unterboss != null) {
            gegnerTeam.unterboss!!
        } else {
            gegnerTeam.drache
        }

        // Schlafen für eine Runde
        Thread.sleep(SLEEP_TIME)

        // Aktionen für die Helden auswählen und durchführen
        heldenGruppe.waehleAktionen(gegner = aktuellerGegner)

        // Schlafen für eine Runde
        Thread.sleep(SLEEP_TIME)

        // Zufällige Aktionen für die Gegner auswählen und durchführen
        gegnerTeam.waehleZufaelligeAktionen(heldenGruppe = heldenGruppe)

        // Überprüfen, ob der Kampf endet (wenn einer der beiden keine HP mehr hat)
        if (!gegnerTeam.istLebendig() || heldenGruppe.alleTot()) {
            break
        }
    }

    // Behandlung des Endes des Kampfes, z.B. wer gewonnen hat
    if (!gegnerTeam.istLebendig()) {
        println("Die Helden haben den Kampf gewonnen!")
    } else if (heldenGruppe.alleTot()) {
        println("Die Helden wurden besiegt. Der Gegner hat gewonnen!")
    }
}
