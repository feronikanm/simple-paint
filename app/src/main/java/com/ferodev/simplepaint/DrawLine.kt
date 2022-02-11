package com.ferodev.simplepaint

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.ferodev.simplepaint.MainActivity.Companion.colorList
import com.ferodev.simplepaint.MainActivity.Companion.currentBrush
import com.ferodev.simplepaint.MainActivity.Companion.paintBrush

class DrawLine @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var startPoint : PointF? = null
    private var endPoint : PointF? = null
    private var isDrawing = false

    init {
        paintBrush.color = currentBrush
        paintBrush.strokeWidth = 10f
        paintBrush.isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas?) {
        if (isDrawing) {
            canvas!!.drawLine(startPoint!!.x, startPoint!!.y, endPoint!!.x, endPoint!!.y, paintBrush)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                startPoint = PointF(event.x, event.y)
                endPoint = PointF()
                colorList.add(currentBrush)
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