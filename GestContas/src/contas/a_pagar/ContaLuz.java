package contas.a_pagar;

public class ContaLuz extends Conta {
    private float gastoLuz;
    private final float GASTO_MAX_LUZ = 1000f;
    private float totalGastosLuz;

    public ContaLuz(boolean atraso, float gastoLuz, float totalGastosLuz) {
        super(atraso);
        this.gastoLuz = gastoLuz;
        this.totalGastosLuz = totalGastosLuz;
    }
    
    @Override
    public void cadastra() {
        System.out.print("Gasto com consumo de luz do mês de " + 
                mesToString(getMesFatur()) + ": R$ ");
        setGastoLuz(sc.nextFloat());
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
        setTotalGastosLuz(getGastoLuz() + checkMulta(getGastoLuz()) 
                - checkDesconto(getGastoLuz(), getGASTO_MAX_LUZ()));
        return ("\nTETO PARA GASTOS COM CONSUMO DE LUZ: " 
                + real.format(getGASTO_MAX_LUZ()) 
                + "\nVALOR BRUTO DA CONTA DO MÊS: " + real.format(getGastoLuz()) 
                + "\nMULTA POR ATRASO: " 
                + real.format(checkMulta(getGastoLuz())) 
                + "\nDESCONTO POR GASTOS ABAIXO DO TETO: " 
                + real.format(checkDesconto(getGastoLuz(), getGASTO_MAX_LUZ())) 
                + "\nTOTAL DE GASTOS COM CONSUMO DE LUZ: " 
                + real.format(getTotalGastosLuz()));
    }

    public float getGastoLuz() {
        return gastoLuz;
    }

    public void setGastoLuz(float gastoLuz) {
        this.gastoLuz = gastoLuz;
    }

    public float getGASTO_MAX_LUZ() {
        return GASTO_MAX_LUZ;
    }

    public float getTotalGastosLuz() {
        return totalGastosLuz;
    }

    public void setTotalGastosLuz(float totalGastosLuz) {
        this.totalGastosLuz = totalGastosLuz;
    }
}