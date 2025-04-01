package com.example.banking_atm;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;


import java.io.File;
// Now our code has been push to git lets push to github
public class HelloApplication extends Application {
    public static Map<String, Object> readjson() throws IOException{
//      This line creates a ObjectMapper object - This allows us to convert a json object to a hash map
        ObjectMapper objectMapper = new ObjectMapper();


//      hashmap(key:str,val:Obj) var  objectmapper reads value from ----the---`data.json` file, further specifies its a hash map
        Map<String, Object> data = objectMapper.readValue(new File("data.json"), Map.class) ;

//      Prints info to console
        System.out.println("Read JSON: " + data);

        return data;
    }


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
//        Calls read.json
        readjson();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}