package com.yj.demo.colormatrixapplication

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.ColorMatrix
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.one)
        val bitmap1 = Bitmap.createBitmap(bitmap.width, bitmap.height, Bitmap.Config.ARGB_8888)
        val colorMatrix = ColorMatrix()

        //ColorMatrix利用ColorMatrix的属性来对图片进行处理原来还是通过设置4*5矩阵的参数
//        colorMatrix.setRotate(0, 360f)
//        colorMatrix.setRotate(1, 360f)
//        colorMatrix.setRotate(2, 360f)
//        colorMatrix.setSaturation(0.2F)
//        colorMatrix.setScale(0.5f, 0.7f, 0.1f, 1f)

        //利用4+5的矩阵去做计算来设计设置以及相关的图片处理
//        colorMatrix.set(floatArrayOf(
//                1.5F,1.5F, 1.5F, 0F, -1F,
//                1.5F,1.5F, 1.5F, 0F, -1F,
//                1.5F,1.5F, 1.5F, 0F, -1F,
//                0f,0f,0f,1f,0f
//        ))
        val oldPiexlsMatris = IntArray(bitmap.width * bitmap.height)
        val newPiexlsMatris = IntArray(bitmap.width * bitmap.height)
        var a1: Int
        var r1: Int
        var g1: Int
        var b1: Int
        bitmap.getPixels(oldPiexlsMatris, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)
        oldPiexlsMatris.forEachIndexed { index, it ->
           val a = Color.alpha(it)
            val r = Color.red(it)
            val g = Color.green(it)
            val  b = Color.blue(it)
//            r1 = 255 - r
//            g1 = 255 - g
//            b1 = 255 - b
//            a1 = a
            r1 =  ((0.393 * r + 0.769 * g + 0.189 * b).toInt())
            g1 = ((0.349 * r + 0.686 * g + 0.168 * b).toInt())
            b1 = ((0.272 * r + 0.534 * g + 0.131 * b).toInt())
            a1 = a
            if (r1 > 255) {
                r1 = 255
            } else if (r1 < 0) {
                r1 = 0
            }
            if (g1 > 255) {
                g1 = 255
            } else if (g1 < 0) {
                g1 = 0
            }
            if (b1 > 255) {
                b1 = 255
            } else if (b1 < 0) {
                b1 = 0
            }
            newPiexlsMatris[index] = Color.argb(a1, r1, g1, b1)
        }
        bitmap1.setPixels(newPiexlsMatris, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)


//        val paint = Paint()
//        val canvas = Canvas(bitmap1)
//        paint.colorFilter = ColorMatrixColorFilter(colorMatrix)
//        canvas.drawBitmap(bitmap, 0f, 0f, paint)

        tv_1.setOnClickListener {
            imageView.setImageBitmap(bitmap1)
        }
    }
}
