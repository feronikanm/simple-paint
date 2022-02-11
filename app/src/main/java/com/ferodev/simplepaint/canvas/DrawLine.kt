package com.ferodev.simplepaint.canvas

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.ferodev.simplepaint.cons.Line
import com.ferodev.simplepaint.MainActivity.Companion.colorList
import com.ferodev.simplepaint.MainActivity.Companion.currentBrush
import com.ferodev.simplepaint.MainActivity.Companion.paintBrush

class DrawLine @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    companion object{
        var line = ArrayList<Line>()
    }

    init {
        paintBrush.color = currentBrush
        paintBrush.strokeWidth = 10f
        paintBrush.isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas) {
        for (l in line) {
            paintBrush.color = l.color
            canvas.drawLine(l.startX, l.startY, l.stopX, l.stopY, paintBrush)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when(event.action){
            MotionEvent.ACTION_DOWN -> {
                colorList.add(currentBrush)
                line.add(Line(event.x, event.y,event.x, event.y, currentBrush))
                return true
            }

            MotionEvent.ACTION_MOVE -> {
                val current = line[line.size - 1]
                current.stopX = event.x
                current.stopY = event.y
                invalidate()
                return true
            }

            MotionEvent.ACTION_UP -> {
                val current = line[line.size - 1]
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