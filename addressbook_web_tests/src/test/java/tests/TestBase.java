package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    protected static ApplicationManager app;
    protected static String browser = System.getProperty("browser", "chrome");
    protected static Properties properties;


    @BeforeEach
    public void setUp() throws IOException {
        if (app == null) {
            properties = new Properties();
            String target = System.getProperty("target", "local.properties");
            properties.load(new FileReader(target));

            app = new ApplicationManager();
            app.init(browser, properties);
        }
    }

    @AfterEach
    void checkDatabaseConsistency() {
        app.jdbc().checkConsistency();
    }
}


