package contas.a_pagar;

public class ContaAgua extends Conta {
    private float gastoAgua;
    private final float GASTO_MAX_AGUA = 880f;
    private float totalGastosAgua;

    public ContaAgua(boolean atraso, float gastoAgua, float totalGastosAgua) {
        super(atraso);
        this.gastoAgua = gastoAgua;
        this.totalGastosAgua = totalGastosAgua;
    }

    @Override
    public void cadastra() {
        super.cadastra();
        System.out.println();
        System.out.print("Gasto com consumo de água do mês de " + 
                mesToString(getMesFatur()) + ": R$ ");
        setGastoAgua(sc.nextFloat());
        char at;
        do {
            System.out.print("Esta conta foi quitada com atraso? (S/N): ");
            at = sc.next().charAt(0);
        } while(at != 'S' && at != 'N' && at != 's' && at != 'n');
        
        if (at == 'S' || at == 's') {
        setAtraso(true);
        }
    }

    @Override
    public String toString() {
        setTotalGastosAgua(getGastoAgua() + checkMulta(getGastoAgua()) 
                - checkDesconto(getGastoAgua(), getGASTO_MAX_AGUA()));
        return (super.toString() + "\nTETO PARA GASTOS COM CONSUMO DE ÁGUA: " 
                + real.format(getGASTO_MAX_AGUA()) 
                + "\nVALOR BRUTO DA CONTA DO MÊS: " 
                + real.format(getGastoAgua()) 
                + "\nMULTA POR ATRASO: " 
                + real.format(checkMulta(getGastoAgua())) 
                + "\nDESCONTO POR GASTOS ABAIXO DO TETO: " 
                + real.format(checkDesconto(getGastoAgua(),getGASTO_MAX_AGUA()))
                + "\nTOTAL DE GASTOS COM CONSUMO DE ÁGUA: " 
                + real.format(getTotalGastosAgua()));
    }

    public float getGastoAgua() {
        return gastoAgua;
    }

    public void setGastoAgua(float gastoAgua) {
        this.gastoAgua = gastoAgua;
    }

    public float getGASTO_MAX_AGUA() {
        return GASTO_MAX_AGUA;
    }

    public float getTotalGastosAgua() {
        return totalGastosAgua;
    }

    public void setTotalGastosAgua(float totalGastosAgua) {
        this.totalGastosAgua = totalGastosAgua;
    }
}