
public class Carrinho {
    private int estoque = 2, qtdItem;
    private double total =0,valor;
    private String cupomAplicado = "";


    public double calcuarTotal(){
        return 0.0;
    }
    public  void aumentarTotal(double valor, int  qtd){
        if(qtd <= 0){
            throw new IllegalArgumentException("A quantdade deve ser maior que 0.");
        }
        this.total += valor * qtd;

    }

    public void adicionarProduto(int qtd) throws EstoqueInsuficienteException {
        if (qtd > estoque) {
            throw new EstoqueInsuficienteException("Produtos com estoque insuficiente");
        }
    }

    public void adicionarItem(double valor){
        this.total += valor;
    }
    public void removerItem(double valor ) {
        this.total -= valor;
    }
    public double getTotal(){
        return total;
    }

    public void utilizarCupom(double percent){
        double desconto = this.total * (percent/100);
        this.total -= desconto;
    }

    public void aplicarCupom(String cupom){
        if(this.cupomAplicado.equals(cupom)){
            throw new CupomJaAplicadoException("Cupom já utilizado");
        }
        this.cupomAplicado = cupom;
    }

    public void finalizarCompra(){
        if(this.qtdItem == 0){
            throw new CarrinhoVazioException("Não foi possivel finalizar a compra, pois o carrinho estar vazio!");
        }
    }





}