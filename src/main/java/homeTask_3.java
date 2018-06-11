import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Random;

public class homeTask_3 {
    public static void main(String[] args) {

        // инициализация драйвера
        WebDriver driver = initChromeDriver();

        // развернуть окно браузера на весь экран
        driver.manage().window().maximize();

        // 1. Войти в Админ панель
        // Логин: webinar.test@gmail.com
        // Пароль: Xcg7299bnSmMuRLp9ITw
        driver.navigate().to("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        sleep(500);

        // ввод логина в поле "адрес E-mail"
        driver.findElement(By.name("email")).sendKeys("webinar.test@gmail.com");
        sleep(500);
        // ввод пароля в поле "Пароль"
        driver.findElement(By.name("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        sleep(500);
        // нажатие кнопки "Ввод"
        driver.findElement(By.name("submitLogin")).click();

        // 2. Выбрать пункт меню Каталог -> категории и дождаться загрузки страницы управления
        // категориями.
        sleep(500);
        //WebElement AdminCatalog = driver.findElement(By.id("subtab-AdminCatalog"));
        WebElement AdminCatalog = driver.findElement(By.xpath("//li[@data-submenu='9']"));
        //навести курсор мышки на элемент
        Actions act = new Actions(driver);
        act.moveToElement(AdminCatalog).perform();
        //выбрать пункт "категории" в раскрывающемся меню
        sleep(700);
        driver.findElement(By.xpath("//li[@data-submenu='11']")).click();

        // 3. Нажать «Добавить категорию» для перехода к созданию новой категории.
        sleep(500);
        driver.findElement(By.className("process-icon-new")).click();

        // 4. После загрузки страницы ввести название новой категории и сохранить изменения. На
        // странице управления категориями должно появиться сообщение об успешном
        // создании категории.

        //генерим рандомный номер категории
        Random rnd = new Random();
        int num = rnd.nextInt(20);

        sleep(500);
        driver.findElement(By.id("name_1")).sendKeys("Test category " + num);
        sleep(500);
        driver.findElement(By.id("category_form_submit_btn")).click();


        // 5. Отфильтровать таблицу категорий по имени и дождаться там появления записи
        // созданной категории.
        sleep(2000);
        driver.findElement(By.xpath("//a[@href='index.php?controller=AdminCategories&categoryOrderby=name&categoryOrderway=asc&token=795a6350b3a0f87af2a165b4c1a34372&id_category=2']/i")).click();

        sleep(2000);
        driver.close();
    }

    // подключаем chromedriver.exe
    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", homeTask_3.class.getResource("chromedriver.exe").getPath());
        //логи
        return new EventFiringWebDriver(new ChromeDriver()).register(new MyWebDriverEventListener());
    }

    // ожидание загрузки контента
    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
