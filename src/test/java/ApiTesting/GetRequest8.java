package ApiTesting;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class GetRequest8 extends TestBase{
    @Test
    public void get1(){
        spec01.pathParam("bookingid",5);
        Response response=given().
                                spec(spec01).
                                when().
                                get("/booking/{bookingid}");
        response.prettyPrint();

        JsonPath json=response.jsonPath();
        System.out.println(json.getString("firstname"));
        assertEquals("firstname is not as expected","Jim",json.getString("firstname"));
        System.out.println(json.getInt("totalprice"));
        assertEquals("lastname is not as expected","Ericsson",json.getString("lastname"));
        System.out.println(json.getString("lastname"));
        assertEquals("totalprice is not as expected",740,json.getInt("totalprice"));
        System.out.println(json.getBoolean("depositpaid"));


    }
}
