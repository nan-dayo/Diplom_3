package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class ResetPasswordPage {

    private WebDriver driver;

    private By emailField = By.xpath("//input[@name='name']");
    private By loginButton = By.xpath("//p/a[@href='/login']");

    public ResetPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Геттер для поля Email")
    public By getEmailField() {
        return emailField;
    }

    @Step("Кликнуть по кнопке Войти в форме восстановления пароля")
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
}
