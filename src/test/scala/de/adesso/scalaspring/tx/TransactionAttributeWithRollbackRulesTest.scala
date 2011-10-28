package de.adesso.scalaspring.tx
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.TransactionDefinition
import org.junit.Assert
import org.junit.Test

class TransactionAttributeWithRollbackRulesTest {

  @Test
  def testDefaultRollback() = {
    val txAttribute = new TransactionAttributeWithRollbackRules();
    Assert.assertFalse(txAttribute.rollbackOn(new Exception()))
    Assert.assertTrue(txAttribute.rollbackOn(new RuntimeException()))
  }

  @Test
  def testRollbackForException() = {
    val txAttribute = new TransactionAttributeWithRollbackRules(rollbackFor = List(classOf[Exception]));
    Assert.assertTrue(List(classOf[Exception]).exists(_.isAssignableFrom(new Exception().getClass())))
    Assert.assertTrue(txAttribute.rollbackOn(new RuntimeException()))
    Assert.assertTrue(txAttribute.rollbackOn(new Exception()))
  }

  @Test
  def testNoRollbackForException() = {
    val txAttribute = new TransactionAttributeWithRollbackRules(noRollbackFor = List(classOf[Exception]));
    Assert.assertFalse(txAttribute.rollbackOn(new Exception()))
    Assert.assertFalse(txAttribute.rollbackOn(new RuntimeException()))
  }

}