package herokuapp;

import java.util.HashMap;
import java.util.Map;

public class KeyValueObj {
    final Map<String, String> data;

    KeyValueObj() {
        data = new HashMap<>();
        data.put("baseUrl", "https://the-internet.herokuapp.com/");
        data.put("username", "tomsmith");
        data.put("password", "SuperSecretPassword!");
        data.put("expectedTextLogin", "You logged into a secure area!");
        data.put("authenticationUrl", "https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }

    public Map<String, String> getAllData() {
        return data;
    }

}




