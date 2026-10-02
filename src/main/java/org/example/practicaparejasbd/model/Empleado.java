package org.example.practicaparejasbd.model;

import javafx.scene.control.DatePicker;

public class Empleado {
    private int id;
    private String nombres;
    private String appllidos;
    private String cedula, correo, departamento;
    private int telefono;
    private String cargo;
    private Double salario;
    private DatePicker fecha_contratacion;
    private String estado;


    public Empleado(){

    }

    public Empleado(int id, String nombres, String appllidos, String cedula, String correo, String departamento, int telefono, String cargo, Double salario, DatePicker fecha_contratacion, String estado) {
        this.id = id;
        this.nombres = nombres;
        this.appllidos = appllidos;
        this.cedula = cedula;
        this.correo = correo;
        this.departamento = departamento;
        this.telefono = telefono;
        this.cargo = cargo;
        this.salario = salario;
        this.fecha_contratacion = fecha_contratacion;
        this.estado = estado;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getAppllidos() {
        return appllidos;
    }

    public void setAppllidos(String appllidos) {
        this.appllidos = appllidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public DatePicker getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(DatePicker fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
