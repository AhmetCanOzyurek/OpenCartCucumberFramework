package Readers.yaml;

import Readers.MyPojo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ConfigYaml extends MyPojo {

    public Application application;
    public User user1;
    public User user2;
    public Browser chrome;
    public Browser edge;


    @Getter
    @Setter
    @ToString
    public class Application {
        private String url;
    }

    @Getter
    @Setter
    @ToString
    public class User {
        private String username;
        private String password;
    }


    @Getter
    @Setter
    @ToString
    public class Browser {
        private String name;
        private boolean headless;
        private String userDataDir;
    }
}
