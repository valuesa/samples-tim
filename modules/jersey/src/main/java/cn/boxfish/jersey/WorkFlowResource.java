package cn.boxfish.jersey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

/**
 * Created by LuoLiBing on 17/3/15.
 */
@Component
@Path("/worker")
public class WorkFlowResource {

    @Context
    public HttpServletRequest request;

    @Context
    public HttpServletResponse response;

    @Autowired
    private WorkFlowService workFlowService;

    @GET
    @Produces("text/plain")
    public String message(@QueryParam("name") @NotNull String name) {
        return workFlowService.message() + name;
    }
}
