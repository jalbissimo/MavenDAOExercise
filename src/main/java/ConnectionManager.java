
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * Abstract manager class for database connections
 * @author alexandru.filipas
 *
 */
public abstract class ConnectionManager {

    /**
     * DataSource object for connections getting
     */
    protected DataSource dataSource;
    /**
     * Build an instance of pooled DataSource
     * @throws PropertyVetoException
     */
    protected abstract void buildDataSource() throws PropertyVetoException;

    /**
     * Get a DB connection from the pool
     * @return existing or new created connection
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }

}
