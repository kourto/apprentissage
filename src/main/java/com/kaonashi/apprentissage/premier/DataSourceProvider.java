package com.kaonashi.apprentissage.premier;
import org.apache.commons.dbcp.BasicDataSource;
import javax.sql.DataSource;

public class DataSourceProvider {
    private static BasicDataSource singleDataSource;

    public static DataSource getSingleDataSourceInstance(){
        Pratique_DB db = new Pratique_DB();
        if(singleDataSource == null){
            singleDataSource = new BasicDataSource();
            singleDataSource.setInitialSize(1);
            singleDataSource.setUrl(db.getDB_URL());
            singleDataSource.setUsername(db.getDB_USERNAME());
            singleDataSource.setPassword(db.getDB_PASSWORD());
        }
        return singleDataSource;
    }
}
