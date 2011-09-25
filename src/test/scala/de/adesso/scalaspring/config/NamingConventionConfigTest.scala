package de.adesso.scalaspring.config
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional

@ContextConfiguration(value=Array("/spring/namingConventionConfig.xml"), inheritLocations=false)
class NamingConventionConfigTest extends CustomerDAOTest {

}