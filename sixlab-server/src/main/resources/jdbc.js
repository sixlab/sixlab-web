var ioc = {
    dataSource: {
        type: "com.alibaba.druid.pool.DruidDataSource",
        events: {
            create: "init",
            depose: 'close'
        },
        fields: {
            url: "jdbc:mysql://127.0.0.1:3306/sixlab?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2b8",
            username: "root",
            password: "root",
            testWhileIdle: true,
            validationQuery: "select 1",
            maxActive: 100
        }
    },
    dao: {
        type: "org.nutz.dao.impl.NutDao",
        args: [{refer: "dataSource"}]
    }
};