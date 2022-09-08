package entities;

import exceptions.BusinessException;

public class Conta {
	
		private Integer numero;
		private String titular;
		private Double saldo;
		private Double saqueLimite;
		
		public Conta() {

}
		public Conta(Integer numero,String titular,Double saldo,Double saqueLimite) {
			this.numero = numero;
			this.titular = titular;
			this.saldo = saldo;
			this.saqueLimite = saqueLimite;
			
		}
		
		public Integer getNumero() {
			return numero;
		}
		
		public void setNumero (Integer numero) {
			this.numero =numero;
			
		}
		public String getTitular() {
			return titular;
		}
		public void setTitular (String titular) {
			this.titular = titular;
				
		}
		public Double getSaldo() {
			return saldo;
		}
		public void setSaldo (Double saldo) {
			this.saldo =saldo;
		}
		public Double getSaqueLimite() {
			return saqueLimite;
		}
		public void setSaqueLimite (Double saqueLimite) {
			this.saqueLimite = saqueLimite;
		}
		public void deposito(double quantia) {
			saldo += quantia;
		}
		public void saque(double quantia) {
			validarSaque (quantia);
			saldo -= quantia;
		}

		private void validarSaque (double quantia) {
			if (quantia> getSaqueLimite()) {
				throw new BusinessException("Erro de saque: A quantia excede o limite de saque");
			} 
			if (quantia > getSaldo()) {
				throw new BusinessException("Erro de saque: Saldo insuficiente");
			}
		}
	}