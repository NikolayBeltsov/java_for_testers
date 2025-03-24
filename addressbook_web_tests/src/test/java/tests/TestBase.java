package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

public class TestBase {

    protected static ApplicationManager app;

    @BeforeEach
    public void setUp() {
        if (app == null) {
            app = new ApplicationManager();
        }
        app.init(System.getProperty("browser", "chrome"));
    }

    public static String randomString(int n) {
        var rnd = new Random();
        var result = "";
        for (int i = 0; i < n; i++){
            result = result + (char)('a' + rnd.nextInt(26));
        }
        return result;
    }

    public static String randomPhoneNumber(int n) {
        var rndNum = new Random();
        var result = "";
        var prefix = "8800";
        for (int i = 0; i < n; i++) {
            result += rndNum.nextInt(10);
        }
        return prefix + result;
    }
}
