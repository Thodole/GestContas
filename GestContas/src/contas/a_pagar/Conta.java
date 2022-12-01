package contas.a_pagar;

import java.util.Scanner;
import java.text.DecimalFormat;

public abstract class Conta {
    // Declaração de atributos da superclasse
    private static byte mesFatur; //uma vez iniciada, esta variavel manterá seu valor até o final do jvm
    private boolean atraso;
    
    Scanner sc = new Scanner(System.in);
    DecimalFormat real = new DecimalFormat("R$ #,##0.00");
    
    public Conta(boolean atraso) {
        this.atraso = atraso;
    }
    
    // método UX/in
    public String mostraModuloED() {
        return "SISTEMA DE GESTÃO DE CONTAS DE CONSUMO"
           + "\n      MÓDULO  |  ENTRADA DE DADOS";
    }

    // método entrada de dados
    public void cadastra() {
        do{
        System.out.print("ATENÇÃO! Para meses, digite números de 1 a 12"
                       + "\nInforme o mês de faturamento das contas: ");
            setMesFatur(sc.nextByte());
        }while (getMesFatur() > 12 || getMesFatur() < 1);
    }
    
    /**
     * Método de saída de dados. Mostra dados informados e gerados na aplicação
     * e os retorna em formato de texto.
     * @return 
     */
    @Override
    public String toString() {
        return ("\nMÊS DO FATURAMENTO: " + mesToString(getMesFatur()) + "\n");
    }

    // método UX/out
    public String mostraModuloSD() {
        return "SISTEMA DE GESTÃO DE CONTAS DE CONSUMO"
           + "\n      MÓDULO  |  SAÍDA DE DADOS";
    }

    // define o mês de acordo com o número informado
    public String mesToString(byte mesByte) {
        String mesString = "";
        switch(mesByte){
            case 1:
                mesString = "janeiro";
                break;
            case 2:
                mesString = "fevereiro";
                break;
            case 3:
                mesString = "março";
                break;
            case 4:
                mesString = "abril";
                break;
            case 5:
                mesString = "maio";
                break;
            case 6:
                mesString = "junho";
                break;
            case 7:
                mesString = "julho";
                break;
            case 8:
                mesString = "agosto";
                break;
            case 9:
                mesString = "setembro";
                break;
            case 10:
                mesString = "outubro";
                break;
            case 11:
                mesString = "novembro";
                break;
            case 12:
                mesString = "dezembro";
                break;
        }
        return mesString;
    }
    
    public float checkMulta(float gasto) {
        float multa;
        if (isAtraso() == true) {
            multa = gasto * 0.02f;
        } else {
            multa = 0;
        }
        return multa;
    }
    
    public float checkDesconto(float gasto, float teto) {
        float desconto = 0;
        if (gasto < teto) {
            desconto = gasto * 0.01f;
        }
        return desconto;
    }

    public static byte getMesFatur() {
        return mesFatur;
    }

    public static void setMesFatur(byte aMesFatur) {
        mesFatur = aMesFatur;
    }

    public boolean isAtraso() {
        return atraso;
    }

    public void setAtraso(boolean atraso) {
        this.atraso = atraso;
    }
    
}