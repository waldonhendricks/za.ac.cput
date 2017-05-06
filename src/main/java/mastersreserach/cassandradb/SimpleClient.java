package mastersreserach.cassandradb;

        import com.datastax.driver.core.Cluster;
        import com.datastax.driver.core.Metadata;
        import com.datastax.driver.core.ResultSet;
        import com.datastax.driver.core.Session;

/**
 * A simple Cassandra client using Datastax driver.
 *
 * @author pfernandom - Waldon Hendricks
 */
public class SimpleClient {
    private Cluster cluster;
    private Session session;

    /**
     * Connect to a Cassandra cluster
     *
     * @param nodes
     *            Array of Strings with the addresses to the nodes to connect
     * @return The metadata of the cluster
     */
    public Metadata connect(String... nodes) {
        cluster = Cluster.builder().addContactPoints("10.47.2.151").build();
        Metadata metadata = cluster.getMetadata();
        session = cluster.connect("person");
        return metadata;
    }

    /**
     * Execute a query
     *
     * @return
     */
    public ResultSet executeQuery() {
        return executeQuery();
    }

    public Cluster getCluster() {
        return cluster;
    }

    /**
     * Execute a query
     *
     * @param query
     * @return
     */
    public ResultSet executeQuery(String query) {
        return session.execute(query);
    }

    /**
     * Get the Session property
     *
     * @return
     */
    public Session getSession() {
        return session;
    }

    /**
     * Close the connection
     */
    public void close() {
        cluster.close();
    }

}