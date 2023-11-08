package model

/**
 * The `Vitamine` class represents a type of `Gegenstand` (item) that can be used by a `Held`.
 * When a `Vitamine` is used, it increases the health points (hp) of the `Held` by 10%.
 *
 * @param held The `Held` who uses the Vitamine to increase their health.
 */
class Vitamine : Gegenstand() {
    override fun benutze(held: Held) {
        held.hp *= 1.1
    }
}
