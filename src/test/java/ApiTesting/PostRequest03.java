package ApiTesting;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PostRequest03 extends TestBase {
    @Test
    public void post03() {

        Response response = createRequestBodyByMap();
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200);

        JsonPath json = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(json.getString("booking.firstname"), requestBodyMap.get("firstname"));
        softAssert.assertEquals(json.getString("booking.lastname"), requestBodyMap.get("lastname"));
        softAssert.assertEquals(json.getInt("booking.totalprice"), requestBodyMap.get("totalprice"));
        softAssert.assertEquals(json.getBoolean("booking.depositpaid"), true);
        softAssert.assertEquals(json.getString("booking.bookingdates.checkin"), bookingDatesMap.get("checkin"));
        softAssert.assertAll();

    }
}