package contas.a_receber;

/**
 * 
 * @author Saul-Medeiros
 * @author thodole
 */
public class TesteFundInvest {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        FundInvest fi = new FundInvest(0f, 0f, 0f);
        System.out.println(fi.mostraModuloED() + "\n");
        fi.cadastra();
        System.out.println("\n\n" + fi.mostraModuloSD() + fi);
    }
}
