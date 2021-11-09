package io.freddie.itemsvc.repository

import io.freddie.itemsvc.entity.SingleTableItem
import org.springframework.data.repository.CrudRepository

interface SingleTableItemRepository: CrudRepository<SingleTableItem, Long> {
}