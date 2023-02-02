import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author José Vinícius de Carvalho Oliveira
 */

public class App {

    public static List<String> posicoes = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        List<Corredor> sapos = new ArrayList<Corredor>(Arrays.asList(new Corredor("Sapo 1"),
                                                                     new Corredor("Sapo 2"),
                                                                     new Corredor("Sapo 3"),
                                                                     new Corredor("Sapo 4"),
                                                                     new Corredor("Sapo 5")));

        for (Corredor corredor : sapos) {
            corredor.start();
        }
    }
}
