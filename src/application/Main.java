package application;

import java.util.Scanner;

import entities.PrintService;

public class Main {

	public static void main(String[] args) {

		PrintService<String> printService = new PrintService<>();

		try (Scanner systemInput = new Scanner(System.in)) {
			
			System.out.println("Digite a quantidade de elementos na lista: ");
			String temp = systemInput.nextLine();
			
			if (!temp.chars().allMatch(Character::isDigit)) {
				throw new NumberFormatException("Digite apenas números!");
			}
			
			int n = Integer.parseInt(temp);
			if (n <= 0) {
				throw new IllegalStateException("A lista deve conter ao menos um número positivo");
			}

			for (int i = 0; i < n; i++) {
				
				String readerBuffer;

				System.out.println("Digite um elemento por extenso: ");
				readerBuffer = systemInput.nextLine();
				if (readerBuffer.isBlank() || readerBuffer.chars().anyMatch(Character::isDigit)) {
					throw new IllegalArgumentException("Digite apenas texto!");
				}
				printService.addValue(readerBuffer);
			}
			printService.print();
		}
		
		catch (IllegalStateException e) {
			e.printStackTrace();
		}
		
		catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
}
