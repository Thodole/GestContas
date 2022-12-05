package contas.a_pagar;

/**
 * 
 * @author Saul-Medeiros
 * @author thodole
 */
public class TesteConta {

    public static void main(String[] args) {
        Conta water = new ContaAgua(false, 0f, 0f);
        Conta light = new ContaLuz(false, 0f, 0f);
        System.out.println(light.mostraModuloED() + "\n");//invoca o cabecalho de entrada
        water.cadastra();
        System.out.println();
        light.cadastra();
        System.out.println("\n\n"+light.mostraModuloSD()+"\n"+water+"\n\n"+light);
    }
}
