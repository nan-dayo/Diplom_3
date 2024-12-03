package pageObject;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

//////////////////СТРАНИЦА ВХОДА В АККАУНТ////////////

public class LoginPage {

    private WebDriver driver;

    //поле email
    private By emailField = By.xpath("//input[@name='name']");
    //поле Пароль
    private By passwordField = By.xpath("//input[@name='Пароль']");
    //кнопка Войти
    private By loginButton = By.className("Auth_link__1fOlj");
    //кнопка Зарегистрироваться
    private By signUpButton = By.xpath("//a[contains(text(), 'Зарегистрироваться')]");
    //Кнопка Восстановить пароль
    private By resetPasswordButton = By.xpath("//a[contains(text(), 'Восстановить пароль')]");
    //Форма Авторизации
    private By loginForm = By.xpath("//form[contains(@class, 'Auth_form__3qKeq')]");

    ///////////////////////////////////////////

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Геттер для кнопки Зарегистрироваться")
    public By getSignUpButton(){
        return signUpButton;
    }

    @Step("Геттер для формы авторизации")
    public By getLoginForm(){
        return loginForm;
    }

    @Step("Геттер для поля email")
    public By getEmailField(){
        return emailField;
    }

    @Step("Геттер для кнопки Войти")
    public By getLoginButton(){
        return loginButton;
    }

    @Step("Заполнить поле 'Email' в форме авторизации")
    public void setUserEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Заполнить поле 'Пароль' в форме авторизации")
    public void setUserPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Кликнуть по кнопке 'Войти' в форме авторизации")
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    @Step("Кликнуть по кнопке 'Зарегистрироваться' в форме авторизации")
    public void clickSignUpButton(){
        driver.findElement(signUpButton).click();
    }

    @Step("Кликнуть по кнопке 'Восстановить пароль' в форме авторизации")
    public void clickResetPasswordButton(){
        driver.findElement(resetPasswordButton).click();
    }

    @Step("Войти в аккаунт")
    public void loginAccount(String email, String password){
        setUserEmail(email);
        setUserPassword(password);
        clickLoginButton();
    }



}
