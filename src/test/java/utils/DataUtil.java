package utils;

import base.BaseTests;
import org.testng.annotations.DataProvider;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class DataUtil extends BaseTests {

    @DataProvider
    public static Object[][] dataProvider1() {
        return readYAML("src/main/resources/data1.yaml");
    }

    @DataProvider
    public static Object[][] dataProvider2() {
        return readYAML("src/main/resources/data2.yaml");
    }

    @DataProvider
    public static Object[][] dataProvider3() {
        return readYAML("src/main/resources/data3.yaml");
    }

    @DataProvider
    public static Object[][] dataProvider4() {
        return readYAML("src/main/resources/data4.yaml");
    }

    @DataProvider
    public static Object[][] dataProvider5() {
        return readYAML("src/main/resources/data5.yaml");
    }

    private static Object[][] readYAML(String filePath) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        Yaml yaml = new Yaml();
        Map<String, Object> data = yaml.load(inputStream);

        Object[][] testData = new Object[1][1];
        testData[0][0] = data;

        return testData;
    }
}
