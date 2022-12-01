package contas.a_receber;

import contas.a_pagar.ContaAgua;
import contas.a_pagar.ContaLuz;
import java.text.DecimalFormat;
import java.util.Scanner;

public class FundInvest {
    private ContaAgua water = new ContaAgua(false,0f, 0f);
    private ContaLuz light = new ContaLuz(false,0f, 0f);
    private float fundInvest = 1500f;
    private final float TETO_CONSUMO = light.getGASTO_MAX_LUZ() 
            + water.getGASTO_MAX_AGUA();
    private float totalGastosConsumo;
    private float balanco;
    
    Scanner sc = new Scanner (System.in);
    DecimalFormat real = new DecimalFormat("R$ #,##0.00");
    
    public FundInvest(float fundInvest, float totalGastosConsumo, 
            float balanco){
        this.fundInvest = fundInvest;
        this.totalGastosConsumo = totalGastosConsumo;
        this.balanco = balanco;
    }
    
    public String mostraModuloED(){
        return "SISTEMA DE GESTÃO FUNDO DE INVESTIMENTOS"
           + "\n       MÓDULO  |  ENTRADA DE DADOS";
    }
    
    public String mostraModuloSD(){
        return "SISTEMA DE GESTÃO FUNDO DE INVESTIMENTOS"
           + "\n       MÓDULO  |  SAÍDA DE DADOS";
    }
    
    public void cadastra(){
        getWater().cadastra();
        System.out.println();
        getLight().cadastra();
    }
    
    @Override
    public String toString(){
        String txt1 = (getWater().toString() + "\n" + getLight().toString() 
                + "\n\nSALDO ANTERIOR DO FUNDO DE INVESTIMENTOS: "
                + real.format(getFundInvest())
                +"\nTETO DE GASTOS COM CONTAS DE CONSUMO: " 
                + real.format(getTETO_CONSUMO()));
        
        setTotalGastosConsumo(getLight().getTotalGastosLuz() 
                + getWater().getTotalGastosAgua());
        setBalanco(getTETO_CONSUMO() - getTotalGastosConsumo());
        float novoSaldo = getFundInvest() + getBalanco();
        
        String txt2 = ("\nTOTAL DE GASTOS COM CONTAS DE CONSUMO: " 
                + real.format(getTotalGastosConsumo()) 
                + "\nBALANÇO CONTÁBIL DE CONSUMO DO MÊS: " 
                + real.format(getBalanco()) + " | " + apresentaResultadoMensal()
                + "\nFUNDO DE INVESTIMENTO APÓS O RESULTADO: " 
                + real.format(novoSaldo));
        return txt1 + txt2;
    }
    
    public String apresentaResultadoMensal(){
        String mensagem;
        if (getBalanco() > 0){
            mensagem = "Saldo Positivo!";
        } else if (getBalanco() < 0){
            mensagem = "Saldo Negativo!";
        } else {
            mensagem = "Saldo Nulo!";
        }
        return mensagem;
    }

    public ContaAgua getWater() {
        return water;
    }

    public void setWater(ContaAgua water) {
        this.water = water;
    }

    
    public ContaLuz getLight() {
        return light;
    }

    public void setLight(ContaLuz light) {
        this.light = light;
    }

    public float getFundInvest() {
        return fundInvest;
    }

    public void setFundInvest(float fundInvest) {
        this.fundInvest = fundInvest;
    }

    public float getTETO_CONSUMO() {
        return TETO_CONSUMO;
    }

    public float getTotalGastosConsumo() {
        return totalGastosConsumo;
    }

    public void setTotalGastosConsumo(float totalGastosConsumo) {
        this.totalGastosConsumo = totalGastosConsumo;
    }

    public float getBalanco() {
        return balanco;
    }

    public void setBalanco(float balanco) {
        this.balanco = balanco;
    }
}