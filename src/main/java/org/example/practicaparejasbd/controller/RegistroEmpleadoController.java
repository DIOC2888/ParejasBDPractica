package org.example.practicaparejasbd.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.practicaparejasbd.model.Empleado;

import java.time.LocalDate;
import java.util.Date;

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

    @FXML
    private TableView<Empleado> tblEmpleado;
    @FXML
    private TableColumn<Empleado, Integer> colID;
    @FXML
    private TableColumn<Empleado, String> colNombres;
    @FXML
    private TableColumn<Empleado, String> colApellidos;
    @FXML
    private TableColumn<Empleado, String> colCedula;
    @FXML
    private TableColumn<Empleado, String> colCorreo;
    @FXML
    private TableColumn<Empleado, String> colTelefono;
    @FXML
    private TableColumn<Empleado, String> colCargo;
    @FXML
    private TableColumn<Empleado, String> colDepartamento;
    @FXML
    private TableColumn<Empleado, Double> colSalario;
    @FXML
    private TableColumn<Empleado, LocalDate> colFechaContratacion;
    @FXML
    private TableColumn<Empleado, String> colEstado;

    private final ObservableList<Empleado> empleado = javafx.collections.FXCollections.observableArrayList();

    public void initialize() {
        configurarTable();
        tblEmpleado.setItems(empleado);
        cmbCargo.getItems().addAll(
                "Gerente",
                "Asistente",
                "Analista",
                "Desarrollador");
        cmbEstado.getItems().addAll(
                "Activo",
                "Inactivo");
    }


    public void configurarTable(){
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombres.setCellValueFactory(new PropertyValueFactory<>("nombres"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        colDepartamento.setCellValueFactory(new PropertyValueFactory<>("departamento"));
        colSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
        colFechaContratacion.setCellValueFactory(new PropertyValueFactory<>("fechaContratacion"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
    }


    public void clickGuardar(ActionEvent actionEvent) {
            Empleado nuevoEmpleado = new Empleado(
                    0,
                    txtNombres.getText(),
                    txtApellidos.getText(),
                    txtCedula.getText(),
                    txtCorreo.getText(),
                    txtTelefono.getText(),
                    cmbCargo.getValue(),
                    txtDepartamento.getText(),
                    Double.parseDouble(txtSalario.getText()),
                    dtpFechaContratacion.getValue(),
                    cmbEstado.getValue()
            );

            empleado.add(nuevoEmpleado);

    }

    public void clickLimpiar(ActionEvent actionEvent) {
    }

    public void clickCargar(ActionEvent actionEvent) {
    }
}
