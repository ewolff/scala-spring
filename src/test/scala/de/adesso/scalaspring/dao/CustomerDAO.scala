package de.adesso.scalaspring.dao
import de.adesso.scalaspring.domain.Customer

trait CustomerDAO {

  def save(customer: Customer): Customer

  def deleteById(id: Int): Unit

  def count(): Int

  def findById(id: Int): Option[Customer]

}