package com.developers.blog.configuration;

import com.developers.domain.JpaEntityMarker;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = JpaEntityMarker.class)
public class JpaRepositoryConfiguration {

	private final DataSource blogDataSource;

	private final JpaProperties jpaProperties;

	public JpaRepositoryConfiguration(DataSource blogDataSource, JpaProperties jpaProperties) {
		this.blogDataSource = blogDataSource;
		this.jpaProperties = jpaProperties;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		EntityManagerFactoryBuilder builder = new EntityManagerFactoryBuilder(createJpaVendorAdapter(), jpaProperties.getProperties(), null);
		return builder.dataSource(blogDataSource).packages(JpaEntityMarker.class).build();
	}

	private JpaVendorAdapter createJpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(jpaProperties.isShowSql());
		adapter.setDatabase(jpaProperties.getDatabase());
		adapter.setDatabasePlatform(jpaProperties.getDatabasePlatform());
		adapter.setGenerateDdl(jpaProperties.isGenerateDdl());
		return adapter;
	}
}
