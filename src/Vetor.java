import java.lang.reflect.Array;
import java.util.Arrays;

public class Vetor {

    private Aluno[] alunos = new Aluno[100];

    private int TotalDeAlunos = 0;


    public Aluno pega(int posicao) {

        if(!posicaoOcupada(posicao))

            throw new IllegalArgumentException("posicao inválida");

        //recebe uma posição e devolve o aluno

        /*
        1️⃣ posicaoOcupada(posicao)

Esse é um método booleano da sua própria classe:

private boolean posicaoOcupada(int posicao) {
    return posicao >= 0 && posicao < TotalDeAlunos;
}


Ele verifica se a posição:

não é negativa (posicao >= 0)

está dentro do limite de alunos adicionados (posicao < TotalDeAlunos)

📌 Ou seja:
retorna true se a posição for válida e já existir um aluno ali.

2️⃣ O operador ! (negação)
!posicaoOcupada(posicao)


O ! inverte o valor booleano:

se posicaoOcupada for true → vira false

se for false → vira true

👉 Aqui significa:
“SE a posição NÃO estiver ocupada”

3️⃣ O if
if (!posicaoOcupada(posicao))


O if verifica a condição:

Se a posição for inválida ou inexistente → entra no if

4️⃣ throw new IllegalArgumentException(...)
throw new IllegalArgumentException("posicao inválida");


Isso faz duas coisas importantes:

🔹 throw

Interrompe imediatamente a execução do método

Lança um erro (exceção)

🔹 IllegalArgumentException

É uma exceção usada quando o método recebeu um argumento inválido

Muito comum em validações de parâmetros

🔹 Mensagem "posicao inválida"

É o texto que aparecerá no erro

Ajuda a entender o que deu errado

5️⃣ O que acontece na prática?

No método pega:

public Aluno pega(int posicao) {
    if (!posicaoOcupada(posicao))
        throw new IllegalArgumentException("posicao inválida");

    return alunos[posicao];
}
         */

        return alunos[posicao];
    }

    public void remove(int posicao) {

        for(int i = posicao; i < this.TotalDeAlunos; i++) {
            this.alunos[i] = this.alunos[i+1];
        }
        TotalDeAlunos--;

        //remove pela posição

    }

    public void adiciona(int posicao, Aluno aluno){

        for(int i = TotalDeAlunos - 1; i > posicao; i-= 1){

            alunos[i+1] = alunos[i];
        }

        alunos[posicao] = aluno;
        TotalDeAlunos++;

        this.garanteEspaco();


    }

    public boolean contem(Aluno aluno) {

        for (int i = 0; i < TotalDeAlunos; i++) {
            if (aluno.equals(alunos[i])){

                return true;
            }


        }

        //descobre se o aluno está ou não na lista

        return false;


    }

    private boolean posicaoOcupada (int posicao){

        return posicao >= 0 && posicao < TotalDeAlunos;
    }


    public int tamanho() {

        //devolve a quantidade de alunos
        return TotalDeAlunos;
    }

    private void garanteEspaco(){
        if (TotalDeAlunos == alunos.length){

            Aluno[] novoArray = new Aluno[alunos.length*2];
            for (int i = 0; i < alunos.length; i++) {

                novoArray[i] = alunos[i];
                
            }

            this.alunos = novoArray;
        }
    }
    /*
    🧠 Ideia principal (bem simples)

👉 Esse método serve para garantir que sempre exista espaço para colocar mais alunos.
Se a “caixa” ficar cheia, ele cria uma caixa maior e passa tudo para ela.

1️⃣ private void garanteEspaco()

private → só essa classe pode usar esse método

void → ele não devolve nada

garanteEspaco → nome que significa:
“verifica se ainda cabe mais alguém”

📌 É um método “ajudante”, não é chamado direto pelo usuário.

2️⃣ if (TotalDeAlunos == alunos.length)

Imagine:

TotalDeAlunos → quantas figurinhas já estão na caixa

alunos.length → quantos espaços a caixa tem

📦 Se:

figurinhas == espaços da caixa


👉 A caixa está cheia 😱

Então precisamos de uma maior.

3️⃣ Aluno[] novoArray = new Aluno[alunos.length * 2];

Aqui acontece a mágica ✨

Cria uma nova caixa

Ela tem o dobro do tamanho da antiga

Exemplo:

Caixa velha: 100 espaços
Caixa nova: 200 espaços


📌 Nada é apagado ainda, é só uma caixa vazia.

4️⃣ for (int i = 0; i < alunos.length; i++)

Esse for é tipo:

“Vamos pegar tudo da caixa velha e colocar na nova”

Começa do primeiro aluno (i = 0)

Vai até o último espaço da caixa antiga

5️⃣ novoArray[i] = alunos[i];

Essa linha copia um aluno por vez:

👉 O aluno da posição i da caixa velha
👉 vai para a posição i da caixa nova

É como tirar uma figurinha da caixa antiga
e colocar no mesmo lugar da caixa nova.

6️⃣ this.alunos = novoArray;

Agora a troca final 🪄

A caixa velha é jogada fora

A caixa nova vira a oficial

👉 A classe passa a usar a caixa grande, com espaço sobrando.

🧩 O que NÃO muda?

Os alunos continuam lá

A ordem continua igual

Só mudou o tamanho da “caixa”
     */

    @Override
    public String toString() {

        //facilitará na impressão
        return Arrays.toString(alunos);
    }


    public void adiciona(Aluno aluno) {

        this.alunos[TotalDeAlunos] = aluno;
        TotalDeAlunos++;

        this.garanteEspaco();


            // recebe um aluno
        }
    }



