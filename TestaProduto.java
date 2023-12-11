//Daniela Akemi Hayashi
//Flavia Cristina Medeiros
//Giovana Salazar Alarcon

import java.util.Scanner;

public class TestaProduto {
   public static void main(String[] args)
   {
    int indice=0, id = 0;
    String descricao;
    double valor = 0;
    int[] validade = new int[3];
    char desconto;

    Scanner input = new Scanner(System.in); 

    do{
        do{
            System.out.print("\n----------------------------------- CADASTRO DE PRODUTOS ------------------------------------\n");
            System.out.print("\n\n [1] Criar Produto");
            System.out.print("\n [2] Criar Produto Perecivel");
            System.out.print("\n [3] Sair");

            System.out.print("\n\n\n Digite o Numero de uma das opcoes acima: ");
            indice = input.nextInt();              // Faz a leitura do indice de uma das opcoes
    }while(indice<1 || indice>3);

        switch(indice){
            case 1:
                System.out.print("\n------------------------------------------ PRODUTO -------------------------------------------\n");
                
                //usuario esta fazendo cadastro de um novo produto
                System.out.print("\nDigite a descricao do produto: ");
                input.nextLine();             //utiliza-se para retirar o proximo input nao ser o enter
                descricao = input.nextLine();
                
                System.out.print("\nDigite o valor do produto: ");
                valor = input.nextDouble();

                //cria-se um novo objeto da classe Produto
                Produto myProduto = new Produto(descricao, valor);
                myProduto.setDescricao(descricao);
                myProduto.setValor(valor);
                myProduto.setId(id);
                System.out.println(myProduto);          //faz a impressao do produto
                break;
            case 2:
                System.out.print("\n------------------------------------- PRODUTO PERECIVEL -------------------------------------\n");

                //usuario esta fazendo cadastro de um novo produto
                System.out.print("\nDigite a descricao do produto: ");
                input.nextLine(); 
                descricao = input.nextLine();
                
                System.out.print("\nDigite o valor do produto: ");
                valor = input.nextDouble();

                System.out.print("\nDigite a data de validade do produto: \n");
                do{
                    System.out.print("Dia(1 a 31).....: ");
                    validade[0] = input.nextInt();
                }while(validade[0]<1 || validade[0]>31);        //faz a leitura do dia (entre 1 e 31)

                do{
                    System.out.print("Mes(1 a 12).....: ");
                    validade[1] = input.nextInt();
                }while(validade[1]<1 || validade[1]>12);        //faz a leitura do mes de janeiro(1) ate dezembro(12)

                System.out.print("Ano(aaaa).......: ");
                validade[2] = input.nextInt();                  //faz a leitura do ano

                //cria-se um novo objeto da classe Perecivel
                Perecivel myPerecivel = new Perecivel(descricao, valor, validade[0], validade[1], validade[2]);
                myPerecivel.setDescricao(descricao);
                myPerecivel.setValor(valor);
                myPerecivel.setId(id);
                System.out.println(myPerecivel);        //faz a impressao do produto perecivel
            
                //verifica se o produto esta vencido
                if(myPerecivel.estaVencido()){                          
                    System.out.printf("O produto esta VENCIDO! \n");
                } else {
                    System.out.printf("O produto NAO esta VENCIDO! \n");
                }
                //verifica se o usuario deseja aplicar desconto
                System.out.print("\nDeseja aplicar desconto de 15% no produto? (s/n): ");
                desconto = input.next().charAt(0);
                if(desconto == 's'){
                    myPerecivel.aplicarDesconto(15);
                    System.out.println(myPerecivel);
                } else {
                System.out.println(myPerecivel);
                }
                break;
            case 3:
                System.out.print("\n\nFIM DO PROGRAMA...\n");
                break;
        }
        //utilizado para manter na tela ate que o usuario deseje proseguir para a proxima tela
        input.nextLine();
        System.out.print("\n\nDigite a tecla ENTER para continuar...");   
        input.nextLine();

    }while(indice != 3);

   } 
}
