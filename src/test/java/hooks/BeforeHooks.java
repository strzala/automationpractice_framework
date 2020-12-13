package hooks;

import io.cucumber.java.Before;
import util.helpers.PropertiesHandler;

public class BeforeHooks {

    @Before(order = 1)
    public void initExecutor() {
        PropertiesHandler.init();
    }
}
