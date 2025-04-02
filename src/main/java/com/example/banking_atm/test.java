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

        return data;
    }

    public static Map<String, Object> fetchUsers() throws IOException {
        var data = readjson();
        var userobj = data.get("users");
        Map<String, Object> users = new LinkedHashMap<>((Map<? extends String, ?>) userobj);
        return users;
    }

    public static Map<String, Object> fetch_a_user(String account_no) throws IOException {
        var users = fetchUsers();
        Map<String, Object> user = new LinkedHashMap<>((Map<? extends String, ?>) users.get(account_no));
        return user;
    }

    public static void delete_a_user(String account_no) throws IOException {
        var users = fetchUsers();
        if(users.containsKey(account_no)){
            users.remove(account_no);
            save_user(users);
        }else{
            System.out.println("User doesn't exist\n");
        }
        System.out.println("Cleared, remaining" + users + "\n");
    }

    public static void save_user(Map<String, Object> users) throws IOException {
        var data = readjson();
        data.put("users", users);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("data.json"),data);
    }

    public static boolean edit_user(String account_no, String newName, String newPIN, String newEmail) throws IOException {
        Map<String, Object> users = fetchUsers();
        if (!users.containsKey(account_no)) {
            System.out.println("User not found");
            return false ;
        }
        Map<String, Object> user = (Map<String, Object>) users.get(account_no);
        if (newName != null && !newName.isEmpty()) {user.put("name", newName);}
        if (newPIN != null && !newPIN.isEmpty()) {user.put("PIN", newPIN);}
        if (newEmail != null && !newEmail.isEmpty()) {user.put("email", newEmail);}

        save_user(users);
        System.out.println("User Updated Successfully");
        return true;
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
            System.out.println("Successful");
        }else{
            System.out.println("failed, user exists");
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println('i');

        boolean result = edit_user("340094", "User 2", "1253","user2email@example.com");
        if (result) {
            Map<String, Object> users = fetchUsers();
            Map<String, Object> user = (Map<String, Object>) users.get("340094");
            System.out.println("Updated User: " + user);
        }
        else{
            System.out.println("failed");
        }

    }
}
