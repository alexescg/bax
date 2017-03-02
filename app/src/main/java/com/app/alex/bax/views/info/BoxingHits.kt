package com.app.alex.bax.views.info

import com.app.alex.bax.R
import com.app.alex.bax.model.BoxingHit

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
    val hitList: List<BoxingHit>

    /**
     * A map of boxing hits, by ID.
     */
    val hitMap: Map<String, BoxingHit>

    private val count: Int

    init {
        val jab: BoxingHit = BoxingHit("1", "Jab", "Long Reach Attack", R.drawable.img_jab)
        val upper: BoxingHit = BoxingHit("2", "Uppercut", "Close Reach Attack", R.drawable.img_upper)
        val hook: BoxingHit = BoxingHit("3", "Hook", "Middle Reach Attack", R.drawable.img_crochet)
        val cross: BoxingHit = BoxingHit("4", "Cross", "Counter Attack", R.drawable.img_drop)
        hitList = listOf(
                jab,
                upper,
                hook,
                cross
        )
        hitMap = mapOf("1" to jab,
                "2" to upper,
                "3" to hook,
                "4" to cross)
        count = hitList.size
    }
}