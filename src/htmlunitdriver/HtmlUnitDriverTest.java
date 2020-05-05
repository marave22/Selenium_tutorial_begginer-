package htmlunitdriver;

import com.gargoylesoftware.htmlunit.WebClient;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import java.lang.reflect.Field;

import static com.sun.javafx.fxml.expression.Expression.get;

public class HtmlUnitDriverTest {

    public static void main(String[] args) throws Exception {
        HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.EDGE);
        driver.get("https://en.wikipedia.org/");
        System.out.println("Title is: " + driver.getTitle());

        WebClient webClient = (WebClient) get(driver, "webClient");

        System.out.println("Browser version is: " + webClient.getBrowserVersion());
        System.out.println("Is Browser Edge: " + webClient.getBrowserVersion().isEdge());
        System.out.println("Is Browser Chrome: " + webClient.getBrowserVersion().isChrome());

        driver.quit();
    }

    private static Object get(Object object, String field) throws Exception {
        Field f = object.getClass().getDeclaredField(field);
        f.setAccessible(true);
        return f.get(object);
    }
}
