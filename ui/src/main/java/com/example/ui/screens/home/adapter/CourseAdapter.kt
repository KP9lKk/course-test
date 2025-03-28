package com.example.ui.screens.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.CourseEntity
import com.example.ui.databinding.ItemCourseBinding

class CourseAdapter(private  val onFavoriteCourse: (CourseEntity) -> Unit): ListAdapter<CourseEntity, CourseAdapter.ViewHolder>(CourseDiffUtilItemCallback()) {
  inner class ViewHolder(private val itemCourseBinding: ItemCourseBinding): RecyclerView.ViewHolder(itemCourseBinding.root){

        fun bind(courseEntity: CourseEntity){
            itemCourseBinding.DescTextView.text = courseEntity.text
            itemCourseBinding.TitleTextView.text = courseEntity.title
            itemCourseBinding.PriceTextView.text = String.format("%.2f ₽", courseEntity.price)
            itemCourseBinding.RatingTextView.text = courseEntity.rate.toString()
            itemCourseBinding.DateTextView.text  = courseEntity.startDate.toString()
            itemCourseBinding.FavoriteButton.isSelected = courseEntity.hasLike
            itemCourseBinding.FavoriteButton.setOnClickListener {
                onFavoriteCourse(courseEntity)
                itemCourseBinding.FavoriteButton.isSelected = !itemCourseBinding.FavoriteButton.isSelected
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}