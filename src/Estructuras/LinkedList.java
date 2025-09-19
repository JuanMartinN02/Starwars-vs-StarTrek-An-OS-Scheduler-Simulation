/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Windows 10
 */
public class LinkedList<T> {

    
    
    private int size; 
    private Node<T> pFirst; 

    public LinkedList() {
        this.size = 0; 
    }
    
   
    
    
    public boolean isEmpty(){
        // me va a decir si la lista esta vacia 
        return pFirst == null; 
    }
    
    public void appendLast(T data){
        // voy a agregar a la lista de primero 
        Node nodo = new Node(data); 
        if (isEmpty()) {
            pFirst = nodo; 
           
        }else{
            Node aux = pFirst; 
            while(aux.getpNext() != null){
                aux = aux.getpNext(); 
            }aux.setpNext(nodo);
            
        }size ++; 
        
    }
    
    public void appendFirst(T data){
        // voy a gregar a la lista de ultimo
        Node nodo = new Node(data); 
        if(isEmpty()){
            pFirst = nodo;  
            size ++; 
        }else{
            Node aux; 
            aux = pFirst; 
            nodo.setpNext(aux); 
            pFirst = nodo;  
        }
        size ++; 
    }
    
       
    
    public void print(){
        // voy a imprimir la lista 
        String string = "";
        Node aux; 
        aux = pFirst; 
        while(aux != null){
            string += aux.getData() + "->"; 
            aux = aux.getpNext();
        }string += "//"; 
        System.out.println(string); 
    }
    
  
    public boolean exists(T data){
        // te dice si existe o no un objeto en la lista
        boolean found = false; 
        if (isEmpty()) {
            return found;   
        }else{
            Node aux; 
            aux = pFirst; 
            while(aux != null && found != true){
                if (aux.getData() == data) {
                    found = true; 
                }else{
                    aux = aux.getpNext(); 
                }
            }
        }
        return found; 
    }
    
    
    public Node deleteFirst(){
        //elimina al comienzo de la lista 
        Node aux = pFirst; 
        Node ret = this.pFirst; 
        if (!isEmpty()) {
            if (size == 1) {
                pFirst = null;  
            }else{
                pFirst = aux.getpNext(); 
            }
          size --;   
        }
        return ret; 
        
    }
    
    
    public void deleteLast(){
        //elimina el nodo al final de la lista
        if (isEmpty()) {// no hay nada que eliminar
            System.out.println("La lista está vacia. Por ende, no se borró nada");  
        }else{
            if (size == 1) {// solo hay 1 elemento en la lista
                pFirst = null; 
                size --;  
                System.out.println("Se logró eliminar con exito el nodo.");  
            }else{
                Node aux = pFirst; 
                while(aux.getpNext().getpNext() != null){
                    aux = aux.getpNext();
                }aux.setpNext(null); 
                size --;  
                System.out.println("Se logró eliminar con exito el nodo."); 
            }
        }
        
    }
    // REVISAR!

    
    public void appendIn(int i, T  data){
         
        if (this.isEmpty()) {// agrego al comienzo de la lista 
            this.appendFirst(data);
            System.out.println("La posición que colocó no existe ya que la lista está vacía. Sin embargo, se insertó el nodo al comienzo de la lista.");
        }else if(i == 0){
            this.appendFirst(data);
        }else if(i == this.size ){
            this.appendLast(data);
        }else if(i > this.size){
            this.appendLast(data);
            System.out.println("La posición que colocó no existe, sin embargo, se insertó el nodo al final de la lista");
        }else{// la posición si existe
           Node aux = this.pFirst; 
           int counter = 0; 
           while(counter +1 != i){
               counter ++; 
               aux = aux.getpNext(); 
           }Node node = new Node(data); 
           Node next = aux.getpNext(); 
           aux.setpNext(node);
           node.setpNext(next);
           this.size ++; 
        }
    }
    
 
    
    public void appendInOrderString(T data){
        if(this.isEmpty()){
            this.appendFirst(data);
        }else if(0<=((String)this.pFirst.getData()).compareToIgnoreCase((String)data)){// el primero es mayor al dato
            this.appendFirst(data); 
        }else if(this.size ==2){
            this.appendLast(data); 
        }else if(0 >((String)this.getLast().getData()).compareToIgnoreCase((String)data)){
            this.appendLast(data);
        }else{
            int counter = 0; 
            Node aux = this.pFirst;
            boolean found = false; 
            while(!found){
                if (((String) aux.getData()).compareToIgnoreCase((String)data) > 0) { 
                    found = true; 
                }counter ++; 
                aux = aux.getpNext(); 
            }this.appendIn(counter-1, data);
            this.size ++; 
            
        }
    }
    
            
    
    public Node getLast(){
        Node aux = null; 
        if (this.isEmpty()) {
            return aux; 
            
        }else if(size ==1){
            return pFirst; 
        }else{
            aux = pFirst; 
            while(aux.getpNext()!= null){
                aux = aux.getpNext(); 
            }
        }
        return aux; 
    }
    
    public void deleteIn(int i){
        // elimina en una posicion determinada. Tomando en cuenta que la primera posicion es 0 y -1 es la ultima posicion
        if (isEmpty() || i>(size -1) || i< -1) {
           System.out.println("Esa posición no existe");  
        }else if(i == -1 || i == (size -1)){
            deleteLast(); 
        }else{// la posicion existe y la tengo que eliminar
            int contador = 1; 
            Node aux1= pFirst;
            Node aux2; 
            while(contador != i){
                aux1 = aux1.getpNext();     
            }aux2 = aux1.getpNext().getpNext();
            aux1.setpNext(aux2); 
            size --; 
        }
    }
  
    public int findIndex(T data){
        // me retorna el indice (empieza en 0). Si no lo encuentra me retorna -1
        if (isEmpty()) {
            return -1; 
        }else{
            Node aux = pFirst; 
            int contador = 0;
            while(aux != null){
                if (aux.getData() == data) {
                    return contador;   
                }else{
                    aux = aux.getpNext(); 
                }
        }
            return -1;
        }
         
    }
    
  
    public void deleteData(T data){
//         eliminar de la lista cuando se pasa por parametro el dato      
        boolean exists = exists(data); 
        boolean deleted = false; 
        if (!exists) {// no tengo nada que borrar
            System.out.println("No se encuentra en la lista, por ende, no se elimino");
        }else{
            if (isEmpty()) {
                System.out.println("La lista está vacia por ende no se puede eliminar lo pedido");   
            }else{
                Node aux; 
                aux = pFirst; 
                if (pFirst.getData() == data) {// quiere decir que es el primero
                    deleteFirst(); 
                }else{ // está en otra posición de la lista
                    while(!deleted){
                        if (aux.getpNext().getData() == data) {// se encontro
                            Node aux2 = aux.getpNext().getpNext(); 
                            aux.setpNext(aux2);
                            deleted = true;
                            System.out.println("Se elimino el nodo con exito!"); 
                        } else{
                            aux = aux.getpNext(); 
                        } 
                    }
                  size --;   
                }
                    
            }
        } 
        
    }
    
    
    public void reverse(){
        Node node = this.deleteFirst(); 
        if(node !=null){
            this.reverse(); 
            this.appendLast((T)node.getData());
        }
 
    }
    
    public LinkedList makeCopy(){
        LinkedList copy = new LinkedList(); 
        if(!this.isEmpty()){
            Node aux = this.pFirst; 
            while(aux!= null){
                copy.appendLast(aux.getData());
                aux = aux.getpNext(); 
            }
        }
        return copy; 
    }
    
    
    public boolean esPalindromo(){
        LinkedList original = this.makeCopy(); 
        this.reverse();
        boolean es = true; 
        if (!this.isEmpty()) {
            Node auxOriginal = original.getpFirst(); 
            Node auxReverse = this.pFirst; 
            while(auxOriginal != null && auxReverse != null){
                if (!auxOriginal.getData().equals(auxReverse.getData())) {
                    es = false; 
                    return es; 
                }auxOriginal = auxOriginal.getpNext(); 
                auxReverse = auxReverse.getpNext(); 
            }
        }
        return es; 
    }
    
    public void sortInt(){
        Node node = this.deleteFirst(); 
        if(node != null){
            this.sortInt();
        }
        
    }
    
    public void sortStr(){
        Node node = this.deleteFirst(); 
        if(node != null){
            this.sortStr(); 
            this.appendInOrderString((T) node.getData());
        }
            
    }
    
    
    public boolean existe(String name){
        boolean e = false; 
        if(this.isEmpty()){
            return e; 
        }else{
            Node aux = this.pFirst; 
            while(aux != null){
                if (((String)aux.getData()).equals(name)) {
                   e = true; 
                   return e; 
                }
                aux = aux.getpNext(); 
            }
        }
        return e; 
    }
    
    
    public void appendLastNode(Node nodo){
        if(this.isEmpty()){
            this.pFirst = nodo; 
            this.size ++; 
        }else{
            Node aux = this.pFirst; 
            while(aux.getpNext() != null){
                aux = aux.getpNext(); 
            }aux.setpNext(nodo);
            this.size ++; 
        }
    }


    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the pFirst
     */
    public Node getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(Node pFirst) {
        this.pFirst = pFirst;
    }

    
    
    
    
}
