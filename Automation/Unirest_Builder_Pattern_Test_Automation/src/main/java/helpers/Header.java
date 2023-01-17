package helpers;

import base.HttpHeader;

import java.util.HashMap;

public class Header {
    public static HttpHeader getHeaders(){
        HashMap<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/json");
        map.put("Accept", "*/*");
        HttpHeader headers = new HttpHeader();
        headers.setHeader(map);
        return headers;
    }
}
