package Readers.json;

import Readers.MyPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

import static utils.Utils.*;

public class TestMapper {

    @Test
    public void testMapCOnfig1() throws Exception {
        String file = "src/test/resources/datafiles/Config1.json";

        ObjectMapper mapper = new ObjectMapper();
        Config1Pojo config = mapper.readValue(new FileReader(file), Config1Pojo.class);

        System.out.println("config = " + config);
        System.out.println("-----------");
        System.out.println("config.getUrl() = " + config.getUrl());
        System.out.println("config.getUsername() = " + config.getUsername());
        System.out.println("config.getPassword() = " + config.getPassword());
    }
    @Test
    public void testMapConfig1ombok() throws IOException {
        String file = "src/test/resources/datafiles/Config1.json";

        ObjectMapper mapper = new ObjectMapper();
        Config1PojoLombok config = mapper.readValue(new FileReader(file), Config1PojoLombok.class);


        System.out.println("config = " + config);
        System.out.println("-----------");
        System.out.println("config.getUrl() = " + config.getUrl());
        System.out.println("config.getUsername() = " + config.getUsername());
        System.out.println("config.getPassword() = " + config.getPassword());

    }@Test
    public void testMapConfig() throws IOException {
        String file = "src/test/resources/datafiles/Config.json";

        ObjectMapper mapper = new ObjectMapper();
        ConfigPojo config = mapper.readValue(new FileReader(file), ConfigPojo.class);


        System.out.println("config = " + config);

        System.out.println(config.getUsers().get(0).getPassword());
    }
    @Test
    public void testMapGeneral1(){
        String file = "src/test/resources/datafiles/Config1.json";

        MyPojo pojo = new Config1PojoLombok();
 Config1PojoLombok data = (Config1PojoLombok) getPojo(file,pojo);
        System.out.println("data.getUrl() = " + data.getUrl());

    }
    @Test
    public void testMapGeneral2(){
        String file = "src/test/resources/datafiles/Config.json";

        MyPojo pojo = new ConfigPojo();
        ConfigPojo data = (ConfigPojo) getPojo(file,pojo);
        
        System.out.println("data.getUsers().get(0).getAdress().getCity() = " + data.getUsers().get(0).getAdress().getCity());
    }



}
