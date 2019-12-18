package com.developers.blog.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static com.developers.blog.configuration.DatasourceType.MASTER;
import static com.developers.blog.configuration.DatasourceType.SLAVE;

@Slf4j
@Configuration
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class DataSourceConfiguration {
	@Bean
	@ConfigurationProperties("database.master")
	public HikariConfig masterHikariConfig() {
		return new HikariConfig();
	}

	@Bean
	@ConfigurationProperties("database.slave")
	public HikariConfig slaveHikariConfig() {
		return new HikariConfig();
	}

	@Bean
	public DataSource routingDataSource(@Qualifier("masterHikariConfig") HikariConfig masterHikariConfig,
		@Qualifier("slaveHikariConfig") HikariConfig slaveHikariConfig) {
		HikariDataSource masterDataSource = new HikariDataSource(masterHikariConfig);
		HikariDataSource slaveDataSource = new HikariDataSource(slaveHikariConfig);

		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put(MASTER, masterDataSource);
		targetDataSources.put(SLAVE, slaveDataSource);

		ReplicationRoutingDataSource routingDataSource = new ReplicationRoutingDataSource();
		routingDataSource.setTargetDataSources(targetDataSources);
		routingDataSource.setDefaultTargetDataSource(masterDataSource);
		return routingDataSource;
	}

	@Bean
	@Primary
	public DataSource blogDatasource(@Qualifier("routingDataSource") DataSource routingDataSource) {
		return new LazyConnectionDataSourceProxy(routingDataSource);
	}
}
