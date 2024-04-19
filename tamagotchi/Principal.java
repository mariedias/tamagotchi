import java.lang.Math; 
public class Principal{


    //Método main que gera executável:
    /**
     * @param args
     */
    public static void main(String [] args){
        String nomeTama = Teclado.leString("Digite o nome do seu tamagotchi: "); //Pede nome do Tamagotchi
        Tamagotchi tama = new Tamagotchi(); //Acessa variáveis e métodos da classe Tamagotchi 
        tama.setNome(nomeTama); //Vai alterar o valor da variável nome para o nome escolhido pelo jogador
        tama.perfil(); //Imprime perfil inicial do tamagotchi

        //Início do loop até que seja quebrado(break)
        while(true){
            //Chama método comer() para que o tamagotchi ganhe peso primeiro (por ser bebê)
            if (tama.getPeso() == 1 && tama.getIdade() == 0){
                tama.comer();
                tama.perfil();
            }
            //Comprova que o tamagotchi está morto, informa jogador e sugere recomeçar jogo    
            else if (tama.getIdade() > 15 || tama.getPeso() <= 0 || tama.getPeso() > 20){
                System.out.println(nomeTama +" morreu :("); //Informa morte
                char recomecar = Teclado.leChar("Deseja recomeçar o jogo? [S/N]");
                if (recomecar == 'S' || recomecar == 's'){
                    nomeTama = Teclado.leString("Digite o nome do seu tamagotchi: ");
                    tama.setNome(nomeTama); //Ao recomeçar o usuário escolhe um novo nome
                    tama.setIdade(0); //Idade do novo tamagotchi é resetada pra 0
                    tama.setPeso(1); //Peso do novo tamagotchi é resetado pra 1
                    tama.perfil(); //Imprime perfil do novo tamagotchi
                }
                else if (recomecar == 'N' || recomecar == 'n'){
                    System.out.println("Fim de jogo"); //Imprime mensagem de fim do jogo se usuário não quiser recomeçar
                    break; //Quebra loop
                }
                else{
                    System.out.println("Opção inválida"); //Imprime mensagem de opção inválida caso outra opção tenha sido selecionada
                }
            }
            //Condições do tamagotchi vivo, randomiza o próximo desejo do mesmo
            else{
                int opAleatoria = (int)(Math.random()*3) + 1;
                if(opAleatoria == 1){
                    tama.comer(); //Tamagotchi está com fome, chama método comer()
                    tama.perfil(); // Imprime perfil
                }
                else if(opAleatoria == 2){
                    tama.dormir(); //Tamagotchi está com sono, chama método dormir()
                    tama.perfil(); //Imprime perfil
                }
                else{
                    tama.exercitar(); //Tamagotchi está entediado, chama método exercitar()
                    tama.perfil(); //Imprime perfil
                }
            }
        }
    }
}