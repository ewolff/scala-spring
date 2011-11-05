package de.adesso.scalaspring.jdbc

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Statement
import org.easymock.MockControl
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.springframework.jdbc.core.ConnectionCallback
import org.springframework.jdbc.core.PreparedStatementCreator
import org.springframework.jdbc.core.PreparedStatementSetter
import org.springframework.jdbc.core.ResultSetExtractor
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.StatementCallback
import de.adesso.scalaspring.jdbc.JdbcConversions._
import org.springframework.jdbc.core.BatchPreparedStatementSetter
import org.springframework.jdbc.core.CallableStatementCallback
import java.sql.CallableStatement
import org.springframework.jdbc.core.CallableStatementCreator

class JdbcConversionTest {

  var called = false;

  @Before
  def before() {
    called = false
  }

  @Test
  def testRowMapper() = {
    Assert.assertFalse(called)
    val rm: RowMapper[String] = (rs: ResultSet) => {
      called = true
      "value"
    }
    Assert.assertEquals("value", rm.mapRow(null, 0))
    Assert.assertTrue(called)
  }

  @Test
  def testRowMapperInt() = {
    val rm1: RowMapper[Int] = (rs: ResultSet, i: Int) => {
      called = true
      i
    }
    Assert.assertEquals(42, rm1.mapRow(null, 42))
    Assert.assertTrue(called)
  }

  @Test
  def testResultSetExtractor() = {
    val rse: ResultSetExtractor[String] = (rs: ResultSet) => {
      called = true
      "value"
    }
    Assert.assertEquals("value", rse.extractData(null))
    Assert.assertTrue(called)
  }

  @Test
  def testConnectionCallback() = {
    val cc: ConnectionCallback[String] = (rs: Connection) => {
      called = true
      "value"
    }
    Assert.assertEquals("value", cc.doInConnection(null))
    Assert.assertTrue(called)
  }

  @Test
  def testStatementCallback() = {
    val sc: StatementCallback[String] = (s: Statement) => {
      called = true
      "value"
    }
    Assert.assertEquals("value", sc.doInStatement(null))
    Assert.assertTrue(called)
  }

  @Test
  def testPreparedStatementCreator() = {
    def ctrlPreparedStatement =
      MockControl.createControl(classOf[PreparedStatement])
    def mockPreparedStatement: PreparedStatement =
      ctrlPreparedStatement.getMock();
    val psc: PreparedStatementCreator = (c: Connection) => {
      called = true
      mockPreparedStatement
    }
    Assert.assertEquals(mockPreparedStatement.toString(), psc.createPreparedStatement(null).toString())
    Assert.assertTrue(called)
  }
  
    @Test
  def testCallableStatementCreator() = {
    def ctrlCallableStatement =
      MockControl.createControl(classOf[CallableStatement])
    def mockCallableStatement: CallableStatement =
      ctrlCallableStatement.getMock();
    val csc: CallableStatementCreator = (c: Connection) => {
      called = true
      mockCallableStatement
    }
    Assert.assertEquals(mockCallableStatement.toString(), csc.createCallableStatement(null).toString())
    Assert.assertTrue(called)
  }

  @Test
  def testPreparedStatementSetter() = {
    val pss: PreparedStatementSetter = (ps: PreparedStatement) => {
      called = true
    }
    pss.setValues(null)
    Assert.assertTrue(called)
  }

  @Test
  def testBatchPreparedStatementSetter() = {
    val pss: BatchPreparedStatementSetter = (42, (ps: PreparedStatement, i: Int) => {
      called = true
    })
    Assert.assertEquals(42, pss.getBatchSize())
    pss.setValues(null, 1)
    Assert.assertTrue(called)
  }

  @Test
  def testCallableStatementCallback() = {
    val cc: CallableStatementCallback[String] = (rs: CallableStatement) => {
      called = true
      "value"
    }
    Assert.assertEquals("value", cc.doInCallableStatement(null))
    Assert.assertTrue(called)
  }
  
  

}