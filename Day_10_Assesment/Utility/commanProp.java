package Day_10_Assesment.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class commanProp {

    public static String getData(String key) throws IOException {

        FileInputStream fis = new FileInputStream(
                "src/test/java/Day_10_Assesment/Resc/commondata.properties"
        );

        Properties p = new Properties();
        p.load(fis);

        String data = p.getProperty(key);

        fis.close();

        return data;
    }
}