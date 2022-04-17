package ApiTesting;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetRequest12 extends TestBase {
    /* Gson: 1. Json-->Java  (De-serilization)
             2.Java==>Json   (Serilization)

     */
    @Test
    public void get1(){
       Response response=given().
                                when().
                                spec(spec03).
                                get();
       response.prettyPrint();
       //Json formatini  Java ya  GSON kullanarak cevirme -->De serilization
        List<Map<String,String>> listOfMaps=response.as(ArrayList.class);
        System.out.println(listOfMaps.get(0));

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(listOfMaps.size(),200,"Id is not as axpected");
        softAssert.assertAll();
        softAssert.assertEquals(listOfMaps.get(120).get("completed"),true);
       softAssert.assertAll();
       softAssert.assertEquals(listOfMaps.get(listOfMaps.size()-2).get("title"),"numquam repellendus a magnam");
        softAssert.assertAll();

        //Java==>Json (Serilization)
        Gson gson=new Gson();
        String jsonFrimJava=gson.toJson(listOfMaps);
        System.out.println(jsonFrimJava);
    }
}
