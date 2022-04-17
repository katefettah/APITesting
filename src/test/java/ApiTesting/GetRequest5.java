package ApiTesting;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class GetRequest5 {
    @Test
    public void get1(){
        Response response=given().
                            accept(ContentType.JSON).
                            when().
                            get("https://restful-booker.herokuapp.com/booking/5");
        response.prettyPrint();
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname",Matchers.equalTo("Jim"),
                        "data.totalprice",Matchers.equalTo(5000));
    }
}
