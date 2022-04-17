package ApiTesting;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PostRequest02 extends TestBase {
    @Test
    public void post02(){
    Response response=createResponseBody();

        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200);

        JsonPath json = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(json.getString("booking.firstname"), jsonRequestBody1.getString("firstname"));
        softAssert.assertEquals(json.getString("booking.lastname"), jsonRequestBody1.getString("lastname"));
        softAssert.assertEquals(json.getInt("booking.totalprice"), jsonRequestBody1.getInt("totalprice"));
        softAssert.assertEquals(json.getBoolean("booking.depositpaid"), jsonRequestBody1.get("depositpaid"));
        softAssert.assertEquals(json.getString("booking.bookingdates.checkin"), jsonBookingDataBody.get("checkin"));
        softAssert.assertAll();

    }

}
