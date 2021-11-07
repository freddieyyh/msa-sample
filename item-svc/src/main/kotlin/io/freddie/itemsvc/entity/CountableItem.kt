package io.freddie.itemsvc.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class CountableItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    @Column(nullable = false)
    open var quantity: Long = 0,
    @Column(nullable = false)
    open var name: String
)

@Entity
class CountableBook(
    val isbn: String,
    val author: String,
    override var name: String,
    override var quantity: Long
) : CountableItem(name = name)

@Entity
class CountableAlbum(
    val trackCount : Int,
    val singer: String,
    override var name: String,
    override var quantity: Long
) : CountableItem(name = name)
