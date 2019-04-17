/**
 * @author - Tereza Holm
 *
 * Driver for Microsoft Edge.
 */

package drivers;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverManager extends DriverManager {
    protected void createWebDriver() {
        EdgeOptions options = new EdgeOptions();
        this.driver = new EdgeDriver(options);
    }
}