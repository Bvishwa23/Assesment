package Day11_Assesment_Task2.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {

    public static String getData(String key) throws IOException {

        FileInputStream fis =
                new FileInputStream(
                        "./src/test/java/Day11_Assesment_Task2/Resc/config.properties"
                );

        Properties properties = new Properties();

        properties.load(fis);

        String value = properties.getProperty(key);

        fis.close();

        return value;
    }
}