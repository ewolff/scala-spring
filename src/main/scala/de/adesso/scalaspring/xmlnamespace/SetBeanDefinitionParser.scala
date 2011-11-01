package de.adesso.scalaspring.xmlnamespace

import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser
import org.w3c.dom.Element
import org.springframework.beans.factory.support.BeanDefinitionBuilder
import org.springframework.util.StringUtils
import org.springframework.beans.factory.xml.ParserContext

class SetBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

  override def getBeanClass(element: Element): Class[SetFactoryBean[AnyRef]] = classOf[SetFactoryBean[AnyRef]]

  override def doParse(element: Element, parserContext: ParserContext, builder: BeanDefinitionBuilder) = {
    def parsedSet = parserContext.getDelegate().parseSetElement(element, builder.getRawBeanDefinition())
    builder.addPropertyValue("sourceSet", parsedSet)
    def scope = element.getAttribute("scope")
    if (StringUtils.hasLength(scope)) {
      builder.setScope(scope);
    }
  }

}