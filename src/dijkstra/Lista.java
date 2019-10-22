/* ***************************************************************
* Autor: Wali Queiroz Santos
* Inicio: 12/06/2016
* Ultima alteracao: 19/06/2016
*************************************************************** */
package dijkstra;
public class Lista {

    private No inicio;
    private int numPos;

    public Lista() {
        inicio = null;
        numPos = 0;
    }

/* ***************************************************************
* Metodo: getNumPos
* Funcao: Este metodo retorna o numero de elementos na lista
* Parametros: Nenhum
* Retorno: int
*************************************************************** */
    public int getNumPos() {
        return numPos;
    }
/* ***************************************************************
* Metodo: isEmpty
* Funcao: Este metodo verifica se a lista esta vazia
* Parametros: Nenhum
* Retorno: boolean
*************************************************************** */
    public boolean isEmpty() {
        return (inicio == null);
    }
    
/* ***************************************************************
* Metodo: inserir
* Funcao: Este metodo insere valores na lista
* Parametros: 
    peso: peso da aresta do grafo
    i: coordenada i da matriz
    j: coodenada j da matriz
* Retorno: void
*************************************************************** */
    public void incluir(int peso, int i, int j){//insere elementos na lista
        No novo = new No(peso, i , j);
        if (isEmpty()) {
            inicio = novo;
        } else {
            No temp = inicio;
            while(temp.getProximo()!=null){
                temp = temp.getProximo();
            }
            temp.setProximo(novo);
        }
        numPos++;
    }
    
/* ***************************************************************
* Metodo: permanente
* Funcao: Este metodo verifica se um no inserido esta na lista de permanentes
* Parametros: i. Numero rotulo do no.
* Retorno: boolean
*************************************************************** */
    public boolean permanente(int i){
        No temp = inicio;
        while(temp!=null){
            if(i==temp.getI()){
                return true;
            }
            temp = temp.getProximo();
        }
        return false;
    }
/* ***************************************************************
* Metodo: menor
* Funcao: Este metodo retona o menor peso da lista de provisorios
* Parametros: Nenhum
* Retorno: int
*************************************************************** */
    public int menor(){
        int menor = 100000;
        No temp = inicio;
        while(temp!=null){
            if(temp.getPeso() < menor){
                menor = temp.getPeso();
            }
            temp = temp.getProximo();
        }
        return menor;
    }
    
/* ***************************************************************
* Metodo: menorI
* Funcao: Este metodo retona a coordenada i da aresta com menor peso da lista de provisorios
* Parametros: Nenhum
* Retorno: int
*************************************************************** */
    public int menorI(){
        int i = 0;
        int menor = 100000;
        No temp = inicio;
        while(temp!=null){
            if(temp.getPeso() < menor){
                menor = temp.getPeso();
                i = temp.getI();
            }
            temp = temp.getProximo();
        }
        return i;
    }
/* ***************************************************************
* Metodo: menorJ
* Funcao: Este metodo retona a coordenada j da aresta com menor peso da lista de provisorios
* Parametros: Nenhum
* Retorno: int
*************************************************************** */
    public int menorJ(){//retorna a cordenada J da aresta com menor peso da lista
        int j = 0;
        int menor = 100000;
        No temp = inicio;
        while(temp!=null){
            if(temp.getPeso() < menor){
                menor = temp.getPeso();
                j = temp.getJ();
            }
            temp = temp.getProximo();
        }
        return j;
    }
    
    
/* ***************************************************************
* Metodo: removeCaminhoErrado
* Funcao: Este metodo verifica se ha duas arestas saindo de um mesmo noh no caminho e  pega a menor
* Parametros: Nenhum
* Retorno: boolean
*************************************************************** */
    public boolean removeCaminhoErrado(){
        No temp = inicio;
        No temp2;
        No ant = inicio;
        while(temp!=null){
            temp2 = temp;
            while (temp2.getProximo()!=null) {
                if(temp2.getProximo().getI() == temp.getI()){
                    if(temp==inicio){
                        inicio = null;
                        return true;
                    }else{
                        ant.setProximo(null);
                        return true;
                    }                   
                }
                temp2 = temp2.getProximo();
            }
            ant = temp;
            temp = temp.getProximo();
        }
        return false;
    }
    
/* ***************************************************************
* Metodo: remover
* Funcao: Este metodo remove um no da lista 
* Parametros: e. Peso da aresta a ser removida
* Retorno: void
*************************************************************** */

    public void remover(int e) {
        No temp = inicio;
        No ant = inicio;
        int valor = inicio.getPeso();

        if (valor == e) {
            inicio = inicio.getProximo();
            numPos--;
        } else {
            while (temp.getProximo() != null && valor != e) {
                ant = temp;
                temp = temp.getProximo();
                valor = temp.getPeso();
            }
            if (valor == e) {
                ant.setProximo(temp.getProximo());
                numPos--;
            } else {
                System.out.println("Elemento nao encontrado!");
            }
        }
    }
    
/* ***************************************************************
* Metodo: soma
* Funcao: Soma os pesos do caminho
* Parametros: Nenhum
* Retorno: int
*************************************************************** */
    public int soma(){
        No temp = inicio;
        int soma = 0;
        while(temp!=null){
            soma += temp.getPeso();
            temp = temp.getProximo();
        }
        return soma;
    }
 
/* ***************************************************************
* Metodo: imprimir
* Funcao: Este metodo imprime os nos permanentes que pertencem ao caminho minimo
* Parametros: Nenhum
* Retorno: void
*************************************************************** */
    public void imprimir(){
        No temp = inicio;
        while(temp!=null){
            if(temp.getProximo()==null){
                System.out.println(temp.getI());
                System.out.println(temp.getJ());
            }else{
                System.out.println(temp.getI());
            }
            temp = temp.getProximo();
        }
    }
    
}
