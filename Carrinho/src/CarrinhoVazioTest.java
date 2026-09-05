import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarrinhoTest {
    @Test
    void carrinhoTemTotalZero() {
        Carrinho carrinho = new Carrinho();
        assertEquals(0.0, carrinho.calcuarTotal());
    }

    @Test
    void aumentoTotal() {
        Carrinho carrinho = new Carrinho();
        assertThrows(IllegalArgumentException.class, () -> {
            carrinho.aumentarTotal(100,0);
        });
    }

    @Test
    void qtdAcimaDoEstoque() {
        Carrinho carrinho = new Carrinho();
        assertThrows(EstoqueInsuficienteException.class, () -> {
            carrinho.adicionarProduto(5);
        });
    }

    @Test
    void removerItemReduzoTotal(){
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarItem(70.0);
        carrinho.removerItem(30.0);
        assertEquals(40.0, carrinho.getTotal());
    }

    @Test
    void aplicacaoCupomDeDesconto(){
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarItem(50.0);
        carrinho.utilizarCupom(10);
        assertEquals(45,carrinho.getTotal());
    }

    @Test
    void cupomJaAplicado(){
        Carrinho carrinho = new Carrinho();
        carrinho.aplicarCupom("ML10");
        assertThrows(CupomJaAplicadoException.class, () ->{
            carrinho.aplicarCupom("ML10");
        });
    }

    @Test
    void finalizarCompraComCarrinhoVazio(){
        Carrinho carrinho = new Carrinho();
        assertThrows(CarrinhoVazioException.class, () -> {
            carrinho.finalizarCompra();
        });
    }


}