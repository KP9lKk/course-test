package com.example.ui.screens.home.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.model.CourseEntity

class CourseDiffUtilItemCallback: DiffUtil.ItemCallback<CourseEntity>(){
    override fun areItemsTheSame(oldItem: CourseEntity, newItem: CourseEntity): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: CourseEntity, newItem: CourseEntity): Boolean =
        oldItem == newItem

}