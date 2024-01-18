package pl.pet.manager.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Configuration class for setting up Hibernate.
 */
@Configuration
@EnableTransactionManagement
public class HibernateConfig {
    /**
     * DataSource for configuring the Hibernate session.
     */
    private DataSource dataSource;

    /**
     * Creates and configures the LocalSessionFactoryBean bean for working with Hibernate.
     *
     * @return LocalSessionFactoryBean object with configured parameters.
     */
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("your.package.with.entities");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    /**
     * Creates and configures the PlatformTransactionManager bean for managing Hibernate transactions.
     *
     * @param sessionFactory Hibernate session provided by LocalSessionFactoryBean.
     * @return HibernateTransactionManager object for transaction management.
     */
    @Bean
    public PlatformTransactionManager hibernateTransactionManager(final SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

    /**
     * Returns a Properties object with Hibernate settings.
     *
     * @return Properties object with Hibernate parameters.
     */
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        return properties;
    }
}
