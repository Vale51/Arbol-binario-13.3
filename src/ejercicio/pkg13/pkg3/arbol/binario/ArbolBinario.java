
package ejercicio.pkg13.pkg3.arbol.binario;


public class ArbolBinario {
    
    protected Nodo raiz;
    public ArbolBinario()
    {
        raiz = null;
    }
    public ArbolBinario(Nodo raiz)
    {
        this.raiz = raiz;
    }
    public Nodo raizArbol()
    {
        return raiz;
    }
    // Comprueba el estatus del árbol
    boolean esVacio()
    {
        return raiz == null;
    }
    
    public static Nodo nuevoArbol(Nodo ramaIzqda, int dato, Nodo ramaDrcha)
    {
        return new Nodo(ramaIzqda, dato, ramaDrcha);
    }
    
    /*public void insertar(int valor){
        if(this.raiz == null){
            this.raiz = new Nodo(valor);
        }
        else{
            this.raiz.insertar(valor);
        }
    }*/
    
    public void dispararPreorden(){
        this.preorden(this.raiz);
    }
    
    public void preorden(Nodo nodo){
        if(nodo == null){
            return; //fin de la recursion, caso base 
        }
        else{
            System.out.println(nodo.valorNodo());
            preorden(nodo.subarbolIzdo());
            preorden(nodo.subarbolDcho());
        }
    }
    
    public void dispararInorden(){
        this.inorden(this.raiz);
    }
    
    public void inorden(Nodo nodo){
        if(nodo == null){
            return; //fin de la recursion, caso base 
        }
        else{
            inorden(nodo.subarbolIzdo());
            System.out.println(nodo.valorNodo());
            inorden(nodo.subarbolDcho());
        }
    }
    
    public void dispararPostorden(){
        this.postorden(this.raiz);
    }
    
    public void postorden(Nodo nodo){
        if(nodo == null){
            return; //fin de la recursion, caso base 
        }
        else{
            postorden(nodo.subarbolIzdo());
            postorden(nodo.subarbolDcho());
            System.out.println(nodo.valorNodo());
        }
    }
    
    public boolean eliminar(int nodo) {
        Nodo aux = raiz;
        Nodo padre = raiz;
        boolean esHijoIzquierdo = true;
        while (aux.dato != nodo) { //BUSCAR EL NODO A ELIMINAR
            padre = aux;
            if (nodo < aux.dato) { //DEBE IRSSE POR EL LADO IZQUIERDO
                esHijoIzquierdo = true;
                aux = aux.subarbolIzdo();
            } else {
                esHijoIzquierdo = false;
                aux = aux.subarbolDcho();
            }
            if (aux == null) { //LLEGO AL FINAL Y NO LO ENCONTRO
                return false;
            }
        }
        if (aux.subarbolIzdo() == null && aux.subarbolDcho() == null) { // el nodo es hoja, no tiene hijos
            if (aux == raiz) { //ES EL UNICO NODO QUE TENEMOS
                raiz = null;
            } else if (esHijoIzquierdo) {
                padre.setRamaDcho(null);
            } else {
                padre.setRamaIzdo(null);
            }
        } else if (aux.subarbolDcho() == null) { // no tiene hijo derecho
            if (aux == raiz) {
                raiz = aux.subarbolIzdo();
            } else if (esHijoIzquierdo) {
                padre.setRamaIzdo(aux.subarbolIzdo());
            } else {
                padre.setRamaDcho(aux.subarbolIzdo());
            }
        } else if (aux.subarbolIzdo() == null) { // no tiene hijo izquierdo
            if (aux == raiz) {
                raiz = aux.subarbolDcho();
            } else if (esHijoIzquierdo) {
                padre.setRamaIzdo(aux.subarbolDcho());
            } else {
                padre.setRamaDcho(aux.subarbolDcho());
            }
        } else { // el nodo tiene 2 hijos 
            Nodo reemplazo = obtenerNodoReemplazo(aux);
            if (aux == raiz) {
                raiz = reemplazo;
            } else if (esHijoIzquierdo) {
                padre.setRamaIzdo(reemplazo);
            } else {
                padre.setRamaDcho(reemplazo);
            }
            reemplazo.setRamaIzdo(aux.subarbolIzdo());
        }
        return true;
    }
    
    public Nodo obtenerNodoReemplazo(Nodo nodoReem) {
        Nodo reemplazoPadre = nodoReem;
        Nodo reemplazo = nodoReem;
        Nodo aux = nodoReem.subarbolIzdo();
        System.out.println("aux: " + aux.valorNodo());
        while (aux != null) {//RECORRER PARA ENCOTRAR CUAL ES EL NODO CANDIDATO A ELIMINAR
            reemplazoPadre = reemplazo;
            System.out.println("reemplazoPadre: " + reemplazoPadre.dato);//avanza hasta llegar al ultimo nodo mas izquierdo 
            reemplazo = aux;
            System.out.println("reemplazo: " + reemplazo.dato);
            aux = aux.subarbolIzdo();
            
        }
        if (reemplazo != nodoReem.subarbolDcho()) {
            reemplazoPadre.setRamaIzdo(reemplazo.subarbolDcho());
            reemplazo.setRamaDcho(nodoReem.subarbolDcho());
        }
        System.out.println("El Nodo REEMPLAZO Es: " + reemplazo.valorNodo());
        return reemplazo;
    }

    
    
    
}
