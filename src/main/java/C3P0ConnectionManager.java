
import java.beans.PropertyVetoException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Connection Manager class for C3P0 connection pools
 * @author alexandru.filipas
 *
 */
public final class C3P0ConnectionManager extends ConnectionManager {

    /**
     * Single instance of that connection manager within JVM shall be created
     */
    private static C3P0ConnectionManager instance;


    private C3P0ConnectionManager() {
    }

    @Override
    protected void buildDataSource() throws PropertyVetoException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/c3po");
        cpds.setUser("root");
        cpds.setPassword("root");
        // the settings below are optional -- c3p0 can work with defaults
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(180);
        this.dataSource = cpds;
    }
    /**
     * Get an instance of connections pool manager
     * @return same instance of {@link C3P0ConnectionManager}
     * @throws PropertyVetoException
     */
    public static C3P0ConnectionManager getInstance() throws PropertyVetoException {
        if (instance == null) {
            synchronized (C3P0ConnectionManager.class) {
                if (instance == null) {
                    instance =  new C3P0ConnectionManager();
                    instance.buildDataSource();
                }
            }
        }
        return instance;
    }

}
