package io.freddie.itemsvc.controller

import io.freddie.itemsvc.entity.Category
import io.freddie.itemsvc.entity.Item
import io.freddie.itemsvc.repository.CategoryRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import javax.transaction.Transactional

@RestController
class CategoryController(
    private val categoryRepository: CategoryRepository
) {
    @PostMapping("/categories")
    fun createCategory() {
        categoryRepository.save(Category(name = "category1"))
        val category = Category(name = "category2")
        val item1 = Item(name = "item1", quantity = 1, category = category)
        val item2 = Item(name = "item2", quantity = 2, category = category)
        category.items.addAll(listOf(item1, item2))
        categoryRepository.save(category)
    }

    @GetMapping("/categories")
    fun updateExistCategory() {
        categoryRepository.save(Category(id = 1, name = "category3"))
    }

    @Transactional
    @GetMapping("categories1")
    fun deleteItemOrphan() {
        val category = categoryRepository.findByIdOrNull(2)!!
        category.items.clear()
    }
}