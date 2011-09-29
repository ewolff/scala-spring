package de.adesso.scalaspring.jdbc
import java.sql.ResultSet
import org.springframework.jdbc.core.RowMapper

object JdbcConversions {

  implicit def rowMapperImplicitResultSetInt[T](func: (ResultSet, Int) => T) = {
    new RowMapper[T] {
      def mapRow(rs: ResultSet, rowNum: Int) = func(rs, rowNum).asInstanceOf[T]
    }
  }

  implicit def rowMapperImplicitResultSet[T](func: (ResultSet) => T) = {
    new RowMapper[T] {
      def mapRow(rs: ResultSet, rowNum :Int) = func(rs).asInstanceOf[T]
    }
  }



}