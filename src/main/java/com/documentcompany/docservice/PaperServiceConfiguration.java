package com.documentcompany.docservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class PaperServiceConfiguration extends Configuration {

    @NotEmpty
    private String memcachedAddress;

    @JsonProperty
    public String getMemcachedAddress() {
        return memcachedAddress;
    }

    @JsonProperty
    public void setMemcachedAddress(String memcachedAddress) {
        this.memcachedAddress = memcachedAddress;
    }
}
