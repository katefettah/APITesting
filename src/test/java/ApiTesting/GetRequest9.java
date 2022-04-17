package ApiTesting;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

import org.testng.asserts.SoftAssert;

public class GetRequest9 extends TestBase {
    @Test
    public void get1(){
       Response response=given().
                            spec(spec02).
                            when().
                            get();
       response.prettyPrint();
       JsonPath json=response.jsonPath();
        System.out.println(json.getString("data.employee_name"));
        assertEquals("Garrett Winters",json.getString("data[1].employee_name"));

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(json.getString("data[0].employee_name"),"Tiger Nixon");
        softAssert.assertAll();

        softAssert.assertEquals(json.getList("data.id").size(),24,"no 24 workers");
        softAssert.assertAll();

        softAssert.assertEquals(json.getInt("data[16].employee_salary"),725000,"no salary");
        softAssert.assertAll();

    }
}
