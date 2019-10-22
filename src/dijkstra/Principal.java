/* ***************************************************************
* Autor: Wali Queiroz Santos
* Inicio: 12/06/2016
* Ultima alteracao: 19/06/2016
*************************************************************** */
package dijkstra;

import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        Dijkstra dijkstra = new Dijkstra();//Objeto necessario
        System.out.println("Informe o numero de vertices do grafo: ");
        int n = ent.nextInt();//numero de vertices do grafo
        int matriz [][] = new int [n][n];//Armazena a matriz de pesos do grafo
        //int matriz [] [] = {{0,7,9,0,0,14}, {7,0,10,15,0,0},{9,10,0,11,0,2},{0,15,11,0,6,0},{0,0,0,6,0,9},{14,0,2,0,9,0}};//matriz de teste
        System.out.println("Informe o vertice inicial: ");
        int vAtual = ent.nextInt();//vertice atual | ponto de patida
        System.out.println("Informe o vertice destino: ");
        int vDestino = ent.nextInt();//vertice destino  
        System.out.println("Informe a matriz de pesos do grafo: ");
        
        for (int i = 0; i < matriz.length; i++) {//preenche a matriz
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = ent.nextInt();
            }
        }
        
        dijkstra.caminhoMinimo(vAtual, vDestino, matriz);//Calcula o caminho minimo e imprime no console
     
    }
    
}
