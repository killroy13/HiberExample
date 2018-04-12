package com.lesson.pet.clinic;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by User on 12.04.2018.
 */
@Configuration
//@PropertySource("classpath:db.properties")
//@EnableTransactionManagement
//@ComponentScans(value = {
//        @ComponentScan("java.com.lesson.pet.clinic.dao"),
//        @ComponentScan("com.boraji.tutorial.spring.service")
//})
public class AppConfig {


    @Bean
    public SessionFactory sessionFactory() {

        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }


//    @Autowired
//    private Environment env;
//
//    @Bean
//    public DataSource getDataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName(env.getProperty("db.driver"));
//        dataSource.setUrl(env.getProperty("db.url"));
//        dataSource.setUsername(env.getProperty("db.username"));
//        dataSource.setPassword(env.getProperty("db.password"));
//        return dataSource;
//    }
//
//    @Bean
//    public LocalSessionFactoryBean getSessionFactory() {
//        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//        factoryBean.setDataSource(getDataSource());
//
//        Properties props=new Properties();
//        props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
//        props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//        props.put("hibernate.current_session_context_class", env.getProperty("hibernate.current_session_context_class"));
//        props.put("hibernate.connection.pool_size", env.getProperty("hibernate.connection.pool_size"));
//
//        factoryBean.setHibernateProperties(props);
//        factoryBean.setAnnotatedClasses(Owner.class);
//        return factoryBean;
//    }
//
//    @Bean
//    public HibernateTransactionManager getTransactionManager() {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(getSessionFactory().getObject());
//        return transactionManager;
//    }







//    @Bean
//    public HibernateJpaSessionFactoryBean sessionFactory() {
//        return new HibernateJpaSessionFactoryBean();
//    }


//    @Bean
//    public SessionFactory sessionFactory(DataSource dataSource) {
//        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
//        Properties props = new Properties();
//        props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//        props.put("hibernate.show_sql", "true");
//        sessionBuilder.addProperties(props);
//        sessionBuilder.addAnnotatedClass(Owner.class);
//        return sessionBuilder.buildSessionFactory();
//    }


}
