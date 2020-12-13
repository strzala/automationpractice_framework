package pages;

import util.enums.PagesType;
import util.webdriverProvider.SeleniumExecutor;

public abstract class BasePage {

    public BasePage(){
        SeleniumExecutor.getExecutor();
    }

    protected void openPage(PagesType page){
        String url = SeleniumExecutor.pageDefaultUrl + page.getUri();
        SeleniumExecutor.openPage(url);
    }
}
