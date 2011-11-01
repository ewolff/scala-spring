package de.adesso.scalaspring.xmlnamespace

import org.springframework.beans.factory.xml.NamespaceHandlerSupport

class ScalaNamespaceHandler extends NamespaceHandlerSupport {

  def init(): Unit = {
    registerBeanDefinitionParser("list", new ListBeanDefinitionParser())
    registerBeanDefinitionParser("set", new SetBeanDefinitionParser())
    registerBeanDefinitionParser("map", new MapBeanDefinitionParser())
  }
  

}