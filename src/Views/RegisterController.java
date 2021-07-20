/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.Message;
import Models.User;
import Services.CashFlowServices;
import Services.Conexionbd;
import Services.UsersService;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class RegisterController implements Initializable {

    @FXML
    private TextField nameInput;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    private TextField lastnameInput;

    @FXML
    private DatePicker bdInput;

    @FXML
    private TextField emailInput;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private ComboBox<String> comboRol;

    UsersService svc = new UsersService();

    User currentuser = new User();

    Message message = new Message();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initCombox();
    }

    @FXML
    private void onCreateacc(ActionEvent event) {

        String names = nameInput.getText();
        String lastnames = lastnameInput.getText();
        String role = comboRol.getValue();
        LocalDate birthdate = bdInput.getValue();
        String email = emailInput.getText();
        String password = passwordInput.getText();
        boolean isValid = validateFields(names, lastnames, email, password);
        boolean emailValidation = svc.validateRegister(email);
        if (isValid && emailValidation) {
            String date = birthdate.toString();
            User newUser = new User(0, names, lastnames, role, date, email, password);
            try {
                this.currentuser = newUser; //use this to get user created
                svc.createUser(newUser); //user with iD:0 fix
                MainApp.setCurrentUser(newUser);
                redirectToMenu();
            } catch (Exception e) {
                message.RegisterAlert();
            }
        } else if (emailValidation == false) {
            message.emailAlert();
        } else {
            message.ivalidFieldsAlert();
        }
        clearForm();

    }

    @FXML
    private void onLogIn(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Login.fxml"));
            Parent root = loader.load();
            LoginController controller = loader.getController();
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
    
    public void redirectToMenu(){
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
    
    public User getCurrentuser() {
        return currentuser;
    }

    public void setCurrentuser(User currentuser) {
        this.currentuser = currentuser;
    }

    public void initCombox() {
        CashFlowServices cfsvc = new CashFlowServices();
        ObservableList<String> roles = cfsvc.getRoles();
        this.comboRol.setItems(roles);
        this.comboRol.setValue("Director de Finanzas");
        this.bdInput.setValue(LocalDate.now());
        //Localdate investigar
    }

    public boolean validateFields(String names, String lastnames, String email, String pass) {
        return !(names.equals("") || names.equals(" ") || lastnames.equals("") || lastnames.equals(" ")
                || email.equals("") || email.equals(" ") || email.contains(" ") || pass.equals("") || pass.equals(" ") || pass.contains(" "));
    }

    public void clearForm() {
        nameInput.clear();
        lastnameInput.clear();
        comboRol.getEditor().clear();
        this.bdInput.setValue(LocalDate.now());
        emailInput.clear();
        passwordInput.clear();
    }

}
