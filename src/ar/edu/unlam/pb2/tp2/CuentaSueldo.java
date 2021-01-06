package ar.edu.unlam.pb2.tp2;

public class CuentaSueldo extends CuentaBancaria {

	public CuentaSueldo(Double saldo, Integer cbu, Cliente cliente) {
	super(saldo, cbu, cliente);
}
	@Override
	public void depositar(Double monto) {
		super.depositar(monto);
	}
	@Override
	public void extraer(Double montoARetirar) {
		if(this.saldo>montoARetirar) {
			super.saldo-=montoARetirar;
	}
	}
}
