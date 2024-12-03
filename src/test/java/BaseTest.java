
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static io.restassured.RestAssured.given;

public class BaseTest {

    protected WebDriver driver;
    protected String bearerToken;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @After
    public void tearDown() {
        if (bearerToken != null) {
            deleteUser(bearerToken);
        }
        driver.quit();
    }

    @Step("Удалить пользователя")
    public void deleteUser(String bearerToken) {
        Response response =
                given()
                        .headers("Content-type", "application/json", "Authorization", bearerToken)
                        .log().all()
                        .when()
                        .delete("https://stellarburgers.nomoreparties.site/api/auth/user");
        response.then().statusCode(202);
    }
}
