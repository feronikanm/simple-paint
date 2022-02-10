package com.ferodev.simplepaint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class DrawLine @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var startPoint : PointF? = null
    private var endPoint : PointF? = null
    private var paint: Paint? = null
    private var isDrawing = false

    init {
        paint = Paint()
        paint!!.color = Color.BLACK
        paint!!.strokeWidth = 10f
        paint!!.isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas?) {
        if (isDrawing) {
            canvas!!.drawLine(startPoint!!.x, startPoint!!.y, endPoint!!.x, endPoint!!.y, paint!!)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                startPoint = PointF(event.x, event.y)
                endPoint = PointF()
                isDrawing = true
            }
            MotionEvent.ACTION_MOVE -> {
                endPoint!!.x = event.x
                endPoint!!.y = event.y
                invalidate()
            }
            MotionEvent.ACTION_UP -> {
                endPoint!!.x = event.x
                endPoint!!.y = event.y
                isDrawing = false
                invalidate()
            }
            else -> {

            }
        }
        return true
    }
}