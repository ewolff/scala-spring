package de.adesso.scalaspring.config
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional

@ContextConfiguration(value=Array("/spring/annotationConfig.xml"), inheritLocations=false)
class AnnotationConfigTest extends CustomerDAOTest {

}