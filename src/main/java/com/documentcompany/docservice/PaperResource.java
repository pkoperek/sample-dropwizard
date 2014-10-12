package com.documentcompany.docservice;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/paper")
@Produces(MediaType.TEXT_PLAIN)
public class PaperResource {

    @GET
    public String getPage(
            @QueryParam("page") String page,
            @QueryParam("size") String size,
            @QueryParam("zoomFactor") String zoomFactor
    ) {
        return "Some page text";
    }

}
