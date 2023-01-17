package base;

import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.experimental.Accessors;

import java.util.HashMap;

@Getter
@Setter
@Accessors(chain=true)
public class HttpHeader {
    @Singular private HashMap<String,String> header = new HashMap<>();
    public void addHeader(String key,String value){
        header.put(key,value);
    }
}
