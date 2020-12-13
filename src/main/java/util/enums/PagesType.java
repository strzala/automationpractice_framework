package util.enums;

public enum PagesType {

    HOME(""),
    SIGNIN ("/index.php?controller=authentication&back=my-account"),
    WOMEN_CATEGORY("/index.php?id_category=3&controller=category"),
    DRESSES_CATEGORY("/index.php?id_category=8&controller=category"),
    CONTACT("/index.php?controller=contact"),
    PRODUCT("/index.php?id_product=1&controller=product"),
    CHECKOUT("/index.php?controller=order");

    private String uri;

    PagesType(String uri) {
        this.uri = uri;
    }

    public String getUri(){
        return uri;
    }
}
