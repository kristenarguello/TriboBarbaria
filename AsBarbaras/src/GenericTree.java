public class GenericTree {   
    private class TreeNode {
        public int value;
        public TreeNode father;
        private TreeNode[] children;
        private int nChild;

        public TreeNode(Integer element) {
            father = null;
            children = new TreeNode[10];
            value = element;
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

    private TreeNode searchNode(Integer value, TreeNode ref) {
        if (ref != null) {
            if (ref.value == value)
                return ref;
            else {
                TreeNode aux = null;
                for (int i = 0; i < ref.getSubtreeSize(); i++) {
                    aux = searchNode(value, ref.getSubtree(i));
                    if (aux != null)
                        return aux;
                }
                return null;
            }
        } else
            return null;
    }

    public boolean add(Integer e, Integer father) {
        TreeNode aux;
        if (nElements == 0) {
            this.root = new TreeNode(e);
        } else {
            aux = searchNode(father, root);
            if (aux == null)
                return false;
            else
                aux.addSubtree(new TreeNode(e));
        }
        nElements++;
        return true;
    }

    public Integer getRoot() {
        if (root != null)
            return root.value;
        return null;
    }

    public void setRoot(Integer e) {
        if ((e != null) && (root != null)) {
            root.value = e;
        }
    }

    public Integer getParent(Integer e) {
        TreeNode aux = searchNode(e, this.root);
        if ((aux != null) && (aux.father != null))
            return aux.father.value;
        return null;
    }

    boolean contains(Integer e) {
        return (searchNode(e, this.root) == null) ? false : true;
    }

    boolean isInternal(Integer e) {
        TreeNode aux = searchNode(e, this.root);
        if ((aux != null) && (aux.getSubtreeSize() > 0))
            return true;
        return false;
    }

    boolean isExternal(Integer e) {
        TreeNode aux = searchNode(e, this.root);
        if ((aux != null) && (aux.getSubtreeSize() == 0)) 
            return true;
        return false;
    }

    boolean isRoot(Integer e) {
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

    int[] positionsWidth() {
        if (nElements == 0)
            return null;

        int[] lista = new int[this.nElements];
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