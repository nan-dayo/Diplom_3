package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

///////////////////////////////////////РЕГИСТРАЦИЯ////////////////////////////////////////////////

public class RegisterPage {

    private WebDriver driver;

    //Форма Регистрации
    private By registerForm = By.xpath("//form[contains(@class, 'Auth_form__3qKeq')]");
    //поле имя
    private By nameField = By.xpath("(//input[@name='name'])[1]");
    //поле email
    private By emailField = By.xpath("(//input[@name='name'])[2]");
    //поле Пароль
    private By passwordField = By.xpath("//input[@name='Пароль']");
    //Кнопка Зарегистрироваться
    private By signUpButton = By.xpath("//button[text()='Зарегистрироваться']");
    //кнопка Войти
    private By loginButton = By.xpath("//a[contains(@href, '/login')]");
    //ошибка некорректный пароль
    private By passwordError = By.xpath("//p[contains(@class, 'input__error')]");

    public String getErrorMessage() {
        return driver.findElement(passwordError).getText();
    }
    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Геттер для поля Имя в форме регистрации")
    public By getNameField(){
        return nameField;
    }

    @Step("Геттер для кнопки Войти")
    public By getLoginButton(){
        return loginButton;
    }



    @Step("Геттер для ошибки Некорректный пароль")
    public By getPasswordErrorMessage(){
        return passwordError;
    }

    @Step("Геттер для формы Регистрация")
    public By getSignUpForm(){
        return registerForm;
    }

    @Step("Заполнить поле 'Имя' в форме регистрации")
    public void setUserName(String username){
        driver.findElement(nameField).sendKeys(username);
    }

    @Step("Заполнить поле 'Email' в форме регистрации")
    public void setUserEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Заполнить поле 'Пароль' в форме регистрации")
    public void setUserPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Кликнуть по кнопке 'Зарегистрироваться' в форме регистрации")
    public void clickSignUpButton(){
        driver.findElement(signUpButton).click();
    }

    @Step("Кликнуть по кнопке 'Войти' в форме регистрации")
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    @Step("Пройти регистрацию")
    public void signUp(String username, String email, String password){
        setUserName(username);
        setUserEmail(email);
        setUserPassword(password);
        clickSignUpButton();
    }


}
