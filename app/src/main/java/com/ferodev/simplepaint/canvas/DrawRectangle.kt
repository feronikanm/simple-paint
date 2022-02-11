package com.ferodev.simplepaint.canvas

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.ferodev.simplepaint.MainActivity
import com.ferodev.simplepaint.MainActivity.Companion.currentBrush
import com.ferodev.simplepaint.MainActivity.Companion.paintBrush
import com.ferodev.simplepaint.cons.Rectangle

class DrawRectangle @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    companion object{
        var rectangle = ArrayList<Rectangle>()
    }

    init {
        paintBrush.color = currentBrush
        paintBrush.strokeWidth = 10f
        paintBrush.isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas) {
        for (r in rectangle) {
            paintBrush.color = r.color
            canvas.drawRect(r.startX, r.startY, r.stopX, r.stopY, paintBrush)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when(event.action){
            MotionEvent.ACTION_DOWN -> {
                MainActivity.colorList.add(currentBrush)
                rectangle.add(Rectangle(event.x, event.y,event.x, event.y, currentBrush))
                return true
            }

            MotionEvent.ACTION_MOVE -> {
                val current = rectangle[rectangle.size - 1]
                current.stopX = event.x
                current.stopY = event.y
                invalidate()
                return true
            }

            MotionEvent.ACTION_UP -> {
                val current = rectangle[rectangle.size - 1]
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