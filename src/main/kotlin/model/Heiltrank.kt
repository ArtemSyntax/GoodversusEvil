package model

/**
 * Die `Heiltrank`-Klasse repräsentiert einen Gegenstand, der die Gesundheit eines Helden erhöht.
 */
class Heiltrank : Gegenstand() {
    /**
     * Benutzt den Heiltrank, um die Gesundheit des Helden um das 1,5-fache zu erhöhen.
     *
     * @param held Der Held, der den Heiltrank benutzt.
     */
    override fun benutze(held: Held) {
        // Erhöht die Gesundheit des Helden um das 1,5-fache
        held.hp *= 1.5
    }
}
