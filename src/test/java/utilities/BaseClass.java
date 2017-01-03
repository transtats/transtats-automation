package utilities;

import org.testng.annotations.*;

/**
 * Created by spathare on 12/16/16.
 */
public class BaseClass {

    public String env;
    public String browser;

    @BeforeTest
    public void beforeTest() throws Exception {

        browser = Utils.readPropertyOrEnv("browser","firefox");
        env = Utils.readPropertyOrEnv("env","prod");
        UiControl.getBrowser(browser);
        UiControl.setUrl(env);
    }

    @AfterTest
    public void afterTest(){

        System.out.println("Closing browser");
        boolean hasQuit = (UiControl.getWebDriver().toString().contains("(null)")) ? true : false;
        if(!hasQuit) {
            UiControl.getWebDriver().close();
            UiControl.getWebDriver().quit();
        }

    }


}
