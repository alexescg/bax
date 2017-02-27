package com.app.alex.bax.views.timer

import android.widget.SeekBar
import android.widget.TextView

/**
 *
 *
 * @author alex
 * @since 2/26/17.
 */
class RestTimeSeekBarListener(val textview: TextView) : SeekBar.OnSeekBarChangeListener {
    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
        this.textview.text = "$progress min"
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        // Just an empty method
    }

    override fun onStopTrackingTouch(seekBar: SeekBar) {
        // Another empty method
    }
}