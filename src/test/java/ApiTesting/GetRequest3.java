package ApiTesting;
import io.restassured.response.*;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
public class GetRequest3 {
    @Test
    public void get1(){
        Response response=given().
                accept("application/json").
                when().
                get("https://restful-booker.herokuapp.com/booking/2");
        response.prettyPrint();
        //status code icin 1.way:
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("firstname", Matchers.equalTo("Eric"),
                        "lastname",Matchers.equalTo("Brown"));

        //status code icin 2.way:
        assertEquals(200,response.getStatusCode());
        assertEquals("application/json; charset=utf-8",response.getContentType());

    }

}
