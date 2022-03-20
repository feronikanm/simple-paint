package com.ferodev.simplepaint

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ferodev.simplepaint.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var isPencilIconClicked = false
    private var isArrowIconClicked = false
    private var isRectangleIconClicked = false
    private var isCircleIconClicked = false
    private var isPaletteIconClicked = false

    companion object {
        var path = Path()
        var paintBrush = Paint()
        var colorList = ArrayList<Int>()
        var currentBrush = Color.BLACK
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.apply {
            btnPencil.setOnClickListener {
                // Untuk mengganti dari false menjadi true
                isPencilIconClicked = !isPencilIconClicked

                if (isPencilIconClicked) { // ini untuk mengecek apakah isPencilIconClicked sudah true valuenya
                    btnPencil.setImageResource(R.drawable.ic_selected_pencil)
                    btnPencil.setBackgroundResource(R.drawable.background_cards)

                    btnArrow.setImageResource(R.drawable.ic_unselected_line)
                    btnArrow.setBackgroundResource(R.drawable.background_card)
                    btnRectangle.setImageResource(R.drawable.ic_unselected_rectangle)
                    btnRectangle.setBackgroundResource(R.drawable.background_card)
                    btnEllipse.setImageResource(R.drawable.ic_unselected_circle)
                    btnEllipse.setBackgroundResource(R.drawable.background_card)
                    btnPallete.setImageResource(R.drawable.ic_unselected_palette)
                    btnPallete.setBackgroundResource(R.drawable.background_card)

                    drawPencil.visibility = View.VISIBLE
                    drawLine.visibility = View.GONE
                    drawEllipse.visibility = View.GONE
                    drawRectangle.visibility = View.GONE

                } else {
                    btnPencil.setImageResource(R.drawable.ic_unselected_pencil)
                    btnPencil.setBackgroundResource(R.drawable.background_card)
                }
            }

            btnArrow.setOnClickListener {
                isArrowIconClicked = !isArrowIconClicked
                if (isArrowIconClicked) {
                    btnArrow.setImageResource(R.drawable.ic_selected_line)
                    btnArrow.setBackgroundResource(R.drawable.background_cards)

                    btnPencil.setImageResource(R.drawable.ic_unselected_pencil)
                    btnPencil.setBackgroundResource(R.drawable.background_card)
                    btnRectangle.setImageResource(R.drawable.ic_unselected_rectangle)
                    btnRectangle.setBackgroundResource(R.drawable.background_card)
                    btnEllipse.setImageResource(R.drawable.ic_unselected_circle)
                    btnEllipse.setBackgroundResource(R.drawable.background_card)
                    btnPallete.setImageResource(R.drawable.ic_unselected_palette)
                    btnPallete.setBackgroundResource(R.drawable.background_card)

                    drawLine.visibility = View.VISIBLE
                    drawPencil.visibility = View.GONE
                    drawEllipse.visibility = View.GONE
                    drawRectangle.visibility = View.GONE

                } else {
                    btnArrow.setImageResource(R.drawable.ic_unselected_line)
                    btnArrow.setBackgroundResource(R.drawable.background_card)
                }
            }

            btnRectangle.setOnClickListener {
                isRectangleIconClicked = !isRectangleIconClicked
                if (isRectangleIconClicked) {
                    btnRectangle.setImageResource(R.drawable.ic_selected_rectangle)
                    btnRectangle.setBackgroundResource(R.drawable.background_cards)

                    btnPencil.setImageResource(R.drawable.ic_unselected_pencil)
                    btnPencil.setBackgroundResource(R.drawable.background_card)
                    btnArrow.setImageResource(R.drawable.ic_unselected_line)
                    btnArrow.setBackgroundResource(R.drawable.background_card)
                    btnEllipse.setImageResource(R.drawable.ic_unselected_circle)
                    btnEllipse.setBackgroundResource(R.drawable.background_card)
                    btnPallete.setImageResource(R.drawable.ic_unselected_palette)
                    btnPallete.setBackgroundResource(R.drawable.background_card)

                    drawRectangle.visibility = View.VISIBLE
                    drawPencil.visibility = View.GONE
                    drawLine.visibility = View.GONE
                    drawEllipse.visibility = View.GONE

                } else {
                    btnRectangle.setImageResource(R.drawable.ic_unselected_rectangle)
                    btnRectangle.setBackgroundResource(R.drawable.background_card)
                }
            }

            btnEllipse.setOnClickListener {
                isCircleIconClicked = !isCircleIconClicked

                if (isCircleIconClicked) {
                    btnEllipse.setImageResource(R.drawable.ic_selected_circle)
                    btnEllipse.setBackgroundResource(R.drawable.background_cards)

                    btnPencil.setImageResource(R.drawable.ic_unselected_pencil)
                    btnPencil.setBackgroundResource(R.drawable.background_card)
                    btnArrow.setImageResource(R.drawable.ic_unselected_line)
                    btnArrow.setBackgroundResource(R.drawable.background_card)
                    btnRectangle.setImageResource(R.drawable.ic_unselected_rectangle)
                    btnRectangle.setBackgroundResource(R.drawable.background_card)
                    btnPallete.setImageResource(R.drawable.ic_unselected_palette)
                    btnPallete.setBackgroundResource(R.drawable.background_card)

                    drawEllipse.visibility = View.VISIBLE
                    drawPencil.visibility = View.GONE
                    drawLine.visibility = View.GONE
                    drawRectangle.visibility = View.GONE

                } else {
                    btnEllipse.setImageResource(R.drawable.ic_unselected_circle)
                    btnEllipse.setBackgroundResource(R.drawable.background_card)
                }
            }

            btnPallete.setOnClickListener {
                isPaletteIconClicked = !isPaletteIconClicked

                if (isPaletteIconClicked) {
                    colorPalate.visibility = View.VISIBLE

                    btnPallete.setImageResource(R.drawable.ic_selected_palette)
                    btnPallete.setBackgroundResource(R.drawable.background_cards)

                    btnPencil.setImageResource(R.drawable.ic_unselected_pencil)
                    btnPencil.setBackgroundResource(R.drawable.background_card)
                    btnArrow.setImageResource(R.drawable.ic_unselected_line)
                    btnArrow.setBackgroundResource(R.drawable.background_card)
                    btnRectangle.setImageResource(R.drawable.ic_unselected_rectangle)
                    btnRectangle.setBackgroundResource(R.drawable.background_card)
                    btnEllipse.setImageResource(R.drawable.ic_unselected_circle)
                    btnEllipse.setBackgroundResource(R.drawable.background_card)
                } else {
                    btnPallete.setImageResource(R.drawable.ic_unselected_palette)
                    btnPallete.setBackgroundResource(R.drawable.background_card)
                    colorPalate.visibility = View.INVISIBLE
                }
            }

            btnBlue.setOnClickListener {
                paintBrush.color = resources.getColor(R.color.google_blue)
                currentColor(paintBrush.color)
                colorPalate.visibility = View.INVISIBLE
                btnPallete.setImageResource(R.drawable.ic_unselected_palette)
                btnPallete.setBackgroundResource(R.drawable.background_card)
            }

            btnRed.setOnClickListener {
                paintBrush.color = resources.getColor(R.color.google_red)
                currentColor(paintBrush.color)
                colorPalate.visibility = View.INVISIBLE
                btnPallete.setImageResource(R.drawable.ic_unselected_palette)
                btnPallete.setBackgroundResource(R.drawable.background_card)
            }

            btnYellow.setOnClickListener {
                paintBrush.color = resources.getColor(R.color.google_yellow)
                currentColor(paintBrush.color)
                colorPalate.visibility = View.INVISIBLE
                btnPallete.setImageResource(R.drawable.ic_unselected_palette)
                btnPallete.setBackgroundResource(R.drawable.background_card)
            }

            btnGreen.setOnClickListener {
                paintBrush.color = resources.getColor(R.color.google_green)
                currentColor(paintBrush.color)
                colorPalate.visibility = View.INVISIBLE
                btnPallete.setImageResource(R.drawable.ic_unselected_palette)
                btnPallete.setBackgroundResource(R.drawable.background_card)
            }

            btnBlack.setOnClickListener {
                paintBrush.color = Color.BLACK
                currentColor(paintBrush.color)
                colorPalate.visibility = View.INVISIBLE
                btnPallete.setImageResource(R.drawable.ic_unselected_palette)
                btnPallete.setBackgroundResource(R.drawable.background_card)
            }
        }
    }

    private fun currentColor(color: Int) {
        currentBrush = color
        path = Path()
    }

}