package de.adesso.scalaspring.tx
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.TransactionDefinition
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.beans.factory.annotation.Autowired

trait TransactionManagement {

  @Autowired
  var txManager: PlatformTransactionManager = null

  def transactional[T](propagation: Propagation = Propagation.REQUIRED,
    isolation: Isolation = Isolation.DEFAULT,
    readOnly: Boolean = false,
    timeout: Int = TransactionDefinition.TIMEOUT_DEFAULT,
    rollbackFor: List[Throwable] = List(),
    noRollbackFor: List[Throwable] = List())(thunk: => T): T = {
    val txAttribute = new TransactionAttributeWithRollbackRules(propagation, isolation, readOnly, timeout, rollbackFor, noRollbackFor)
    val status = txManager.getTransaction(txAttribute)
    try {
      val ret = thunk
      txManager.commit(status)
      ret
    } catch {
      case ex => {
        if (txAttribute.rollbackOn(ex)) {
          txManager.rollback(status)
        } else {
          txManager.commit(status)
        }
        throw ex
      }
    }
  }

}