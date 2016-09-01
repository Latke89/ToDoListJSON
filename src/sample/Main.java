package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("To do list");
        primaryStage.setScene(new Scene(root, 445, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
//        Controller myController = new Controller();
//        myController.readList();
        launch(args);
    }
}
