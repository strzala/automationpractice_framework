package util.enums;

import lombok.Getter;

public enum BrowserType {

    FIREFOX("chrome"),
    CHROME("gecko");

    @Getter
    String caption;

    BrowserType(String caption){
        this.caption = caption;
    }
}

