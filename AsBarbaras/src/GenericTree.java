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

    Queue valoresUltimoNivel() throws Exception {//solucao inspirada no geeks for geeks
        int nivel = 0;
        int contador = 0;
        if (root == null)
            return null;
    
        Queue q = new Queue();
        q.add(root.value);
        while (!q.isEmpty())
        {
            int n = q.size();
    
            while (n > 0)
            {
                TreeNode p = searchNode(q.peek(), root);
                q.remove();
                System.out.print(p.value + "  -  ");
    
                for (int i = 0; i < p.getSubtreeSize(); i++)
                    q.add(p.getSubtree(i).value);
                n--;
            }
            nivel++;
            System.out.println();
        }
        System.out.println("altura: " + nivel);

        Queue ultimo = new Queue();
        q.clear();
        q.add(root.value);
        while (!q.isEmpty())
        {
            int n = q.size();
            while (n > 0)
            {
                TreeNode p = searchNode(q.peek(), root);
                q.remove();
                if (contador==nivel-1)
                    ultimo.add(p.value);
    
                for (int i = 0; i < p.getSubtreeSize(); i++)
                    q.add(p.getSubtree(i).value);
                n--;
            }
            contador++;
        }
        ultimo.exibirLista();
        return ultimo;
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