package Entrega_24062026;

public class SistemaTorneio {

    public SistemaTorneio(){
        //#1 construtor da classe
        /*Lutadores[0] = new Lutador();
        Lutadores[0].setNome("Aline");
        Lutadores[0].setClasse("Guerra");
        Lutadores[0].setAtaque(90);
        Lutadores[0].setDefesa(20);
        Lutadores[0].setAgilidade(40);
        Lutadores[0].CalcularDano();*/
    }

    //vetor e matrizes
    //chamei a classe Lutador [vetor]
    private Lutador[] Lutadores = new Lutador[8];

    //matriz[12][2] indices que irão lutar
    private int[][] Combates = {
        {3, 4}, {3, 5}, {1, 7}, {4, 5},
        {6, 3}, {7, 0}, {7, 5}, {1, 0},
        {6, 4}, {2, 6}, {1, 2}, {0, 2}
    };
    //cada linha é um lutador cada coluna é a pontuação de um combate
    private int[][] Pontuacoes = new int[8][3];

    //FUNÇÕES
    //registrar lutador na primeira opção disponivel
    public void Registar(Lutador objetoLutador) {
        int POSICAO = -1;

        for (int i = 0; i < 8; i++)
            if (Lutadores[i] == null) {
                POSICAO = i;
                Lutadores[i] = objetoLutador;
                break;
            }

        //CRIA UMA EXCEÇÃO(ERRO) EM TEMPO DE EXECUÇÃO
        if (POSICAO == -1)
            throw new RuntimeException("Todos os jogadores já foram preenchidos!");
    }

    //mostrar lutadores
    public void Mostrar() {
        System.out.println("\n=== LUTADORES REGISTRADOS ===");
        boolean acheiLutador = false;
        for (int i= 0; i < 8; i++){
            if (Lutadores[i] != null){
                System.out.println("[" + i + "] " + Lutadores[i].toString());
                System.out.println("-----------------------------");
                acheiLutador = true;
            }
        }
        if(!acheiLutador)
            System.out.print("Nenhum lutador registrador ainda!! ");
    }

    //buscar por nome de jogador
    public void Buscar(String nome) {
        System.out.println("\n=== BUSCAR POR NOME: " + nome + " ===");
        boolean encontrado = false;
        for (int i = 0; i < 8; i++){
            if (Lutadores[i] != null && Lutadores[i].getNome().equalsIgnoreCase(nome)){
                System.out.print(Lutadores[i].toString());
                encontrado = true;
            }
        }
        if (!encontrado)
            System.out.println("Nenhum lutador com o nome \"" + nome + "\" foi encontrado! ");
    }

    //mostrar todos os lutadores que estão na classe
    public void listarClasse(String classe) {
        System.out.println("\n=== LUTADORES DA CLASSE: " + classe + " ===");
        boolean encontrado = false;
        for(int i = 0; i < 8; i++){
            if(Lutadores[i] != null && Lutadores[i].getClasse().equalsIgnoreCase(classe)){
                System.out.println(Lutadores[i].toString());
                System.out.println("---------------------------------");
                encontrado = true;
            }
        }
        if (!encontrado)
            System.out.println("Nenhum lutador da classe \"" + classe + "\" foi registrador.");
    }

    //mostra os combates
    //posicaoA posicaoB é o indice matriz da 12x2 os primeiros seria 3,4
    public void mostrarCombates() {
        System.out.println("\n=== COMBATES DO TORNEIO ===");
        for (int i = 0; i < Combates.length; i++){
            int posicaoA = Combates[i][0];
            int posicaoB = Combates[i][1];
            String nomeA = (Lutadores[posicaoA] != null)? Lutadores[posicaoA].getNome() : "Lutador" + posicaoA;
            String nomeB = (Lutadores[posicaoB] != null)? Lutadores[posicaoB].getNome() : "Lutador" + posicaoB;
            System.out.println("Combate" + (i + 1) + ": " + nomeA + " VS " + nomeB);
        }
    }


    //executa todas lutas e preenche a matriz de potuacoes 8x3
    public void executarLutas() {
        //verifica se todos foram registrados
        for (int i = 0; i < 8; i++){
            if(Lutadores[i] == null){
                System.out.println("Registre os 8 lutadores antes de executar as lutas!");
                return;
            }
        }
        //contador de combates por lutador
        int[] contador = new int[8];

        System.out.println("\n=== EXECUTANDO LUTAS ===");
        for (int i =0; i < Combates.length; i++){
            //ve na matriz12x2 o indice na posicao[0][1]
            int posicaoA = Combates[i][0];
            int posicaoB = Combates[i][1];

            int danoA = Lutadores[posicaoA].getDano();
            int danoB = Lutadores[posicaoB].getDano();

            Pontuacoes[posicaoA][contador[posicaoA]] = danoA - danoB;
            Pontuacoes[posicaoB][contador[posicaoB]] = danoB - danoA;

            contador[posicaoA]++;
            contador[posicaoB]++;

            String resultado;
            if(danoA > danoB)
                resultado = Lutadores[posicaoA].getNome() + " venceu!";
            else if (danoB > danoA)
                resultado = Lutadores[posicaoB].getNome() + " venceu!";
            else
                resultado = "Empate! ";

            System.out.println("Combates " + (i + 1) + ": " +
                    Lutadores[posicaoA].getNome() + " (" + danoA + ") vs " +
                    Lutadores[posicaoB].getNome() + " (" + danoB + ") -> " + resultado);
        }
        System.out.println("LUTAS EXECUTADAS COM SUCESSO!");
    }

    //exibe a pontuacao de cada lutador nos 3 combates e o total acumulado
    public void mostrarPontuacoes() {
        System.out.println("\n=== PONTUACOES ===");
        for(int i =0; i < 8; i++){
            if (Lutadores[i] == null) continue;
            int total = Pontuacoes[i][0] +Pontuacoes[i][1] + Pontuacoes[i][2];
            System.out.println(Lutadores[i].getNome()+
                    " | Primeiro Combate:  " +  Pontuacoes[i][0]+
                    " | Segundo Combate: " + Pontuacoes[i][1]+
                    " | Terceiro Combate: " + Pontuacoes[i][2]+
                    " | Total: " + total);
        }
    }

    /**
     * Exibe o ranking final dos(as) lutadores(as) ordenado por pontuação total (maior para menor).
     * Utiliza selection sort para ordenar.
     */
    public void mostrarRanking() {
        //verifica se todos foram registrados
        for (int i= 0; i < 8; i++){
            if (Lutadores[i] == null){
                System.out.println("Registre todos os lutadores e execute as lutas primeiro!");
                return;
            }
        }
        //calcula totais e guarda indices
        int[] totais = new int[8]; // guarda a soma dos 3 combates
        int[] indices = new int[8]; // guarda a posicao original do lutador

        //soma os 3 combates e guarda os indices
        for (int i =0; i < 8; i++){
            totais[i] = Pontuacoes[i][0] + Pontuacoes[i][1] + Pontuacoes[i][2];
            indices[i] = i;
        }

        //max = máximo (maior)
        //Idx = índice (posição)
        //Selection sort descrescente
        for (int i= 0; i < 7; i++){
            int atualMelhor = i;
            for (int j = i + 1; j < 8; j++){
                if(totais[indices[j]] > totais[indices[atualMelhor]])
                    atualMelhor = j;
            }
            int valorTemporario = indices[i];
            indices[i] = indices[atualMelhor];
            indices[atualMelhor] = valorTemporario;
        }

        //mensagemCampeao = texto que aparece somente para o primeiro colocado do ranking.
        System.out.println("\n=== RANKING FINAL DO TORNEIO ===");
        for (int i =0; i < 8; i++){
            int indiceLutador = indices[i];
            String mensagemCampeao = (i == 0) ? " <<< CAMPEÃO! >>> " : "";
            System.out.println((i + 1) + "° - " +
                    Lutadores[indiceLutador].getNome() +
                    " | Classe: " + Lutadores[indiceLutador].getClasse() +
                    " | Pontuação: " + totais[indiceLutador] + mensagemCampeao);
        }


    }

}

/*A classe SistemaTorneio é a responsável por controlar
o torneio.
Armazena os lutadores.
Define os combates.
Executa as lutas.
Calcula as pontuações.
Exibe o ranking final.*/
