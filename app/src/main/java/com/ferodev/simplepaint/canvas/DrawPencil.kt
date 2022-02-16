package com.ferodev.simplepaint.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.ferodev.simplepaint.MainActivity.Companion.colorList
import com.ferodev.simplepaint.MainActivity.Companion.currentBrush
import com.ferodev.simplepaint.MainActivity.Companion.paintBrush
import com.ferodev.simplepaint.MainActivity.Companion.path
import com.ferodev.simplepaint.cons.Pencil

class DrawPencil @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    var params : ViewGroup.LayoutParams? = null

    companion object {
        private const val TOUCH_TOLERANCE = 4f
        var pencil = ArrayList<Pencil>()
    }

    private var mX = 0f
    private var mY = 0f


    init{
        paintBrush.isAntiAlias = true
        paintBrush.isDither = true
        paintBrush.color = currentBrush
        paintBrush.style = Paint.Style.STROKE
        paintBrush.strokeJoin = Paint.Join.ROUND
        paintBrush.strokeCap = Paint.Cap.ROUND
        paintBrush.strokeWidth = 16f
        paintBrush.alpha = 0xff

        params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    private fun touchStart(x: Float, y: Float) {

        val p = Pencil(currentBrush, path)
        pencil.add(p)
        colorList.add(currentBrush)
        path.moveTo(x, y)
        mX = x
        mY = y
    }

    private fun touchMove(x: Float, y: Float) {
        val dx = Math.abs(x - mX)
        val dy = Math.abs(y - mY)
        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
            path.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2)
            mX = x
            mY = y
        }
    }

    private fun touchUp() {
        path.lineTo(mX, mY)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                touchStart(x, y)
                invalidate()
            }
            MotionEvent.ACTION_MOVE -> {
                touchMove(x, y)
                invalidate()
            }
            MotionEvent.ACTION_UP -> {
                touchUp()
                invalidate()
            }
        }
        return true
    }

    override fun onDraw(canvas: Canvas) {
        for (p in pencil){
            paintBrush.color = p.color
            canvas.drawPath(p.path!!, paintBrush)
            invalidate()
        }
    }

    fun undo() {
        if (pencil.size != 0) {
            pencil.removeAt(pencil.size - 1)
            invalidate()
        }
    }

}