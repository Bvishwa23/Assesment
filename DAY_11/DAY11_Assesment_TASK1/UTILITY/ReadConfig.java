package DAY11_Assesment.UTILITY;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    public static String getData(String key)
            throws IOException {

        FileInputStream fis =
                new FileInputStream(
                        "./src/test/java/DAY11_Assesment/Resc/config.properties"
                );

        Properties properties =
                new Properties();

        properties.load(fis);

        fis.close();

        return properties.getProperty(key);
    }
}