package cucumber.steps;

import cucumber.pages.AuthenticationPage;
import cucumber.pages.FooterActions;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AuthenticationSteps {

    private static WebDriver driver;
    private AuthenticationPage authenticationPage;
    private FooterActions actions;

    @Given("Estoy en la página de inicio de sesión")
    public void openLoginPage() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        authenticationPage = new AuthenticationPage(driver);
    }

    @When("Ingreso el username {string} y password \"secret_sauce\"")
    public void enterUsernameAndPassword(String username) {
        authenticationPage.enterUsername(username);
        authenticationPage.enterPassword("secret_sauce");
    }

    @And("Hago clic en el botón de inicio de sesión")
    public void clickLoginButton() {
        authenticationPage.clickLoginButton();
    }

    @Then("Accederé a la página de inventario")
    public void enterInventoryPage() {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        actions = new FooterActions(driver);
    }

    @When("Ingreso un username incorrecto y password válido")
    public void insertInvalidUsername() {
        authenticationPage.enterUsername("locked_out_user");
        authenticationPage.enterPassword("secret_sauce");
    }

    @When("Ingreso username válido y un password incorrecto")
    public void insertInvalidPassword() {
        authenticationPage.enterUsername("standard_user");
        authenticationPage.enterPassword("12345");
    }

    @Then("Permanezco en la página de inicio de sesión")
    public void stayLoginPage() {
        Assertions.assertTrue("https://www.saucedemo.com".equals(driver.getCurrentUrl()) || "https://www.saucedemo.com/".equals(driver.getCurrentUrl()));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("tearDown");
        }
    }
}
