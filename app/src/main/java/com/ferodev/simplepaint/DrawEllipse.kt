package com.ferodev.simplepaint

import android.content.Context
import android.graphics.Canvas
import android.graphics.PointF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class DrawEllipse @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var startPoint : PointF? = null
    private var endPoint : PointF? = null
    private var isDrawing = false

    init {
        MainActivity.paintBrush.color = MainActivity.currentBrush
        MainActivity.paintBrush.strokeWidth = 10f
        MainActivity.paintBrush.isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas?) {
        if (isDrawing) {
            canvas!!.drawOval(startPoint!!.x, startPoint!!.y, endPoint!!.x, endPoint!!.y,
                MainActivity.paintBrush
            )
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                startPoint = PointF(event.x, event.y)
                endPoint = PointF()
                MainActivity.colorList.add(MainActivity.currentBrush)
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