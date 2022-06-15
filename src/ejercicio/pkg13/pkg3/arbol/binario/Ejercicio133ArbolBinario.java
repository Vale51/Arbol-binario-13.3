/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio.pkg13.pkg3.arbol.binario;
import java.util.Scanner;

public class Ejercicio133ArbolBinario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){ //añadido throws Exception
        Scanner sc = new Scanner(System.in);
        
        ArbolBinario arbol = new ArbolBinario();
        Nodo raiz = null;
        
        boolean hayRaiz = false;
        int menu = 1, salir = 1, datoNodoEliminar, menuRecorrido;
        
        while(menu != 0){
            System.out.println("Seleccione una opcion");
            System.out.println("1.Insertar un nodo");
            System.out.println("2.Eliminar un nodo");
            System.out.println("3.Recorrer el arbol");
            menu = sc.nextInt();
            
            
            switch(menu){
                case 1:
                    while(salir!=0){
                        if(!hayRaiz){ //si no hay raiz, se pide un nodo raiz
                            System.out.println("Inserte el nodo raiz");
                            raiz = ArbolBinario.nuevoArbol(null,sc.nextInt(),null);
                            arbol = new ArbolBinario(raiz);
                            hayRaiz = true;
                        }
                        else{
                            System.out.println("Inserte un nodo");
                            raiz.insertar(sc.nextInt());
                        }
                        
                        System.out.println("Desea seguir insertando nodos? Presione 0 para salir");
                        salir = sc.nextInt();
                    }    
                    break;
                
                case 2:
                    System.out.println("Ingrese el nodo a eliminar");
                    datoNodoEliminar = sc.nextInt();
                    arbol.eliminar(datoNodoEliminar);
                    break;
                    
                case 3:    
                    System.out.println("Seleccione una opcion");
                    System.out.println("1.Recorrido preorden");
                    System.out.println("2.Recorrido inorden");
                    System.out.println("3.Recorrido postorden");
                    
                    menuRecorrido = sc.nextInt();
                    
                    switch(menuRecorrido){
                        case 1:
                            arbol.dispararPreorden();
                            break;
                        case 2:
                            arbol.dispararInorden();
                            break;
                        case 3:
                            arbol.dispararPostorden();
                            break;
                    }    
                    break;
            }
        }
    }
}
