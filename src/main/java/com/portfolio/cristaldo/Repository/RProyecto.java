/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.cristaldo.Repository;

import com.portfolio.cristaldo.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Paola
 */
public interface RProyecto extends JpaRepository<Proyecto, Integer>{
    Optional<Proyecto> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
