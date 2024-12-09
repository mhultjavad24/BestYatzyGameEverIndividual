import java.io.FileInputStream;
import java.util.Properties;

public class Rules {

    private String rules;

    public Rules() {

        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream("src/Rules.properties"));
        } catch (Exception e) {
            System.out.println("Rules file could not be loaded");
            e.printStackTrace();
        }

        setRules(properties.getProperty("rules"));
    }

    public String getRules() {
        return "Rules: " + rules;
    }

    private void setRules(String rules) {
        this.rules = rules;
    }

}
