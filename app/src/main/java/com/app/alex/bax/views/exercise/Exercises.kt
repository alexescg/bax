package com.app.alex.bax.views.exercise

import com.app.alex.bax.model.Exercise
import org.jetbrains.annotations.Mutable

/**
 *
 *
 * @author alex
 * @since 3/2/17.
 */
object Exercises {
    /**
     * An array of boxing hits.
     */
    val exerciseList: MutableSet<Exercise>

    /**
     * A map of boxing hits, by ID.
     */
    //    val hitMap: Map<String, Exercise>

    private val count: Int

    init {
        val shadowBox: Exercise = Exercise("Shadow Box", "Box against your shadow")
        val jumpRope: Exercise = Exercise("Jumping Rope", "Jump a Rope constantly")
        val heavyBag: Exercise = Exercise("HeavyBag", "Hit a Heavy Bag")
        exerciseList = mutableSetOf(
                shadowBox,
                jumpRope,
                heavyBag
        )
//        hitMap = mapOf("1" to jab,
//                "2" to upper,
//                "3" to hook,
//                "4" to cross)
        count = exerciseList.size
    }
}