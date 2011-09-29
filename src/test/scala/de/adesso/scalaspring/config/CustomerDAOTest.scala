package de.adesso.scalaspring.config

import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.ContextConfiguration
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import de.adesso.scalaspring.dao.CustomerDAO
import de.adesso.scalaspring.domain.Customer
import org.junit.Assert
import org.springframework.transaction.annotation.Transactional
import de.adesso.scalaspring.Config

abstract class CustomerDAOTest extends Config {
  
  @Autowired
  var customerDAO : CustomerDAO = _
  
  @Test
  def testSaveDelete() {
    val numberOfCustomersBefore = customerDAO.count()
    val customer = customerDAO.save(Customer(0,"Wolff","Eberhard",42.0))
    Assert.assertTrue(customer.id != 0)
    Assert.assertEquals(numberOfCustomersBefore+1, customerDAO.count())
   customerDAO.deleteById(customer.id)
   Assert.assertEquals(numberOfCustomersBefore, customerDAO.count())
  }

  @Test
  def testSaveGetById() {
    val customer = customerDAO.save(Customer(0,"Wolff","Eberhard",42.0))
    val foundCustomer = customerDAO.findById(customer.id)
    Assert.assertEquals(customer, foundCustomer.get)
  }
  
  @Test
  def testGetNoneById() {
    Assert.assertTrue(customerDAO.findById(800).isEmpty)
  }
  
}