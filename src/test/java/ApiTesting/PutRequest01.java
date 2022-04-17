package ApiTesting;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PutRequest01 extends TestBase{
    @Test
    public void put01() {
        Response response = given().
                spec(spec03).
                when().
                get("/200");

        response.prettyPrint();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userId", 20);
        jsonObject.put("id",150);
        jsonObject.put("title", "sev kardesim");
        jsonObject.put("completed", false);

        Response responseAfterPut=given().
                                contentType(ContentType.JSON).
                                spec(spec03).
                                auth().
                                basic("admin","password123").
                                body(jsonObject.toString()).
                                when().
                                put("/200");
        responseAfterPut.prettyPrint();
    }
}