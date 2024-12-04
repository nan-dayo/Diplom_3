import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.RegisterPage;
import pageObject.ResetPasswordPage;
import java.time.Duration;
import java.util.Map;
import java.util.Random;
import static org.junit.Assert.*;

public class LoginTest extends BaseTest{

    String userName = "user" + new Random().nextInt(10000);
    String email = "random" + new Random().nextInt(10000) + "@mail.com";
    String password = "password" + new Random().nextInt(10000);

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной странице")
    public void testLoginAccountMainPage(){

        System.out.println("Username: " + userName);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Регистрация
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.getLoginAccountButton()));
        mainPage.clickLoginAccountButton();
        loginPage.clickSignUpButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.getSignUpForm()));
        registerPage.signUp(userName, email, password);
        wait.until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailField()));
        loginPage.loginAccount(email, password);

        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getMakeOrderButton()));
        WebElement element = driver.findElement(mainPage.getMakeOrderButton());
        assertTrue(element.isDisplayed());

        Response loginResponse = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(Map.of("email", email, "password", password))
                .post(LOGIN_URL);

        bearerToken = loginResponse.jsonPath().getString("accessToken");
    }

    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    public void testLoginPersonalAccountButton(){

        System.out.println("Username: " + userName);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Регистрация
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.getLoginAccountButton()));
        mainPage.clickLoginAccountButton();
        loginPage.clickSignUpButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.getSignUpForm()));
        registerPage.signUp(userName, email, password);
        wait.until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getLoginButton()));
        mainPage.clickPersonalAccountButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailField()));
        loginPage.loginAccount(email, password);

        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getMakeOrderButton()));
        WebElement element = driver.findElement(mainPage.getMakeOrderButton());
        assertTrue(element.isDisplayed());

        Response loginResponse = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(Map.of("email", email, "password", password))
                .post(LOGIN_URL);

        bearerToken = loginResponse.jsonPath().getString("accessToken");
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void testLoginRegisterFormButton(){
        System.out.println("Username: " + userName);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Регистрация
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.getLoginAccountButton()));
        mainPage.clickLoginAccountButton();
        loginPage.clickSignUpButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.getNameField()));
        registerPage.signUp(userName, email, password);
        wait.until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getSignUpButton()));
        loginPage.clickSignUpButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.getLoginButton()));
        registerPage.clickLoginButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailField()));
        loginPage.loginAccount(email, password);

        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getMakeOrderButton()));
        WebElement element = driver.findElement(mainPage.getMakeOrderButton());
        assertTrue(element.isDisplayed());

        Response loginResponse = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(Map.of("email", email, "password", password))
                .post(LOGIN_URL);

        bearerToken = loginResponse.jsonPath().getString("accessToken");

    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void testLoginFromResetPasswordForm(){
        System.out.println("Username: " + userName);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Регистрация
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.getLoginAccountButton()));
        mainPage.clickLoginAccountButton();
        loginPage.clickSignUpButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.getNameField()));
        registerPage.signUp(userName, email, password);
        wait.until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getSignUpButton()));
        loginPage.clickResetPasswordButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(resetPasswordPage.getEmailField()));
        resetPasswordPage.clickLoginButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailField()));
        loginPage.loginAccount(email, password);

        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getMakeOrderButton()));
        WebElement element = driver.findElement(mainPage.getMakeOrderButton());
        assertTrue(element.isDisplayed());

        Response loginResponse = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(Map.of("email", email, "password", password))
                .post(LOGIN_URL);

        bearerToken = loginResponse.jsonPath().getString("accessToken");
    }
}


