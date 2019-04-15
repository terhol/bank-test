/**
 * @author - Tereza Holm
 *
 * Allows to choose from browsers from enum DriverType.
 */

package drivers;


public class DriverManagerFactory {

    public static DriverManager getWebDriver(DriverType type) {
        DriverManager driverManager;
        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            case IE:
                driverManager = new IEDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
        }
        return driverManager;

    }
}
