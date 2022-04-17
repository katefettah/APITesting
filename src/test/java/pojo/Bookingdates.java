package pojo;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class Bookingdates {
    @JsonProperty("checkin")
    private String checkin;
    @JsonProperty("checkout")
    private String checkout;

    @JsonProperty("checkin")
    public String getCheckin() {
        return checkin;
    }

    @JsonProperty("checkin")
    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    @JsonProperty("checkout")
    public String getCheckout() {
        return checkout;
    }

    @JsonProperty("checkout")
    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }



    public Bookingdates(String checkin, String checkout) {
        this.checkin=checkin;
        this.checkout=checkout;

    }

    public Bookingdates(){

    }

    @Override
    public String toString() {
        return "Bookingdates{checkin=" + checkin + ", checkout='" + checkout + "}";

    }
}
