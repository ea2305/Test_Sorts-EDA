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
  *@return String: calculo de complejidad con funcion
  */
  public String calculoFuncion(){
    int n = getNumElementos();
    return(
      "\n"+"Calculo de complejidad por funcion"
      +"\n\t"+"HeapSort complejidad: "+ (n*log(n,2))
      +"\n\t"+"Insercion complejidad: "+ (n*n)
      +"\n\t"+"Merge complejidad: "+ (n*log(n,2))
      +"\n\t"+"Seleccion complejidad: "+ (n*n)
      +"\n\t"+"Quicksort complejidad: "+ (n*log(n,2))
    );
  }
}
