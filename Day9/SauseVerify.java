package Day9;

public class SauseVerify {
SauseTest k=new SauseTest();

    public void executor(String Keyword) {
        if (Keyword.equals("OPEN_BROWSER")) {
            k.lanuchBroswer();
        } else if (Keyword.equals("OPEN_URL")) {
            k.openUrl();
        } else if (Keyword.equals("USERNAME")) {
            k.un();
            ;
        } else if (Keyword.equals("PASSWORD")) {
            k.pass();
        } else if (Keyword.equals("LOGIN")) {
            k.login();
        } else if (Keyword.equals("CLOSE_BROWSER")) {
            k.close();
        }
    }
}
