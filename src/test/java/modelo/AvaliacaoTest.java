package modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import alfa.br.com.gilmario.modelo.Avaliacao;
import alfa.br.com.gilmario.modelo.ValoresInvalidosException;

public class AvaliacaoTest {

    private Avaliacao avaliacao;

    @Before
    public void setup() {

        avaliacao = new Avaliacao();
    }


//    //CT01
//    @Test
//    public void testaQuatidadeParametrosMenorQuatro() {
//
//        String resultado = avaliacao.avalia(7.0, 6.0,  5);
//    }


    //CT02
//    public void testaQuatidadeParametrosMaiorQuatro() {
//
//        String resultado = avaliacao.avalia(7.0, 6.0,  5, 96, 48);
//    }

    //CT03
    @Test
    public void testQtdParametros4ENota1MenorQueZero() {
        try {
            String resultado = avaliacao.avalia(-7.0, 6.0, 5, 96 );
        } catch (Exception e) {
            Assert.assertTrue(e instanceof ValoresInvalidosException);
        }
    }


    //CT04
    @Test
    public void testQtdParametros4ENota1MaiorQueDez() {
        try {
            String resultado = avaliacao.avalia(11.0, 6.0, 5, 96);
        } catch (Exception e) {
            Assert.assertTrue(e instanceof ValoresInvalidosException);
        }
    }

    //CT05
    @Test
    public void testNota2MenorQueZero() {
        try {
            String resultado = avaliacao.avalia(8.0, -1.0, 5,96);
        } catch (Exception e) {
            Assert.assertTrue(e instanceof  ValoresInvalidosException);
        }
    }

    //CT06
    @Test
    public void testNota2MaiorQueDez() {
        try {
            String resultado = avaliacao.avalia(8.0, 11.0, 5,96);
        } catch (Exception e) {
            Assert.assertTrue(e instanceof  ValoresInvalidosException);
        }
    }

    //CT07
    @Test
    public void testQtdFaltasMenorQueZero() {
        try {
            String resultado = avaliacao.avalia(8.0, 7.0, -3,96);
        } catch (Exception e) {
            Assert.assertTrue(e instanceof  ValoresInvalidosException);
        }
    }

    //CT08
    @Test
    public void testQtdFaltasMaiorQueCargaHoraria() {
        try {
            String resultado = avaliacao.avalia(8.0, 7.0, 97, 96);
        } catch (Exception e) {
            Assert.assertTrue(e instanceof  ValoresInvalidosException);
        }
    }

    //CT09
    @Test
    public void testCargaHorariaMenorQueZero() {
        try {
            String resultado = avaliacao.avalia(8.0, 7.0, 16, -1);
        } catch (Exception e) {
            Assert.assertTrue(e instanceof  ValoresInvalidosException);
        }
    }

    //CT10
    @Test
    public void testCargaHorariaMaiorQue96() {
        try {
            String resultado = avaliacao.avalia(8.0, 7.0, 16, 97);
        } catch (Exception e) {
            Assert.assertTrue(e instanceof  ValoresInvalidosException);
        }
    }

    //CT11
    @Test
    public void testReprovadoPorFalta() {
        String resultado = null;
        try {
            resultado = avaliacao.avalia(8.0, 7.0, 28, 96);
        } catch (ValoresInvalidosException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(resultado.equals("Reprovado por Falta."));
    }

    //CT12
    @Test
    public void testReprovadoPorMedia() {
        String resultado = null;
        try {
            resultado = avaliacao.avalia(2.0, 3.0, 15, 96);
            Assert.assertTrue(resultado.equals("Reprovado por Média."));
        } catch (ValoresInvalidosException e) {
            e.printStackTrace();
        }
    }

    //CT13
    @Test
    public void testSegundaChamada() {
        String resultado = null;
        try {
            resultado = avaliacao.avalia(4.0, 5.0, 15, 96);
            Assert.assertTrue(resultado.equals("Prova Extra."));
        } catch (ValoresInvalidosException e) {
            e.printStackTrace();
        }
    }

    //CT14
    @Test
    public void testAprovado() {
        String resultado = null;
        try {
            resultado = avaliacao.avalia(7.0, 8.0, 15, 96);
            Assert.assertTrue(resultado.equals("Aprovado."));
        } catch (ValoresInvalidosException e) {
            e.printStackTrace();
        }
    }

}