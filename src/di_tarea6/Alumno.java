/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_tarea6;

/**
 * Esta clase genera los alumnos que despues usaremos para generar los informes
 * @author Víctor Gallego Cabezas
 * @version 2.0
 * */

public class Alumno {
    
    /**
     * Dni del alumno
     */
    private String dni;
    
    /**
     * Provincia de residencia del alumno
     */
    private String provincia;
    
    /**
     * Modulo en el que esta matriculado
     */
    private String modulo;
    
    /**
     * Nota obtenida por el alumno
     */
    private double nota;

    /**
     * Constructor para la clase Alumno
     * @param dni Dni del alumno
     * @param modulo Modulo en el que esta matriculado
     * @param provincia Provincia de residencia del alumno
     * @param nota Nota obtenida por el alumno
     */
    public Alumno(String dni, String modulo, String provincia, double nota) {
        this.dni = dni;
        this.modulo = modulo;
        this.provincia = provincia;
        this.nota = nota;
    }
    
    /**
     * Método para obtener el dni del alumno
     * @return String El dni del alumno
     */
    public String getDni() {
        return dni;
    }

    /**
     * Método para obtener la provicia del alumno
     * @return String La provicia del alumno
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Método para obtener el módulo en donde esta matriculado el alumno
     * @return String El módulo en donde esta matriculado el alumno
     */
    public String getModulo() {
        return modulo;
    }

    /**
     * Método para obtener la nota del alumno
     * @return double La nota del alumno
     */
    public double getNota() {
        return nota;
    }
    
    
    
         
    
}
