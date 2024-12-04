import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;
import pageObject.*;
import java.time.Duration;
import java.util.Map;
import java.util.Random;
import static org.junit.Assert.*;

public class PersonalAccountTest extends BaseTest{

    String userName = "user" + new Random().nextInt(10000);
    String email = "random" + new Random().nextInt(10000) + "@mail.com";
    String password = "password" + new Random().nextInt(10000);

    @Test
    @DisplayName("Переход по клику на 'Личный кабинет'")
    public void testClickPersonalAccountButtonRedirectsToPersonalAccount(){

        System.out.println("Username: " + userName);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Регистрация
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.getLoginAccountButton()));
        mainPage.clickLoginAccountButton();
        loginPage.clickSignUpButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.getSignUpForm()));
        registerPage.signUp(userName, email, password);
        wait.until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));

        //Авторизация
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailField()));
        loginPage.loginAccount(email, password);

        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getMakeOrderButton()));
        mainPage.clickPersonalAccountButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(personalAccountPage.getProfileButtonBlock()));

        WebElement element = driver.findElement(personalAccountPage.getProfileButtonBlock());
        assertTrue(element.isDisplayed());

        Response loginResponse = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(Map.of("email", email, "password", password))
                .post(LOGIN_URL);

        bearerToken = loginResponse.jsonPath().getString("accessToken");

    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на 'Конструктор'")
    public void testClickOnConstructorButtonRedirectsToConstructor(){
        System.out.println("Username: " + userName);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Регистрация
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.getLoginAccountButton()));
        mainPage.clickLoginAccountButton();
        loginPage.clickSignUpButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.getSignUpForm()));
        registerPage.signUp(userName, email, password);
        wait.until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));

        //Авторизация
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailField()));
        loginPage.loginAccount(email, password);

        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getMakeOrderButton()));
        mainPage.clickPersonalAccountButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(personalAccountPage.getProfileButtonBlock()));

        WebElement element = driver.findElement(personalAccountPage.getProfileButtonBlock());
        assertTrue(element.isDisplayed());

        Response loginResponse = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(Map.of("email", email, "password", password))
                .post(LOGIN_URL);

        bearerToken = loginResponse.jsonPath().getString("accessToken");

        mainPage.clickConstructorButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getMakeOrderButton()));
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void testClickOnLogoRedirectsToConstructor(){
        System.out.println("Username: " + userName);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Регистрация
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.getLoginAccountButton()));
        mainPage.clickLoginAccountButton();
        loginPage.clickSignUpButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.getSignUpForm()));
        registerPage.signUp(userName, email, password);
        wait.until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));

        //Авторизация
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailField()));
        loginPage.loginAccount(email, password);

        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getMakeOrderButton()));
        mainPage.clickPersonalAccountButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(personalAccountPage.getProfileButtonBlock()));

        WebElement element = driver.findElement(personalAccountPage.getProfileButtonBlock());
        assertTrue(element.isDisplayed());

        Response loginResponse = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(Map.of("email", email, "password", password))
                .post(LOGIN_URL);

        bearerToken = loginResponse.jsonPath().getString("accessToken");

        mainPage.clickLogoButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getMakeOrderButton()));
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void testLogOutFromPersonalAccount(){
        System.out.println("Username: " + userName);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Регистрация
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.getLoginAccountButton()));
        mainPage.clickLoginAccountButton();
        loginPage.clickSignUpButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.getSignUpForm()));
        registerPage.signUp(userName, email, password);
        wait.until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));

        //Авторизация
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailField()));
        loginPage.loginAccount(email, password);

        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getMakeOrderButton()));;
        mainPage.clickPersonalAccountButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(personalAccountPage.getLogoutButton()));
        personalAccountPage.clickLogoutButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailField()));
        WebElement element = driver.findElement(loginPage.getEmailField());
        assertTrue(element.isDisplayed());
    }

}
