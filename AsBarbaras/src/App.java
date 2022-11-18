import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.io.IOException;
public class App {
    public static void main(String[] args) throws Exception {
        GenericTree gt = new GenericTree();
        

        
    }
    //iterar pela coisa e se tiver nivel maximo = (nao tem maior)
    //ver quais que tem maior terra
    //como criar os nodos?s

    public boolean readFile(String nomeArq, GenericTree gt) {
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
                    gt.add(paizao);
                } else {
                    String[] dados = line.split(" ");
                    int terras = Integer.parseInt(dados[2]);
                    Barbaro d = new Barbaro(gt.searchBarbaro(dados[0], gt.getRoot()), dados[1], terras);
                    gt.add(d);
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
