//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.banking_atm;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class JSONDatabase {
    public JSONDatabase() {
    }

    public static Map readjson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return (Map)objectMapper.readValue(new File("data.json"), Map.class);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("j");
        JSONDatabase.FinancesTable.fetch_a_finance("template-user-account_no");
        JSONDatabase.FinancesTable.create_a_finance("340094");
    }

    public static class UserTable {
        public UserTable() {
        }

        public static Map<String, Object> fetchUsers() throws IOException {
            Map data = JSONDatabase.readjson();
            Object userobj = data.get("users");
            return new LinkedHashMap((Map)userobj);
        }

        public static Map<String, Object> fetch_a_user(String account_no) throws IOException {
            Map<String, Object> users = fetchUsers();
            return new LinkedHashMap((Map)users.get(account_no));
        }

        public static String fetchuserKey(String userinfo) throws IOException {
            Map<String, Object> users = fetchUsers();

            for(Map.Entry<String, Object> entry : users.entrySet()) {
                HashMap<String, Object> innerMap = (HashMap)entry.getValue();

                for(Map.Entry<String, Object> innerEntry : innerMap.entrySet()) {
                    if (((String)innerEntry.getKey()).equals("name") && innerEntry.getValue().equals(userinfo)) {
                        System.out.println("User Exists");
                        return (String)entry.getKey();
                    }
                }
            }

            return "doesn't exists";
        }

        public static void delete_a_user(String account_no) throws IOException {
            Map<String, Object> users = fetchUsers();
            if (users.containsKey(account_no)) {
                users.remove(account_no);
                save_user(users);
            } else {
                System.out.println("User doesn't exist\n");
            }

            System.out.println("Cleared, remaining" + String.valueOf(users) + "\n");
        }

        public static void save_user(Map<String, Object> users) throws IOException {
            Map data = JSONDatabase.readjson();
            data.put("users", users);
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("data.json"), data);
        }

        static boolean nameExists(String userinfo) throws IOException {
            Map<String, Object> users = fetchUsers();

            for(Map.Entry<String, Object> entry : users.entrySet()) {
                HashMap<String, Object> innerMap = (HashMap)entry.getValue();

                for(Map.Entry<String, Object> innerEntry : innerMap.entrySet()) {
                    if (((String)innerEntry.getKey()).equals("name")) {
                        if (innerEntry.getValue().equals(userinfo)) {
                            System.out.println("User Exists");
                            System.out.println(innerEntry.getValue());
                            return true;
                        }

                        System.out.println("Error........");
                    }
                }
            }

            return false;
        }

        static boolean dataUserExists(String column, String userinfo) throws IOException {
            Map<String, Object> users = fetchUsers();

            for(Map.Entry<String, Object> entry : users.entrySet()) {
                HashMap<String, Object> innerMap = (HashMap)entry.getValue();

                for(Map.Entry<String, Object> innerEntry : innerMap.entrySet()) {
                    if (((String)innerEntry.getKey()).equals(column)) {
                        if (innerEntry.getValue().equals(userinfo)) {
                            System.out.println("User Exists");
                            System.out.println(innerEntry.getValue());
                            return true;
                        }

                        System.out.println("Error........");
                    }
                }
            }

            return false;
        }

        public static boolean edit_user(String account_no, String newName, String newPIN, String newEmail) throws IOException {
            Map<String, Object> users = fetchUsers();
            if (!users.containsKey(account_no)) {
                System.out.println("User not found");
                return false;
            } else {
                Map<String, Object> user = (Map)users.get(account_no);
                if (newName != null && !newName.isEmpty()) {
                    user.put("name", newName);
                }

                if (newPIN != null && !newPIN.isEmpty()) {
                    user.put("PIN", newPIN);
                }

                if (newEmail != null && !newEmail.isEmpty()) {
                    user.put("email", newEmail);
                }

                save_user(users);
                System.out.println("User Updated Successfully");
                return true;
            }
        }

        public static void create_a_user(String name, String PIN, String email) throws IOException {
            Map<String, Object> users = fetchUsers();
            int randomy = (int)(Math.random() * (double)1000000.0F + (double)4.0F);
            String account_no = Integer.toString(randomy);
            if (!users.containsKey(account_no)) {
                Map<String, Object> newuser = new HashMap();
                newuser.put("name", name);
                newuser.put("PIN", PIN);
                newuser.put("email", email);
                users.putIfAbsent(account_no, newuser);
                save_user(users);
                System.out.println("Successful");
            } else {
                System.out.println("failed, user exists");
            }

        }
    }

    public class FinancesTable {
        public FinancesTable() {
        }

        public static Map<String, Object> fetchFinances() throws IOException {
            Map data = JSONDatabase.readjson();
            Map<String, Object> financeobj = new LinkedHashMap((Map)data.get("finances"));
            return financeobj;
        }

        public static Map<String, Object> fetch_a_finance(String account_no) throws IOException {
            Map<String, Object> financeobj = fetchFinances();
            Map<String, Object> finance = new LinkedHashMap((Map)financeobj.get(account_no));
            return finance;
        }

        public static void save_finances(Map<String, Object> finances) throws IOException {
            Map data = JSONDatabase.readjson();
            data.put("finances", finances);
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("data.json"), data);
        }

        public static void delete_a_finance(String account_no) throws IOException {
            Map<String, Object> finances = fetchFinances();
            if (finances.containsKey(account_no)) {
                finances.remove(account_no);
                save_finances(finances);
            } else {
                System.out.println("Datapoint doesn't exist\n");
            }

            System.out.println("Cleared, remaining" + String.valueOf(finances) + "\n");
        }

        public static void create_a_finance(String account_no) throws IOException {
            Map<String, Object> finances = fetchFinances();
            if (!finances.containsKey(account_no) && JSONDatabase.UserTable.fetchUsers().containsKey(account_no)) {
                Map<String, Object> newfinance = new HashMap();
                newfinance.put("balance", "GHC 0000"); //should change this to int
                newfinance.put("time_logs", new ArrayList());
                newfinance.put("withdrawals", new ArrayList());
                newfinance.put("deposit", new ArrayList());
                finances.putIfAbsent(account_no, newfinance);
                System.out.println(finances);
                save_finances(finances);
            }

        }

        public static void create_a_finance(String account_no, String balance) {
        }

        public static void create_a_finance(String account_no, String balance, String time_logs, String withdrawals) {
        }
    }
}
