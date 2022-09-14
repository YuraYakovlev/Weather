package com.example.weather

import android.view.animation.Interpolator

class BounceInterpolator(
    private val amplitude: Double,
    private val frequency: Double
) : Interpolator {
    override fun getInterpolation(p0: Float): Float {
        return (-1 * Math.pow(Math.E, -p0/ amplitude) *
                Math.cos(frequency * p0) + 1).toFloat()
    }
}