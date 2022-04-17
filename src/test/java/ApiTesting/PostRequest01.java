package ApiTesting;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import org.testng.asserts.SoftAssert;

public class PostRequest01 extends TestBase {

    @Test
    public void post01() {

        String jsonRequestBody = "{\n" +
                "    \"firstname\": \"suada\",\n" +
                "    \"lastname\": \"Hoxha\",\n" +
                "    \"totalprice\": 122,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2016-01-30\",\n" +
                "        \"checkout\": \"2020-09-22\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";

        Response response = given().
                contentType(ContentType.JSON).
                spec(spec01).
                auth().basic("admin", "password123").
                body(jsonRequestBody).
                when().
                post("/booking");
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200);

        JsonPath json = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(json.getString("booking.firstname"), "suada");
        softAssert.assertEquals(json.getString("booking.lastname"), "Hoxha");
        softAssert.assertEquals(json.getInt("booking.totalprice"), 122);
        softAssert.assertEquals(json.getBoolean("booking.depositpaid"), true);
        softAssert.assertEquals(json.getString("booking.bookingdates.checkin"), "2016-01-30");
        softAssert.assertAll();
    }

    }



