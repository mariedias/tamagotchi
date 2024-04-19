public class Tamagotchi{
    private String nome; //Variável nome do tamagotchi
    private int idade; //Variável idade do tamagotchi
    private int peso; //Variável peso do tamagotchi
    private int fomeEscolha; //Variável que seleciona comandos realcionados a fome
    private int tedioEscolha; //Variável que seleciona comandos relacionados ao tédio
    private int sonoEscolha; //Variável que seleciona comandos relacionados ao sono

    //Método que referencia as variáveis do perfil
    public Tamagotchi(){
        this.nome = "";
        this.idade = 0;
        this.peso = 1;
    }    
    //Método construtor do perfil do tamagotchi
    public Tamagotchi(String nome, int idade, int peso){
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
    }
    //Método de acesso getNome (pega informação da variável)
    public String getNome(){
        return nome;
    }
    //Método de acesso setNome (altera informação da variável)
    public void setNome(String nome){
        this.nome = nome;
    }
    //Método de acesso getIdade 
    public int getIdade(){
        return idade;
    }
    //Método de acesso setIdade
    public void setIdade(int idade){
        this.idade = idade;
    }
    //Método de acesso getPeso
    public int getPeso(){
        return peso;
    }
    //Método de acesso setPeso
    public void setPeso(int peso){
        this.peso = peso;
    }
    //Método void (sem retorno) que condiciona a ação de comer
    public void comer(){
        System.out.println(nome+" está com fome\n");
        fomeEscolha = Teclado.leInt("Escolha: \n 1 - Comer muito\n 2 - Comer pouco\n 3 - Não comer\n");
        if (fomeEscolha == 1){
            this.peso += 5;
            if (this.peso < 20 && this.peso > 0){
                perfil();
                dormir();
            }
        } 
        else if (fomeEscolha == 2){
            this.peso += 1;
        }
        else if (fomeEscolha == 3){
            this.peso -= 2;
        }
        else{
            System.out.println("Opção inválida");
        }    
    }
    //Método void dormir que condiciona a ação de dormir
    public void dormir(){
        System.out.println(nome+" está com sono\n");
        sonoEscolha = Teclado.leInt("Escolha: \n 1 - Dormir\n 2 - Permanecer acordado\n");
        if (sonoEscolha == 1){
            this.idade += 1;
        } 
        else if (sonoEscolha == 2){
            int j=0;
            while (j<5){
                this.idade += 0;                        
                j++;
            }
            for (int i=0; i > 5; i++)
                this.sonoEscolha = 1;
        }
        else{
            System.out.println("Opção inválida");
        }        
    }
    //Método void que condiciona a ação de se exercitar
    public void exercitar(){
        System.out.println(nome+" está entediado\n");
        tedioEscolha = Teclado.leInt("Escolha: \n 1 - Correr por 10 minutos\n 2 - Caminhar por 10 minutos\n");
        if (tedioEscolha == 1){
            this.peso -= 4;
            System.out.println(nome+" comeu muito após a corrida");
            this.peso += 5;
            perfil();
            dormir();
        }
        else if (tedioEscolha == 2){
            this.peso -= 1;
            perfil();
            comer();
        }
        else{
            System.out.println("Opção inválida");
        }    
    }
    //Método void que imprime o perfil do tamagotchi (nome, idade e peso)
    public void perfil(){
        System.out.println("\n");
        System.out.println("+--------------------------------------+");
        System.out.println("|      PERFIL DO SEU TAMAGOTCHI        |");
        System.out.println("+--------------------------------------+");
        System.out.println("\n");
        System.out.println(
            "             **         ** \n" +       
            "            * * *     * * * \n" +        
            "          *        *        * \n" +        
            "         *    **       **    * \n" +      
            "          *       ***       * \n" +      
            "             * * *   * * * \n" +        
            "          *                 * \n" +
            "         *                   *");
        System.out.println("\n");
        System.out.println("Nome: "+nome);
        if (idade == 1){
            System.out.println("Idade: "+idade+" dia \n"+
                "Peso: "+peso+" kg \n" +
                "\n");
        }
        else{
            System.out.println("Idade: "+idade+" dias \n"+
                "Peso: "+peso+" kg \n" +
                "\n");
        }
    }
}