package ApiTesting;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestBase {
    protected RequestSpecification spec01;
    protected RequestSpecification spec02;
    protected RequestSpecification spec03;
    Map<String, String> bookingDatesMap = new HashMap<>();
    Map<String, Object> requestBodyMap = new HashMap<>();
    JSONObject jsonBookingDataBody = new JSONObject();
    JSONObject jsonRequestBody1 = new JSONObject();

    @BeforeClass
    public void setUp01() {
        spec01 = new RequestSpecBuilder().
                setBaseUri("https://restful-booker.herokuapp.com").
                build();
    }

    @BeforeClass
    public void setUp02() {
        spec02 = new RequestSpecBuilder().
                setBaseUri("http://dummy.restapiexample.com/api/v1/employees").
                build();

    }

    @BeforeClass
    public void setUp03() {
        spec03 = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com/todos").
                build();

    }

    protected Response createResponseBody() {

        jsonBookingDataBody.put("checkin", "2016-01-30");
        jsonBookingDataBody.put("checkout", "2020-09-22");


        jsonRequestBody1.put("firstname", "suada");
        jsonRequestBody1.put("lastname", "Hoxha");
        jsonRequestBody1.put("totalprice", 122);
        jsonRequestBody1.put("bookingdates", jsonBookingDataBody);
        jsonRequestBody1.put("additionalneeds", "Breakfast");

        Response response = given().
                contentType(ContentType.JSON).
                spec(spec01).
                auth().basic("admin", "password123").
                body(jsonRequestBody1.toString()).
                when().
                post("/booking");
        return response;
    }

    protected Response createRequestBodyByMap() {

        bookingDatesMap.put("checkin", "2016-01-30");
        bookingDatesMap.put("checkout", "2020-09-22");

        requestBodyMap.put("firstname", "nihat");
        requestBodyMap.put("lastname", "Hoxha");
        requestBodyMap.put("totalprice", 122);
        requestBodyMap.put("depositpaid", true);
        requestBodyMap.put("bookingdates", bookingDatesMap);
        Response response = given().
                contentType(ContentType.JSON).
                spec(spec01).
                auth().basic("admin", "password123").
                body(requestBodyMap).
                when().
                post("/booking");
        return response;
    }
}