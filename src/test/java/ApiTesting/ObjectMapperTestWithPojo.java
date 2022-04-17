package ApiTesting;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.Booking;
import pojo.Bookingdates;
import utilities.JsonUtil;
import static org.junit.Assert.assertEquals;

import static io.restassured.RestAssured.given;

public class ObjectMapperTestWithPojo extends TestBase {

    @Test
    public void jaToJson(){
        Bookingdates bookingdates= new Bookingdates("2020-11-03", "2020-11-08");
        System.out.println(bookingdates);

        String javaToJson= JsonUtil.convertJavaToJson(bookingdates);
        System.out.println(javaToJson);

    }

    @Test
    public void JsonToJava(){
        Response response = given().
                spec(spec01).
                when().
                get("/booking/3");

        response.prettyPrint();

        //API'dan gelen Json data'yi Pojo Class'a cevirmis olduk
        Booking jsonToPojoApi=JsonUtil.convertJsonToJava(response.asString(), Booking.class);
        System.out.println(jsonToPojoApi);

        //Test Case;de verilen Json Formatindaki data'yi Pojo objectine cevirdik.
        Bookingdates bookingDates=new Bookingdates("2018-06-16","2021-03-28");
        Booking booking =new Booking("Susan", "Jackson", 461, false, bookingDates, "Breakfast");

        response.
                then().
                assertThat().
                statusCode(200);
        assertEquals(booking.getBookingdates().getCheckin(),jsonToPojoApi.getBookingdates().getCheckin());
        assertEquals(booking.getBookingdates().getCheckout(),jsonToPojoApi.getBookingdates().getCheckout());

    }
}
