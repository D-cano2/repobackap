/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.cristaldo.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {

    @NotBlank
    private String nombreEdu;
    @NotBlank

    private String descripcionEdu;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreEdu, String descripcionEdu) {
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
        
        
    }

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreE(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getDescripcionEdu() {
        return descripcionEdu;
    }

    public void setDescripcionE(String descripcionEdu) {
        this.descripcionEdu = descripcionEdu;
    }
    
    

}
