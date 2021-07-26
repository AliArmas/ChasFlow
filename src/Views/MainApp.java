package Views;

import Models.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    
    Stage RegisterStage, MenuStage;
    public static User CurrentUser = new User();
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("CashFlow App");
        stage.setMaximized(true);
        stage.setTitle("CashFlow App");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);   
    }

    public static User getCurrentUser() {
        return CurrentUser;
    }

    public static void setCurrentUser(User CurrentUser) {
        MainApp.CurrentUser = CurrentUser;
    }
    
}
