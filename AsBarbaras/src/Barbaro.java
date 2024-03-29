public class Barbaro {
    private String nome;
    private int terras;
    private int nivel;
    private Barbaro pai;

    public Barbaro(Barbaro pai, String nome, int terras) {
        this.nome = nome;
        this.terras = terras;
        this.pai = pai;
        if (pai == null) 
            nivel = 1;  
        else 
            nivel = pai.getNivel() + 1;
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
        return nome + " que possui " + terras + ", está na geração: " + nivel;
    }

    
}
