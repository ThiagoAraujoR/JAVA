package Fundamentos;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import java.util.concurrent.TimeUnit;

public class TrabalhoAutomatos {
	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		
		String entrada;
		
		entrada=JOptionPane.showInputDialog("Insira uma entrada. 0 para sair.");

		
		if(entrada.contains("@")) {
			Email(entrada);
		}else if(entrada.length()==11) {
			CPF(entrada);
		}else if(entrada.length()==7) {
			Placa(entrada);
		}else if(entrada.contentEquals("0")){
			System.out.println("Volte Sempre");
			System.exit(0);
		}else{
			System.out.println("Valor inválido");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			menu();
		}
			
		}
	
	public static void Email( String entrada) {
		if(entrada.contains("@")) {
			System.out.println("É um email");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			menu();
		}
	}
	
	public static void CPF(String entrada) {
		int soma, resto, num, peso, dig10,dig11;
		//Verifica numeros iguais
		if(entrada.equals("00000000000")||entrada.equals("11111111111") ||entrada.equals("22222222222")
				||entrada.equals("33333333333")||entrada.equals("44444444444")||entrada.equals("55555555555")
				||entrada.equals("66666666666")||entrada.equals("77777777777")||entrada.equals("88888888888")
				||entrada.equals("99999999999")) {
			System.out.println("CPF INVALIDO");
		}else {
			
			//Verifica o 10º digito
			soma = 0;
            peso = 10;
            for (int i=0; i<9; i++) {
	            num = (int)(entrada.charAt(i) - 48);
	            soma = soma + (num * peso);
	            peso = peso - 1;
            }

            resto = 11 - (soma % 11);
            
            if((resto == 10) || (resto == 11)) {
                dig10 = '0';
            }else {
            	dig10 = (char)(resto + 48);
            }
           
            // Calculo do 2o. Digito Verificador
            soma = 0;
            peso = 11;
            
            for(int i=0; i<10; i++) {
            	num = (int)(entrada.charAt(i) - 48);
            	soma = soma + (num * peso);
            	peso = peso - 1;
            }

            resto = 11 - (soma % 11);
            if ((resto == 10) || (resto == 11)) {
            	dig11 = '0';
            }else {
            	dig11 = (char)(resto + 48);
                 }
			
			if((entrada.charAt(9)==dig10) && (entrada.charAt(10)==dig11)) {
				System.out.println("É um CPF Válido");
			}else {
				System.out.println("Não é um CPF Válido");
			}
		}
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		menu();
	}
	
	public static void Placa(String entrada) {
		Pattern Placa = Pattern.compile("[A-Z]{3}-[0-0]{4}");
		System.out.println("É uma Placa de automóvel");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		menu();
	}
}