package core;

import java.text.DecimalFormat;

import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/")
public class Imperial_to_Metric_Converter {
      DecimalFormat df = new DecimalFormat("####0.00");
      
// http://localhost:89/RWS5/calc/xml/kg=>lb/100
      @GET
      @Path("xml/kg=>lb/{input}")
      @Produces("application/xml")
      public String kg_to_lb_xml(
                   @DefaultValue("1") @PathParam("input") Double input) { // w in kilogram
                   Double kg = input;
                   Double lb = kg * 2.2046;
      
                   String kg_out = df.format(kg).toString();
                   String lb_out = df.format(lb).toString();
            return "<calc conversion=\"kg to lb\">" + "<kg>" + kg_out + "</kg>" + "<lb>" + lb_out + "</lb>" + "</calc>"; }
      
   // http://localhost:89/RWS5/calc/xml/lb=>kg/100
      @GET
      @Path("xml/lb=>kg/{input}")
      @Produces("application/xml")
      public String lb_to_kg_xml(
                   @DefaultValue("1") @PathParam("input") Double input) { // w in pounds
                   Double lb = input;
                   Double kg = lb * 0.453592;
      
                   String kg_out = df.format(kg).toString();
                   String lb_out = df.format(lb).toString();
            return "<calc conversion=\"lb to kg\">" + "<lb>" + lb_out + "</lb>" + "<kg>" + kg_out + "</kg>" + "</calc>"; }      
      
     // http://localhost:89/RWS8/calc/json/kg=>lb/100  
      // http://api.nakhabtsev.com:89/RWS8/calc/json/kg=>lb/100
      @GET
      @Path("json/kg=>lb/{input}")
      @Produces("application/json")
      public String kg_to_lb_json(
                   @DefaultValue("1") @PathParam("input") Double input) { // w in kilogram
                   Double kg = input;
                   Double lb = kg * 2.2046;
      
                   String kg_out = df.format(kg).toString();
                   String lb_out = df.format(lb).toString();
                   
                   return "{\r\n\t\"calc\": {\r\n\t\t\"conversion\": \"kg to lb\", \r\n\t\t\"kg\": " + kg_out + ", \r\n\t\t\"lb\": " + lb_out + "\r\n\t\t}\r\n}";  }
      
      // http://localhost:89/RWS8/calc/json/lb=>kg/100       
      @GET
      @Path("json/lb=>kg/{input}")
      @Produces("application/json")
      public String lb_to_kg_json(
                   @DefaultValue("1") @PathParam("input") Double input) { // w in pounds
		    	   Double lb = input;
		           Double kg = lb * 0.453592;
      
                   String kg_out = df.format(kg).toString();
                   String lb_out = df.format(lb).toString();
                   
                   JsonBuilderFactory factory = Json.createBuilderFactory(null);
                   JsonObject json = (JsonObject) factory.createObjectBuilder()
                           .add("calc", factory.createObjectBuilder()            // adding root element

                                  .add("conversion", "lb to kg")                  // adding object
                                  .add("lb", lb_out)                              // adding object
                                  .add("kg", kg_out)                              // adding object

                                )

                            .add("other conversions", factory.createArrayBuilder() // adding array

                                   .add(factory.createObjectBuilder()              // adding object

                                        .add("length", "cm to in")                 // adding object of array
                                        .add("temperature", "C to F"))             // adding object of array

                               )

                           .build();
                      
                             //System.out.println(json);
                   
                   String out = json.toString();
                   return out;

                                            }
                		   
//return "{\"calc\": {\"conversion\": \"lb to kg\", \"lb\": " + lb_out + ", \"kg\": " + kg_out + "}}";  }
}



