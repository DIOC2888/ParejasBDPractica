package org.example.practicaparejasbd.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.practicaparejasbd.connection.DatabaseConnection;
import org.example.practicaparejasbd.model.Empleado;

import java.sql.*;
import java.time.LocalDate;

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
    private ComboBox<String> cmbDepartamento;
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
        cmbDepartamento.getItems().addAll(
                "Recursos Humanos",
                "Finanzas",
                "Tecnología",
                "Marketing"
        );
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
    if (!validarFormulario())
    {
        return;
    }

        String sql = "INSERT INTO empleado (nombres, apellidos, cedula, correo, " +
                "telefono, cargo, departamento, salario, fechaContratacion, estado) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setString(1, txtNombres.getText());
            statement.setString(2, txtApellidos.getText());
            statement.setString(3, txtCedula.getText());
            statement.setString(4, txtCorreo.getText());
            statement.setString(5, txtTelefono.getText());
            statement.setString(6, cmbCargo.getValue());
            statement.setString(7, cmbDepartamento.getValue());
            statement.setDouble(8, Double.parseDouble(txtSalario.getText()));
            statement.setDate(9, Date.valueOf(dtpFechaContratacion.getValue()));
            statement.setString(10, cmbEstado.getValue());
            statement.execute();

        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    public void clickLimpiar(ActionEvent actionEvent) {
        txtNombres.clear();
        txtApellidos.clear();
        txtCedula.clear();
        txtCorreo.clear();
        txtTelefono.clear();
        txtSalario.clear();
        cmbCargo.setValue(null);
        cmbDepartamento.setValue(null);
        cmbEstado.setValue(null);
        dtpFechaContratacion.setValue(null);
    }

    public void clickCargar(ActionEvent actionEvent) {
        empleado.clear();
        String sql = "SELECT * FROM empleado";

        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
        ){
            while(resultSet.next()){
                Empleado empleado = new Empleado();
                empleado.setId(resultSet.getInt("id"));
                empleado.setNombres(resultSet.getString("nombres"));
                empleado.setApellidos(resultSet.getString("apellidos"));
                empleado.setCedula(resultSet.getString("cedula"));
                empleado.setCorreo(resultSet.getString("correo"));
                empleado.setTelefono(resultSet.getString("telefono"));
                empleado.setCargo(resultSet.getString("cargo"));
                empleado.setDepartamento(resultSet.getString("departamento"));
                empleado.setSalario(resultSet.getDouble("salario"));
                empleado.setFechaContratacion(resultSet.getDate("fechaContratacion").toLocalDate());
                empleado.setEstado(resultSet.getString("estado"));
                this.empleado.add(empleado);
            }
            mostrarAlerta(
                    Alert.AlertType.INFORMATION,
                    "Carga de Datos",
                    "Datos Cargados Correctamente",
                    "Se han cargado los datos de la base de datos correctamente."
            );
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }


    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String encabezado, String mensaje){

        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(mensaje);
        alert.showAndWait();

    }

    @FXML
    private boolean validarFormulario() {

        if (txtNombres.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtCedula.getText().isEmpty() || txtCorreo.getText().isEmpty()
                || cmbDepartamento.getValue() == null || txtTelefono.getText().isEmpty() || txtSalario.getText().isEmpty() || cmbCargo.getValue() == null || cmbEstado.getValue() == null)
        {

            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Registro Incompleto",
                    "Datos Faltantes del registro",
                    "Le faltan campos por llenar.\nPor favor, verifique de nuevo."
            );

            return false;
        }

        return true;
    }


}


