package Fundamentos;


import javax.swing.JOptionPane;

public class Operadores {
	public static void main(String[] args) {

	String altura= JOptionPane.showInputDialog("Insira a altura");
	String peso= JOptionPane.showInputDialog("Insira o Peso");
	
	double valor1= Double.parseDouble(altura);
	double valor2= Double.parseDouble(peso);
	double imc = valor2/Math.pow(valor1, 2);
	imc = imc *10000;
	String IMC;
	IMC = String.format("%.2f", imc);
	
	if (imc < 19) {
        JOptionPane.showMessageDialog(null,"Vc está abaixo do peso com o IMC de: "+IMC);
      } else if (imc >= 19 && imc <= 30) {
        JOptionPane.showMessageDialog(null,"Vc está no peso ideal com o IMC de:"+IMC);
      }else if(imc>=31) {
    	  JOptionPane.showMessageDialog(null," Vc está acima do peso com o IMC de:"+IMC);
      }
	
	}
}
