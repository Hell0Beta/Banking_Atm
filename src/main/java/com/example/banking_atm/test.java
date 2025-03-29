package com.example.banking_atm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.print.DocFlavor;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.io.File;
public class test {
    public static Map<String, Object> readjson() throws IOException{
//      This line creates a ObjectMapper object - This allows us to convert a json object to a hash map
        ObjectMapper objectMapper = new ObjectMapper();


//      hashmap(key:str,val:Obj) var  objectmapper reads value from ----the---`data.json` file, further specifies its a hash map
        Map<String, Object> data = objectMapper.readValue(new File("data.json"), Map.class) ;

//      Prints info to console
        System.out.println("Read JSON: " + data + "\n");

        return data;
    }

    public static Map<String, Object> fetchUsers() throws IOException {
        var data = readjson();
        var userobj = data.get("users");
        Map<String, Object> users = new LinkedHashMap<>((Map<? extends String, ?>) userobj);
        System.out.println(users);
        return users;
    }

    public static Map<String, Object> fetch_a_user(String account_no) throws IOException {
        var users = fetchUsers();
        Map<String, Object> user = new LinkedHashMap<>((Map<? extends String, ?>) users.get(account_no));
        System.out.println("user data for - template-user-account_no:\n" + user);
        return user;
    }

    public static void delete_a_user(String account_no) throws IOException {
        var user = fetch_a_user(account_no);
        user.clear();
        System.out.println("Cleared, remaining" + user);
    }

    public static void save_user(Map<String, Object> users) throws IOException {
        var data = readjson();
        data.put("users", users);
        System.out.println(data);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("data.json"),data);
    }


    public static void create_a_user(String name, String PIN, String email) throws IOException{
        var users = fetchUsers();
        int randomy = (int)(Math.random()*1000000+4);

        String account_no = Integer.toString(randomy);

        if(!users.containsKey(account_no)) {
            Map<String, Object> newuser = new HashMap<>();
            newuser.put("name",name);
            newuser.put("PIN", PIN);
            newuser.put("email", email);
            users.putIfAbsent(account_no, newuser);

            save_user(users);
        }else{
            System.out.println("failed, user exists");
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println('i');
        create_a_user("User1", "0123", "example2@demo.com");

    }
}
