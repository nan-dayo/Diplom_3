import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.RegisterPage;
import java.time.Duration;
import java.util.Map;
import java.util.Random;
import static org.junit.Assert.*;

public class SignUpTest extends BaseTest {

    String userName = "user" + new Random().nextInt(10000);
    String email = "random" + new Random().nextInt(10000) + "@mail.com";
    String password = "password" + new Random().nextInt(10000);

        @Test
        @DisplayName("Успешная регистрация пользователя")
        public void testSuccessSignUp () {
            System.out.println("Username: " + userName);
            System.out.println("Email: " + email);
            System.out.println("Password: " + password);

            MainPage mainPage = new MainPage(driver);
            RegisterPage registerPage = new RegisterPage(driver);
            LoginPage loginPage = new LoginPage(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            wait.until(ExpectedConditions.elementToBeClickable(mainPage.getLoginAccountButton()));
            mainPage.clickLoginAccountButton();
            loginPage.clickSignUpButton();
            wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.getSignUpForm()));
            registerPage.signUp(userName, email, password);

            wait.until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
            String currentUrl = driver.getCurrentUrl();
            assertEquals(LOGIN_PAGE_URL, currentUrl);

            Response loginResponse = RestAssured.given()
                    .header("Content-Type", "application/json")
                    .body(Map.of("email", email, "password", password))
                    .post(LOGIN_URL);

            bearerToken = loginResponse.jsonPath().getString("accessToken");
        }

        @Test
        @DisplayName("Ошибка при регистрации с паролем меньше шести символов")
        public void testErrorPasswordIsTooShort(){
            System.out.println("Username: " + userName);
            System.out.println("Email: " + email);
            password = "12345";

            MainPage mainPage = new MainPage(driver);
            RegisterPage registerPage = new RegisterPage(driver);
            LoginPage loginPage = new LoginPage(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            wait.until(ExpectedConditions.elementToBeClickable(mainPage.getLoginAccountButton()));
            mainPage.clickLoginAccountButton();
            loginPage.clickSignUpButton();
            wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.getSignUpForm()));


            registerPage.signUp(userName, email, password);
            wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.getPasswordErrorMessage()));
            String actualErrorMessage = registerPage.getErrorMessage();

            assertEquals("Сообщение об ошибке не совпадает", "Некорректный пароль", actualErrorMessage);
        }

}

