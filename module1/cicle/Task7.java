/* 
Basics of software code development.
Циклы. Задача 7.
Для каждого натурального числа в промежутке от m до n вывести все делители,
кроме единицы и самого числа. m и n вводятся с клавиатуры.
 */
package by.epam_training.java_online.module1.cicle;
import java.util.Scanner;

public class Task7 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int m = 0;
		int n = 0;
		@SuppressWarnings("unused")
		String str;
		
		System.out.print("Input beginning (more than 3): ");
		
		while (!sc.hasNextInt()) {
			str = sc.next();
			System.out.print("Input beginning (more than 3): ");
		}
		
		m = sc.nextInt();
		
		System.out.print("Input end (more than beginning): ");
		
		while (!sc.hasNextInt()) {
			str = sc.next();
			System.out.print("Input end (more than beginning): ");
		}
		
		n = sc.nextInt();

		if (m < n) {
			
			if (m > 3 && n > m) {
				
				for (int i = m; i <= n; i++) {
					System.out.print(i + " : ");
					
					for (int j = 2; j <= i / 2; j++) {
						
						if (i % j == 0)
							System.out.print(j + " ");
					}
					
					System.out.println();
				}
			}
		} else
			System.out.println("end must be more than beginning!");
	}
}
