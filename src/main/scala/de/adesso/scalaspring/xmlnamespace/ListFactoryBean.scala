package de.adesso.scalaspring.xmlnamespace
import org.springframework.beans.factory.config.AbstractFactoryBean
import scala.reflect.BeanProperty
import collection.JavaConversions._
import scala.collection.mutable.Buffer

class ListFactoryBean[T] extends AbstractFactoryBean[List[T]] {

  @BeanProperty
  var sourceList: java.util.List[T] = null

  @Override
  def getObjectType(): Class[List[T]] = classOf[List[T]]

  override def createInstance(): List[T] = {
    if (this.sourceList == null) {
      throw new IllegalArgumentException("'sourceList' is required");
    }
    var result: Buffer[T] = sourceList
    return result.toList;
  }

}