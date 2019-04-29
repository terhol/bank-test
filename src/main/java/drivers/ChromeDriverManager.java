/**
 * @author - Tereza Holm
 *
 * Driver for Chrome.
 */

//TODO Chrome stopped working suddenly - "session not created: Chrome version must be between 70 and 73" error is thrown

package drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

    @Override
    protected void createWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        this.driver = new ChromeDriver(options);


    }
}
