package de.adesso.scalaspring.tx

import org.springframework.transaction.interceptor.DefaultTransactionAttribute
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Isolation

class TransactionAttributeWithRollbackRules(propgation: Propagation,
  isolation: Isolation,
  readOnly: Boolean,
  timeout: Int,
  rollbackFor: List[Throwable],
  noRollbackFor: List[Throwable]) extends DefaultTransactionAttribute(propgation.value()) {

  setIsolationLevel(isolation.value())
  setReadOnly(readOnly)
  setTimeout(timeout)

  override def rollbackOn(ex: Throwable) = {
    if (rollbackFor.contains(ex)) { true }
    if (noRollbackFor.contains(ex)) { false }
    super.rollbackOn(ex)
  }

}