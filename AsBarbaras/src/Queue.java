public class Queue {
    private class Nodo {
        private String pedido;
        private Nodo referencia;

        public Nodo(String valor) {
            this.pedido = valor;
            this.referencia = null;
        }

        public Nodo getReferencia() {
            return referencia;
        }

        public void setReferencia(Nodo prox) {
            this.referencia = prox;
        }

        public String getValor() {
            return pedido;
        }
    }

    private int tam;
    private Nodo inicio;
    private Nodo fim;

    public Queue() {
        inicio = null;
        fim = null;
        tam = 0;
    }

    public void add(String nome) {
        Nodo aux = new Nodo(nome);
        if (tam == 0)
            inicio = aux;
        else
            fim.setReferencia(aux);

        fim = aux;
        tam++;
    }

    public void remove() {
        try {
            Nodo removido = inicio;
            inicio = inicio.getReferencia();
            tam--;
            removido.setReferencia(null);
        } catch (Exception i) {
            System.out.println("Lista está vazia");
        }
    }

    public String peek() throws Exception {
        if (tam > 0)
            return inicio.getValor();
        else
            throw new Exception("A lista está vazia!");
    }

    public boolean isEmpty() {
        return (tam == 0);
    }

    public int size() {
        return tam;
    }

    public void clear() {
        tam = 0;
        fim = inicio = null;
    }

    public void exibirLista() {
        Nodo nav = inicio;
        System.out.print("[");
        while (nav!=null) {
            System.out.print(nav.getValor() + " - ");
            nav = nav.getReferencia();
        }
        System.out.print("]");
    }
}