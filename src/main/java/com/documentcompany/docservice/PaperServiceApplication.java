package com.documentcompany.docservice;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class PaperServiceApplication extends Application<PaperServiceConfiguration> {

    @Override
    public void initialize(Bootstrap<PaperServiceConfiguration> bootstrap) {
        // does nothing
    }

    @Override
    public void run(PaperServiceConfiguration configuration, Environment environment) throws Exception {
        // does nothing
    }
}
