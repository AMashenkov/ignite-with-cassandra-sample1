package org.testprojects.ignite.ignte_cassandra_client;

import com.gm.test_cassandra.model.Test1Key;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;

/**
 * Created by Alexander Fedotov.
 */
public class IgniteServerRunner {

    public static final String CACHE_NAME = "Test1Key";

    public static void main(String[] args) throws Exception {
        runServer();
    }

    private static void runServer() throws Exception {
        System.setProperty("IGNITE_QUIET", "false");

        Ignite ignite = Ignition.start("node.xml");

        IgniteCache<Object , Test1Key> cache = ignite.cache(CACHE_NAME);

        Object key = "1";
        cache.put(key, new Test1Key("id1"));

        System.out.println(cache.get(key));
    }
}
