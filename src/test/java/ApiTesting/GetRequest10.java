package ApiTesting;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import org.testng.asserts.SoftAssert;

import java.util.Collections;
import java.util.List;

public class GetRequest10 extends TestBase{
    @Test
    public void get1(){
       Response response=given().
                        spec(spec02).
                        when().
                        get();
       response.prettyPrint();
       response.then().assertThat().statusCode(200);

       JsonPath json=response.jsonPath();
        List<String>idList=json.getList("data.findAll{Integer.valueOf(it.id)>10}.id");
        System.out.println();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(idList.size(),14,"it is not expected");
        softAssert.assertAll();
        List<Integer>ageList=json.getList("data.findAll{Integer.valueOf(it.employee_age)<30}.employee_age");
        System.out.println(ageList);
        Collections.sort(ageList);
        System.out.println(ageList);
       softAssert.assertFalse(ageList.get(ageList.size()-1).equals("23"));
        softAssert.assertAll();

        List<String>employeeList=json.getList("data.findAll{Integer.valueOf(it.employee_salary)>35000}.employee_salary");
        System.out.println(employeeList);
        //softAssert.assertTrue(employeeList.contains(""),"this employee is not here");
       // softAssert.assertAll();
    }
}
