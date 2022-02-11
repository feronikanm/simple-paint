package com.ferodev.simplepaint

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.ferodev.simplepaint.MainActivity.Companion.colorList
import com.ferodev.simplepaint.MainActivity.Companion.currentBrush
import com.ferodev.simplepaint.MainActivity.Companion.paintBrush

class DrawGaris @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val garis = ArrayList<Garis>()

    init {
        paintBrush.color = currentBrush
        paintBrush.strokeWidth = 10f
        paintBrush.isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas) {
        for (l in garis) {
            canvas.drawLine(l.startX, l.startY, l.stopX, l.stopY, paintBrush)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when(event.action){
            MotionEvent.ACTION_DOWN -> {
                colorList.add(currentBrush)
                garis.add(Garis(event.x, event.y,event.x, event.y ))
                return true
            }

            MotionEvent.ACTION_MOVE -> {
                val current = garis[garis.size - 1]
                current.stopX = event.x
                current.stopY = event.y
                invalidate()
                return true
            }

            MotionEvent.ACTION_UP -> {
                val current = garis[garis.size - 1]
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
