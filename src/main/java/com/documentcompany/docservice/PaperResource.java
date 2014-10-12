package com.documentcompany.docservice;

import net.spy.memcached.MemcachedClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/paper")
@Produces(MediaType.TEXT_PLAIN)
public class PaperResource {

    private final MemcachedClient memcachedClient;

    public PaperResource(MemcachedClient memcachedClient) {
        this.memcachedClient = memcachedClient;
    }

    @GET
    public String getPage(
            @QueryParam("page") String page,
            @QueryParam("size") String size,
            @QueryParam("zoomFactor") String zoomFactor
    ) {
        Object cached = memcachedClient.get(page + size + zoomFactor);
        if (cached != null) {
            return cached.toString();
        }

        // instead of returning static string, there should be some code which
        // actually reads the paper file
        return "Some page text";
    }

}
