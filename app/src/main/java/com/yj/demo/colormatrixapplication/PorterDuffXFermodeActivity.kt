package com.yj.demo.colormatrixapplication

import android.graphics.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.DecelerateInterpolator
import kotlinx.android.synthetic.main.activity_porter_duff_xfermode.*

class PorterDuffXFermodeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_porter_duff_xfermode)
        val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.one)
        val bitmap1 = Bitmap.createBitmap(bitmap.width, bitmap.height, Bitmap.Config.ARGB_8888)
        val paint = Paint()
        val canvas = Canvas(bitmap1)
        canvas.drawRoundRect(0F, 0F, bitmap.width * 1f, bitmap.height * 1f, 10f, 10f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas.drawBitmap(bitmap,0f,0f,paint)
        tv_1.setOnClickListener {
            imageView.setImageBitmap(bitmap1)
            tv_1.animate()
                    .alpha(0.5f)
                    .translationX(100f)
                    .setDuration(2000)
                    .setInterpolator(DecelerateInterpolator())
                    .start()
        }

    }
}
