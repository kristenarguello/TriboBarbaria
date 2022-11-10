public class GenericTree {   
    private class TreeNode {
        public String value;
        public TreeNode father;
        private TreeNode[] children;
        private int nChild;

        public TreeNode(String nome) {
            father = null;
            children = new TreeNode[10];
            value = nome;
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

        boolean removeSubtree(TreeNode n) {
            if (n == null) {
                return false;
            }
            int idx = -1;
            for (int i = 0; i < nChild; i++)
                if (children[i] == null) {
                    idx = i;
                    break;
                }
            if (idx == -1)
                return false;

            for (int i = idx; i < nChild; i++)
                children[i] = children[i + 1];
            nChild--;
            children[nChild] = null;
            return true;
        }

        // busca subtree pelo indice dentro da lista de filhos
        TreeNode getSubtree(int i) {
            if (i >= 0 && i < nChild)
                return children[i];
            return null;
        }

        // retorna o número de filhos
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

    private TreeNode searchNode(String nome, TreeNode ref) {
        if (ref != null) {
            if (ref.value == nome)
                return ref;
            else {
                TreeNode aux = null;
                for (int i = 0; i < ref.getSubtreeSize(); i++) {
                    aux = searchNode(nome, ref.getSubtree(i));
                    if (aux != null)
                        return aux;
                }
                return null;
            }
        } else
            return null;
    }

    public boolean add(String n, String father) {
        TreeNode aux;
        if (nElements == 0) {
            this.root = new TreeNode(n);
        } else {
            aux = searchNode(father, root);
            if (aux == null)
                return false;
            else
                aux.addSubtree(new TreeNode(n));
        }
        nElements++;
        return true;
    }

    public String getRoot() {
        if (root != null)
            return root.value;
        return null;
    }

    public void setRoot(String e) {
        if ((e != null) && (root != null)) {
            root.value = e;
        }
    }

    public String getParent(String e) {
        TreeNode aux = searchNode(e, this.root);
        if ((aux != null) && (aux.father != null))
            return aux.father.value;
        return null;
    }

    boolean contains(String e) {
        return (searchNode(e, this.root) == null) ? false : true;
    }

    boolean isInternal(String e) {
        TreeNode aux = searchNode(e, this.root);
        if ((aux != null) && (aux.getSubtreeSize() > 0))
            return true;
        return false;
    }

    boolean isExternal(String e) {
        TreeNode aux = searchNode(e, this.root);
        if ((aux != null) && (aux.getSubtreeSize() == 0)) 
            return true;
        return false;
    }

    boolean isRoot(String e) {
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

    String[] positionsWidth() {
        if (nElements == 0)
            return null;

        String[] lista = new String[this.nElements];
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

    int[] niveis() {
        if (nElements == 0)
            return null;

        String[] lista = new String[this.nElements];
        int[] lniveis = new int[lista.length];

        int idx = 0;
        int pos = 0;
        int nivel = 0;
        //int cont = 0;

        lista[idx] = root.value;
        lniveis[idx++] = nivel;

        while (idx < nElements) {
            TreeNode aux = searchNode(lista[pos++], this.root);
            if (aux != null)
                
                for (int i = 0; i < aux.getSubtreeSize(); i++) {
                    lniveis[idx] = nivel;
                    lista[idx++] = aux.getSubtree(i).value;
                }
        }
        return lniveis;
    }//ainda ta dando errado, mas pensei em algumas ideias

    boolean dentro(String[] l, String v) {
        for (String n : l) {
            if (v.equals(n)) 
                return true;
        }
        return false;
    }//procura a string dentro da arvore

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