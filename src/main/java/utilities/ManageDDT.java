package utilities;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDDT extends CommonOps{

    @DataProvider(name = "DataProvider-Search")
    public Object[][] getDataObject(){
        return getDataFromCSV(getData("DDTFile") + "MenuSearchOption.csv");
    }

    public static List<String> readCSV(String scvFile){
        List<String> lines = null;
        File file = new File(scvFile);
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        }catch (IOException e){
            System.out.println("See: " + e);
        }
        return lines;
    }


    public static Object[][] getDataFromCSV(String filePath){
        List<String> csvData = readCSV(filePath);
        Object[][] data = new Object[csvData.size()][2]; //מספר העמודות שלי שווה 2 ומספר השורות שלי יכול לשתנות

        for (int i = 0; i< csvData.size(); i++){
            data[i][0] = csvData.get(i).split(",")[0];
            data[i][1] = csvData.get(i).split(",")[1];
        }
        return data;
    }

}
