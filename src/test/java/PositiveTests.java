import config.EndPoint;
import config.TestConfig;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class PositiveTests extends TestConfig {
    @Test
    public void getAllUsers() {
        given().
        when().
                get(EndPoint.USERS).
        then().
                statusCode(200);
    }
    @Test
    public void createNewUser() {
        String newUserJson = "{\n" +
                "  \"id\": 69,\n" +
                "  \"firstName\": \"Oleg\",\n" +
                "  \"lastName\": \"Petrov\"\n" +
                "}";
        given().
                log().
                all().
                body(newUserJson).
        when().
                post(EndPoint.USERS).
        then().
                log().
                all().
                statusCode(201);
    }
}
