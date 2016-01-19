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
 
 public class Main{
     
     static final String DIV = "\n";//Divisor of read File
     static String [] data_Sort = null;//Content information in String form
     static Integer [] data_SortInteger = null;
     
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
                        "7.-Imprimir elementos cargados","[8..00].- Salir =>"};

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
                try{
                    data_Sort = loadFile();
                    data_SortInteger = parseInformation(data_Sort);//Transform string to integer
                    
                }catch(IOException e){ data_Sort = null;}
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
            default:
                return -1;
        }           
     }
     
     //Read file
     private static String[] loadFile()throws IOException{
         
           //instance of file reader => 
         Scanner read = new Scanner(System.in);
         
         //declaration arry with information
         String [] myFile;
                  
         //Declareation with name inside
         System.out.println("==============>[ LECTURA DE ARCHIVO PARA ORDENAMIENTO]<==============\n");
         System.out.println("===========[ INTRODUZCA EL NOMBRE DEL ARCHIVO]=============");
         String nameFile = read.nextLine();
         
         //Create fileReader             
       
        AnalizaFile fileReader = new AnalizaFile(nameFile);
        myFile = fileReader.getAllFile().split( DIV );
        
        if(fileReader.getNumberLines() < 1){
            System.out.println("X =======> Error verifique el nombre he intente de nuevo\n");
            return null;
        }          
                   
         System.out.println("==============> LOS DATOS SE AN CARGADO CORRECTAMENTE !");
         //Some sentences for load file
         return myFile;
     }
     
     private static Integer[] parseInformation(String[] Element){
         
         Integer [] Temp = new Integer[Element.length];
         Integer index = 0;
         for(String element : Element)
             Temp[index] = Integer.parseInt(Element[index++]);
         
         return Temp;
     } 
     
     public static <T> void printArray(T[] A){
         
         System.out.println("\n\t>>>>>>[ CONTENIDO DEL ARCHIVO ]<<<<<<\n");
         for(T element : A){
             System.out.println(element);
         }
         
     }
     
 }