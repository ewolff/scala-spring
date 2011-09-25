package de.adesso.scalaspring.config
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import de.adesso.scalaspring.dao.CustomerDAO;
import de.adesso.scalaspring.service.Service2
import de.adesso.scalaspring.service.Service1

@Configuration
class ScalaConfig {

  @Autowired
  var dataSource: DataSource = null

  @Bean
  def transactionManager() = new DataSourceTransactionManager(dataSource)

  @Bean
  def customerDAO() = new CustomerDAO(dataSource)
  
  @Bean
  def service1() = new Service1(customerDAO())

  @Bean
  def service2() = new Service2(customerDAO())

}