/**
 *Main class, add your instance of class, in the correct method
 *@author Elihu Alejandro Cruz Albores
 *@author Julio de Buen Hernandez
 *@author Luis Angel Farelo Toledo
 *@author Luis Alcocer ... [Put your name, please]
 *@author Carlos Maximiliano Ortiz Escobar
 */

 import java.util.Scanner;
 import util.AnalizaFile;
 import java.io.*;
 import sorts.*;
 import util.analizar.*;

 public class Main{

     static final String DIV = "\n";//Divisor of read File
     static String [] data_Sort = null;//Content information in String form
     static Integer [] data_SortInteger = null;

     public static void main(String []argv){
         //Call menu

        Menu();//Callback to metodos an file reader

     }

     //Add parameters at interface "SortStruct", if you want to do :v
     public static void test_HeapSort(){

         System.out.println("\n***************[ HEAPSORT]***************\n");

         HeapSort myHeap = new HeapSort();

         if(data_SortInteger == null){
             System.out.println(">> Cargue datos de un archivo, antes de iniciar.");
             return;
         }

        myHeap.heapSort(data_SortInteger);

        System.out.println("\n>> [ Numero de intercambios : " + myHeap.getIndex() + " ]");
        //printArray(data_Sort);
        //printArray(data_SortInteger);

     }

     //Add parameters at interface "SortStruct", if you want to do :v
     public static void test_InsertionSort(){

        System.out.println("\n***************[ INSERTION SORT ]***************\n");

        Insercion insercion = new Insercion();
        if(data_SortInteger == null){
             System.out.println(">> Cargue datos de un archivo, antes de iniciar.");
             return;
         }

         insercion.ordenarInsercion(data_SortInteger);

        System.out.println("\n>> [ Numero de intercambios : " + insercion.getCount() + " ]");
        //printArray(data_Sort);
        //printArray(data_SortInteger);

     }

     //Add parameters at interface "SortStruct", if you want to do :v
     public static void test_MergeSort(){

         System.out.println("\n***************[ MERGESORT]***************\n");

         MergeSort myMerge = new MergeSort();

         if(data_SortInteger == null){
             System.out.println(">> Cargue datos de un archivo, antes de iniciar.");
             return;
         }

         myMerge.mergeSort(data_SortInteger);

         System.out.println("\n>> [ Numero de intercambios : " + myMerge.getIndex() + " ]");
        //printArray(data_Sort);
        //printArray(data_SortInteger);

     }

     //Add parameters at interface "SortStruct", if you want to do :v
     public static void test_SelectionSort(){

        System.out.println("\n***************[ SELECTIONSORT]***************\n");

        Seleccion seleccion=new Seleccion();


         if(data_SortInteger == null){
             System.out.println(">> Cargue datos de un archivo, antes de iniciar.");
             return;
         }

        Integer[] data = seleccion.seleccion(data_SortInteger);
        //printArray(data_Sort);
        //printArray(data_SortInteger);
     }

     //Add parameters at interface "SortStruct", if you want to do :v

     public static void test_QuickSort(){

        System.out.println("\n***************[ HEAPSORT]***************\n");

        QuickSort myQuick = new QuickSort();

        if(data_SortInteger == null){
            System.out.println(">> Cargue datos de un archivo, antes de iniciar.");
            return;
        }

        myQuick.sort(data_SortInteger);

        System.out.println("\n>> [ Numero de intercambios : " + myQuick.getIndex() + " ]");
        //printArray(data_Sort);
        //printArray(data_SortInteger);

     }
     /**
     *muestra la complejidad de los algoritmos de ordenamiento
     */
     private static void calcularComplejidad(){
       System.out.println("\n***************[ Complejidad ]***************\n");

       QuickSort myQuick = new QuickSort();

       if(data_SortInteger == null){
           System.out.println(">> Cargue datos de un archivo, antes de iniciar.");
           return;
       }
       AnalizaArray aa = new AnalizaArray(data_Sort);
       System.out.println(aa.calculoFuncion());
     }

     public static void Menu(){
        //Start options with methods sort
        Scanner read = new Scanner(System.in);
        int option = 1;

        String[] options = {"1.-Cargar un archivo =>","2.-Ordenamiento por metodo : HeapSort","3.-Ordenamiento por metodo : Insercion",
                        "4.-Ordenamiento por metodo : Merge","5.-Ordenamiento por metodo : Seleccion", "6.-Ordenamiento por metodo : Quicksort",
                        "7.-Imprimir elementos cargados","8.-Reiniciar array","9.-Calcular complejidad","[10..00].- Salir =>"};

        while(option != -1){//Waiting for defalut case

            System.out.println("\n\n===============>[MENU PRINCIPAL]<==================\n");
            for(String element : options)
                System.out.println(element);

            try{

                option = switcherMenu(read.nextInt());

            }catch(Exception e){
                //Restart read for caractrers because chars are corrupted
                System.out.println("Importante! => Introduzca solo numeros.");
                read = new Scanner(System.in);
            }

        }
     }

     //Flow selector
     protected static int switcherMenu(int option){

        switch(option){
            case 1:
                //load file external directory
                AnalizaFile myReader = new AnalizaFile();
                data_Sort = myReader.loadFile();
                data_SortInteger = myReader.parseInformation(data_Sort);//Transform string to integer

                return option;
            case 2:
                //any parameters
                test_HeapSort();
                return option;
            case 3:
                //any parameters
                test_InsertionSort();
                return option;
            case 4:
                //any parameters
                test_MergeSort();
                return option;
            case 5:
                //any parameters
                test_SelectionSort();
                return option;
            case 6:
                //any parameters
                test_QuickSort();
                return option;
            case 7:
                printArray(data_Sort);
                printArray(data_SortInteger);
                return option;
            case 8:
                restarArray();
                System.out.println("\n**********>ARREGLO REINICIADO !\n");
                return option;
            case 9:
              calcularComplejidad();
              return option;
            default:
                return -1;
        }
     }

     public static <T> void printArray(T[] A){

         System.out.println("\n\t>>>>>>[ CONTENIDO DEL ARCHIVO ]<<<<<<\n");
         for(T element : A){
             System.out.println(element);
         }

     }

     private static void restarArray(){
         AnalizaFile myReader = new AnalizaFile();
         data_SortInteger = myReader.parseInformation(data_Sort);//Transform string to integer
     }

 }
