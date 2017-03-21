package com.app.alex.bax.views.exercise

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.app.alex.bax.R
import com.app.alex.bax.model.Exercise
import com.app.alex.bax.views.TwoLineItemViewHolder

/**
 *
 *
 * @author alex
 * @since 3/4/17.
 */
class ExerciseListAdapter(var exercises: List<Exercise>, var context: Context) : BaseAdapter() {

    var layoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var viewHolder: TwoLineItemViewHolder
        var tempView: View?

        if (convertView == null) {
            tempView = layoutInflater.inflate(R.layout.item_twolineitem, parent, false)
            viewHolder = TwoLineItemViewHolder()

            viewHolder.title = tempView.findViewById(R.id.li_title) as TextView
            viewHolder.content = tempView.findViewById(R.id.li_content) as TextView

            tempView.tag = viewHolder
        } else {
            tempView = convertView
            viewHolder = convertView.tag as TwoLineItemViewHolder
        }

        val exercise: Exercise = exercises.elementAt(position)
        viewHolder.title.text = exercise.name
        viewHolder.content.text = exercise.description
        return tempView!!
    }

    override fun getItem(position: Int): Any {
        return exercises.elementAt(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return exercises.size
    }

}