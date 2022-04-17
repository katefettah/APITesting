package ApiTesting;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
public class GetRequest7 extends TestBase{

    @Test
    public void get1(){
        Response response=given().
                            spec(spec01).
                            when().
                            get("/booking?Firstname=Sally");
        response.prettyPrint();
        response.
                then().
                assertThat().
                statusCode(200);

        assertTrue(response.asString().contains("bookingid"));

    }

    @Test
    public void get2(){
        spec01.queryParam("firstname", "Susan",
                        "depositpaid",true);
        Response response=given().
                            spec(spec01).
                            when().
                            get("/booking");

        response.prettyPrint();
        assertTrue(response.asString().contains("bookingid"));
    }
}
