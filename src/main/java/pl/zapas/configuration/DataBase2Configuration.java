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
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories(

        entityManagerFactoryRef = "DataBase2EntityManagerFactory",
        transactionManagerRef = "DataBase2TransactionManager",
        basePackages = {
                "pl.zapas.repository.subiekt"
        }
)
public class DataBase2Configuration {

    @Bean(name = "DataBase2dataSource")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "DataBase2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(
            EntityManagerFactoryBuilder entityManagerFactoryBuilder, @Qualifier("DataBase2dataSource") DataSource dataSource) {
        return entityManagerFactoryBuilder.dataSource(dataSource)
                .packages("pl.zapas.entity.subiekt")
                .persistenceUnit("database2")
                .build();
    }

    @Bean(name = "DataBase2TransactionManager")
    public PlatformTransactionManager platformTransactionManager(
            @Qualifier("DataBase2EntityManagerFactory")
            EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
