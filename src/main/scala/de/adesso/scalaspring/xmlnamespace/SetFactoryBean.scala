package de.adesso.scalaspring.xmlnamespace

import org.springframework.beans.factory.config.AbstractFactoryBean
import scala.reflect.BeanProperty
import collection.JavaConversions._

class SetFactoryBean[T] extends AbstractFactoryBean[Set[T]] {

  @BeanProperty
  var sourceSet: java.util.Set[T] = null

  @Override
  def getObjectType(): Class[List[T]] = classOf[List[T]]

  override def createInstance(): Set[T] = {
    if (this.sourceSet == null) {
      throw new IllegalArgumentException("'sourceSet' is required");
    }
    var scalaSet :scala.collection.mutable.Set[T] = sourceSet
    return scalaSet.toSet
  }

}