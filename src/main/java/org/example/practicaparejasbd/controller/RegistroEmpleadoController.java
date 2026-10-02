package org.example.practicaparejasbd.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class RegistroEmpleadoController {
    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtTelefono;
    @FXML
    private ComboBox<String> cmbCargo;
    @FXML
    private TextField txtDepartamento;
    @FXML
    private TextField txtSalario;
    @FXML
    private DatePicker dtpFechaContratacion;
    @FXML
    private ComboBox<String> cmbEstado;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnLimpiar;
    @FXML
    private Button btnCargar;


    public void clickGuardar(ActionEvent actionEvent) {
    }

    public void clickLimpiar(ActionEvent actionEvent) {
    }

    public void clickCargar(ActionEvent actionEvent) {
    }
}
