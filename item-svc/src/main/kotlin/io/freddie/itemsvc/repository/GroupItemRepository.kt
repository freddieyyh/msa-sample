package io.freddie.itemsvc.repository

import io.freddie.itemsvc.entity.GroupItem
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.history.RevisionRepository

interface GroupItemRepository : CrudRepository<GroupItem, Long>, RevisionRepository<GroupItem, Long, Int> {
}