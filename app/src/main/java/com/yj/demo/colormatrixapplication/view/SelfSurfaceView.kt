package com.yj.demo.colormatrixapplication.view

import android.content.Context
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView

/**
 * desc:
 * time: 2018/9/6
 * @author yinYin
 */
class SelfSurfaceView : SurfaceView, SurfaceHolder.Callback,Runnable {
    override fun run() {

    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {

    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
    }

    constructor(context: Context):super(context)
    constructor(context: Context,attributeSet: AttributeSet):super(context,attributeSet)
}