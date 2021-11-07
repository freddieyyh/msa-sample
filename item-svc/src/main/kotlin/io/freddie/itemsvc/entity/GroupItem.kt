package io.freddie.itemsvc.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import org.hibernate.envers.Audited
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
@Audited
class GroupItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var name: String,
    @JsonManagedReference
    @OneToMany(mappedBy = "groupItem", cascade = [CascadeType.ALL])
    var items: MutableList<Item> = mutableListOf(),
) {

}