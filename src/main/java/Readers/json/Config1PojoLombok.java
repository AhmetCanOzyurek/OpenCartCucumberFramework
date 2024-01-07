package Readers.json;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Config1PojoLombok extends myJsonPojo{
    //lombok annotationlar kullanilarak getter, setter, toString ve error islemlerinde kolaylik saglar

    private String url;
    private String username;
    private String password;

}
