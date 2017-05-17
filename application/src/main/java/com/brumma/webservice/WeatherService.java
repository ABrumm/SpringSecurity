package com.brumma.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

@Path("/test")
public class WeatherService
{
  
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String printText(){
        System.out.println( "Running WS!" );
        return "Hello";
    }
}
