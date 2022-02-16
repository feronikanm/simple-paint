package com.ferodev.simplepaint

import android.graphics.*
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ferodev.simplepaint.canvas.DrawEllipse
import com.ferodev.simplepaint.canvas.DrawLine
import com.ferodev.simplepaint.canvas.DrawPencil
import com.ferodev.simplepaint.canvas.DrawRectangle
import com.ferodev.simplepaint.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var isPencilIconClicked = false
    private var isArrowIconClicked = false
    private var isRectangleIconClicked = false
    private var isCircleIconClicked = false
    private var isPaletteIconClicked = false

    private lateinit var drawPencil: DrawPencil
    private lateinit var drawLine: DrawLine
    private lateinit var drawRectangle: DrawRectangle
    private lateinit var drawEllipse: DrawEllipse

    companion object {
        var path = Path()
        var paintBrush = Paint()
        var colorList = ArrayList<Int>()
        var currentBrush = Color.BLACK
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        drawPencil = findViewById<View>(R.id.draw_pencil) as DrawPencil
        drawLine = findViewById<View>(R.id.draw_line) as DrawLine
        drawRectangle = findViewById<View>(R.id.draw_rectangle) as DrawRectangle
        drawEllipse = findViewById<View>(R.id.draw_ellipse) as DrawEllipse

        binding.btnPencil.setOnClickListener {
            // Untuk mengganti dari false menjadi true
            isPencilIconClicked = !isPencilIconClicked

            if (isPencilIconClicked) { // ini untuk mengecek apakah isPencilIconClicked sudah true valuenya
                binding.btnPencil.setImageResource(R.drawable.ic_selected_pencil)
                binding.btnPencil.setBackgroundResource(R.drawable.background_cards)

                binding.btnArrow.setImageResource(R.drawable.ic_unselected_line)
                binding.btnArrow.setBackgroundResource(R.drawable.background_card)
                binding.btnRectangle.setImageResource(R.drawable.ic_unselected_rectangle)
                binding.btnRectangle.setBackgroundResource(R.drawable.background_card)
                binding.btnEllipse.setImageResource(R.drawable.ic_unselected_circle)
                binding.btnEllipse.setBackgroundResource(R.drawable.background_card)
                binding.btnPallete.setImageResource(R.drawable.ic_unselected_palette)
                binding.btnPallete.setBackgroundResource(R.drawable.background_card)

                binding.drawPencil.visibility = View.VISIBLE
                binding.drawLine.visibility = View.GONE
                binding.drawEllipse.visibility = View.GONE
                binding.drawRectangle.visibility = View.GONE

            } else {
                binding.btnPencil.setImageResource(R.drawable.ic_unselected_pencil)
                binding.btnPencil.setBackgroundResource(R.drawable.background_card)
            }
        }

        binding.btnArrow.setOnClickListener {
            isArrowIconClicked = !isArrowIconClicked
            if (isArrowIconClicked){
                binding.btnArrow.setImageResource(R.drawable.ic_selected_line)
                binding.btnArrow.setBackgroundResource(R.drawable.background_cards)

                binding.btnPencil.setImageResource(R.drawable.ic_unselected_pencil)
                binding.btnPencil.setBackgroundResource(R.drawable.background_card)
                binding.btnRectangle.setImageResource(R.drawable.ic_unselected_rectangle)
                binding.btnRectangle.setBackgroundResource(R.drawable.background_card)
                binding.btnEllipse.setImageResource(R.drawable.ic_unselected_circle)
                binding.btnEllipse.setBackgroundResource(R.drawable.background_card)
                binding.btnPallete.setImageResource(R.drawable.ic_unselected_palette)
                binding.btnPallete.setBackgroundResource(R.drawable.background_card)

                binding.drawLine.visibility = View.VISIBLE
                binding.drawPencil.visibility = View.GONE
                binding.drawEllipse.visibility = View.GONE
                binding.drawRectangle.visibility = View.GONE

            }else{
                binding.btnArrow.setImageResource(R.drawable.ic_unselected_line)
                binding.btnArrow.setBackgroundResource(R.drawable.background_card)
            }
        }

        binding.btnRectangle.setOnClickListener {
            isRectangleIconClicked = !isRectangleIconClicked
            if (isRectangleIconClicked){
                binding.btnRectangle.setImageResource(R.drawable.ic_selected_rectangle)
                binding.btnRectangle.setBackgroundResource(R.drawable.background_cards)

                binding.btnPencil.setImageResource(R.drawable.ic_unselected_pencil)
                binding.btnPencil.setBackgroundResource(R.drawable.background_card)
                binding.btnArrow.setImageResource(R.drawable.ic_unselected_line)
                binding.btnArrow.setBackgroundResource(R.drawable.background_card)
                binding.btnEllipse.setImageResource(R.drawable.ic_unselected_circle)
                binding.btnEllipse.setBackgroundResource(R.drawable.background_card)
                binding.btnPallete.setImageResource(R.drawable.ic_unselected_palette)
                binding.btnPallete.setBackgroundResource(R.drawable.background_card)

                binding.drawRectangle.visibility = View.VISIBLE
                binding.drawPencil.visibility = View.GONE
                binding.drawLine.visibility = View.GONE
                binding.drawEllipse.visibility = View.GONE

            }else{
                binding.btnRectangle.setImageResource(R.drawable.ic_unselected_rectangle)
                binding.btnRectangle.setBackgroundResource(R.drawable.background_card)
            }
        }

        binding.btnEllipse.setOnClickListener {
            isCircleIconClicked = !isCircleIconClicked

            if (isCircleIconClicked){
                binding.btnEllipse.setImageResource(R.drawable.ic_selected_circle)
                binding.btnEllipse.setBackgroundResource(R.drawable.background_cards)

                binding.btnPencil.setImageResource(R.drawable.ic_unselected_pencil)
                binding.btnPencil.setBackgroundResource(R.drawable.background_card)
                binding.btnArrow.setImageResource(R.drawable.ic_unselected_line)
                binding.btnArrow.setBackgroundResource(R.drawable.background_card)
                binding.btnRectangle.setImageResource(R.drawable.ic_unselected_rectangle)
                binding.btnRectangle.setBackgroundResource(R.drawable.background_card)
                binding.btnPallete.setImageResource(R.drawable.ic_unselected_palette)
                binding.btnPallete.setBackgroundResource(R.drawable.background_card)

                binding.drawEllipse.visibility = View.VISIBLE
                binding.drawPencil.visibility = View.GONE
                binding.drawLine.visibility = View.GONE
                binding.drawRectangle.visibility = View.GONE

            }else{
                binding.btnEllipse.setImageResource(R.drawable.ic_unselected_circle)
                binding.btnEllipse.setBackgroundResource(R.drawable.background_card)
            }
        }

        binding.btnPallete.setOnClickListener {
            isPaletteIconClicked = !isPaletteIconClicked

            if (isPaletteIconClicked){
                binding.colorPalate.visibility = View.VISIBLE

                binding.btnPallete.setImageResource(R.drawable.ic_selected_palette)
                binding.btnPallete.setBackgroundResource(R.drawable.background_cards)

                binding.btnPencil.setImageResource(R.drawable.ic_unselected_pencil)
                binding.btnPencil.setBackgroundResource(R.drawable.background_card)
                binding.btnArrow.setImageResource(R.drawable.ic_unselected_line)
                binding.btnArrow.setBackgroundResource(R.drawable.background_card)
                binding.btnRectangle.setImageResource(R.drawable.ic_unselected_rectangle)
                binding.btnRectangle.setBackgroundResource(R.drawable.background_card)
                binding.btnEllipse.setImageResource(R.drawable.ic_unselected_circle)
                binding.btnEllipse.setBackgroundResource(R.drawable.background_card)
            }else{
                binding.btnPallete.setImageResource(R.drawable.ic_unselected_palette)
                binding.btnPallete.setBackgroundResource(R.drawable.background_card)
                binding.colorPalate.visibility = View.INVISIBLE
            }
        }

        binding.btnBlue.setOnClickListener {
            paintBrush.color = resources.getColor(R.color.google_blue)
            currentColor(paintBrush.color)
            binding.colorPalate.visibility = View.INVISIBLE
            binding.btnPallete.setImageResource(R.drawable.ic_unselected_palette)
            binding.btnPallete.setBackgroundResource(R.drawable.background_card)
        }

        binding.btnRed.setOnClickListener {
            paintBrush.color = resources.getColor(R.color.google_red)
            currentColor(paintBrush.color)
            binding.colorPalate.visibility = View.INVISIBLE
            binding.btnPallete.setImageResource(R.drawable.ic_unselected_palette)
            binding.btnPallete.setBackgroundResource(R.drawable.background_card)
        }

        binding.btnYellow.setOnClickListener {
            paintBrush.color = resources.getColor(R.color.google_yellow)
            currentColor(paintBrush.color)
            binding.colorPalate.visibility = View.INVISIBLE
            binding.btnPallete.setImageResource(R.drawable.ic_unselected_palette)
            binding.btnPallete.setBackgroundResource(R.drawable.background_card)
        }

        binding.btnGreen.setOnClickListener {
            paintBrush.color = resources.getColor(R.color.google_green)
            currentColor(paintBrush.color)
            binding.colorPalate.visibility = View.INVISIBLE
            binding.btnPallete.setImageResource(R.drawable.ic_unselected_palette)
            binding.btnPallete.setBackgroundResource(R.drawable.background_card)
        }

        binding.btnBlack.setOnClickListener {
            paintBrush.color = Color.BLACK
            currentColor(paintBrush.color)
            binding.colorPalate.visibility = View.INVISIBLE
            binding.btnPallete.setImageResource(R.drawable.ic_unselected_palette)
            binding.btnPallete.setBackgroundResource(R.drawable.background_card)
        }
    }

    private fun currentColor(color: Int) {
        currentBrush = color
        path = Path()
    }

}