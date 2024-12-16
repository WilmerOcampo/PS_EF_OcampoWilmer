package cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * A class that represents all the common features between all the pages in the Sauce Demo website
 */
public abstract class SaucePage {

    private WebDriver driver;
    private By twitterIcon = new By.ByLinkText("Twitter");
    private By facebookIcon = new By.ByLinkText("Facebook");
    private By linkedinIcon = new By.ByLinkText("LinkedIn");

    public SaucePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Method which returns the webdriver for other pages to use in their own methods
     */
    public WebDriver getDriver() {
        try {
            return driver;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method for clicking the twitter icon in the footer
     */
    public void clickTwitterIcon() {
        try {
            driver.findElement(twitterIcon).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for clicking the facebook icon in the footer
     */
    public void clickFacebookIcon() {
        try {
            driver.findElement(facebookIcon).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for clicking the linked in icon in the footer
     */
    public void clickLinkedinIcon() {
        try {
            driver.findElement(linkedinIcon).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for returning the current url that the driver is in
     */
    public String getCurrentURL() {
        try {
            return driver.getCurrentUrl();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
