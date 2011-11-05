package de.adesso.scalaspring.dao
import de.adesso.scalaspring.config.CustomerDAOTest
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(value = Array("/spring/xmlTxConfig.xml"), inheritLocations = false)
class TxCustomerDAOTest extends CustomerDAOTest {

}