public class Barbaro {
    private String nome;
    private int terras;
    private int nivel;
    private Barbaro pai;

    private static int cont;


    public Barbaro(String nome, int terras, Barbaro pai) {
        this.nome = nome;
        this.terras = terras;
        if (cont == 0) 
            nivel = 0;
        else 
            nivel = pai.getNivel() + 1;
        
        cont++;
    }  

    public String getNome() {
        return nome;
    }

    public int getTerras() {
        return terras;
    }
    public void setTerras(int terrasNovas) {
        terras += terrasNovas;
    }

    public int getNivel() {
        return nivel;
    }

    public Barbaro getPai() {
        return pai;
    }

    public String toString() {
        return nome + " possui " + terras + ", geração: " + nivel;
    }

    
}
