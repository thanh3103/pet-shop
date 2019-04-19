package com.website.springmvc.config;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.website.springmvc.entities.Address;
import com.website.springmvc.entities.OrderDetail;
import com.website.springmvc.entities.Category;
import com.website.springmvc.entities.Order;
import com.website.springmvc.entities.Product;
import com.website.springmvc.entities.User;

@EnableTransactionManagement
@Configuration
public class SpringDatabaseConfig extends WebMvcConfigurerAdapter {
	@Bean
	public LocalSessionFactoryBean sessionFactory(BasicDataSource dataSource) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan(new String[] { "com.website.springmvc.entities" });
		sessionFactory.setAnnotatedClasses(User.class, Address.class, Product.class, Category.class, Order.class,
				OrderDetail.class);
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

	@Bean(name = "dataSource")
	public BasicDataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/petshop");
		// jdbc:mysql://petshopinstance.c4euvourlczk.ap-southeast-1.rds.amazonaws.com:3306/petshop
		// jdbc:mysql://35.200.155.1:3306/petshop
		dataSource.setUsername("root");
		dataSource.setPassword("");// 123456//abc123456(aws)
		return dataSource;
	}

	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}

}