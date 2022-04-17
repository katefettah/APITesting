package ApiTesting;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetRequest1 {
    @Test
    public void getMethod01(){
    given().
            when().
            get("https://restful-booker.herokuapp.com/booking").
            then().
            assertThat().
            statusCode(200);
    }

    @Test
    public void getMethod02(){
       Response response= given().
                when().
                get("https://restful-booker.herokuapp.com/booking/3");
        response.prettyPrint();
        System.out.println(response.getStatusCode());
        System.out.println(response.statusLine());
        System.out.println(response.getContentType());
        System.out.println(response.getHeader("Content-Type"));
        System.out.println(response.getHeaders());
        System.out.println(response.getHeader("Data"));
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8");

    }
}
