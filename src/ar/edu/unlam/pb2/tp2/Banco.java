package ar.edu.unlam.pb2.tp2;

import java.util.ArrayList;
import java.util.Iterator;

public class Banco {
	private ArrayList <CuentaBancaria> cuentas;
	private String nombre;
	
	public Banco(String nombre) {
		this.cuentas = new ArrayList<>();
		this.nombre=nombre;
	}
	
	public Boolean agregarCuenta(CuentaBancaria cuenta) {
		return cuentas.add(cuenta);
	}
	
	
	public CuentaBancaria buscarCuenta(Integer cbu) throws CuentaNoEncontradaExceptions {
		for (CuentaBancaria cuentaBancaria : cuentas) {
			if(cuentaBancaria.getCbu().equals(cbu)) {
				return cuentaBancaria;
			}
		}
		
		throw new CuentaNoEncontradaExceptions("La cuenta buscada no existe");
	}
	
	
	public void transferir(Integer cbuOrigen, Integer cbuDestino, Double monto) throws SaldoInsuficienteExceptions, MontoInvalidoExceptions {
		Iterator <CuentaBancaria> it1 = cuentas.iterator();
		while(it1.hasNext()) {
		CuentaBancaria cOrigen = it1.next();
		if(cOrigen.getCbu().equals(cbuOrigen)) {
			cOrigen.extraer(monto);
		}
		if(monto>cOrigen.getSaldo()) {
			throw new MontoInvalidoExceptions("Monto invalido para realizar la transferencia");
		}
		if(cOrigen.getSaldo()<monto) {
			throw new SaldoInsuficienteExceptions("Saldo insuficiente para realizar la transferencia");
		}
		}
		Iterator <CuentaBancaria> it2 = cuentas.iterator();
		while(it2.hasNext()) {
			CuentaBancaria cDestino = it2.next();
			if(cDestino.getCbu().equals(cbuDestino)) {
				cDestino.depositar(monto);
			}
		}
		
	}
	
	
	public ArrayList<CuentaBancaria> ObtenerListadoDeCuentaDeUnCliente(Long dni){
		ArrayList <CuentaBancaria>listaCuentaCliente=new ArrayList<>();
		Iterator <CuentaBancaria> it = cuentas.iterator();
		while(it.hasNext()) {
			CuentaBancaria c = it.next();
			if(c.cliente.getDni().equals(dni)) {
				listaCuentaCliente.add(c);
				
			}
		}
		return listaCuentaCliente;
	}
	public Integer cantidadDeCuentasDelBanco() {
		return cuentas.size();
	}
	
	
}
