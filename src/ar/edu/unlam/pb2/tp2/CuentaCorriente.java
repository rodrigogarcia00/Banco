package ar.edu.unlam.pb2.tp2;

public class CuentaCorriente extends CuentaBancaria {
	private Double limiteDescubierto;
	private Double deuda;

	public CuentaCorriente(Double saldo, Integer cbu, Cliente cliente) {
		super(saldo, cbu, cliente);
		this.limiteDescubierto=150.0;
		this.deuda=0.0;
	}
	

public Double getLimiteDescubierto() {
		return limiteDescubierto;
	}


	public void setLimiteDescubierto(Double limiteDescubierto) {
		this.limiteDescubierto = limiteDescubierto;
	}
	
public Double getDeuda() {
		return deuda;
	}

public void setDeuda(Double deuda) {
		this.deuda = deuda;
	}

	@Override
	public void depositar(Double montoADepositar) {
		super.depositar(montoADepositar);
	}
	
	public void extraer(Double montoARetirar) {
		Double comision=5.0;
			if(montoARetirar<=this.saldo) {
				this.saldo-=montoARetirar;
			}else if(montoARetirar<=super.getSaldo()+limiteDescubierto) {
				limiteDescubierto=(montoARetirar-super.getSaldo());
				super.saldo-=super.getSaldo();
				deuda=limiteDescubierto+((limiteDescubierto*comision)/100);
			}
	}
}
