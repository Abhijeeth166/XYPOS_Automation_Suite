package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Global_Variables {
    public static final int DEFAULT_TIMEOUT_VALUE = 60;

    // Declare URLs
    public static final String STYLIST_QA_URL = "https://stylist-qa.xyretail.com/";
    public static final String STYLIST_DEV_URL = "https://stylistdev.xyretail.com/";

    // The URL that will be used, set based on the config file
    public static String URL;

    public static final String PASSWORD = "!Buddy1jar";

    public static final String ARMANI_USERNAME = "admin166@armani.com";
    public static final String BOGGI_USERNAME = "admin166@boggi.com";
    public static final String DAMIANI_USERNAME = "admin166@damiani.it";
    public static final String GOLDENGOOSE_USERNAME = "admin166@goldengoose.com";
    public static final String FENDER_USERNAME = "admin166@fender.com";
    public static final String PAULANDSHARK_USERNAME = "admin166@pands.com";
    public static final String SLOWEAR_USERNAME = "admin166@slowear.com";

    // Static block to load the URL from config.properties
    static {
        try (FileInputStream input = new FileInputStream("src/main/java/properties/config.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            // Read the environment URL choice from the config file
            String environmentUrl = prop.getProperty("environment.url");

            // Set the URL based on the config
            if ("STYLIST_QA_URL".equalsIgnoreCase(environmentUrl)) {
                URL = STYLIST_QA_URL;
            } else if ("STYLIST_DEV_URL".equalsIgnoreCase(environmentUrl)) {
                URL = STYLIST_DEV_URL;
            } else {
                // Default to STYLIST_DEV_URL if not defined correctly
                URL = STYLIST_DEV_URL;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            // Fallback in case of an error
            URL = STYLIST_DEV_URL;
        }
    }

    // Method to get the username based on the brand
    public static String getUsername(String brand) {
        switch (brand.toLowerCase()) {
            case "armani":
                return ARMANI_USERNAME;
            case "boggi":
                return BOGGI_USERNAME;
            case "damiani":
                return DAMIANI_USERNAME;
            case "goldengoose":
                return GOLDENGOOSE_USERNAME;
            case "fender":
                return FENDER_USERNAME;
            case "paul&shark":
                return PAULANDSHARK_USERNAME;
            case "slowear":
                return SLOWEAR_USERNAME;
            default:
                throw new IllegalArgumentException("Username not found for the specified brand: " + brand);
        }
    }
}
