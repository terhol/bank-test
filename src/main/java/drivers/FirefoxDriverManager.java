/**
 * @author - Tereza Holm
 *
 *Driver for Firefox.
 */

package drivers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager {

    @Override
    protected void createWebDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        this.driver = new FirefoxDriver(options);

    }
}
