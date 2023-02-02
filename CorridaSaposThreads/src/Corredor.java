import java.util.Random;

/**
 * @author José Vinícius de Carvalho Oliveira
 */

public class Corredor extends Thread {
    public static final int TAM_MAX_PULO = 5;
    public static final int DISTANCIA_MAX = 50;

    private String nome;
    private int pulos;
    private int distancia;

    
    public Corredor(String nome) {
        this.nome = nome;
        this.pulos = 0;
        this.distancia = 0;
    }

    @Override
    public void run() {
        while (getDistancia() < DISTANCIA_MAX) {
            pular();

            try {
                sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
       
        if (getDistancia() == DISTANCIA_MAX) {
            posicaoSapoChegada();
        }
    }

    public void pular() {
        StringBuilder mensagem = new StringBuilder();
        int diferenca;
        Random random = new Random();
       
        int pulo = random.nextInt(TAM_MAX_PULO + 1);
        this.pulos++;
        this.distancia += pulo;

        if (getDistancia() > DISTANCIA_MAX) {
            diferenca = getDistancia() - DISTANCIA_MAX;
            this.distancia = getDistancia() - diferenca;
        }

        mensagem.append("O corredor " + getNome() + " pulou " + pulo + " metros. ");
        mensagem.append("Já percorreu " + getDistancia() + " metros. ");
        mensagem.append("E deu " + getPulos() + " pulos!");

        System.out.println(mensagem);
    }

    private synchronized void posicaoSapoChegada() {
        synchronized(App.posicoes) {
            App.posicoes.add(this.nome);
            System.out.println("O corredor: " + this.nome + " - chegou em " + (App.posicoes.indexOf(this.nome) + 1) + "º lugar");
        }
        
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setPulos(int pulos) {
        this.pulos = pulos;
    }

    public int getPulos() {
        return pulos;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getDistancia() {
        return distancia;
    }
}
