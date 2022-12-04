/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author Lazaro
 */
 public class ErrorEntradaNoValida extends Exception {
    public ErrorEntradaNoValida(){
        super("Ha introducido una opcion no valida.");
    }
 }