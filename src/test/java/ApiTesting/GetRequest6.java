package ApiTesting;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetRequest6 extends TestBase{

    @Test
    public void get1(){
        Response response=given().
                                spec(spec01).
                                when().
                                get("/booking/5");
        response.prettyPrint();
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", equalTo("Sally"),
                        "lastname",equalTo("Wilson"),
                        "totalprice",equalTo(226),
                        "bookingdates.checkin",equalTo("2020-04-15"));
    }

}
