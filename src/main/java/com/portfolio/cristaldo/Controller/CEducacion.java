/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.cristaldo.Controller;

import com.portfolio.cristaldo.Dto.dtoEducacion;
import com.portfolio.cristaldo.Entity.Educacion;
import com.portfolio.cristaldo.Security.Controller.Mensaje;
import com.portfolio.cristaldo.Service.Seducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = {"https://frontend-portfolio-diego.web.app","http://localhost:4200"})
public class CEducacion {
    @Autowired
    Seducacion sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = sEducacion.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
        if(StringUtils.isBlank(dtoeducacion.getNombreEdu())){
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            
        }
        if(sEducacion.existsByNombreEdu(dtoeducacion.getNombreEdu())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
            Educacion educacion = new Educacion(
                    dtoeducacion.getNombreEdu(), dtoeducacion.getDescripcionEdu());
            sEducacion.save(educacion);
            return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
    }
   
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sEducacion.existsByNombreEdu(dtoeducacion.getNombreEdu()) && sEducacion.getByNombreEdu(dtoeducacion.getNombreEdu()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getNombreEdu())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = sEducacion.getOne(id).get();
        educacion.setNombreEdu(dtoeducacion.getNombreEdu());
        educacion.setDescripcionEdu(dtoeducacion.getDescripcionEdu());
        
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    } 
}
