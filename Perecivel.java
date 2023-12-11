import java.util.Calendar;

public class Perecivel extends Produto{ 
    
    private int[] validade;

    //contrutor
    public Perecivel(String descricao, double valor, int dia, int mes, int ano)
    {
        super(descricao, valor);
        this.validade = new int[]{dia, mes, ano};
    }

    //metodo que verifica se o produto esta vencido ou nao
    public boolean estaVencido()
    {
      Calendar c = Calendar.getInstance();  //classe para verificar a data do dia atual

      int anoAtual = c.get(Calendar.YEAR);
      int mesAtual = c.get(Calendar.MONTH) + 1;
      int diaAtual = c.get(Calendar.DAY_OF_MONTH);

      //tranforma o dia, mes e ano em um numero inteiro (exemplo: 18/10/2023 = 20231018)
      int dataValidade = validade[2] * 10000 + validade[1] * 100 + validade[0];
      int dataAtual = anoAtual * 10000 + mesAtual * 100 + diaAtual; 

      return dataAtual > dataValidade;    //retorna true caso a data atual for maior que a data de validade
    }

    //metodo para aplicar desconto no produto perecivel
    public void aplicarDesconto(double d)
    {
        double desconto = this.getValor() * (d / 100);  
        this.setValor(this.getValor() - desconto);    //aplica o desconto sobre o valor do produto (nesse caso o destonto e de 15%) 
    }

    @Override
    public String toString()
    {
      return String.format("%nDADOS DO PRODUTO: %nID: %d %nValor: %.2f %nDescricao: %s %nValidade: %d/%d/%d", 
        getId(), getValor(), getDescricao(), validade[0], validade[1], validade[2]);
    }
}
