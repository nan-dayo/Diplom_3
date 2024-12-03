import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.RegisterPage;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;



public class SignUpTest extends BaseTest {



        @Test
        @DisplayName("Успешная регистрация пользователя")
        public void testSuccessSignUp () {
            String userName = "сэм";
            String email = "samtest1233@mail.com";
            String password = "123qwer4";

            MainPage mainPage = new MainPage(driver);
            RegisterPage registerPage = new RegisterPage(driver);
            LoginPage loginPage = new LoginPage(driver);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                    wait.until(ExpectedConditions.elementToBeClickable(mainPage.getLoginAccountButton()));
            mainPage.clickLoginAccountButton();
            loginPage.clickSignUpButton();
            wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.getSignUpForm()));

            registerPage.signUp(userName, email, password);

            wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));
            String currentUrl = driver.getCurrentUrl();
            assertEquals("https://stellarburgers.nomoreparties.site/login", currentUrl);

            Response loginResponse = RestAssured.given()
                    .header("Content-Type", "application/json")
                    .body(Map.of("email", email, "password", password))
                    .post("https://stellarburgers.nomoreparties.site/api/auth/login");

            bearerToken = loginResponse.jsonPath().getString("accessToken");
        }

        @Test
        @DisplayName("Ошибка при регистрации с паролем меньше шести символов")
        public void testErrorPasswordIsTooShort(){
            String userName = "дин";
            String email = "deantest1233@mail.com";
            String password = "123qw";

            MainPage mainPage = new MainPage(driver);
            RegisterPage registerPage = new RegisterPage(driver);
            LoginPage loginPage = new LoginPage(driver);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(mainPage.getLoginAccountButton()));

            mainPage.clickLoginAccountButton();
            loginPage.clickSignUpButton();
            wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.getSignUpForm()));

            registerPage.signUp(userName, email, password);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class, 'input__error')]")));
            String actualErrorMessage = registerPage.getErrorMessage();

            assertEquals("Сообщение об ошибке не совпадает", "Некорректный пароль", actualErrorMessage);
        }

}

