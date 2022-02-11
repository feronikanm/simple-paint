package com.ferodev.simplepaint.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.ferodev.simplepaint.cons.Ellipse
import com.ferodev.simplepaint.MainActivity
import com.ferodev.simplepaint.MainActivity.Companion.currentBrush
import com.ferodev.simplepaint.MainActivity.Companion.paintBrush

class DrawEllipse @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val ellipse = ArrayList<Ellipse>()

    init {
        paintBrush.color = currentBrush
        paintBrush.strokeWidth = 10f
        paintBrush.isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas) {
        for (e in ellipse) {
            paintBrush.color = e.color
            canvas.drawOval(e.startX, e.startY, e.stopX, e.stopY, paintBrush)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when(event.action){
            MotionEvent.ACTION_DOWN -> {
                MainActivity.colorList.add(MainActivity.currentBrush)
                ellipse.add(Ellipse(event.x, event.y,event.x, event.y, currentBrush))
                return true
            }

            MotionEvent.ACTION_MOVE -> {
                val current = ellipse[ellipse.size - 1]
                current.stopX = event.x
                current.stopY = event.y
                invalidate()
                return true
            }

            MotionEvent.ACTION_UP -> {
                val current = ellipse[ellipse.size - 1]
                current.stopX = event.x
                current.stopY = event.y
                invalidate()
                return true
            }

            else -> {
                return false
            }
        }
    }
}