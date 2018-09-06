package com.yj.demo.colormatrixapplication

import android.graphics.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_matarix.*

class MatarixActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matarix)
        val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.one)
        val bitmap1 = Bitmap.createBitmap(bitmap.width, bitmap.height, Bitmap.Config.ARGB_8888)


        val matrixArray = floatArrayOf(
               1f,0f,0f,
                0f,1f,0f,
                0f,0f,1f
        )
        val matrix = Matrix()
        matrix.setValues(matrixArray)
        matrix.setScale(1.5F,1.5F,bitmap.width/2f,bitmap.height/2f)
        matrix.postRotate(90f)
        val paint = Paint()
        val canvas = Canvas(bitmap1)
        canvas.drawBitmap(bitmap,matrix,paint)
        tv_1.setOnClickListener {
            imageView.setImageBitmap(bitmap1)
        }
    }
}
