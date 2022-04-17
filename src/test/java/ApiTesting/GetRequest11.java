package ApiTesting;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import org.testng.asserts.SoftAssert;

import java.util.HashMap;


public class GetRequest11 extends TestBase{
    @Test
    public void get01() {
        Response response = given().
                spec(spec03).
                when().
                get("/2");
        response.prettyPrint();

        HashMap<String, String> hashMap = response.as(HashMap.class);
        System.out.println(hashMap.values());
        System.out.println(hashMap.keySet());

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(hashMap.get("completed"),false,"it was expected false");
        softAssert.assertAll();

        softAssert.assertEquals(hashMap.get("userId"),1);
        softAssert.assertAll();
        softAssert.assertEquals(hashMap.get("id"),2);
        softAssert.assertAll();
        softAssert.assertEquals(hashMap.get("title"),"quis ut nam facilis et officia qui");
        softAssert.assertAll();



    }
}