package io.freddie.itemsvc.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long = 0L,
    var name: String,
    @OneToMany(mappedBy = "category")
    var items: MutableList<Item> = mutableListOf()
) {
}

@Entity
class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,
    var name: String,
    var quantity: Int,
    @ManyToOne
    @JoinColumn(name = "category_id")
    var category: Category
) {
}