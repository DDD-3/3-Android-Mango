package com.mango.ui.category

import androidx.lifecycle.liveData
import com.mango.base.BaseViewModel
import com.mango.model.Category
import javax.inject.Inject

class CategoryViewModel @Inject constructor() : BaseViewModel() {

    val items = liveData<List<Category>> {
        val categories = mutableListOf<Category>()

        categories.add(Category(0, "식당", ""))
        categories.add(Category(1, "카페, 디저트", ""))
        categories.add(Category(2, "미용", ""))
        categories.add(Category(3, "과일 야채", ""))
        categories.add(Category(4, "병원", ""))
        categories.add(Category(5, "운동", ""))
        categories.add(Category(6, "놀이", ""))
        categories.add(Category(7, "취미", ""))

        emit(categories)
    }
}