package ar.edu.unlam.pb2.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCuenta {

	@Test
	public void testQueVerificaUnaExtraccionEnCuentaSaldo() {
		Cliente cliente = new Cliente ((long) 42540661, "fabricio","jara");
		CuentaSueldo cuentaSueldo = new CuentaSueldo(100.0, 1111111, cliente);
		cuentaSueldo.depositar(100.0);
		assertEquals((Double)200.0,cuentaSueldo.getSaldo());
		cuentaSueldo.extraer(150.0);
		assertEquals((Double)50.0, cuentaSueldo.getSaldo());
	}
	@Test
	public void testQueVerificaUnaExtraccionEnCajaDeAhorro() throws SaldoInsuficienteExceptions, MontoInvalidoExceptions {
		Cliente cliente = new Cliente ((long) 42540661, "fabricio","jara");
		CajaDeAhorro cajaAhorro = new CajaDeAhorro(100.0,2222222, cliente);
		cajaAhorro.depositar(300.0);
		
		cajaAhorro.extraer(20.0);
		cajaAhorro.extraer(20.0);
		cajaAhorro.extraer(20.0);
		cajaAhorro.extraer(20.0);
		cajaAhorro.extraer(20.0);
		cajaAhorro.extraer(10.0);
		
		assertEquals((Double)284.0, cajaAhorro.getSaldo());
		
	}
	@Test
	public void testQueVerificaLaExtraccionEnCuentaCorriente() {
		Cliente cliente = new Cliente ((long) 42540661, "fabricio","jara");
		CuentaCorriente cc = new CuentaCorriente(100.0, 3333333,cliente);
			cc.extraer(200.0);
			assertEquals((Double)0.0, cc.getSaldo());
			assertEquals((Double)105.0,cc.getDeuda());
	}
	@Test
	public void testQueVerificaLaExtraccionEnCuentaCorriente2() {
		Cliente cliente = new Cliente ((long) 42540661, "fabricio","jara");
		CuentaCorriente cc = new CuentaCorriente(500.0, 44444444, cliente);
			cc.extraer(550.0);
			assertEquals((Double)0.0, cc.getSaldo());
			assertEquals((Double)52.5,cc.getDeuda());
	}
	@Test
	public void testQueVerificaTransferenciaEntreCuentasCorrientes() throws SaldoInsuficienteExceptions, MontoInvalidoExceptions{
		Cliente cliente = new Cliente ((long) 42540661, "fabricio","jara");
		Cliente cliente2 = new Cliente ((long) 42540661, "fabricio","jara");
		CuentaCorriente c1 = new CuentaCorriente(100.0, 1234,cliente);
		CuentaCorriente c2 = new CuentaCorriente(100.0, 1121, cliente2);
		Banco banco = new Banco("Banco");
		banco.agregarCuenta(c1);
		banco.agregarCuenta(c2);
		banco.transferir(1234,1121,50.0);
		assertEquals((Double)50.0,c1.getSaldo());
		assertEquals((Double)150.0,c2.getSaldo());
		
		}
	@Test
	public void testQueVerificaTransferenciaEntreCuentasSueldos() throws SaldoInsuficienteExceptions, MontoInvalidoExceptions{
		Cliente cliente = new Cliente ((long) 42540661, "fabricio","jara");
		Cliente cliente2 = new Cliente ((long) 42540661, "fabricio","jara");
		CuentaSueldo cs1 = new CuentaSueldo(100.0, 1234,cliente);
		CuentaSueldo cs2 = new CuentaSueldo(100.0, 1111,cliente2);
		Banco banco = new Banco("BancoS");
		banco.agregarCuenta(cs1);
		banco.agregarCuenta(cs2);
		banco.transferir(1234,1111,60.0);
		assertEquals((Double)40.0,cs1.getSaldo());
		assertEquals((Double)160.0,cs2.getSaldo());
		
		}
	
	@Test
	public void testQueVerificaTransferenciaDeCuentaCorrienteACuentaSueldo() throws CuentaNoEncontradaExceptions, SaldoInsuficienteExceptions, MontoInvalidoExceptions {
		Cliente cliente = new Cliente ((long) 42540661, "fabricio","jara");
		Cliente cliente2 = new Cliente ((long) 42540661, "fabricio","jara");
		CuentaCorriente c1 = new CuentaCorriente(100.0, 1234, cliente);
		CuentaSueldo c2 = new CuentaSueldo(100.0, 1121, cliente2);
		Banco banco = new Banco("Banco");
		banco.agregarCuenta(c1);
		banco.agregarCuenta(c2);
		banco.transferir(1234,1121,50.0);
		assertEquals((Double)50.0,c1.getSaldo());
		assertEquals((Double)150.0,c2.getSaldo());
		
		}
//	@Test
//	public void testQueVerificaObtenerListaDeCuentasDeUnCliente() throws CuentaNoEncontradaExceptions {
//		Cliente cliente = new Cliente ((long) 42540661, "fabricio","jara");
//		CuentaCorriente c1 = new CuentaCorriente(100.0, 1234, cliente);
//		CuentaSueldo c2 = new CuentaSueldo(100.0, 1121, cliente);
//		Banco banco = new Banco("Banco");
//		banco.agregarCuenta(c1);
//		banco.agregarCuenta(c2);
//		
//		banco.ObtenerListadoDeCuentaDeUnCliente((long) 42540661);
//	}
	@Test(expected = CuentaNoEncontradaExceptions.class)
	public void cuentaNoEncontradaExceptions() throws CuentaNoEncontradaExceptions{
		Cliente cliente = new Cliente ((long) 42540661, "fabricio","jara");
		CuentaCorriente c1 = new CuentaCorriente(100.0, 1234, cliente);
		CuentaSueldo c2 = new CuentaSueldo(100.0, 1121, cliente);
		Banco banco = new Banco("Banco");
		
		banco.buscarCuenta(null);
		
	}
	@Test
	public void montoInvalidoException() throws SaldoInsuficienteExceptions, MontoInvalidoExceptions{
		Cliente cliente = new Cliente ((long) 42540661, "fabricio","jara");
		CuentaCorriente c1 = new CuentaCorriente(100.0, 1234, cliente);
		CuentaSueldo c2 = new CuentaSueldo(100.0, 1121, cliente);
		Banco banco = new Banco("Banco");
			banco.transferir(1234, 1121, 12300.0);
		
	}
	@Test 
	public void saldoInsuficienteException() throws SaldoInsuficienteExceptions, CuentaNoEncontradaExceptions, MontoInvalidoExceptions {
		Cliente cliente = new Cliente ((long) 42540661, "fabricio","jara");
		CuentaCorriente c1 = new CuentaCorriente(100.0, 1234, cliente);
		CuentaSueldo c2 = new CuentaSueldo(100.0, 1121, cliente);
		Banco banco = new Banco("Banco");
		banco.transferir(1121, 1234, 1500.0);
	}

}
