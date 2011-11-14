package de.adesso.scalaspring.jdbc

import java.sql.Connection
import java.sql.ResultSet
import java.sql.ResultSet
import org.springframework.jdbc.core.ConnectionCallback
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.StatementCallback
import java.sql.Statement
import org.springframework.jdbc.core.ResultSetExtractor
import java.sql.PreparedStatement
import org.springframework.jdbc.core.PreparedStatementCreator
import org.springframework.jdbc.core.PreparedStatementSetter
import org.springframework.jdbc.core.BatchPreparedStatementSetter
import java.sql.CallableStatement
import org.springframework.jdbc.core.CallableStatementCallback
import org.springframework.jdbc.core.CallableStatementCreator

object JdbcConversions {

  implicit def rowMapperImplicitResultSetInt[T](func: (ResultSet, Int) => T) = {
    new RowMapper[T] {
      def mapRow(rs: ResultSet, rowNum: Int) = func(rs, rowNum)
    }
  }

  implicit def rowMapperImplicitResultSet[T](func: (ResultSet) => T) = {
    new RowMapper[T] {
      def mapRow(rs: ResultSet, rowNum: Int) = func(rs)
    }
  }

  implicit def resultSetExtratorImplicitResultSetInt[T](func: (ResultSet) => T) = {
    new ResultSetExtractor[T] {
      def extractData(rs: ResultSet) = func(rs)
    }
  }

  implicit def connectionCallbackImplicit[T](func: (Connection) => T) = {
    new ConnectionCallback[T] {
      def doInConnection(c: Connection) = func(c)
    }
  }

  implicit def statementCallbackImplicit[T](func: (Statement) => T) = {
    new StatementCallback[T] {
      def doInStatement(s: Statement) = func(s)
    }
  }

  implicit def callableStatementCallbackImplicit[T](func: (CallableStatement) => T) = {
    new CallableStatementCallback[T] {
      def doInCallableStatement(cs: CallableStatement) = func(cs)
    }
  }

  implicit def preparedStatementCreatorImplicit(func: (Connection) => PreparedStatement) = {
    new PreparedStatementCreator {
      def createPreparedStatement(c: Connection) = func(c)
    }
  }

  implicit def callableStatementCreatorImplicit(func: (Connection) => CallableStatement) = {
    new CallableStatementCreator {
      def createCallableStatement(c: Connection) = func(c)
    }
  }

  implicit def preparedStatementSetterImplicit(func: (PreparedStatement) => Unit) = {
    new PreparedStatementSetter {
      def setValues(ps: PreparedStatement) = func(ps)
    }
  }

  implicit def batchPreparedStatementSetterImplicit(t: Tuple2[Int, ((PreparedStatement, Int) => Unit)]) = {
    new BatchPreparedStatementSetter {
      def setValues(ps: PreparedStatement, i: Int) = t._2(ps,i)
      def getBatchSize() = t._1
    }
  }

}