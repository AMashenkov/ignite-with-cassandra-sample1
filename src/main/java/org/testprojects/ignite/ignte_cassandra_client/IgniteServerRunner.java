package org.testprojects.ignite.ignte_cassandra_client;

import com.gm.test_cassandra.model.Test1;
import com.gm.test_cassandra.model.Test1Key;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;

/**
 * Created by Alexander Fedotov.
 */
public class IgniteServerRunner {

    public static void main(String[] args) throws Exception {
        runServer();
    }

    private static void runServer() throws Exception {
        System.setProperty("IGNITE_QUIET", "false");

        Ignite ignite = Ignition.start("node.xml");

        checkStringKey(ignite);

        checkPojoKey(ignite);
    }

    private static void checkStringKey(Ignite ignite) {
        try(IgniteCache<Object , Test1Key> cache = ignite.cache("cassandraCache1")) {

            Object key = "1";
            cache.put(key, new Test1Key("id1"));

            System.out.println(cache.get(key));
        }
    }

    private static void checkPojoKey(Ignite ignite) {
        try(IgniteCache<Test1Key , Test1> cache2 = ignite.cache("cassandraCache2")) {

            Test1Key key = new Test1Key("id1");

            Test1 val = new Test1();
            val.setColumn1("col1 value");
            val.setColumn3("col1 value");
            val.setColumn5("col1 value");

            cache2.put(key, val);

            System.out.println(cache2.get(key));
        }
    }
}
