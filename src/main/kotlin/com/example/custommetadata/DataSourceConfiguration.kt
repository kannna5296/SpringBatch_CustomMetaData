package com.example.custommetadata

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.batch.BatchDataSource
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import javax.sql.DataSource


@Configuration
class DataSourceConfiguration {

    @Bean
    @Primary
    fun businessDataSource(): DataSource{
        return DataSourceBuilder.create()
            .driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
            .url("jdbc:sqlserver://localhost:1433;encrypt=false;")
            .username("sa")
            .password("Password123456789")
            .build()
    }

    @Bean
    fun businessDataJdbcTemplate(@Qualifier("businessDataSource") dataSource: DataSource): JdbcTemplate {
        return JdbcTemplate(dataSource)
    }

    @Bean
    @BatchDataSource
    fun metaDataSource(): DataSource {
        return EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScripts("/org/springframework/batch/core/schema-h2.sql")
            .build()
    }

    @Bean
    fun metaDataJdbcTemplate(@Qualifier("metaDataSource") dataSource: DataSource): JdbcTemplate {
        return JdbcTemplate(dataSource)
    }
}