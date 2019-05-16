package tests;

import java.util.Properties;

public class DataPropertiesReader extends PropertiesReader{

    private  Properties dataProperties = new Properties();

    public DataPropertiesReader(String nameOfPropertiesFile){
        dataProperties = loadPropertiesFile(nameOfPropertiesFile);
    }

    public String getData(String data){
        return dataProperties.getProperty(data);
    }




}
