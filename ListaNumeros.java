/**
 * Un objeto de esta clase
 * guarda una lista de números enteros
 * 
 * La clase incluye una serie de métodos de instancia
 * para hacer operaciones sobre la lista
 * y dos  métodos estáticos para trabajar con
 * arrays de dos dimensiones
 *
 * @author -
 */


import java.util.Arrays;
import java.util.Random;

public class ListaNumeros {
    public static final int DIMENSION = 10;
    public static final int ANCHO_FORMATO = 6;
    public static final char CAR_CABECERA = '-';

    private static final Random generador = new Random();
    //DONE
    private int[] lista;
    private int pos;
    

    /**
     * Constructor de la clase ListaNumeros
     * Crea e inicializa adecuadamente los
     * atributos
     *
     * @param n el tamaño máximo de la lista
     */
    public ListaNumeros(int n) {
        //DONE
        lista = new int[n];
        pos = 0;
    }

    /**
     * Añade un valor al final de la lista 
     * siempre que no esté completa
     *
     * @param numero el valor que se añade.  
     * @return true si se ha podido añadir, false en otro caso
     */
    public boolean addElemento(int numero) {
        //DONE
        if(pos == lista.length)
        {
            return false;
        }
        System.arraycopy(lista,0,lista,1,pos);
        lista[pos] = numero;
        pos++;
        return true;
    }

    /**
     * @return true si la lista está completa, false en otro caso
     * Hacer sin if
     */
    public boolean estaCompleta() {
        //DONE
        return pos == lista.length;
    }

    /**
     * @return true si la lista está vacía, false en otro caso.
     * Hacer sin if
     */
    public boolean estaVacia() {
       //DONE
        return pos == 0;
    }

    /**
     * @return el nº de elementos realmente guardados en la lista
     */
    public int getTotalNumeros() {
        //DONE
        return pos;
    }

    /**
     * Vacía la lista
     */
    public void vaciarLista() {
       //DONE
        pos = 0;
    }

    /**
     * @return una cadena con representación textual de la lista 
     * (leer enunciado)
     * 
     * Si la lista está vacía devuelve ""
     */
    public String toString() {
       //DONE
        String lista2 = "";
        for(int i = 0;i < pos;i++){
            lista2 = lista2+lista[i]+ "\t";
        }
        return lista2;
    }

     

    /**
     * Mostrar en pantalla la lista
     */
    public void escribirLista() {
        System.out.println(this.toString());
    }

    /**
     *  
     * @return el segundo valor máximo en la lista
     * Cuando no haya un segundo máximo el método 
     * devolverá el valor Integer.MIN_VALUE
     * 
     * Si lista = {21, -5, 28, -7, 28, 77, 77, -17, 21, 15, 28, 28, 77} se devuelve 28
     * Si lista = {21, -5, 28, -7, 77} se devuelve 28
     * Si lista = {77, 21} se devuelve 21
     * Si lista = {21} se devuelve Integer.MIN_VALUE
     * Si lista = {21, 21, 21, 21} se devuelve Integer.MIN_VALUE
     * 
     * No se puede usar ningún otro array auxiliar ni hay que ordenar previamente
     * la lista
     */
    public int segundoMaximo() {
        //DONE
        int casiMax = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE + 1;
        for (int i = 0; i <= pos; i++) {
            if (max < lista[i]) {
                max = lista[i];
            }
            if (casiMax < lista[i]){
                casiMax = lista[i];
            }
        }
        return  casiMax;
    }

    /**
     * El método coloca los valores que son segundos máximos al principio de
     * la lista respetando el orden de aparición del resto de elementos
     * 
     * No se puede usar ningún otro array auxiliar ni hay que ordenar previamente
     * la lista
     * 
     * Si lista = {21, -5, 28, -7, 28, 77, 77, -17, 21, 15, 28, 28, 77} 
     * lista queda  {28, 28, 28, 28, 21, -5, -7, 77, 77, -17, 21, 15, 77} y se devuelve true
     * 
     * Si lista = {77, 21} lista queda {21, 77} y se devuelve true
     * Si lista = {21} lista queda igual y se devuelve false
     * Si lista = {21, 21, 21, 21} lista queda igual y se devuelve false
     * 
     * @return true si se han colocado los segundos máximos
     *          false si no se han colocado los segundos máximos porque no había ninguno
     */
    public boolean segundosMaximosAlPrincipio() {
        //DONE
        int aux = segundoMaximo();
        for (int i = 0; i < lista.length; i++) {
            lista[i + 1] = lista[i];
            lista[0] = aux;
        }
        return aux == lista[0];
    }

    /**
     * @param numero búsqueda binaria de  numero en lista
     * @return devuelve -1 si no se encuentra o la posición en la que aparece
     *  
     * El array original lista no se modifica
     * Para ello crea  previamente una copia
     * de lista y trabaja  con la copia
     *  
     * Usa exclusivamente métodos de la clase Arrays
     */
    public int buscarBinario(int numero) {
         //DONE
        return Arrays.binarySearch(lista,0,pos,pos);
    }

    /**
     * 
     * @return devuelve un array bidimensional de enteros de tamaño DIMENSION
     * inicializado con valores aleatorios entre 0 y 10 inclusive
     * 
     * Estos valores van a representar el brillo de una zona del espacio
     * 
     */
    public static int[][] crearBrillos() {
       //DONE
       
       int[][] brillos = new int[DIMENSION][DIMENSION];
        for (int i = 0; i < brillos.length; i++) {
            for (int j = 0; j < brillos[i].length; j++) {
                brillos[i][j] = generador.nextInt(8) + 3;
            }
        }
        return brillos;
    }

    /**
     * @param  uno array bidimensional brillos
     * @return un nuevo array bidimensional de valores booleanos
     *          de las mismas dimensiones que el array brillos con
     *          valores true en las posiciones donde hay estrellas
     * 
     * Una posición f,c del array brillos es una estrella 
     * si la suma del valor de los brillos de sus cuatro vecinos 
     * (arriba, abajo, derecha e izquierda) es mayor que 30
     * 
     * Nota -  No hay estrellas en los bordes del array brillos
     */
    public static boolean[][] detectarEstrellas(int[][] uno) {
       //DONE
       boolean[][] mapaEstelar = new boolean[DIMENSION][DIMENSION];
        for (int i = 0; i < uno.length; i++) {
            for (int j = 0; j < uno[i].length; j++) {
                if(uno[i-1][j] + uno[i+1][j] +uno[i][j-1] + uno[i][j+1] > 30){
                    mapaEstelar[i][j] = true;
                }
            }
        }
       return mapaEstelar;
    }
}
