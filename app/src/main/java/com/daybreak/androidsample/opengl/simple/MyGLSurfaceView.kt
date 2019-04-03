package com.daybreak.androidsample.opengl.simple

import android.content.Context
import android.opengl.GLSurfaceView
import android.util.AttributeSet

class MyGLSurfaceView(context: Context, attrs: AttributeSet?) : GLSurfaceView(context, attrs) {
        constructor(context: Context): this(context, null)

        private val renderer : MyGLRenderer

        init {
            setEGLContextClientVersion(2)

            renderer = MyGLRenderer()

            setRenderer(renderer)
        }
    }