package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

////////////////////////////////////////////ВОССТАНОВЛЕНИЕ ПАРОЛЯ////////////////////////////////////////////

public class ResetPasswordPage {

    private WebDriver driver;

    //Поле Email
    private By emailField = By.xpath("//input[@name='name']");
    //Кнопка Восстановить
    private By resetButton = By.xpath("//button[text()='Восстановить']");
    //Кнопка Войти
    private By loginButton = By.xpath("//p/a[@href='/login']");



    public ResetPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Геттер для поля Email")
    public By getEmailField() {
        return emailField;
    }

    @Step("Заполнить поле 'Email' в форме восстановления пароля")
    public void setUserEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Кликнуть по кнопке 'Восстановить' в форме восстановления пароля")
    public void clickResetButton(){
        driver.findElement(resetButton).click();
    }

    @Step("Кликнуть по кнопке Войти в форме восстановления пароля")
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    @Step("Восстановить пароль")
    public void resetPassword(String email){
        setUserEmail(email);
        clickResetButton();
    }
}
