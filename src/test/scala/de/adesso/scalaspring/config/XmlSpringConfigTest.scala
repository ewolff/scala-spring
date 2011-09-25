package de.adesso.scalaspring.config
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional

@ContextConfiguration(Array("/spring/xmlSpringConfig.xml"))
class XmlSpringConfigTest extends CustomerDAOTest {

}