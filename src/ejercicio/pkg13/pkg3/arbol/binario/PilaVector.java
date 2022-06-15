/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.pkg13.pkg3.arbol.binario;

import java.util.Vector;
public class PilaVector 
{
    private static final int INICIAL = 19;
    private int cima;
    private Vector listaPila;
    public PilaVector()
    {
        cima = -1;
        listaPila = new Vector(INICIAL);
    }
    public void insertar(Object elemento)throws Exception
    {
        cima++;
        listaPila.addElement(elemento);
    }
    public Object quitar() throws Exception
    {
        Object aux;
        if (pilaVacia())
        {
            throw new Exception ("Pila vacía, no se puede extraer.");
        }
        aux = listaPila.elementAt(cima);
        listaPila.removeElementAt(cima);
        cima--;
        return aux;
    }
    public Object cimaPila() throws Exception
    {
        if (pilaVacia())
        {
            throw new Exception ("Pila vacía, no se puede extraer.");
        }
        return listaPila.elementAt(cima);
    }
    public boolean pilaVacia()
    {
     return cima == -1;
    }
    public void limpiarPila()throws Exception
    {
        while (! pilaVacia())
            quitar();
    }
}

