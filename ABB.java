public class ABB{
    private Nodo raiz;
    ABB(){
        this.raiz = null;
    } 
    public boolean esVacio(){
        return (this.raiz == null); 
    }
    public Nodo getRaiz(){
        return this.raiz;
    }
    public void insertarValor(int valor){
        if (this.raiz == null){
            System.out.println("Insertando raiz: " + valor);
            this.raiz = new Nodo();
            this.raiz.dato = valor;
            this.raiz.izquierdo = null;
            this.raiz.derecho = null;
        }else{
            insertarNodo(valor, this.raiz);
        }
    }
    public void insertarNodo(int valor, Nodo nodoRef){
        if (valor <= nodoRef.dato){
            if (nodoRef.izquierdo == null){
                System.out.println("Insertando hijo izquierdo de: "  + nodoRef.dato + ": " + valor);
                nodoRef.izquierdo =  new Nodo();
                nodoRef.izquierdo.dato = valor;
                nodoRef.izquierdo.izquierdo = null;
                nodoRef.izquierdo.derecho = null;
            }else{
                insertarNodo(valor, nodoRef.izquierdo);
            }
        }else{
            if (valor > nodoRef.dato){
                if (nodoRef.derecho == null){
                    System.out.println("Insertando hijo derecho de: " + nodoRef.dato + ": " + valor);
                    nodoRef.derecho =  new Nodo();
                    nodoRef.derecho.dato = valor;
                    nodoRef.derecho.izquierdo = null;
                    nodoRef.derecho.derecho = null;
                }else{
                    insertarNodo(valor, nodoRef.derecho);
                } 
            }
        }
    }
    //Imprime arbol 
    public void muestracostado(int nivel, Nodo nodoRef){
        if (nodoRef == null){
            return;
        }else{
            muestracostado(nivel + 1, nodoRef.derecho);
            System.out.println("[" + nodoRef.dato + "]");
            muestracostado(nivel + 1, nodoRef.izquierdo);
        }
    }
    
    private void Espacios(int cantidad){
        for (int i = 0; i < cantidad; i++) {
            System.out.print("   ");
        }
    }
    
    //Buscar nodo
    public boolean busqueda(int valor, Nodo nodoRef){
        if (nodoRef==null)
            return false;
        else if(valor<nodoRef.dato)
            return busqueda(valor,nodoRef.izquierdo);
        else if(valor>nodoRef.dato)
            return busqueda(valor,nodoRef.derecho);
        else 
            return true; //Regresa
    }
    //Acomoda en inorden
    public void inorden(Nodo nodoRef){
        if(nodoRef==null){
            return;
        }
        inorden(nodoRef.izquierdo);
        System.out.print(nodoRef.dato + " - ");
        inorden(nodoRef.derecho);
    }
    //Acomoda en preorden
    public void preorden(Nodo nodoRef){
        if(nodoRef==null){
            return; 
        }
        System.out.print(nodoRef.dato + " - ");
        preorden(nodoRef.izquierdo);
        preorden(nodoRef.derecho);
    }
    //Acomoda en post orden
    public void postorden(Nodo nodoRef){
        if(nodoRef==null){
            return; 
        }
        postorden(nodoRef.izquierdo);
        postorden(nodoRef.derecho);
        System.out.print(nodoRef.dato + " - ");
    }
    public void eliminaNodo(int valor) {
        this.raiz = eliminarNodoRecursivo(this.raiz, valor);
    }
    private Nodo eliminarNodoRecursivo(Nodo nodoRef, int valor){
        if (nodoRef == null) {
            return null;
        }
        if (valor < nodoRef.dato){
            nodoRef.izquierdo = eliminarNodoRecursivo(nodoRef.izquierdo, valor);
        }else if(valor > nodoRef.dato){
            nodoRef.derecho = eliminarNodoRecursivo(nodoRef.derecho, valor);
        }else{
            if (nodoRef.izquierdo == null){
                return nodoRef.derecho;
            }else if (nodoRef.derecho == null){
                return nodoRef.izquierdo;
            }            
            nodoRef.dato = predecesor(nodoRef.derecho);
            nodoRef.derecho = eliminarNodoRecursivo(nodoRef.derecho, nodoRef.dato);
        }
        return nodoRef;
    }
    private int predecesor(Nodo nodoRef){
        while(nodoRef.izquierdo != null){
            nodoRef = nodoRef.izquierdo;
        }
        return nodoRef.dato;
    }
}