package ApiTesting;

import org.testng.annotations.Test;
import utilities.JsonUtil;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import org.testng.asserts.SoftAssert;


import java.util.HashMap;
import java.util.Map;


public class ObjectMapperTestWithMap extends TestBase{

    @Test
    public void javaToJson(){
        Response response=given().
                            spec(spec01).
                            when().
                            get("/booking/3");
        response.prettyPrint();
        //Api dan gelen datayi Map'a cevirelim==>De=seralization
        Map<String, Object> jsonToMap=JsonUtil.convertJsonToJava(response.asString(),Map.class);
        System.out.println(jsonToMap);
        /*
        1.Api dan gelen datayi map a cevirdim.
        2.Test case de bana verilen datayi map a cevirecegim
        3. 1. ve 2. datalari assert edecegim.
         */

        Map<String,Object> jsonToMapTestCase=new HashMap<>();

        jsonToMapTestCase.put("firstname","Mary");
        jsonToMapTestCase.put("lastname","Ericsson");
        jsonToMapTestCase.put("totalprice",570);
        jsonToMapTestCase.put("depositpaid",false);

        response.
                then().
                statusCode(200).
                assertThat();
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(jsonToMap.get("firstname"),jsonToMapTestCase.get("firstname"));
        softAssert.assertEquals(jsonToMap.get("lastname"),jsonToMapTestCase.get("lastname"));
        softAssert.assertAll();
    }


}
