package model

/**
 * Diese abstrakte Klasse repräsentiert einen Gegenstand im Spiel, der von Helden benutzt werden kann.
 *
 * @property held Der Held, der den Gegenstand benutzt.
 */
abstract class Gegenstand {

    /**
     * Diese abstrakte Methode wird aufgerufen, wenn ein Held den Gegenstand benutzt.
     *
     * @param held Der Held, der den Gegenstand benutzt.
     */
    abstract fun benutze(held: Held)
}
