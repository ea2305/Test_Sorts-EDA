 /**
*@author Flyzx
*@version 0.1
*/
package util.analizar;
import util.AnalizaFile;
/**
*Clase que analiza un array y determina el algoritmo mas optimo
*/
public class AnalizaArray{
  //arreglo donde se guardaran los datos de tipo Integer
  static Integer [] data_SortInteger;
  /**
  *@param arreglo de datos de tipo Integer
  */
  public AnalizaArray(Integer [] data_SortInteger){
    this.data_SortInteger = data_SortInteger;
  }
  /**
  *@return int: numero de elementos
  */
  private int getNumElementos(){
    return data_SortInteger.length;
  }
  /**
  *@param int: valor, int: base
  *@return int: logaritmo
  */
  private int log(int valor, int base){
    return (int)(Math.log(valor) / Math.log(base));
  }
  /**
  *@return boolean[]: indica si esta ordenado y su tipo
  */
  private boolean[] ordenado(){
    boolean[] orden = {false, false};
    int n = getNumElementos();
    if(this.data_SortInteger[0] < this.data_SortInteger[n-1]){
      for (int i=1; i<n ; i++) {
        if(this.data_SortInteger[i-1] > this.data_SortInteger[i]){
          return orden;
        }
      }
      orden[0]=true;
      orden[1]=true;
      return orden;
    }else{
      for (int i=1; i<n ; i++) {
        if(this.data_SortInteger[i-1] < this.data_SortInteger[i]){
          return orden;
        }
      }
      orden[0]=true;
      return orden;
    }
  }
  /**
  *@return String: calculo de complejidad con funcion
  */
  public String calculoFuncion(){
    int n = getNumElementos();
    boolean[] orden = ordenado();
    if(orden[0]){
      if(orden[1]){
        return(
          "\n"+"Calculo de complejidad por funcion"
          +"\n"+"Arreglo Ordenado Ascendente con n: "+ n
          +"\n\t"+"HeapSort complejidad: "+ (n*log(n,2))
          +"\n\t"+"Insercion complejidad: "+ (n*n)
          +"\n\t"+"Merge complejidad: "+ (n*log(n,2))
          +"\n\t"+"Seleccion complejidad: "+ (n*n)
          +"\n\t"+"Quicksort complejidad: "+ (n*log(n,2))
        );
      }else{
        return(
          "\n"+"Calculo de complejidad por funcion"
          +"\n"+"Arreglo Ordenado Descendente con n: "+ n
          +"\n\t"+"HeapSort complejidad: "+ (n*log(n,2))
          +"\n\t"+"Insercion complejidad: "+ (n*n)
          +"\n\t"+"Merge complejidad: "+ (n*log(n,2))
          +"\n\t"+"Seleccion complejidad: "+ (n*n)
          +"\n\t"+"Quicksort complejidad: "+ (n*log(n,2))
        );
      }

    }else{
      return(
        "\n"+"Calculo de complejidad por funcion"
        +"\n"+"Arreglo Desordenado con n: "+ n
        +"\n\t"+"HeapSort complejidad: "+ ((n*log(n,2))+(n/2))
        +"\n\t"+"Insercion complejidad: "+ ((((n*n)-n)/2)/2)
        +"\n\t"+"Merge complejidad: "+ ((n*log(n,2))+((2*n)/3))
        +"\n\t"+"Seleccion complejidad: "+ (((n*n)-n)/2)
        +"\n\t"+"Quicksort complejidad: "+ ((n*log(n,2))/3)
      );
    }
  }
}
