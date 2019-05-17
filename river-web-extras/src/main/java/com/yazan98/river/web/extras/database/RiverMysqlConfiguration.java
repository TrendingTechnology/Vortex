package com.yazan98.river.web.extras.database;

/**
 *    Copyright [2019] [Yazan Tarifi]
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

/**
 * Created By : Yazan Tarifi
 * Date : 5/17/2019
 * Time : 4:08 PM
 */

import com.yazan98.river.web.extras.database.info.MysqlDatabaseInfo;
import org.hibernate.SessionFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * To Use This Configure Class Alone Follow this Example
 *
 * Configuration
 * EntityScan("com.....domain")
 * public class Configure extends MysqlConfigure {
 * ...
 * }
 */

@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public abstract class RiverMysqlConfiguration implements RiverDatabaseConfigure<MysqlDatabaseInfo> {

    private DataSource dataSource;

    private void fillDatabaseInfo() {
        dataSource = DataSourceBuilder.create()
                .driverClassName(getDatabaseInfo().getDriverClass())
                .password(getDatabaseInfo().getPassword())
                .url(getDatabaseInfo().getDatabaseUrl())
                .username(getDatabaseInfo().getUserName())
                .build();
    }

    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(final DataSource dataSource) {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        return sessionBuilder.buildSessionFactory();
    }

    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(final SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

    @Bean
    public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
        final DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        return initializer;
    }
}
