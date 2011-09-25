package de.adesso.scalaspring.xmlnamespace

import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser
import org.w3c.dom.Element
import org.springframework.beans.factory.support.BeanDefinitionBuilder
import org.springframework.util.StringUtils
import org.springframework.beans.factory.xml.ParserContext
import org.springframework.beans.factory.xml.NamespaceHandler
import org.springframework.beans.PropertyValue
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.beans.factory.config.BeanDefinitionHolder
import org.w3c.dom.Node
import org.springframework.beans.MutablePropertyValues
import org.springframework.core.Conventions
import org.springframework.beans.factory.xml.BeanDefinitionParser
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate

class PropertyDefinitionParser {} /*extends BeanDefinitionParserDelegate with NamespaceHandler {

  override def init() = {}

  override def parse(element: Element, parserContext: ParserContext): BeanDefinition = {
    parserContext.getReaderContext().error(
      "Class [" + getClass().getName() + "] does not support custom elements.", element);
    return null;
  }

  override def decorate(node: Node, definition: BeanDefinitionHolder, parserContext: ParserContext): BeanDefinitionHolder = {
    node match {
      case element: Element => {
        def propertyName = element.getAttribute("name")
        if (!StringUtils.hasLength(propertyName)) {
          parserContext.getReaderContext().error("Tag 'property' must have a 'name' attribute", element)
          return definition
        }

        
        val value = parsePropertyValue(element, definition.getBeanDefinition(), propertyName)

      }

    }
  } 

} */