package de.adesso.scalaspring.tx
import org.springframework.beans.factory.annotation.Autowired
import de.adesso.scalaspring.dao.CustomerDAO
import de.adesso.scalaspring.Config
import org.springframework.transaction.annotation.Propagation
import de.adesso.scalaspring.domain.Customer
import org.junit.Assert
import org.junit.Test
import org.springframework.transaction.annotation.Transactional
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@ContextConfiguration(Array("/spring/scalaSpringConfig.xml"))
class TransactionTest extends Config with TransactionManagement  {

  @Autowired
  var customerDAO: CustomerDAO = null

  @Test
  def transactionTest() = {
    val countBefore = customerDAO.count()
    try {
      transactional(propagation = Propagation.REQUIRES_NEW) {
        customerDAO.save(Customer(0, "Wolff", "Eberhard", 42.0))
        throw new RuntimeException()
      }
    } catch {
      case ex => {
      }
    }
    Assert.assertEquals(countBefore, customerDAO.count())
    try {
      transactional(propagation = Propagation.REQUIRED) {
        customerDAO.save(Customer(0, "Wolff", "Eberhard", 42.0))

      }
    } catch {
      case ex => {
      }
    }
    Assert.assertEquals(countBefore + 1, customerDAO.count())
  }

}