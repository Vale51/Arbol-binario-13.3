/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.pkg13.pkg3.arbol.binario;

/**
 *
 * @author user
 */
public class Nodo {
    protected int dato;
    protected Nodo izdo;
    protected Nodo dcho;
    
    public Nodo(int valor)
    {
        dato = valor;
        izdo = dcho = null;
    }
    public Nodo(Nodo ramaIzdo, int valor, Nodo ramaDcho)// sobrecarga de constructores
    {
        this(valor); //dato cambiado x valor
        izdo = ramaIzdo;
        dcho = ramaDcho;
    }
    // operaciones de acceso
    public Object valorNodo(){ return dato; } //valor cambiado x dato
    public Nodo subarbolIzdo(){ return izdo; }
    public Nodo subarbolDcho(){ return dcho; }
    public void nuevoValor(int d){ dato = d; }
    public void setRamaIzdo(Nodo n){ izdo = n; }
    public void setRamaDcho(Nodo n){ dcho = n; }
    
    
    public void insertar(int dato){
        if(dato < this.dato){
            if(this.izdo == null){
                this.izdo = new Nodo(dato);
            }
            else{
                this.izdo.insertar(dato);
            }
            
        }
        else{
            if(this.dcho == null){
                this.dcho = new Nodo(dato);
            }
            else{
                this.dcho.insertar(dato);
            }
        }    
    }
    
    public boolean esHoja(){
        return (izdo == null && dcho == null); // si izdo y dcho son null, el nodo es hoja (no tiene hijos)
    }

    public boolean ultimoPadre(){
        return (izdo.izdo == null && dcho == null); // si izdo y dcho son null, el nodo es hoja (no tiene hijos)
    }
    
    
    
}
