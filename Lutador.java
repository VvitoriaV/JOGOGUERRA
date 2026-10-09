package Entrega_24062026;

public class Lutador {

    //constantes das classes de combate permanecem assim e a menos risco de erro
    public static final String Caca = "Caca";
    public static final String Guerra = "Guerra";
    public static final String Estrategia = "Estrategia";
    public static final String Magia = "Magia";

    //atributos privados (informações que cada lutador possui)
    private String Nome;
    private String Classe;
    private int Ataque;
    private int Defesa;
    private int Agilidade;
    private int Dano;

    //métodos que colocam valores nos atributos
    public void setNome(String nome) {        this.Nome = nome;    }

    public void setClasse(String classe) {        this.Classe = classe;    }

    public void setAtaque(int ataque) {        this.Ataque = ataque;    }

    public void setDefesa(int defesa) {        this.Defesa = defesa;    }

    public void setAgilidade(int agilidade) {        this.Agilidade = agilidade;    }


    //-Calcula Dano
    public void CalcularDano() {        Dano = Ataque + Defesa + Agilidade;    }

    //-Retorna valores
    public String getNome() {        return Nome;    }

    public String getClasse() {        return Classe;    }

    public int getAtaque() {        return Ataque;    }

    public int getDefesa() {        return Defesa;    }

    public int getAgilidade() {        return Agilidade;    }

    public int getDano() {        return Dano;    }

    //-Torna a classe em texto (converte)
    public String toString() {
        return
                "Nome: " + getNome() + "\r\n" +
                        "Classe: " + getClasse() + "\r\n" +
                        "Ataque: " + getAtaque() + "\r\n" +
                        "Defesa: " + getDefesa() + "\r\n" +
                        "Agilidade: " + getAgilidade() + "\r\n" +
                        "Dano: " + getDano();


    }
}

/*A classe Lutador representa cada participante do torneio.
Ela armazena os atributos do lutador,
calcula seu dano total a partir dos atributos de combate
e disponibiliza métodos para cadastrar, consultar e exibir essas informações.*/
