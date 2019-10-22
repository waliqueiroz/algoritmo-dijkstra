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
public class No {
    
    private int peso;
    private int i;
    private int j;
    private No proximo;
    
    public No(int peso, int i, int j){
        this.peso = peso;
        this.i = i;
        this.j = j;
        proximo = null;   
    }
    
    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
    
    
}
