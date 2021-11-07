//package io.freddie.itemsvc.entity
//
//import javax.persistence.DiscriminatorColumn
//import javax.persistence.DiscriminatorValue
//import javax.persistence.Entity
//import javax.persistence.GeneratedValue
//import javax.persistence.GenerationType
//import javax.persistence.Id
//import javax.persistence.Inheritance
//import javax.persistence.InheritanceType
//
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "type")
//abstract class JoinedItem(
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    var id: Long,
//    val name: String,
//    val score: Double
//) {
//}
//
//@Entity
//@DiscriminatorValue("book")
//class JoinedBookItem (
//    var isbn: String,
//    var author: String
//) : JoinedItem()
//
//@Entity
//@DiscriminatorValue("food")
//class JoinedFoodItem (
//
//)