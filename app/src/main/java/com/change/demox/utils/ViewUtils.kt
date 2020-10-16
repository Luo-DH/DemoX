package com.change.demox.utils

import android.content.Context
import android.text.method.PasswordTransformationMethod
import android.view.View


object ViewUtils {

    /**
     * 大点密码风格的TransformationMethod
     */
    object BiggerDotPasswordTransformationMethod : PasswordTransformationMethod() {

        override fun getTransformation(source: CharSequence, view: View): CharSequence {
            return PasswordCharSequence(super.getTransformation(source, view))
        }

        private class PasswordCharSequence(
                val transformation: CharSequence
        ) : CharSequence by transformation {
            override fun get(index: Int): Char = if (transformation[index] == DOT) {
                BIGGER_DOT
            } else {
                transformation[index]
            }
        }

        private const val DOT = '\u2022'
        private const val BIGGER_DOT = '●'
    }

    /**
     * dip to px
     *
     * @param context
     * @param dpValue
     * @return
     */
    fun dip2px(context: Context?, dpValue: Float): Float {
        if (context == null) return 0f
        val scale = context.resources.displayMetrics.density
        return dpValue * scale + 0.5f
    }
}