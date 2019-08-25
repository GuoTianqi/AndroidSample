package com.daybreak.androidsample.opengl.simple

import android.content.Context
import android.opengl.GLSurfaceView
import android.opengl.GLSurfaceView.RENDERMODE_WHEN_DIRTY
import android.util.AttributeSet
import android.view.MotionEvent

private const val TOUCH_SCALE_FACTOR = 180.0f / 320.0f

class MyGLSurfaceView(context: Context, attrs: AttributeSet?) : GLSurfaceView(context, attrs) {
    constructor(context: Context): this(context, null)

    private var previousX = 0f
    private var previousY = 0f

    private val renderer : MyGLRenderer

    init {
        setEGLContextClientVersion(2)

        renderer = MyGLRenderer()

        setRenderer(renderer)

        renderMode = RENDERMODE_WHEN_DIRTY
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y
        when (event.action) {
            MotionEvent.ACTION_MOVE -> {
                var dx = x - previousX
                var dy = y - previousY

                if (y > height / 2) {
                    dx *= -1
                }

                if (x < width / 2) {
                    dy *= -1
                }

                renderer.angle += (dx + dy) * TOUCH_SCALE_FACTOR
                requestRender()
            }
        }

        previousX = x
        previousY = y

        return true
    }
}