package core;
import java.text.DecimalFormat;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;

public class JSON_Factory {

       public static void main(String[] args) {

              DecimalFormat df = new DecimalFormat("####0.00");
              Double kg = 100D;
              Double lb = kg * 2.2046;
              String kg_out = df.format(kg).toString();
              String lb_out = df.format(lb).toString();
              
        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonObject json = factory.createObjectBuilder()
            
             .add("calc", factory.createObjectBuilder()            // adding root element

                    .add("conversion", "kg to lb")                  // adding object
                   .add("kg", kg_out)                              // adding object
                   .add("lb", lb_out)                              // adding object

                 )

             .add("other conversions", factory.createArrayBuilder() // adding array

                    .add(factory.createObjectBuilder()              // adding object

                         .add("length", "cm to in")                 // adding object of array
                         .add("temperature", "C to F"))             // adding object of array

                )

            .build();
       
              System.out.println(json);

                             }
}

