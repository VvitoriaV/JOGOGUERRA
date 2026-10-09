package Entrega_24062026;

import java.util.*;
public class Marco3 {

    private static final SistemaTorneio obj = new SistemaTorneio();

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        PreencherDadosLutadores();


        //(flSair = true) ele encerra sessão se flSair for verdadeiro
        boolean flSair = false;
        int escolhaMenu;

        do {
            System.out.println(" ");
            System.out.println("Menu:");
            System.out.println("1 - Registrar lutadores(as)");
            System.out.println("2 - Mostrar lutadores(as)");
            System.out.println("3 - Buscar por nome");
            System.out.println("4 - Listar por classe");
            System.out.println("5 - Mostrar combates");
            System.out.println("6 - Executar lutas");
            System.out.println("7 - Mostrar pontuações");
            System.out.println("8 - Mostrar ranking");
            System.out.println("9 - Encerrar");

            escolhaMenu = entrada.nextInt();
            entrada.nextLine(); //limpa o buffer após nextInt

            switch (escolhaMenu) {
                case 1: {
                    Registrar();
                    break;
                }
                case 2: {
                    obj.Mostrar();
                    break;
                }
                case 3: {
                    System.out.println("Digite o nome a buscar ");
                    String nome = entrada.nextLine();
                    obj.Buscar(nome);
                    break;
                }
                case 4: {
                    System.out.println("Digite a classe: ");
                    String classe = entrada.nextLine();
                    obj.listarClasse(classe);
                    break;
                }
                case 5: {
                    obj.mostrarCombates();
                    break;
                }
                case 6: {
                    obj.executarLutas();
                    break;
                }
                case 7: {
                    obj.mostrarPontuacoes();
                    break;
                }
                case 8: {
                    obj.mostrarRanking();
                    break;
                }
                case 9: {
                    flSair = true;
                    break;
                }
                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }
            // Enguanto flSair for falso vai rodar após ser verdadeiro encerra a sessão
        } while (!flSair);

        System.out.println("Sessão encerrada..!");
        entrada.close();
    }

    public static void Registrar() {
        Scanner entrada = new Scanner(System.in);

        int escolha;
        Lutador novoLutador = new Lutador();

        System.out.println("Qual o nome do lutador? ");
        novoLutador.setNome(entrada.nextLine());

        // do (faça) while (enquanto) a escolha for de 1 a 4
        do {
            System.out.println("Qual a classe de combate? ");
            System.out.println("Digite: ");
            System.out.println("1 - Caça ");
            System.out.println("2 - Guerra ");
            System.out.println("3 - Estratégia ");
            System.out.println("4 - Magia ");
            escolha = entrada.nextInt();

            if (escolha < 1 || escolha > 4) {
                System.out.println("Opção inválida!! ");
                System.out.println(" ------------------------------- ");
            } else

                switch (escolha) {
                    case 1: novoLutador.setClasse(Lutador.Caca); break;
                    case 2: novoLutador.setClasse(Lutador.Guerra);break;
                    case 3: novoLutador.setClasse(Lutador.Estrategia);break;
                    case 4: novoLutador.setClasse(Lutador.Magia);break;
                }
        } while (escolha < 1 || escolha > 4);

        /* do-while (fazer-enquanto) a escolha for de 0 a 100*/

        do {
            System.out.println("Digite qual o valor do ATAQUE? ");
            escolha = entrada.nextInt();
            if (escolha < 0 || escolha > 100) {
                System.out.println("Opção inválida!! ");
                System.out.println(" ------------------------------- ");
            } else
                novoLutador.setAtaque(escolha);
        } while (escolha < 0 || escolha > 100);

        do {
            System.out.println("Digite qual o valor da DEFESA? ");
            escolha = entrada.nextInt();
            if (escolha < 0 || escolha > 100) {
                System.out.println("Opção inválida!! ");
                System.out.println(" ------------------------------- ");
            } else
                novoLutador.setDefesa(escolha);
        } while (escolha < 0 || escolha > 100);

        do {
            System.out.println("Digite qual o valor da AGILIDADE? ");
            escolha = entrada.nextInt();
            if (escolha < 0 || escolha > 100) {
                System.out.println("Opção inválida!! ");
                System.out.println(" ------------------------------- ");
            } else
                novoLutador.setAgilidade(escolha);
        } while (escolha < 0 || escolha > 100);

        //calcula o dano antes de registrar
        novoLutador.CalcularDano();

        obj.Registar(novoLutador);
        System.out.println("Jogador cadastrado com sucesso! Dano: " + novoLutador.getDano());



    }

    public static void PreencherDadosLutadores(){
        //#1
        Lutador l1 = new Lutador();
        //- [0]
        l1.setNome("Aline");
        l1.setClasse("Guerra");
        l1.setAtaque(90);
        l1.setDefesa(20);
        l1.setAgilidade(40);
        l1.CalcularDano();
        //-
        obj.Registar(l1);
        //------------------------------------------------


        //#2
        Lutador l2 = new Lutador();
        //- [1]
        l2.setNome("Joana");
        l2.setClasse("Magia");
        l2.setAtaque(90);
        l2.setDefesa(50);
        l2.setAgilidade(43);
        l2.CalcularDano();
        //-
        obj.Registar(l2);
        //---------------------------------------------

        //#3
        Lutador l3 = new Lutador();
        //- [2]
        l3.setNome("Lucas");
        l3.setClasse("Caca");
        l3.setAtaque(42);
        l3.setDefesa(50);
        l3.setAgilidade(40);
        l3.CalcularDano();
        //-
        obj.Registar(l3);
        //---------------------------------------------

        //#4
        Lutador l4 = new Lutador();
        //- [3]
        l4.setNome("Joaquim");
        l4.setClasse("Estrategia");
        l4.setAtaque(80);
        l4.setDefesa(60);
        l4.setAgilidade(43);
        l4.CalcularDano();
        //-
        obj.Registar(l4);
        //-------------------------------------------

        //#5
        Lutador l5 = new Lutador();
        // [4]
        l5.setNome("Raquel");
        l5.setClasse("Caca");
        l5.setAtaque(96);
        l5.setDefesa(70);
        l5.setAgilidade(40);
        l5.CalcularDano();
        //-
        obj.Registar(l5);
        //---------------------------------------

        //#6
        Lutador l6 = new Lutador();
        // [5]
        l6.setNome("Elena");
        l6.setClasse("Guerra");
        l6.setAtaque(95);
        l6.setDefesa(50);
        l6.setAgilidade(30);
        l6.CalcularDano();
        //-
        obj.Registar(l6);
        //---------------------------------------

        //#7
        Lutador l7 = new Lutador();
        // [6]
        l7.setNome("Luana");
        l7.setClasse("Estrategia");
        l7.setAtaque(90);
        l7.setDefesa(20);
        l7.setAgilidade(43);
        l7.CalcularDano();
        //-
        obj.Registar(l7);
        //-------------------------------------

        //#8
        Lutador l8 = new Lutador();
        // [7]
        l8.setNome("Amanda");
        l8.setClasse("Magia");
        l8.setAtaque(90);
        l8.setDefesa(40);
        l8.setAgilidade(43);
        l8.CalcularDano();
        //-
        obj.Registar(l8);
        //-----------------------------------


    }

}

/*Esse Marco3 é a classe principal do programa. Ela é responsável por:

Exibir o menu.
Receber as escolhas do usuário.
Chamar os métodos da classe SistemaTorneio.
Cadastrar lutadores manualmente ou automaticamente.*/