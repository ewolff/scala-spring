package de.adesso.scalaspring.xmlnamespace

import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser
import org.w3c.dom.Element
import org.springframework.beans.factory.support.BeanDefinitionBuilder
import org.springframework.util.StringUtils
import org.springframework.beans.factory.xml.ParserContext

class MapBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

  override def getBeanClass(element: Element): Class[MapFactoryBean[AnyRef,AnyRef]] = classOf[MapFactoryBean[AnyRef,AnyRef]]

  override def doParse(element: Element, parserContext: ParserContext, builder: BeanDefinitionBuilder) = {
    def parsedMap = parserContext.getDelegate().parseMapElement(element, builder.getRawBeanDefinition())
    builder.addPropertyValue("sourceMap", parsedMap)
    def scope = element.getAttribute("scope")
    if (StringUtils.hasLength(scope)) {
      builder.setScope(scope);
    }
  }

}