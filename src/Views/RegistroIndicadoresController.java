/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.Message;
import Models.Registro;
import Services.CashFlowServices;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;


public class RegistroIndicadoresController implements Initializable {

    @FXML
    private ComboBox<Integer> cobroCombo;
    
    @FXML
    private TextField cobroRazonInput;
    
    @FXML
    private TextField montoCobroInput;
    
    @FXML
    private Button addCobro;
    
    @FXML
    private Text CurrentUserName;
    
    @FXML
    private Text CurrentUserRole;
    
    @FXML
    private Region onBacking;
    
    @FXML
    private ImageView onBack;
    
    @FXML
    private ComboBox<Integer> pagoCombo;
    
    @FXML
    private TextField pagoRazonInput;
    
    @FXML
    private TextField montoPagoInput;
    
    @FXML
    private Button addPago;
    
    @FXML
    private ComboBox<Integer> bancosCombo;
    
    @FXML
    private TextField pagoBancoInput;
    
    @FXML
    private TextField montoBancoInput;
    
    @FXML
    private Button addBanco;
    
    @FXML
    private Button Salir;
    
    @FXML
    private ComboBox<String> comboMes;
    
    ObservableList<String> meses = FXCollections.observableArrayList();

    CashFlowServices svc = new CashFlowServices();
    LocalDate month;
    Message alert = new Message();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	initMES();
    	this.CurrentUserName.setText(MainApp.getCurrentUser().getNombres()+ " "+ MainApp.getCurrentUser().getApellidos());
    	this.CurrentUserRole.setText(MainApp.getCurrentUser().getRol());
        initCombox();
        this.comboMes.setValue("Noviembre");
        this.comboMes.setItems(meses);
    }

    @FXML
    private void onAddCobro(ActionEvent event) {

        int noSemana = this.cobroCombo.getValue();
        String mes = comboMes.getValue();
        String razon = this.cobroRazonInput.getText();
        String monto = this.montoCobroInput.getText();
        String tipo = "Cobro";
        boolean isValid = validateRegister(razon, monto);
        if (isValid) {
            Registro newRegistro = new Registro(noSemana, mes, razon, Double.parseDouble(monto), tipo);
            this.svc.createRegister(newRegistro);
            clearFields();
        } else {
            alert.ivalidFieldsAlert();
        }

    }
    
    public void initMES(){
        this.meses.add("Noviembre");
        this.meses.add("Diciembre");
        this.meses.add("Enero");
        this.meses.add("Febrero");
        this.meses.add("Marzo");
        this.meses.add("Abril");
        this.meses.add("Mayo");
        this.meses.add("Junio");
        this.meses.add("Julio");
        this.meses.add("Agosto");
        this.meses.add("Septiembre");
        this.meses.add("Octubre");
    }

    @FXML
    private void backToMenuReg(MouseEvent event) {
        RouterMenu();
    }

    @FXML
    private void backToMenu(MouseEvent event) {
        RouterMenu();
    }

    @FXML
    private void onAddPago(ActionEvent event) {
        int noSemana = this.pagoCombo.getValue();
        String mes = comboMes.getValue();
        String razon = this.pagoRazonInput.getText();
        String monto = this.montoPagoInput.getText();
        String tipo = "Pago";
        boolean isValid = validateRegister(razon, monto);
        if (isValid) {
            Registro newRegistro = new Registro(noSemana, mes, razon, Double.parseDouble(monto), tipo);
            this.svc.createRegister(newRegistro);
            clearFields();
        } else {
            alert.ivalidFieldsAlert();
        }
    }

    @FXML
    private void onAddBanco(ActionEvent event) {
        int noSemana = this.bancosCombo.getValue();
        String mes = comboMes.getValue();
        String razon = this.pagoBancoInput.getText();
        String monto = this.montoBancoInput.getText();
        String tipo = "Banco";
        boolean isValid = validateRegister(razon, monto);
        if (isValid) {
            Registro newRegistro = new Registro(noSemana, mes, razon, Double.parseDouble(monto), tipo);
            this.svc.createRegister(newRegistro);
            clearFields();
        } else {
            alert.ivalidFieldsAlert();
        }
    }

    public void clearFields() {
        this.cobroRazonInput.setText("");
        this.montoCobroInput.setText("");
        this.pagoRazonInput.setText("");
        this.montoPagoInput.setText("");
        this.montoBancoInput.setText("");
        this.pagoBancoInput.setText("");
    }

    public void initCombox() {
        ObservableList<Integer> semanas = this.svc.getweeks();
        this.pagoCombo.setItems(semanas);
        this.cobroCombo.setItems(semanas);
        this.bancosCombo.setItems(semanas);
        this.pagoCombo.setValue(1);
        this.cobroCombo.setValue(1);
        this.bancosCombo.setValue(1);
    }

    public boolean validateRegister(String razon, String monto) {
        return !(razon.equals("") || razon.equals(" ") || monto.equals(" ") || monto.equals("") || monto.contains("a"));
    }

    public void validateSuperUser() {

    }

    public void RouterMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/MenuIndicadores.fxml"));
            Parent root = loader.load();
            MenuIndicadoresController controller = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.setTitle("CashFlow App");
            stage.show();
            //stage.setOnCloseRequest(e -> controller.closeWindow());
            Stage myStage = (Stage) this.pagoCombo.getScene().getWindow();
            myStage.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @FXML
    void OnMouseClickedSalir(MouseEvent event) {
    	System.exit(1);
    }
}
