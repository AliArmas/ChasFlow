/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.Message;
import Models.User;
import Services.UsersService;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class LoginController implements Initializable {

    private Label label;
    @FXML
    private TextField emailInput;
    @FXML
    private PasswordField passwordInput;
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;

    Message message = new Message();

    UsersService svc = new UsersService();

    ArrayList<User> users = new ArrayList<>();

    User currentuser = new User();

    private void handleButtonAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void onLogin(ActionEvent event) {
        String email = emailInput.getText();
        String pass = passwordInput.getText();
        boolean isValid = validateFields(email, pass);
        if (isValid) {
            try {
                this.currentuser = this.svc.validateLogin(email, pass);
                if (this.currentuser == null) {
                    message.loginAlert();
                } else if(this.currentuser != null) {
                    MainApp.setCurrentUser(this.currentuser);
                    redirectToMenu();
                }
            } catch (Exception e) {
                message.loginAlert();
            }
        } else {
            message.ivalidFieldsAlert();
        }
    }

    @FXML
    private void onRegister(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Register.fxml"));
            Parent root = loader.load();
            RegisterController controller = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.setMaximized(true);
            stage.setTitle("CashFlow App");
            stage.show();
            //stage.setOnCloseRequest(e -> controller.closeWindow());
            Stage myStage = (Stage) this.registerButton.getScene().getWindow();
            myStage.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void closeWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Register.fxml"));
            Parent root = loader.load();
            RegisterController controller = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();
            //stage.setOnCloseRequest(e -> controller.closeWindow());

            Stage myStage = (Stage) this.loginButton.getScene().getWindow();
            myStage.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void redirectToMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/MainMenu.fxml"));
            Parent root = loader.load();
            MainMenuContoller controller = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.setMaximized(true);
            stage.setTitle("CashFlow App");
            stage.show();
            //stage.setOnCloseRequest(e -> controller.closeWindow());
            Stage myStage = (Stage) this.loginButton.getScene().getWindow();
            myStage.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean validateFields(String email, String pass) {
        return !(email.equals("") || email.equals(" ") || email.contains(" ") || pass.equals("") || pass.equals(" ") || pass.contains(" "));
    }

    public User getCurrentuser() {
        return currentuser;
    }

    public void setCurrentuser(User currentuser) {
        this.currentuser = currentuser;
    }

}
