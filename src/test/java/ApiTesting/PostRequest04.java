package ApiTesting;

import org.testng.annotations.Test;
import pojo.Booking;
import pojo.Bookingdates;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.asserts.SoftAssert;


public class PostRequest04 extends TestBase {
    //POJO ile data create etme
    @Test
    public void post01(){
    Bookingdates bookingdates=new Bookingdates("2016-01-30","2020-09-22");
        Booking booking=new Booking("kate","fettah", 122,
                true, bookingdates, "Breakfast" );

        Response response=given().
                            contentType(ContentType.JSON).
                            spec(spec01).
                            auth().
                            basic("admin","password").
                            when().
                            body(booking).
                            post("/booking");
        response.prettyPrint();
        response.
                then().
                assertThat().
                statusCode(200);

        JsonPath json = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(json.getString("booking.firstname"), booking.getFirstname());
        softAssert.assertEquals(json.getString("booking.lastname"), booking.getLastname());
        softAssert.assertEquals(json.getInt("booking.totalprice"), booking.getTotalprice());
        softAssert.assertEquals(json.get("booking.depositpaid"), booking.getDepositpaid());
        softAssert.assertEquals(json.getString("booking.bookingdates.checkin"), bookingdates.getCheckin());
        softAssert.assertAll();



    }

}
