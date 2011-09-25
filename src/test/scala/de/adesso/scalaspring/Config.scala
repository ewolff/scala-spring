package de.adesso.scalaspring
import org.springframework.transaction.annotation.Transactional
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(classOf[SpringJUnit4ClassRunner])
@Transactional
@ContextConfiguration(locations=Array("/spring/scalaSpringConfig.xml"), inheritLocations=false)
abstract class Config {

}