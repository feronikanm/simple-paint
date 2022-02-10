package com.ferodev.simplepaint

import android.graphics.*
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ferodev.simplepaint.DrawPath.Companion.colorList
import com.ferodev.simplepaint.DrawPath.Companion.currentBrush
import com.ferodev.simplepaint.DrawPath.Companion.pathList
import com.ferodev.simplepaint.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private lateinit var paintBinding: PaintViewLayoutBinding
//    private lateinit var paint: PaintView

    companion object{
        var path = Path()
        var paintBrush = Paint()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        paintBinding = binding.paint
        setContentView(binding.root)
        supportActionBar?.hide()

//        paint = paintBinding.paintView

        var isClicked = true


        binding.btnPencil.setOnClickListener {
            Toast.makeText(this, "Pencil Clicked", Toast.LENGTH_LONG).show()
            if (isClicked) {
                binding.btnPencil.setImageResource(R.drawable.ic_selected_pencil)
            }else if(isClicked == true){
                binding.btnPencil.setImageResource(R.drawable.ic_pencil_black)
            }


        }

        binding.btnArrow.setOnClickListener {
            Toast.makeText(this, "Arrow Clicked", Toast.LENGTH_LONG).show()
        }

        binding.btnRectangle.setOnClickListener {
            Toast.makeText(this, "Rectangle Clicked", Toast.LENGTH_LONG).show()


        }

        binding.btnEllipse.setOnClickListener {
            Toast.makeText(this, "Ellipse Clicked", Toast.LENGTH_LONG).show()


        }

        binding.btnPallete.setOnClickListener {
            Toast.makeText(this, "Palette Clicked", Toast.LENGTH_LONG).show()
            binding.colorPalate.visibility = View.VISIBLE
        }

        binding.btnRed.setOnClickListener {
            Toast.makeText(this, "Red Clicked", Toast.LENGTH_LONG).show()
            paintBrush.color = resources.getColor(R.color.red)
            currentColor(paintBrush.color)
            binding.colorPalate.visibility = View.INVISIBLE
        }

        binding.btnGreen.setOnClickListener {
            Toast.makeText(this, "Green Clicked", Toast.LENGTH_LONG).show()
            paintBrush.color = resources.getColor(R.color.green)
            currentColor(paintBrush.color)
            binding.colorPalate.visibility = View.INVISIBLE
        }

        binding.btnBlue.setOnClickListener {
            Toast.makeText(this, "Blue Clicked", Toast.LENGTH_LONG).show()
            paintBrush.color = resources.getColor(R.color.blue)
            currentColor(paintBrush.color)
            binding.colorPalate.visibility = View.INVISIBLE
        }

        binding.btnBlack.setOnClickListener {
            Toast.makeText(this, "Black Clicked", Toast.LENGTH_LONG).show()
            paintBrush.color = Color.BLACK
            currentColor(paintBrush.color)
            binding.colorPalate.visibility = View.INVISIBLE
        }

        binding.btnWhite.setOnClickListener {
            Toast.makeText(this, "White Clicked", Toast.LENGTH_LONG).show()
            pathList.clear()
            colorList.clear()
            path.reset()
            binding.colorPalate.visibility = View.INVISIBLE
        }
    }

    private fun currentColor(color: Int){
        currentBrush = color
        path = Path()
    }


}