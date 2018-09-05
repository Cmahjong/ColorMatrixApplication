package com.yj.demo.colormatrixapplication

import android.graphics.*
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val colorMatrix = ColorMatrix()
        colorMatrix.setRotate(0, 360f)
        colorMatrix.setRotate(1, 360f)
        colorMatrix.setRotate(2, 360f)
        colorMatrix.setSaturation(0.2F)
        colorMatrix.setScale(0.5f, 0.7f, 0.1f, 1f)
        val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.one)
        val bitmap1 = Bitmap.createBitmap(bitmap.width, bitmap.height, Bitmap.Config.ARGB_8888)
        val paint = Paint()
        val canvas = Canvas(bitmap1)
        paint.colorFilter = ColorMatrixColorFilter(colorMatrix)
        canvas.drawBitmap(bitmap, 0f, 0f, paint)

        tv_1.setOnClickListener {
            imageView.setImageBitmap(bitmap1)
        }
    }
}
