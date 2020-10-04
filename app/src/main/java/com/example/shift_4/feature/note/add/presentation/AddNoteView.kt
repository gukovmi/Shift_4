package com.example.shift_4.feature.note.add.presentation

import com.example.shift_4.feature.note.presentation.base.BaseView

interface AddNoteView : BaseView {
    fun initView()
    fun showToast(message: String)
}