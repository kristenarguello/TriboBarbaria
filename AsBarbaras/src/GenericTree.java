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
            if (ref.value.getNome() == b)
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

    public TreeNode getRoot() {
        if (root != null)
            return root;
        return null;
    }

    public void setRoot(Barbaro e) {
        if ((e != null) && (root != null)) {
            root.value = e;
        }
    }

    public Barbaro getParent(Barbaro e) {
        TreeNode aux = searchNode(e, this.root);
        if ((aux != null) && (aux.father != null))
            return aux.father.value;
        return null;
    }

    boolean contains(Barbaro e) {
        return (searchNode(e, this.root) == null) ? false : true;
    }

    boolean isInternal(Barbaro e) {
        TreeNode aux = searchNode(e, this.root);
        if ((aux != null) && (aux.getSubtreeSize() > 0))
            return true;
        return false;
    }

    boolean isExternal(Barbaro e) {
        TreeNode aux = searchNode(e, this.root);
        if ((aux != null) && (aux.getSubtreeSize() == 0)) 
            return true;
        return false;
    }

    boolean isRoot(Barbaro e) {
        if ((root != null) && (e != null) && (root.value == e))
            return true;
        return false;
    }

    boolean isEmpty() {
        return (nElements == 0);
    }

    int size() {
        return nElements;
    }

    void clear() {
        root = null;
        nElements = 0;
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
            if (b.getTerras() > maior) {
                maior = b.getTerras();
                maisRico = b;
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

}