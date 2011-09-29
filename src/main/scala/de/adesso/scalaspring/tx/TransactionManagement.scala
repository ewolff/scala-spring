package de.adesso.scalaspring.tx
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.TransactionDefinition
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.support.TransactionTemplate
import org.springframework.transaction.TransactionStatus
import org.springframework.transaction.support.TransactionCallback

trait TransactionManagement {

  @Autowired
  var txManager: PlatformTransactionManager = null

  implicit def txCallbackImplicit[T](func: => T) = {
    new TransactionCallback[T] {
      def doInTransaction(status: TransactionStatus) = func.asInstanceOf[T]
    }
  }

  def transactional[T](propagation: Propagation = Propagation.REQUIRED,
    isolation: Isolation = Isolation.DEFAULT,
    readOnly: Boolean = false,
    timeout: Int = TransactionDefinition.TIMEOUT_DEFAULT,
    rollbackFor: List[Throwable] = List(),
    noRollbackFor: List[Throwable] = List())(func: => T): T = {
    val txAttribute = new TransactionAttributeWithRollbackRules(propagation, isolation, readOnly, timeout, rollbackFor, noRollbackFor)
    val txTemplate = new TransactionTemplate(txManager, txAttribute)
    txTemplate.execute(func)
  }

}