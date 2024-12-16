package cucumber.pages;

import org.openqa.selenium.WebDriver;

public class FooterActions extends SaucePage {

    public FooterActions(WebDriver driver) {
        super(driver);
        this.getDriver().get("https://www.saucedemo.com/inventory.html");
    }

    public void clickTwitterIcon() {
        super.clickTwitterIcon();
    }

    public void clickFacebookIcon() {
        super.clickFacebookIcon();
    }

    public void clickLinkedinIcon() {
        super.clickLinkedinIcon();
    }

}
