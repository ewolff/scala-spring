package de.adesso.scalaspring.xmlnamespace

import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser
import org.w3c.dom.Element
import org.springframework.beans.factory.support.BeanDefinitionBuilder
import org.springframework.util.StringUtils
import org.springframework.beans.factory.xml.ParserContext

class ListBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

  override def getBeanClass(element: Element): Class[ListFactoryBean[AnyRef]] = classOf[ListFactoryBean[AnyRef]]

  override def doParse(element: Element, parserContext: ParserContext, builder: BeanDefinitionBuilder) = {
    def listClass = element.getAttribute("list-class")
    def parsedList = parserContext.getDelegate().parseListElement(element, builder.getRawBeanDefinition())
    builder.addPropertyValue("sourceList", parsedList)
    def scope = element.getAttribute("scope")
    if (StringUtils.hasLength(scope)) {
      builder.setScope(scope);
    }
  }

}