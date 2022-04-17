package ApiTesting;

import io.restassured.response.*;
import org.testng.annotations.Test;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;

public class GetRequest2 {
    @Test
    public void get01(){
                        given().
                            accept("application/json").
                        when().
                            get("https://restful-booker.herokuapp.com/booking").
                        then().
                            assertThat().
                        statusCode(200).
                        contentType("application/json");
    }

    @Test
    public void get02(){
       Response response= given().
                accept("application/json").
         when().
                 get("https://restful-booker.herokuapp.com/booking/999");
       response.prettyPrint();
       response.
                then().
                assertThat().
                statusCode(404);

    }
    @Test
    public void get03(){
      Response response=  given().
                            when().
                              get("https://restful-booker.herokuapp.com/booking/999");
      response.prettyPrint();
        System.out.println(response.getStatusCode());
    assertEquals(404,response.getStatusCode());
    }
}
