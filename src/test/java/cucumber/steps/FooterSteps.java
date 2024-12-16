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

import java.util.Set;

public class FooterSteps {
    private static WebDriver driver;
    private FooterActions actions;

    @Given("Estoy en la pagina de inventario")
    public void onTheInventoryPage() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.enterUsername("standard_user");
        authenticationPage.enterPassword("secret_sauce");
        authenticationPage.clickLoginButton();

        actions = new FooterActions(driver);
    }

    @When("Hago clic en el enlace de Twitter en el footer")
    public void clickOnTwitterInFooter() {
        actions.clickTwitterIcon();  // Método en la página de inventario para hacer clic en Twitter
    }

    @Then("Seré redirigido a la página de Twitter")
    public void verifyTwitterRedirection() {
        switchToNewWindow();
        Assertions.assertTrue(driver.getCurrentUrl().contains("x.com"));
        closeAndSwitchBack();
    }

    @And("Vuelvo a la página de Saucedemo")
    public void backToSauceDemo() {
        driver.get("https://www.saucedemo.com");
    }

    @When("Hago clic en el enlace de Facebook en el footer")
    public void clickOnFacebookInFooter() {
        actions.clickFacebookIcon();
    }

    @Then("Seré redirigido a la página de Facebook")
    public void verifyFacebookRedirection() {
        // Cambiar de ventana y verificar la URL
        switchToNewWindow();
        Assertions.assertTrue(driver.getCurrentUrl().contains("facebook.com"));
        closeAndSwitchBack();
    }

    @When("Hago clic en el enlace de LinkedIn en el footer")
    public void clickOnLinkedinInFooter() {
        actions.clickLinkedinIcon();
    }

    @Then("Seré redirigido a la página de LinkedIn")
    public void verifyLinkedinRedirection() {
        switchToNewWindow();
        Assertions.assertTrue(driver.getCurrentUrl().contains("linkedin.com"));
        closeAndSwitchBack();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void switchToNewWindow() {
        Set<String> allWindows = driver.getWindowHandles();
        String originalWindow = driver.getWindowHandle();
        allWindows.remove(originalWindow);
        String newWindow = allWindows.iterator().next();
        driver.switchTo().window(newWindow);
    }

    private void closeAndSwitchBack() {
        driver.close();
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
    }
}
