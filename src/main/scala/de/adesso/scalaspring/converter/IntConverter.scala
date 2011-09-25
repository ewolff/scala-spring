package de.adesso.scalaspring.converter

import org.springframework.core.convert.ConversionService
import org.springframework.core.convert.TypeDescriptor
import org.springframework.core.convert.converter.Converter

class IntConverter extends Converter[java.lang.String, Int] {

  def convert(source: java.lang.String) = source.toInt

}