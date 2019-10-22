/* ***************************************************************
* Autor: Wali Queiroz Santos
* Inicio: 12/06/2016
* Ultima alteracao: 19/06/2016
*************************************************************** */
package dijkstra;

/**
 *
 * @author Wali
 */
public class Dijkstra {
    
    private Lista provisorios = new Lista();//lista de vertices provisorios
    private Lista permanentes = new Lista();//lista de vertices permanentes
    private Lista caminho = new Lista();//lista que armazena o caminho minimo
        
    /* ***************************************************************
* Metodo: caminhoMinimo
* Funcao: Este metodo calcula o menor caminho entre dois nos em um grafo
* Parametros: 
    vAtual: vertice inicial do caminho
    vDestino: vertice final do caminho
    matriz: matriz com os pesos das arestas do grafo 
* Retorno: void
*************************************************************** */
    public void caminhoMinimo(int vAtual, int vDestino, int matriz [][]){
        while(vAtual!=vDestino){
            for (int i = 0; i < matriz.length; i++) {//gera os provisorios
                if(matriz[vAtual][i] != 0 && !permanentes.permanente(i)){//Se o no atual tem ligacao com um no i e tal no nao esta na lista de permanentes
                    provisorios.incluir(matriz[vAtual][i], vAtual, i);//este no eh adicionado na lista de provisorios
                }
            }
            
            permanentes.incluir(0, vAtual, 0);//marca o atual como visitado
            caminho.incluir(provisorios.menor(), provisorios.menorI(), provisorios.menorJ());//adiciona ao caminho o vertice mais proximo do atual, junto com as coordenadas da aresta
            
            
            if(caminho.removeCaminhoErrado()){//verifica se o caminho esta correto, se nao estiver, apaga a partir do ponto errado e reinsere a aresta correta
                caminho.incluir(provisorios.menor(), provisorios.menorI(), provisorios.menorJ());
            }
            
            vAtual = provisorios.menorJ();//atualiza o vertice atual
            provisorios.remover(provisorios.menor());//remove o na marcado como permanente da lista de provisorios
            
        }
        System.out.println("O menor caminho e de tamanho: " + caminho.soma() + " e passa por: ");//imprime o caminho e os vertices por onde ele passa
        caminho.imprimir();//imprime os vertices por onde o caminho passa
    }
}
