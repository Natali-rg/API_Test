import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import util.sql.SQLInstans;
import util.sql.StatemenT;

public class TestDB {
    static StatemenT dbDriver;


    static WebDriver driver;
    @BeforeClass
    public static void start(){
        dbDriver= SQLInstans.getInstance();

//        driver= DriverFactory.getDriver(BROWSER.CHROME);
    }
    @Test
    public void test(){
//        driver.get("https://accounts.google.com/AccountChooser/identifier?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&flowName=GlifWebSignIn&flowEntry=AccountChooser");
//        dbDriver.selectUsersByName("Mike");
//        User user=dbDriver.getUserByid("118");
//        System.out.println(user.getEmail());
//        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(user.getEmail());
//        dbDriver.insert("Natik","natik@gmail.com", "f4567g","g45dd54r456d");
//        dbDriver.delete("g45dd54r456d");
//        dbDriver.updatePassword("Qwerty","123");
        dbDriver.selectUsersByEmail("natik@gmail.com");

    }
}
