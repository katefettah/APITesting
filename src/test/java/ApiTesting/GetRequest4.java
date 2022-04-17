package ApiTesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class GetRequest4 {
    @Test
    public void get01(){
        Response response=given().
                            accept(ContentType.JSON).
                            when().
                            get("http://dummy.restapiexample.com/api/v1/employees");
        response.prettyPrint();
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("data.id",Matchers.hasSize(24),
                        "data.employee_name",Matchers.hasItem("Doris Wilder"),
                        "data.employee_age",Matchers.hasItems(21,61,23));



    }
}
