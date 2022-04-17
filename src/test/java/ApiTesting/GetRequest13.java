package ApiTesting;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class GetRequest13 extends TestBase{
    @Test
    public void get1() {
        Response response = given().
                when().
                spec(spec02).
                get();
        response.prettyPrint();

        JsonPath json=response.jsonPath();

        SoftAssert softAssert=new SoftAssert();
    //1.way never do
        softAssert.assertEquals(json.getString("data[0].employee_name"),"Tiger Nixon");
        softAssert.assertEquals(json.getString("data[1].employee_name"),"Garrett Winters");
        softAssert.assertEquals(json.getString("data[2].employee_name"),"Ashton Cox");
        softAssert.assertEquals(json.getString("data[3].employee_name"),"Cedric Kelly");
        softAssert.assertAll();
    //2. can do but not suggested
        List<String>nameList=new ArrayList<>();
        nameList.add("Tiger Nixon");
        nameList.add("Garrett Winters");
        nameList.add("Ashton Cox");
        nameList.add("Cedric Kelly");

       for(int i=0;i<nameList.size();i++){
           softAssert.assertEquals(json.getString("data["+i+"].employee_name"),nameList.get(i));
           softAssert.assertAll();
       }

       //3.way do exactly the same
        List<Map>realData=json.getList("data");
        System.out.println(realData);

        HashMap<Integer,String>expectedData=new HashMap<>();
        expectedData.put(0,"Tiger Nixon");
        expectedData.put(1,"Garrett Winters");
        expectedData.put(2,"Ashton Cox");
        expectedData.put(3,"Cedric Kelly");

        for(int i=0; i<expectedData.size();i++){
            softAssert.assertEquals(realData.get(i).get("employee_name"),expectedData.get(i));
            softAssert.assertAll();
        }


    }
}