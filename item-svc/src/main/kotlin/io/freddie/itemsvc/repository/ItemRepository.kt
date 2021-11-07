package io.freddie.itemsvc.repository

import io.freddie.itemsvc.entity.Item
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.history.RevisionRepository

interface ItemRepository : CrudRepository<Item, Long>, RevisionRepository<Item, Long, Int> {
}