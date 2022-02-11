package com.ferodev.simplepaint

import android.app.PendingIntent.getActivity
import android.graphics.*
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ferodev.simplepaint.DrawPath.Companion.pathList
import com.ferodev.simplepaint.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private lateinit var paintBinding: PaintViewLayoutBinding
//    private lateinit var paint: PaintView

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
        binding = ActivityMainBinding.inflate(layoutInflater)
//        paintBinding = binding.paint
        setContentView(binding.root)
        supportActionBar?.hide()

//        paint = paintBinding.paintView


        binding.btnPencil.setOnClickListener {
            Toast.makeText(this, "Pencil Clicked", Toast.LENGTH_LONG).show()

            // Untuk mengganti dari false menjadi true
            isPencilIconClicked = !isPencilIconClicked

            if (isPencilIconClicked) { // ini untuk mengecek apakah isPencilIconClicked sudah true valuenya
                binding.btnPencil.setImageResource(R.drawable.ic_selected_pencil)
                binding.btnPencil.setBackgroundResource(R.drawable.background_cards)

                binding.btnArrow.setImageResource(R.drawable.ic_unselected_arrow)
                binding.btnArrow.setBackgroundResource(R.drawable.background_card)
                binding.btnRectangle.setImageResource(R.drawable.ic_unselected_rectangle)
                binding.btnRectangle.setBackgroundResource(R.drawable.background_card)
                binding.btnEllipse.setImageResource(R.drawable.ic_unselected_circle)
                binding.btnEllipse.setBackgroundResource(R.drawable.background_card)
                binding.btnPallete.setImageResource(R.drawable.ic_unselected_palette)
                binding.btnPallete.setBackgroundResource(R.drawable.background_card)

                binding.drawPath.visibility = View.VISIBLE
                binding.drawLine.visibility = View.GONE
                binding.drawEllipse.visibility = View.GONE
                binding.drawRectangle.visibility = View.GONE

            } else {
                binding.btnPencil.setImageResource(R.drawable.ic_unselected_pencil)
                binding.btnPencil.setBackgroundResource(R.drawable.background_card)
            }
        }

        binding.btnArrow.setOnClickListener {
            Toast.makeText(this, "Arrow Clicked", Toast.LENGTH_LONG).show()

            isArrowIconClicked = !isArrowIconClicked
            if (isArrowIconClicked){
                binding.btnArrow.setImageResource(R.drawable.ic_selected_arrow)
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
                binding.drawPath.visibility = View.GONE
                binding.drawEllipse.visibility = View.GONE
                binding.drawRectangle.visibility = View.GONE

            }else{
                binding.btnArrow.setImageResource(R.drawable.ic_unselected_arrow)
                binding.btnArrow.setBackgroundResource(R.drawable.background_card)
            }
        }

        binding.btnRectangle.setOnClickListener {
            Toast.makeText(this, "Rectangle Clicked", Toast.LENGTH_LONG).show()

            isRectangleIconClicked = !isRectangleIconClicked
            if (isRectangleIconClicked){
                binding.btnRectangle.setImageResource(R.drawable.ic_selected_rectangle)
                binding.btnRectangle.setBackgroundResource(R.drawable.background_cards)

                binding.btnPencil.setImageResource(R.drawable.ic_unselected_pencil)
                binding.btnPencil.setBackgroundResource(R.drawable.background_card)
                binding.btnArrow.setImageResource(R.drawable.ic_unselected_arrow)
                binding.btnArrow.setBackgroundResource(R.drawable.background_card)
                binding.btnEllipse.setImageResource(R.drawable.ic_unselected_circle)
                binding.btnEllipse.setBackgroundResource(R.drawable.background_card)
                binding.btnPallete.setImageResource(R.drawable.ic_unselected_palette)
                binding.btnPallete.setBackgroundResource(R.drawable.background_card)

                binding.drawRectangle.visibility = View.VISIBLE
                binding.drawPath.visibility = View.GONE
                binding.drawLine.visibility = View.VISIBLE
                binding.drawEllipse.visibility = View.GONE

            }else{
                binding.btnRectangle.setImageResource(R.drawable.ic_unselected_rectangle)
                binding.btnRectangle.setBackgroundResource(R.drawable.background_card)
            }
        }

        binding.btnEllipse.setOnClickListener {
            Toast.makeText(this, "Ellipse Clicked", Toast.LENGTH_LONG).show()

            isCircleIconClicked = !isCircleIconClicked

            if (isCircleIconClicked){
                binding.btnEllipse.setImageResource(R.drawable.ic_selected_circle)
                binding.btnEllipse.setBackgroundResource(R.drawable.background_cards)

                binding.btnPencil.setImageResource(R.drawable.ic_unselected_pencil)
                binding.btnPencil.setBackgroundResource(R.drawable.background_card)
                binding.btnArrow.setImageResource(R.drawable.ic_unselected_arrow)
                binding.btnArrow.setBackgroundResource(R.drawable.background_card)
                binding.btnRectangle.setImageResource(R.drawable.ic_unselected_rectangle)
                binding.btnRectangle.setBackgroundResource(R.drawable.background_card)
                binding.btnPallete.setImageResource(R.drawable.ic_unselected_palette)
                binding.btnPallete.setBackgroundResource(R.drawable.background_card)

                binding.drawEllipse.visibility = View.VISIBLE
                binding.drawPath.visibility = View.GONE
                binding.drawLine.visibility = View.VISIBLE
                binding.drawRectangle.visibility = View.GONE

            }else{
                binding.btnEllipse.setImageResource(R.drawable.ic_unselected_circle)
                binding.btnEllipse.setBackgroundResource(R.drawable.background_card)
            }
        }

        binding.btnPallete.setOnClickListener {
            Toast.makeText(this, "Palette Clicked", Toast.LENGTH_LONG).show()

            isPaletteIconClicked = !isPaletteIconClicked

            if (isPaletteIconClicked){
                binding.btnPallete.setImageResource(R.drawable.ic_selected_palette)
                binding.btnPallete.setBackgroundResource(R.drawable.background_cards)

                binding.btnPencil.setImageResource(R.drawable.ic_unselected_pencil)
                binding.btnPencil.setBackgroundResource(R.drawable.background_card)
                binding.btnArrow.setImageResource(R.drawable.ic_unselected_arrow)
                binding.btnArrow.setBackgroundResource(R.drawable.background_card)
                binding.btnRectangle.setImageResource(R.drawable.ic_unselected_rectangle)
                binding.btnRectangle.setBackgroundResource(R.drawable.background_card)
                binding.btnEllipse.setImageResource(R.drawable.ic_unselected_circle)
                binding.btnEllipse.setBackgroundResource(R.drawable.background_card)

                binding.colorPalate.visibility = View.VISIBLE
            }else{
                binding.btnPallete.setImageResource(R.drawable.ic_unselected_palette)
                binding.btnPallete.setBackgroundResource(R.drawable.background_card)
                binding.colorPalate.visibility = View.INVISIBLE
            }
        }

        binding.btnRed.setOnClickListener {
            Toast.makeText(this, "Red Clicked", Toast.LENGTH_LONG).show()
            paintBrush.color = resources.getColor(R.color.red)
            currentColor(paintBrush.color)
            binding.colorPalate.visibility = View.INVISIBLE
            binding.btnPallete.setImageResource(R.drawable.ic_unselected_palette)
            binding.btnPallete.setBackgroundResource(R.drawable.background_card)
        }

        binding.btnGreen.setOnClickListener {
            Toast.makeText(this, "Green Clicked", Toast.LENGTH_LONG).show()
            paintBrush.color = resources.getColor(R.color.green)
            currentColor(paintBrush.color)
            binding.colorPalate.visibility = View.INVISIBLE
            binding.btnPallete.setImageResource(R.drawable.ic_unselected_palette)
            binding.btnPallete.setBackgroundResource(R.drawable.background_card)
        }

        binding.btnBlue.setOnClickListener {
            Toast.makeText(this, "Blue Clicked", Toast.LENGTH_LONG).show()
            paintBrush.color = resources.getColor(R.color.blue)
            currentColor(paintBrush.color)
            binding.colorPalate.visibility = View.INVISIBLE
            binding.btnPallete.setImageResource(R.drawable.ic_unselected_palette)
            binding.btnPallete.setBackgroundResource(R.drawable.background_card)
        }

        binding.btnBlack.setOnClickListener {
            Toast.makeText(this, "Black Clicked", Toast.LENGTH_LONG).show()
            paintBrush.color = Color.BLACK
            currentColor(paintBrush.color)
            binding.colorPalate.visibility = View.INVISIBLE
            binding.btnPallete.setImageResource(R.drawable.ic_unselected_palette)
            binding.btnPallete.setBackgroundResource(R.drawable.background_card)
        }

        binding.btnWhite.setOnClickListener {
            Toast.makeText(this, "White Clicked", Toast.LENGTH_LONG).show()
            pathList.clear()
            colorList.clear()
            path.reset()
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