/**
 *Main class, add your instance of class, in the correct method
 *@author Elihu Alejandro Cruz Albores
 *@author Julio de Buen Hernandez
 *@author Luis Angel Farelo Toledo
 *@author Luis Alcocer ... [Put your name, please]
 */
 
 import java.util.Scanner;
 import java.util.List;
 
 public class Main{
     
     public static void main(String []argv){
         //Call menu
         
        Menu();//Callback to metodos an file reader
         
     }
     
     //Add parameters at interface "SortStruct", if you want to do :v
     public static void test_HeapSort(){}
     
     //Add parameters at interface "SortStruct", if you want to do :v
     public static void test_InsertionSort(){}
     
     //Add parameters at interface "SortStruct", if you want to do :v
     public static void test_MergeSort(){}
     
     //Add parameters at interface "SortStruct", if you want to do :v
     public static void test_SelectionSort(){}
     
     //Add parameters at interface "SortStruct", if you want to do :v
     public static void test_QuickSort(){}
     
     public static void Menu(){
        //Start options with methods sort
        Scanner read = new Scanner(System.in);
        int option = 1;       

        String[] options = {"1.-Cargar un archivo =>","2.-Ordenamiento por metodo : HeapSort","3.-Ordenamiento por metodo : Insercion",
                        "4.-Ordenamiento por metodo : Merge","5.-Ordenamiento por metodo : Seleccion", "6.-Ordenamiento por metodo : Quicksort",
                        "[7..00].- Salir =>"};

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
                loadFile();
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
            default:
                return -1;
        }           
     }
     
     //Read file
     private static String[] loadFile(){
         
           //instance of file reader => 
//         AnallizaFile fileReader = new AnallizaFile();       
         //Some sentences for load file
         return null;
     }
     
 }