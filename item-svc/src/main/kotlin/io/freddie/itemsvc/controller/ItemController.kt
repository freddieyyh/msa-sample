package io.freddie.itemsvc.controller

import io.freddie.itemsvc.dto.GroupItemDto
import io.freddie.itemsvc.dto.ItemDto
import io.freddie.itemsvc.entity.GroupItem
import io.freddie.itemsvc.entity.Item
import io.freddie.itemsvc.repository.GroupItemRepository
import io.freddie.itemsvc.repository.ItemRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import javax.transaction.Transactional

@RestController
class ItemController(val itemRepository: ItemRepository, val groupItemRepository: GroupItemRepository) {
    @GetMapping("/items/{id}")
    fun getItem(@PathVariable id: Long): String {
        if (id == 1L) {
            throw RuntimeException("id is not 1")
        }
        return "Item id $id"
    }

    @PostMapping("/items")
    fun createItem(@RequestBody itemDto: ItemDto): Item {
        val item = Item(name = itemDto.name!!, quantity = itemDto.quantity!!)
        item.createdAt = LocalDateTime.now()
        item.createdBy = "creator"
        return itemRepository.save(item)
    }

    @PutMapping("/items/{id}")
    fun updateItem(@PathVariable id: Long, @RequestBody itemDto: ItemDto): Item {
        val item = itemRepository.findByIdOrNull(id)
            ?: throw RuntimeException("no item")

        itemDto.name?.let { item.name = it }
        itemDto.quantity?.let { item.quantity = it }
        item.createdBy = "updater"

        return itemRepository.save(item)
    }

    @PostMapping("/groups")
    @Transactional
    fun createItemGroup(@RequestBody groupItemDto: GroupItemDto) : GroupItem {
        return groupItemRepository.save(GroupItem(name = groupItemDto.name!!))
    }

    @PutMapping("/groups/{groupId}/items/{itemId}")
    @Transactional
    fun addItem(@PathVariable groupId: Long, @PathVariable itemId: Long) {
        val groupItem = groupItemRepository.findByIdOrNull(groupId)
            ?: throw RuntimeException()

        val item = itemRepository.findByIdOrNull(itemId)
            ?: throw RuntimeException()

        item.groupItem = groupItem
        groupItem.items.add(item)

        groupItemRepository.save(groupItem)
    }

    @PutMapping("/groups/{groupId}/test")
    @Transactional
    fun test(@PathVariable groupId: Long) {
        val groupItem = groupItemRepository.findByIdOrNull(groupId)
            ?: throw RuntimeException()

        groupItem.items.first().name = "newname"
        groupItemRepository.save(groupItem)
    }

    @DeleteMapping("/items/{id}")
    fun deleteItem(@PathVariable id: Long) {
        itemRepository.deleteById(id)
    }
}