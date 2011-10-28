package de.adesso.scalaspring.tx

import org.springframework.transaction.interceptor.DefaultTransactionAttribute
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.TransactionDefinition

class TransactionAttributeWithRollbackRules(propagation: Propagation = Propagation.REQUIRED,
  isolation: Isolation = Isolation.DEFAULT,
  readOnly: Boolean = false,
  timeout: Int = TransactionDefinition.TIMEOUT_DEFAULT,
  rollbackFor: List[Class[_ <: Throwable]] = List(),
  noRollbackFor: List[Class[_ <: Throwable]] = List()) extends DefaultTransactionAttribute(propagation.value()) {

  setIsolationLevel(isolation.value())
  setReadOnly(readOnly)
  setTimeout(timeout)

  override def rollbackOn(ex: Throwable) : Boolean = {
    def clazz=ex.getClass()
    if (rollbackFor.exists(_.isAssignableFrom(clazz))) { return true }
    if (noRollbackFor.exists(_.isAssignableFrom(clazz))) { return false }
    super.rollbackOn(ex)
  }

}