import config.EndPoint;
import config.TestConfig;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class NegativeTests extends TestConfig {

    @Test
    public void CantUpdateNonExistingContact() {
        String contactJson = "{\n" +
                "  \"id\": 5,\n" +
                "  \"firstName\": \"Oleg\",\n" +
                "  \"lastName\": \"Petrov\",\n" +
                "  \"phone\": \"1234567890\",\n" +
                "  \"email\": \"om@tv.ru\"\n" +
                "}";
        given().
                log().
                all().
                body(contactJson).
                pathParam("userId", EndPoint.USER_ID).
                pathParam("contactId", EndPoint.CONTACT_ID).
        when().
                put("/users/{userId}/contacts/{contactId}").
        then().
                log().
                all().
                body("error", equalTo(EndPoint.CONTACT_NOT_FOUND_ERROR_TEXT));

    }

    @Test
    public void searchUserWithInvalidName() {
        given().
                log().
                all().
                pathParam("invalidUserName", EndPoint.INVALID_USER_NAME).
        when().
                get("users/search?name={invalidUserName}").
        then().
                log().
                all().
                body("error", equalTo(EndPoint.USER_WITH_THIS_NAME_NOT_FOUND_ERROR_TEXT));
    }
}
