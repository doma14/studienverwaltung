package de.malbrich.studienverwaltung.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

//@EnableJpaRepositories(basePackages = "de.malbrich.studienverwaltung.entities.repositories")
//@EnableTransactionManagement
@Configuration
public class DatasourceBean {

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		return builder.setType(EmbeddedDatabaseType.HSQL).build();
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setPackagesToScan("de.malbrich.studienverwaltung.entities");
		factoryBean.setDataSource(dataSource());
		factoryBean.setJpaPropertyMap(hibernateJpaProperties());
		factoryBean.afterPropertiesSet();

		return factoryBean.getObject();
	}

	private Map<String, ?> hibernateJpaProperties() {

		HashMap<String, String> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "create-drop");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
		properties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		properties.put("hibernate.default_schema", "public");
		properties.put("hibernate.c3p0.min_size", "2");
		properties.put("hibernate.c3p0.max_size", "5");
		properties.put("hibernate.c3p0.timeout", "300"); // 5mins

		return properties;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}
}
