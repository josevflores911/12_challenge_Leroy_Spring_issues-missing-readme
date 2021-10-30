package tech.getarrays.produtomanager.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;

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

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "testEntityManagerFactory",
        transactionManagerRef = "testTransactionManager",
        basePackages = { "tech.getarrays.produtomanager.repo" }
)
public class DbConfig {

    @Bean(name = "testDataSource")
    @ConfigurationProperties(prefix = "test.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "testEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    testEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("testDataSource") DataSource dataSource
    ) {
        return
                builder
                        .dataSource(dataSource)
                        .packages("tech.getarrays.produtomanager.model")
                        .persistenceUnit("test")
                        .build();
    }
    @Bean(name = "testTransactionManager")
    public PlatformTransactionManager testTransactionManager(
            @Qualifier("testEntityManagerFactory") EntityManagerFactory
                    testEntityManagerFactory
    ) {
        return new JpaTransactionManager(testEntityManagerFactory);
    }
}