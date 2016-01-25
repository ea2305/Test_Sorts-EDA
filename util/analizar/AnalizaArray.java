/**
*@author Flyzx
*@version 0.1
*/
package util.analizar;
/**
*Clase que analiza un array y determina el algoritmo mas optimo
*/
public class AnalizaArray{
  //arreglo donde se guardaran los datos de tipo String
  static String [] data_Sort;
  //arreglo donde se guardaran los datos de tipo Integer
  static Integer [] data_SortInteger;
  /**
  *@param arreglo de datos de tipo String
  */
  public AnalizaArray(String [] data_Sort){
    this.data_Sort = data_Sort;
    this.data_SortInteger = null;
  }
  /**
  *@param arreglo de datos de tipo String
  */
  public AnalizaArray(Integer [] data_SortInteger){
    this.data_Sort = null;
    this.data_SortInteger = data_SortInteger;
  }
  /**
  *@return int: numero de elementos
  */
  private int getNumElementos(){
    if(this.data_Sort != null)
      return data_Sort.length;
    if(this.data_SortInteger != null)
      return data_SortInteger.length;
    return 0;
  }
  /**
  *@param int: valor, int: base
  *@return int: logaritmo
  */
  private int log(int valor, int base){
    return (int)(Math.log(valor) / Math.log(base));
  }
  /**
  *@param int: valor
  *@return boolean: signo + = true, signo - = false
  */
  private boolean signo(int a){
    if(a < 0) return false;
    else return true;
  }
  /**
  *@param int: valor
  *@return int: valor absoluto
  */
  private int valAbs(int a){
    if(a < 0) return -a;
    else return a;
  }
  /**
  *@return boolean[]: indica si esta ordenado y su tipo
  */
  private boolean[] ordenado(){
    boolean[] orden = {false, false};
    if(this.data_Sort != null){
      int n = getNumElementos();
      int box = data_Sort[0].compareTo(data_Sort[n-1]);
      int distancia = valAbs(box);
      orden[1] = signo(box);
      for (int i=n-1; i>0; i/=2) {
        box = data_Sort[0].compareTo(data_Sort[i]);
        if(orden[1] != signo(box)){
          return orden;
        }
        if(valAbs(distancia) < valAbs(box)){
          return orden;
        }
        distancia = box;
      }
      orden[0]=true;
      return orden;
    }
    if(this.data_SortInteger != null){
      int n = getNumElementos();
      int box = data_SortInteger[0].compareTo(data_SortInteger[n-1]);
      int distancia = valAbs(box);
      orden[1] = signo(box);
      for (int i=n-1; i>0; i/=2) {
        box = data_SortInteger[0].compareTo(data_SortInteger[i]);
        if(orden[1] != signo(box)){
          return orden;
        }
        if(valAbs(distancia) < valAbs(box)){
          return orden;
        }
        distancia = box;
      }
      orden[0]=true;
      return orden;
    }
    return orden;
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
        +"\n"+"Arreglo con n: "+ n
        +"\n\t"+"HeapSort complejidad: "+ ((n*log(n,2))+(n/2))
        +"\n\t"+"Insercion complejidad: "+ ((((n*n)-n)/2)/2)
        +"\n\t"+"Merge complejidad: "+ ((n*log(n,2))+((2*n)/3))
        +"\n\t"+"Seleccion complejidad: "+ (((n*n)-n)/2)
        +"\n\t"+"Quicksort complejidad: "+ ((n*log(n,2))/3)
      );
    }
  }
}
