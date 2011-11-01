package de.adesso.scalaspring.xmlnamespace
import org.springframework.beans.factory.config.AbstractFactoryBean
import scala.reflect.BeanProperty
import collection.JavaConversions._
import scala.collection.mutable.Buffer

class MapFactoryBean[T, S] extends AbstractFactoryBean[Map[T,S]] {

  @BeanProperty
  var sourceMap: java.util.Map[T, S] = null

  @Override
  def getObjectType(): Class[Map[T, S]] = classOf[Map[T, S]]

  override def createInstance(): Map[T, S] = {
    if (this.sourceMap == null) {
      throw new IllegalArgumentException("'sourceList' is required");
    }
    var result: scala.collection.mutable.Map[T, S] = sourceMap
    return result.toMap
  }

}
