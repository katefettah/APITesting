package ApiTesting;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
public class PutRequest02 extends TestBase {

    @Test
    public void put01(){
        Response response=given().
                spec(spec03).
                when().
                get("/11");
        response.prettyPrint();

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userId", 2);
        jsonObject.put("title","dur kardesim");
        jsonObject.put("completed", true);

        Response responseAfter=given().
                                contentType(ContentType.JSON).
                                spec(spec03).
                                body(jsonObject.toString()).
                                when().
                                put("/11");
        responseAfter.prettyPrint();

        response.
                then().
                statusCode(200).
                assertThat();
        SoftAssert softAssert=new SoftAssert();

        Map<String,Object> map=responseAfter.as(HashMap.class); //GSON

        softAssert.assertEquals(map.get("userId"),jsonObject.get("userId"));
        softAssert.assertEquals(map.get("title"), jsonObject.getString("title"));
        softAssert.assertEquals(map.get("completed"), jsonObject.get("completed"));
        softAssert.assertAll();

    }

}
