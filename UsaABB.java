import java.io.*;
import java.util.Scanner;
public class UsaABB{
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args){
        ABB arbol = new ABB();
        System.out.println(" ");
        arbol.insertarValor(20);
        arbol.insertarValor(10);
        arbol.insertarValor(7);
        arbol.insertarValor(27);
        arbol.insertarValor(90);
        arbol.insertarValor(30);
        arbol.insertarValor(14);
        arbol.insertarValor(4);
        System.out.println(" ");
        System.out.println("Árbol Binario: ");
        System.out.println(" ");
        arbol.muestracostado(0, arbol.getRaiz());
        System.out.println(" ");
        System.out.println("¿Qué nodo quieres encontrar? ");
        int valorBuscado = teclado.nextInt();
        if(arbol.busqueda(valorBuscado, arbol.getRaiz())){
            System.out.println("Se encuentra en el árbol");
        }
        else{
            System.out.println("No se encuentra en el árbol");
        }
        System.out.println(" ");
        System.out.println("Orden:");
        arbol.inorden(arbol.getRaiz());
        System.out.println("Preorden:");
        arbol.preorden(arbol.getRaiz());
        System.out.println("Postorden:");
        arbol.postorden(arbol.getRaiz());
        System.out.println(" ");
        System.out.println("¿Qué nodo quieres borrar? ");
        int Eliminar = teclado.nextInt();
        System.out.println("Eliminar nodo ingresado: " + Eliminar);
        arbol.eliminaNodo(Eliminar);
        System.out.println(" ");
        System.out.println("Árbol después de eliminar el nodo: ");
        System.out.println(" ");
        arbol.muestracostado(0, arbol.getRaiz());
    }
}