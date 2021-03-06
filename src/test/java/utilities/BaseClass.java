package utilities;

import org.testng.annotations.*;

import static pages.LoginPage.login;
import static pages.LoginPage.logout;
import static pages.LoginPage.viewTranstats;

/**
 * Created by spathare on 12/16/16.
 */
public class BaseClass {

    public String env;
    public String browser;

    @BeforeTest
    public void beforeTest() throws Exception {

        browser = Utils.readPropertyOrEnv("browser","chrome");
        env = Utils.readPropertyOrEnv("env","qa");
        UiControl.getBrowser(browser);
        UiControl.setUrl(env);
        login();
        viewTranstats();
    }

    @AfterTest
    public void afterTest() throws Exception{
        logout();
        System.out.println("Closing browser");
        boolean hasQuit = (UiControl.getWebDriver().toString().contains("(null)")) ? true : false;
        if(!hasQuit) {
            UiControl.getWebDriver().close();
            UiControl.getWebDriver().quit();
        }
    }


}
