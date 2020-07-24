import org.junit.Test;

import static io.restassured.RestAssured.*;

public class PositiveTests {
    @Test
    public void getAllUsers() {
        given().
        when().get("http://localhost:8080/users").
        then().statusCode(200);
    }
}
