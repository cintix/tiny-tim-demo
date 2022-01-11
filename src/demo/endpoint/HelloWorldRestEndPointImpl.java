/*
 */
package demo.endpoint;

import demo.model.Person;
import demo.model.ResponseModel;
import dk.cintix.application.server.rest.annotations.Inject;
import dk.cintix.application.server.rest.http.request.RestHttpRequest;
import dk.cintix.application.server.rest.jsd.JsonServiceDescriptionEngine;
import dk.cintix.application.server.rest.response.Response;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author cix
 */
public class HelloWorldRestEndPointImpl implements HelloWorldRestEndPoint {

    @Inject
    RestHttpRequest request;

    @Override
    public Response sayHelloBack(String name) {
        return new Response().OK().model(new ResponseModel("Hello " + name));
    }

    @Override
    public Response sayHelloBackWithAge(String name, int age) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, -age);
        return new Response().OK().model(new ResponseModel("Hello " + name + " your " + age + " old and born in " + calendar.get(Calendar.YEAR)));
    }

    @Override
    public Response sayHelloToTheWorld() {
        System.out.println("request: " + request);
        return new Response().OK().model(new ResponseModel("Hello everyone!"));
    }

    @Override
    public Response register(Person person) {
        System.out.println("person " + person);
        return new Response().OK();
    }

    @Override
    public Response documentation() {
        return new Response().OK().model(JsonServiceDescriptionEngine.generateServiceDefination("/api/hello", null, this));
    }

}
