import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.io.IOException;

public class GenericTree {   
    private class TreeNode {
        public Barbaro value;
        public TreeNode father;
        private TreeNode[] children;
        private int nChild;

        public TreeNode(Barbaro b) {
            father = null;
            children = new TreeNode[10];
            value = b;
            nChild = 0;
        }

        public void addSubtree(TreeNode n) {
            if (nChild == children.length)
                grow();
            children[nChild] = n;
            n.father = this;
            nChild++;
        }

        private void grow() {
            TreeNode aux[] = new TreeNode[children.length * 2];
            for (int i = 0; i < children.length; i++)
                aux[i] = children[i];
            children = aux;
        }

        TreeNode getSubtree(int i) {
            if (i >= 0 && i < nChild)
                return children[i];
            return null;
        }

        int getSubtreeSize() {
            return nChild;
        }
    }

    private TreeNode root;
    private int nElements;

    public GenericTree() {
        this.root = null;
        this.nElements = 0;
    } 

    private TreeNode searchNode(Barbaro b, TreeNode ref) {
        if (ref != null) {
            if (ref.value == b)
                return ref;
            else {
                TreeNode aux = null;
                for (int i = 0; i < ref.getSubtreeSize(); i++) {
                    aux = searchNode(b, ref.getSubtree(i));
                    if (aux != null)
                        return aux;
                }
                return null;
            }
        } else
            return null;
    }
    
    Barbaro searchBarbaro(String b, TreeNode ref) {
        if (ref != null) {
            if (ref.value.getNome().equals(b))
                return ref.value;
            else {
                Barbaro aux = null;
                for (int i = 0; i < ref.getSubtreeSize(); i++) {
                    aux = searchBarbaro(b, ref.getSubtree(i));
                    if (aux != null)
                        return aux;
                }
                return null;
            }
        } else
            return null;
    }

    public boolean add(Barbaro n) {
        TreeNode aux;
        if (nElements == 0) {
            this.root = new TreeNode(n);
        } else {
            aux = searchNode(n.getPai(), root);
            if (aux == null)
                return false;
            else
                aux.addSubtree(new TreeNode(n));
        }
        nElements++;
        return true;
    }

    public Barbaro getParent(Barbaro e) {
        TreeNode aux = searchNode(e, this.root);
        if ((aux != null) && (aux.father != null))
            return aux.father.value;
        return null;
    }

    Barbaro[] positionsWidth() {
        if (nElements == 0)
            return null;

        Barbaro[] lista = new Barbaro[this.nElements];
        int idx = 0;
        int pos = 0;

        lista[idx++] = root.value;
        while (idx < nElements) {
            TreeNode aux = searchNode(lista[pos++], this.root);
                for (int i = 0; i < aux.getSubtreeSize(); i++)
                    lista[idx++] = aux.getSubtree(i).value;
        }
        return lista;
    }

    int ultimoNivel() {
        Barbaro[] lista = positionsWidth();
        int maior = 0;
        for (Barbaro b : lista) {
            if (b.getNivel() > maior)
                maior = b.getNivel();
        }
        return maior;
    }

    Barbaro[] ultimaGeracao() {
        Barbaro[] lista = positionsWidth();
        Barbaro[] aux = new Barbaro[lista.length];
        int pos = 0;
        int ultimoNivel = ultimoNivel();
        for (Barbaro b : lista) {
            if (b.getNivel()==ultimoNivel){
                aux[pos] = b;
                pos++;
            }
        }
        return aux;
    }
    
    Barbaro maisTerras() {
        Barbaro[] lista = ultimaGeracao();
        int maior = 0;
        Barbaro maisRico = null;
        for (Barbaro b : lista) {
            if (b!=null && b.getTerras() > maior) {
                maior = b.getTerras();
                maisRico = b;
            } 
            if (b==null) {
                break;
            }
        }
        return maisRico;
    }

    void distribuicaoTerras() {
        Barbaro[] lista = positionsWidth();
        for (Barbaro b : lista) {
            if (b.getPai()!=null) {
                TreeNode aux = searchNode(b.getPai(), this.root);
                int herdadas = aux.value.getTerras() / aux.getSubtreeSize();
                b.setTerras(herdadas);
            }
        }
    }

    public void doTheString() {
        printValue(root);
    }

    private void printValue(TreeNode ref) {
        if (ref != null) {
            System.out.print(ref.value + "; ");
            for (int i = 0; i < ref.getSubtreeSize(); i++)
                printValue(ref.getSubtree(i));
        }
    }

    public boolean readFile(String nomeArq) {
        Path path1 = Paths.get(nomeArq);
        int cont = 0;
        int terrasPaiTudo = 0;
        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (cont == 0) { 
                    terrasPaiTudo = Integer.parseInt(line);
                } else if (cont == 1) {
                    String[] dados = line.split(" ");
                    Barbaro paizao = new Barbaro(null, dados[0], terrasPaiTudo);
                    add(paizao);

                    int terras = Integer.parseInt(dados[2]);
                    Barbaro segundo = new Barbaro(paizao, dados[1], terras);
                    add(segundo);
                } else {
                    String[] dados = line.split(" ");
                    int terras = Integer.parseInt(dados[2]);
                    Barbaro d = new Barbaro(searchBarbaro(dados[0], root), dados[1], terras);
                    add(d);
                }
                cont++;
            }
        }
        catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
        return true;
    }
}