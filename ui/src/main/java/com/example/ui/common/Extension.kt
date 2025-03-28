package com.example.ui.common

import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.TextView

fun TextView.setClickableText(
    text: String,
    start:Int,
    end: Int,
    color: Int? = null,
    click: () -> Unit) {
    val spannable = SpannableStringBuilder(text)
    val clickableSpan = object : ClickableSpan() {
        override fun onClick(widget: View) {
            click()
            widget.invalidate()
        }

        override fun updateDrawState(ds: TextPaint) {
            super.updateDrawState(ds)
            ds.isUnderlineText = false
        }
    }
    spannable.setSpan(clickableSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    color?.let {
        spannable.setSpan(ForegroundColorSpan(it), start, end, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
    }
    movementMethod = LinkMovementMethod.getInstance()
    setText(spannable)
}