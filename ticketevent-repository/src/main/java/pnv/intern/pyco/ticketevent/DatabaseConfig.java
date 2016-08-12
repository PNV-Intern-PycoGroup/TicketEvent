package pnv.intern.pyco.ticketevent;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
	private final String DB_DRIVER = "com.mysql.jdbc.Driver";

	private final String DB_PASSWORD = "";

	private final int DB_MAX_POOL_SIZE = 5;

	private final String DB_URL = "jdbc:mysql://localhost:3306/ticket_event_schema?characterEncoding=UTF-8"; 
	private final String DB_USERNAME = "root";

	private final String HIBERNATE_DIALECT = "org.hibernate.dialect.MySQL5Dialect";

	private final String HIBERNATE_SHOW_SQL = "true";

	private final String ENTITYMANAGER_PACKAGES_TO_SCAN = "pnv.intern.pyco.ticketevent"; // put packages to scan
	
	@Bean(destroyMethod = "close")
    public DataSource dataSource() {
        final HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName(DB_DRIVER);
        ds.setJdbcUrl(DB_URL);
        ds.setUsername(DB_USERNAME);
        ds.setPassword(DB_PASSWORD);
        ds.setMaximumPoolSize(DB_MAX_POOL_SIZE);
        return ds;
    }

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
		hibernateProperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
		sessionFactoryBean.setHibernateProperties(hibernateProperties);

		return sessionFactoryBean;
	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
}
