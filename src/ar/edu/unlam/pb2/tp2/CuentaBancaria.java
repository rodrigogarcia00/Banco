package ar.edu.unlam.pb2.tp2;

public abstract class CuentaBancaria {
	protected  Double saldo;
	protected Integer cbu;
	protected Double cantidadExtracciones;
	protected Cliente cliente;

	public CuentaBancaria(Double saldo, Integer cbu, Cliente cliente) {
		this.saldo = saldo;
		this.cbu=cbu;
		this.cantidadExtracciones=0.0;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public Integer getCbu() {
		return cbu;
	}

	public void setCbu(Integer cbu) {
		this.cbu = cbu;
	}

	public void depositar(Double monto) {
		saldo+=monto;
	}
	public abstract void extraer(Double monto) throws SaldoInsuficienteExceptions, MontoInvalidoExceptions;

	public Double getCantidadExtracciones() {
		return cantidadExtracciones;
	}

	public void setCantidadExtracciones(Double cantidadExtracciones) {
		this.cantidadExtracciones = cantidadExtracciones;
	}
	
}
