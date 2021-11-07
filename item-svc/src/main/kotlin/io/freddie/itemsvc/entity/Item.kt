package io.freddie.itemsvc.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import org.hibernate.envers.AuditOverride
import org.hibernate.envers.Audited
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Version

@Entity
@AuditOverride(forClass = BaseEntity::class)
@Audited
class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var name: String,
    var quantity: Int,
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "group_item_id")
    var groupItem: GroupItem? = null
) : BaseEntity() {
}