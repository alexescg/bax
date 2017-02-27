package com.app.alex.bax.views.info

import java.util.*

/**
 *
 *
 * @author alex
 * @since 2/26/17.
 */
object BoxingHits {
    /**
     * An array of boxing hits.
     */
    val items: List<BoxingHit>

    /**
     * A map of boxing hits, by ID.
     */
    val item_map: Map<String, BoxingHit>

    private val count: Int

    init {
        val jab: BoxingHit = BoxingHit("1", "Jab", "Long Reach Attack")
        val upper: BoxingHit = BoxingHit("2", "Uppercut", "Close Reach Attack")
        val hook: BoxingHit = BoxingHit("3", "Hook", "Middle Attack")
        val cross: BoxingHit = BoxingHit("4", "Cross", "Counter Attack")
        items = listOf(
                jab,
                upper,
                hook,
                cross
        )
        item_map = mapOf("1" to jab,
                "2" to upper,
                "3" to hook,
                "4" to cross)
        count = items.size
    }


    private fun createDummyItem(position: Int): BoxingHit {
        return BoxingHit(position.toString(), "Item " + position, makeDetails(position))
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A dummy item representing a piece of content.
     */
    class BoxingHit(val id: String, val content: String, val details: String) {
        override fun toString(): String {
            return "BoxingHit(id='$id', content='$content', details='$details')"
        }
    }
}