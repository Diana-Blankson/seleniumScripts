package demonopCommerce;

import java.util.HashMap;
import java.util.Map;

public class Credentials {

    final Map<String, String> data;
    Credentials (){
        this.data = new HashMap<>();
        data.put("fName","First");
        data.put("lName", "Last");
        data.put("email","dbselenium@gmail.com");
        data.put("companyName", "DAB");
        data.put("password", "dbSel$$122");
        data.put("wrongPassword", "dbSelWrong");

    }
    public Map<String, String> getAllCredentials(){
        return data;
    }

}
