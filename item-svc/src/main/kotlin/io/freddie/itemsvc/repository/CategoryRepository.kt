package io.freddie.itemsvc.repository

import io.freddie.itemsvc.entity.Category
import org.springframework.data.repository.CrudRepository

interface CategoryRepository: CrudRepository<Category, Long> {
}