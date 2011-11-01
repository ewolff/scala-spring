package de.adesso.scalaspring.xmlnamespace
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.beans.factory.annotation.Autowired
import org.junit.Assert
import org.junit.Test

@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(Array("/spring/scalaNamespace.xml"))
class ScalaXmlNamespaceTest {

  @Autowired
  var scalaBean: ScalaBean = null

  @Test
  def testList() = {
    Assert.assertEquals(2, scalaBean.list.size)
    Assert.assertEquals(42, scalaBean.list(0))
    Assert.assertEquals(21, scalaBean.list(1))
  }

  @Test
  def testSet() = {
    Assert.assertEquals(2, scalaBean.set.size)
    Assert.assertTrue(scalaBean.set.contains(42))
    Assert.assertTrue(scalaBean.set.contains(21))
  }

  @Test
  def testMap() = {
    Assert.assertEquals(2, scalaBean.map.size)
    def a=scalaBean.map.keySet.first
    Assert.assertEquals("hello42", scalaBean.map.get("42").get)
    Assert.assertEquals("hello21", scalaBean.map.get("21").get)
    
  }

}