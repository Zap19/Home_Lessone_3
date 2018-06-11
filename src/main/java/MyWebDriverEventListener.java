import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class MyWebDriverEventListener implements WebDriverEventListener {

    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("Navigated to:'" + url + "'");
    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Found element By : " + by.toString());
    }

    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Clicked on: " + element.toString());
    }

    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Element value changed: " + webElement.toString());
    }

    public void onException(Throwable error, WebDriver driver) {
        System.out.println("Exception occured: " + error);
    }

    //не переопределенные методы
    public void beforeClickOn(WebElement element, WebDriver driver) {}
    public void beforeNavigateBack(WebDriver driver) {}
    public void afterNavigateBack(WebDriver driver) {}
    public void beforeNavigateForward(WebDriver driver) {}
    public void afterNavigateForward(WebDriver driver) {}
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {}
    public void beforeNavigateTo(String url, WebDriver driver) {}
    public void beforeScript(String script, WebDriver driver) {}
    public void afterScript(String script, WebDriver driver) {}
    public void beforeAlertAccept(WebDriver webDriver) {}
    public void afterAlertAccept(WebDriver webDriver) {}
    public void afterAlertDismiss(WebDriver webDriver) {}
    public void beforeAlertDismiss(WebDriver webDriver) {}
    public void beforeNavigateRefresh(WebDriver webDriver) {}
    public void afterNavigateRefresh(WebDriver webDriver) {}
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {}

}