package pl.zapas.configuration;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "EntityManagerFactory",
        transactionManagerRef = "TransactionManager",
        basePackages = {
                "pl.zapas.repository.primary"
        }
)
public class DataBase1Configuration {

    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource.first")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(
            EntityManagerFactoryBuilder entityManagerFactoryBuilder, @Qualifier("dataSource") DataSource dataSource) {
        return entityManagerFactoryBuilder.dataSource(dataSource)
                .packages("pl.zapas.entity.primary")
                .persistenceUnit("database1")
                .build();
    }

    @Bean(name = "TransactionManager")
    public PlatformTransactionManager platformTransactionManager(
            @Qualifier("EntityManagerFactory")
            EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
        return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
    }
}
