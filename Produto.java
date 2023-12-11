public class Produto {
  
    private int id;
    private double valor;
    private String descricao;
    private static int quantidade = 0;

    //construtor
    public Produto(String descricao, double valor)
    {
        this.descricao = descricao;
        this.valor = valor;
    }

    //metodos para retornar o valor das variaveis
    public String getDescricao()
    {
        return descricao;
    }

    public int getId()
    {
        return id;
    }

    public double getValor()
    {
        return valor;
    }

    public int getQuantidade()
    {
        return quantidade;
    }

    //metodos para setar os valor das variaveis
    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    } 
    
    public void setId(int id)
    {
        quantidade++;
        id = quantidade;
        
        this.id = id;
    } 
    
    public void setValor(double valor)
    {
        if (valor < 0.0) 
            throw new IllegalArgumentException(
                "O Valor do produto deve ser POSITIVO (maior ou igual a 0.0)!!!");
        
        this.valor = valor;
    }
    

       
    // retorna a String que representa o objeto produto
    @Override
    public String toString()
    {
        return String.format("%nDADOS DO PRODUTO: %nID: %d %nValor: %.2f %nDescricao: %s", 
            getId(), getValor(), getDescricao());
    }
    
}

