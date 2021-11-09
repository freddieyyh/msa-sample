package io.freddie.itemsvc.entity

import javax.persistence.Column
import javax.persistence.DiscriminatorColumn
import javax.persistence.DiscriminatorType
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.InheritanceType

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name = "item_type",
    discriminatorType = DiscriminatorType.INTEGER
)
open class SingleTableItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column
    open var quantity: Int = 0
}

@Entity
@DiscriminatorValue("1")
class SingleTableFood(
    var cookedBy: String,
    override var quantity: Int = 0
): SingleTableItem() {
}

@Entity
@DiscriminatorValue("2")
class SingleTableBook(
    var title: String,
    var isbn: String,
    override var quantity: Int = 0
) : SingleTableItem() {
}