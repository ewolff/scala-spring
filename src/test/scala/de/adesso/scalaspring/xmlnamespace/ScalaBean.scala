package de.adesso.scalaspring.xmlnamespace
import scala.reflect.BeanProperty

class ScalaBean {

  @BeanProperty
  var list: List[Int] = null

  @BeanProperty
  var set: Set[Int] = null

  @BeanProperty
  var map: Map[String, String] = null
  
}