/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.listasimple;

import javax.swing.JOptionPane;

/**
 *
 * @author SCIS2-01
 */
public class Listasimple {
       Nodo inicio; 
    Listasimple(){
    inicio=null;
    }
    
    public void insertarInicio(String nombre, int edad, float promedio){
        Nodo nuevo=new Nodo();
        nuevo.setNombre(nombre);
        nuevo.setEdad(edad);
        nuevo.setPromedio(promedio);
        nuevo.setEnlace(null);        
   if(inicio==null){
   JOptionPane.showMessageDialog(null, "La lista esta vacia");   
    inicio=nuevo;      
   }else{       
       nuevo.setEnlace(inicio);
       inicio=nuevo;         
   }}   
    
    public void insertarFinal(String nombre, int edad, float promedio){
        Nodo nuevo=new Nodo();
        nuevo.setNombre(nombre);
        nuevo.setEdad(edad);
        nuevo.setPromedio(promedio);
        nuevo.setEnlace(null);        
   if(inicio==null){
   JOptionPane.showMessageDialog(null, "La lista esta vacia");   
    inicio=nuevo;   
       }
   else{       
       Nodo temporal=inicio;       
       while(temporal.getEnlace()!=null){           
           temporal=temporal.getEnlace();
       
       }
        temporal.setEnlace(nuevo);     
       
   }}   
    
    
    
    
    
    
    
    public void consultar(){    
        Nodo temporal=inicio;        
        if(inicio==null){
   JOptionPane.showMessageDialog(null, "La lista esta vacia");       
        }else{     
            do{            
           JOptionPane.showMessageDialog(null,
                   "Nombre:  "+temporal.getNombre()+" LA EDAD ES :"+
                           temporal.getEdad()+" EL PORMEDIO ES "+temporal.getPromedio());      
           
           temporal=temporal.getEnlace();
                
            }while(temporal!=null);
        
        }
    
        
    }
    
    public void insertarPosicion(String nombre, int edad, float promedio, int posicion) {
    Nodo nuevo = new Nodo();
    nuevo.setNombre(nombre);
    nuevo.setEdad(edad);
    nuevo.setPromedio(promedio);
    
    // Si la posición es 1, inserta al inicio
    if (posicion == 1) {
        nuevo.setEnlace(inicio);
        inicio = nuevo;
        return;
    }
    
    // Recorrer la lista para encontrar la posición
    Nodo temporal = inicio;
    int contador = 1;
    
    // Avanzar hasta la posición anterior
    while (temporal != null && contador < posicion - 1) {
        temporal = temporal.getEnlace();
        contador++;
    }
    
    // Si la posición es inválida (mayor que el tamaño de la lista)
    if (temporal == null) {
        JOptionPane.showMessageDialog(null, "Posición fuera de rango");
        return;
    }
    
    // Insertar el nodo en la posición indicada
    nuevo.setEnlace(temporal.getEnlace());
    temporal.setEnlace(nuevo);
}
    
    public void moverNodoAlFinal(String nombre) {
    if (inicio == null) {
        JOptionPane.showMessageDialog(null, "La lista está vacía");
        return;
    }

    Nodo anterior = null;
    Nodo temporal = inicio;

    // Buscar el nodo con el nombre dado
    while (temporal != null && !temporal.getNombre().equals(nombre)) {
        anterior = temporal;
        temporal = temporal.getEnlace();
    }

    // Si no se encuentra el nombre
    if (temporal == null) {
        JOptionPane.showMessageDialog(null, "El nombre no se encontró en la lista");
        return;
    }

    // Si el nodo ya está al final
    if (temporal.getEnlace() == null) {
        JOptionPane.showMessageDialog(null, "El nodo ya está al final de la lista");
        return;
    }

    // Si el nodo está al inicio
    if (anterior == null) {
        inicio = temporal.getEnlace();
    } else {
        // Eliminar el nodo de su posición actual
        anterior.setEnlace(temporal.getEnlace());
    }

    // Mover el nodo al final
    Nodo ultimo = inicio;
    while (ultimo.getEnlace() != null) {
        ultimo = ultimo.getEnlace();
    }
    ultimo.setEnlace(temporal);
    temporal.setEnlace(null);

    JOptionPane.showMessageDialog(null, "El nodo ha sido movido al final de la lista");
}
    
    public void eliminarPorPosicion(int posicion) {
    if (inicio == null) {
        JOptionPane.showMessageDialog(null, "La lista está vacía");
        return;
    }

    // Si se desea eliminar el primer nodo
    if (posicion == 1) {
        inicio = inicio.getEnlace();
        JOptionPane.showMessageDialog(null, "Nodo eliminado de la posición " + posicion);
        return;
    }

    Nodo temporal = inicio;
    Nodo anterior = null;
    int contador = 1;

    // Recorrer la lista hasta la posición deseada
    while (temporal != null && contador < posicion) {
        anterior = temporal;
        temporal = temporal.getEnlace();
        contador++;
    }

    // Si la posición es inválida
    if (temporal == null) {
        JOptionPane.showMessageDialog(null, "Posición fuera de rango");
        return;
    }

    // Eliminar el nodo en la posición indicada
    anterior.setEnlace(temporal.getEnlace());
    JOptionPane.showMessageDialog(null, "Nodo eliminado de la posición " + posicion);
}
    
    public void eliminarPorDato(String nombre) {
    if (inicio == null) {
        JOptionPane.showMessageDialog(null, "La lista está vacía");
        return;
    }

    boolean encontrado = false;

    // Eliminar nodos con el dato dado del inicio de la lista
    while (inicio != null && inicio.getNombre().equals(nombre)) {
        inicio = inicio.getEnlace();
        encontrado = true;
    }

    // Si la lista estaba llena de nodos con el dato dado
    if (!encontrado && inicio == null) {
        JOptionPane.showMessageDialog(null, "Todos los nodos han sido eliminados");
        return;
    }

    Nodo temporal = inicio;
    Nodo anterior = null;

    // Recorrer la lista para eliminar los nodos con el dato dado
    while (temporal != null) {
        if (temporal.getNombre().equals(nombre)) {
            anterior.setEnlace(temporal.getEnlace());
            encontrado = true;
        } else {
            anterior = temporal;
        }
        temporal = temporal.getEnlace();
    }

    if (encontrado) {
        JOptionPane.showMessageDialog(null, "Nodos con el nombre \"" + nombre + "\" han sido eliminados");
    } else {
        JOptionPane.showMessageDialog(null, "No se encontraron nodos con el nombre \"" + nombre + "\"");
    }
}
    
    public void ordenarPorNombre() {
    if (inicio == null || inicio.getEnlace() == null) {
        JOptionPane.showMessageDialog(null, "La lista no tiene suficientes elementos para ordenar");
        return;
    }

    boolean huboCambio;
    do {
         
        //actual: para rastrear el nodo que estamos comparando.
        //siguiente: es el nodo siguiente al que se está comparando.
        //anterior: rastrea el nodo anterior en caso de que necesitemos intercambiar nodos.
        //huboCambio: se utiliza para verificar si hubo intercambios en cada pasada del ciclo.
        
        Nodo actual = inicio;
        Nodo siguiente = inicio.getEnlace();
        Nodo anterior = null;
        huboCambio = false;

        
        //Usamos un ciclo while para recorrer toda la lista. Si el nombre del nodo actual es mayor (alfabéticamente) que el del nodo siguiente, entonces intercambiamos ambos nodos.
        while (siguiente != null) {
            if (actual.getNombre().compareToIgnoreCase(siguiente.getNombre()) > 0) {
                // Intercambiar nodos
                huboCambio = true;
                if (anterior == null) {
                    // Cambiar el inicio de la lista
                    inicio = siguiente;
                } else {
                    anterior.setEnlace(siguiente);
                }
                actual.setEnlace(siguiente.getEnlace());
                siguiente.setEnlace(actual);
                
                // Actualizar punteros
                anterior = siguiente;
                siguiente = actual.getEnlace();
            } else {
                anterior = actual;
                actual = siguiente;
                siguiente = siguiente.getEnlace();
            }
        }
    } while (huboCambio);

    JOptionPane.showMessageDialog(null, "Lista ordenada alfabéticamente por nombre");
}
    
}
