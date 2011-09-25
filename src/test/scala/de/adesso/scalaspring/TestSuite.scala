package de.adesso.scalaspring

import de.adesso.scalaspring.config.AnnotationConfigTest
import org.junit.runner.RunWith
import org.junit.runners.Suite
import de.adesso.scalaspring.tx.TransactionTest
import de.adesso.scalaspring.xmlnamespace.ScalaXmlNamespaceTest
import de.adesso.scalaspring.config.XmlSpringConfigTest
import de.adesso.scalaspring.config.ScalaSpringConfigTest
import de.adesso.scalaspring.config.NamingConventionConfigTest
import de.adesso.scalaspring.config.ScalaSpringConfigTest
@RunWith(classOf[Suite])
@Suite.SuiteClasses(Array(classOf[AnnotationConfigTest], classOf[ScalaSpringConfigTest], classOf[XmlSpringConfigTest],
  classOf[TransactionTest], classOf[ScalaXmlNamespaceTest], classOf[NamingConventionConfigTest]))
class TestSuite {

}