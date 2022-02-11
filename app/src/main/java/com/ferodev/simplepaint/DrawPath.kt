package com.ferodev.simplepaint

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.ferodev.simplepaint.MainActivity.Companion.colorList
import com.ferodev.simplepaint.MainActivity.Companion.currentBrush
import com.ferodev.simplepaint.MainActivity.Companion.paintBrush
import com.ferodev.simplepaint.MainActivity.Companion.path


class DrawPath : View {

    var params : ViewGroup.LayoutParams? = null

    companion object {
        private const val TOUCH_TOLERANCE = 4f
        var pathList = ArrayList<Path>()
    }

    private var mX = 0f
    private var mY = 0f

    constructor(context: Context) : this(context, null){
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0){
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttrs: Int) : super(context, attrs, defStyleAttrs){
        init()
    }

    private fun init(){
        paintBrush.isAntiAlias = true
        paintBrush.isDither = true
        paintBrush.color = currentBrush
        paintBrush.style = Paint.Style.STROKE
        paintBrush.strokeJoin = Paint.Join.ROUND
        paintBrush.strokeCap = Paint.Cap.ROUND
        paintBrush.strokeWidth = 16f
        paintBrush.alpha = 0xff

        params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    private fun touchStart(x: Float, y: Float) {
        pathList.add(path)
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

        canvas.drawCircle(200F, 200F, 150F, paintBrush)
        canvas.drawLine(50F, 100F, 600F, 600F, paintBrush)
        canvas.drawLine(50F, 550F, 770F, 0F, paintBrush)
        canvas.drawRect(30F, 30F, 500F, 200F, paintBrush)

        for (i in pathList.indices){
            paintBrush.setColor(colorList[i])
            canvas.drawPath(pathList[i], paintBrush)

            invalidate()
        }
    }

}