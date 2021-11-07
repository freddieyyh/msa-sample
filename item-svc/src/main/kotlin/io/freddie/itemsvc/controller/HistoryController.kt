package io.freddie.itemsvc.controller

import io.freddie.itemsvc.entity.GroupItem
import io.freddie.itemsvc.repository.GroupItemRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HistoryController(private val groupItemRepository: GroupItemRepository) {
    @GetMapping("/groups/{id}/rev/{rev}")
    fun getRev(@PathVariable id : Long, @PathVariable rev: Int) : GroupItem {
        return groupItemRepository.findRevision(id, rev).get().entity
    }
}