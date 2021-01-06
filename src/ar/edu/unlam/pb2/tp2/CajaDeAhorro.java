package ar.edu.unlam.pb2.tp2;

public class CajaDeAhorro extends CuentaBancaria {
	private Double costoAdicional;
	
	public CajaDeAhorro(Double saldo, Integer cbu, Cliente cliente) {
		super(saldo, cbu, cliente);
		this.costoAdicional=6.0;
	}
	
	public void extraer(Double monto) throws SaldoInsuficienteExceptions, MontoInvalidoExceptions {
		if(monto==0) {
			throw new MontoInvalidoExceptions("Monto invalido");
		}
		super.cantidadExtracciones++;
		if((super.saldo>=monto)&&(super.getCantidadExtracciones()>5.0)){
			super.saldo-=monto+costoAdicional;
		}else if (super.saldo>=monto){
			super.saldo-=monto;
			
		}else {
			throw new SaldoInsuficienteExceptions("Saldo insuficiente");
		}
		
	}
		
}
