package com.example.banking_atm;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;
import java.io.File;
public class model {
    public static Map readjson() throws IOException{
//      This line creates a ObjectMapper object - This allows us to convert a json object to a hash map
        ObjectMapper objectMapper = new ObjectMapper();

//      hashmap(key:str,val:Obj) var  objectmapper reads value from ----the---`data.json` file, further specifies its a hash map

        return objectMapper.readValue(new File("data.json"), Map.class);
    }

    public static class UserTable{
        public static Map<String, Object> fetchUsers() throws IOException {
            var data = readjson();
            var userobj = data.get("users");
            return new LinkedHashMap<>((Map<? extends String, ?>) userobj);
        }

        public static Map<String, Object> fetch_a_user(String account_no) throws IOException {
            var users = fetchUsers();
            return new LinkedHashMap<>((Map<? extends String, ?>) users.get(account_no));
        }

        public static String fetchuserKey(String userinfo) throws IOException {
            var users = fetchUsers();
            for (Map.Entry<String, Object> entry : users.entrySet()) {
                HashMap<String, Object> innerMap = (HashMap<String, Object>) entry.getValue();
                for (Map.Entry<String, Object> innerEntry : innerMap.entrySet()) {
//                System.out.println("  Inner Key: " + innerEntry.getKey() + ", Value: " + innerEntry.getValue());
                    if (innerEntry.getKey().equals("name")) {
                        if (innerEntry.getValue().equals(userinfo)) {
                            System.out.println("User Exists");
                            return entry.getKey();
                        }
                    }
                }
            }
            return "doesn't exists";
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

        //  checks if name exists in users table
        static boolean nameExists(String userinfo) throws IOException {
            var users = fetchUsers();
            for (Map.Entry<String, Object> entry : users.entrySet()) {
                HashMap<String, Object> innerMap = (HashMap<String, Object>) entry.getValue();
                for (Map.Entry<String, Object> innerEntry : innerMap.entrySet()) {
//                System.out.println("  Inner Key: " + innerEntry.getKey() + ", Value: " + innerEntry.getValue());
                    if (innerEntry.getKey().equals("name")){
                        if (innerEntry.getValue().equals(userinfo)){
                            System.out.println("User Exists");
                            System.out.println(innerEntry.getValue());
                            return true;
                        }
                        else {
                            System.out.println("Error........");
                        }
                    }
                }
            }
            return false;
        }

        //  checks for any given data exists in any given column
        static boolean dataUserExists(String column, String userinfo) throws IOException {
            var users = UserTable.fetchUsers();
            for (Map.Entry<String, Object> entry : users.entrySet()) {
                HashMap<String, Object> innerMap = (HashMap<String, Object>) entry.getValue();
                for (Map.Entry<String, Object> innerEntry : innerMap.entrySet()) {
//                System.out.println("  Inner Key: " + innerEntry.getKey() + ", Value: " + innerEntry.getValue());
                    if (innerEntry.getKey().equals(column)){

                        if (innerEntry.getValue().equals(userinfo)){
                            System.out.println("User Exists");
                            System.out.println(innerEntry.getValue());
                            return true;
                        }
                        else {
                            System.out.println("Error........");
                        }
                    }
                }
            }
            return false;
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

        public static boolean changePin(String account_no, String newPIN) throws IOException {
            Map<String, Object> users = fetchUsers();
            if (!users.containsKey(account_no)) {
                System.out.println("User not found");
                return false ;
            }
            Map<String, Object> user = (Map<String, Object>) users.get(account_no);

            if (newPIN != null && !newPIN.isEmpty()) {user.put("PIN", newPIN);}


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
                FinancesTable.create_a_finance(account_no);
                save_user(users);
                System.out.println("Successful");
            }else{
                System.out.println("failed, user exists");
            }
        }

    }

    public class FinancesTable{

        public static Map<String, Object> fetchFinances() throws IOException {
            var data = readjson();
            Map<String, Object> financeobj = new LinkedHashMap<>((Map<? extends String, ?>) data.get("finances"));
            return financeobj;
        }

        public static Map<String, Object> fetch_a_finance(String account_no) throws IOException {
            var financeobj = fetchFinances();
            Map<String, Object> finance = new LinkedHashMap<>((Map<? extends String, ?>) financeobj.get(account_no));
            return finance;
        }

        public static void save_finances(Map<String, Object> finances) throws IOException {
            var data = readjson();
            data.put("finances", finances);
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("data.json"),data);
        }

        public static void delete_a_finance(String account_no) throws IOException {
            var finances = fetchFinances();
            if(finances.containsKey(account_no)){
                finances.remove(account_no);
                save_finances(finances);
            }
            else{
                System.out.println("Datapoint doesn't exist\n");
            }
            System.out.println("Cleared, remaining" + finances + "\n");

        }

        public static void create_a_finance(String account_no) throws IOException {
            var finances = fetchFinances();
            if(!finances.containsKey(account_no) && UserTable.fetchUsers().containsKey(account_no)){
                Map<String, Object> newfinance = new HashMap<>();
                newfinance.put("balance", "GHC 0000");
                newfinance.put("time_logs", new ArrayList<>());
                newfinance.put("withdrawals", new ArrayList<>());
                newfinance.put("deposit", new ArrayList<>());
                finances.putIfAbsent(account_no, newfinance);
                System.out.println(finances);
                save_finances(finances);
            }
        }

        public static void create_a_finance(String account_no,String balance){

        }

        public static void create_a_finance(String account_no,String balance, String time_logs, String withdrawals){

        }
    }

    public class Session{
        
    }
    public static void main(String[] args) throws IOException {
        File session = new File("session.json");
    }
}
