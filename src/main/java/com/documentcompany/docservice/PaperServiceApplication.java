package com.documentcompany.docservice;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;

public class PaperServiceApplication extends Application<PaperServiceConfiguration> {

    public static void main(String[] args) throws Exception {
        new PaperServiceApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<PaperServiceConfiguration> bootstrap) {
        // does nothing
    }

    @Override
    public void run(PaperServiceConfiguration configuration, Environment environment) throws Exception {
        MemcachedClient memcachedClient = new MemcachedClient(AddrUtil.getAddresses(configuration.getMemcachedAddress()));
        environment.jersey().register(new PaperResource(memcachedClient));
    }
}
