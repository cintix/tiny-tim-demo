/*
 */
package demo.endpoint;

import demo.model.Person;
import dk.cintix.tinyserver.rest.annotations.Action;
import dk.cintix.tinyserver.rest.annotations.Cache;
import dk.cintix.tinyserver.rest.annotations.POST;
import dk.cintix.tinyserver.rest.annotations.Static;
import dk.cintix.tinyserver.rest.http.Status;
import dk.cintix.tinyserver.rest.response.Response;

/**
 *
 * @author cix
 */
public interface HelloWorldRestEndPoint {

    @Cache(timeToLive = 2500)
    @Action(path = "{name}")
    public Response sayHelloBack(String name);

    @Cache(timeToLive = 2500, status = {Status.OK, Status.NotFound})
    @Cache(timeToLive = 1000, status = {Status.InternalServerError})
    @Action(path = "{name}/age/{age}")
    public Response sayHelloBackWithAge(String name, int age);

    @Static
    @Action(path = "world")
    public Response sayHelloToTheWorld();

    @POST
    @Action(consume = "application/json")
    public Response register(Person person);

}
