package pl.sg.usercatalog.repository;

import liquibase.integration.spring.SpringLiquibase;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class RepositoryConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        String dbHost = env.getProperty("DB_HOST");
        String dbPort = env.getProperty("DB_PORT");
        String dbSid = env.getProperty("DB_SID");
        String url = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbSid + "?allowPublicKeyRetrieval=true&useSSL=false";
        dataSource.setUrl(url);
        dataSource.setUsername(env.getProperty("DB_USERNAME"));
        dataSource.setPassword(env.getProperty("DB_PASSWORD"));
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource());
        liquibase.setChangeLog("classpath:db/changelog/db.changelog-master.yaml");
        return liquibase;
    }
}