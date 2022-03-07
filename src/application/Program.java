package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Business;
import entities.Individual;
import entities.TaxPayers;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		File filePath = new File("C:\\Projeto_Fixacao_Java\\Arquivos\\imposto.csv");
		String pathDir = filePath.getParent();
		String fileProcessed = pathDir + "\\out\\calculoImposto.csv";
		
		List<TaxPayers> taxPayers = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			
			String linha = br.readLine();
			
			while(linha != null) {
				
				String[] splitLine = linha.split(",");
				char ch = splitLine[0].charAt(0);
				String name = splitLine[1];
				Double yearlyIncome = Double.parseDouble(splitLine[2]);
				if(ch == 'p') {
					Double healthExpenses = Double.parseDouble(splitLine[3]);
					taxPayers.add(new Individual(name, yearlyIncome, healthExpenses));
				}
				else if(ch == 'e') {
					int quantityEmployee = Integer.parseInt(splitLine[3]);
					taxPayers.add(new Business(name, yearlyIncome, quantityEmployee));
				}
				
				linha = br.readLine();
			}
		
		}catch(IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileProcessed))){
			Double soma =0.0;
			
			for(TaxPayers tax : taxPayers) {
				bw.write(tax.toString());
				bw.newLine();
				
				System.out.println(tax);
				soma += tax.taxesAmount(tax.getYearlyIncome());
			}
			
		}catch(IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		
		sc.close();
	}

}
