package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainException;

public class Program {
	
	public static void main(String[] arg) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.println("Qual Quarto Deseja? ");
			int roomNumber = sc.nextInt();
			System.out.println("Quando fará checkIn? Exemplo dd/mm/yyy");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Quando fará checkOut? Exemplo dd/mm/yyy");
			Date checkOut = sdf.parse(sc.next());
			
				
			Reservation res = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reserva: "+res.toString());
			
			System.out.println("Informe as novas datas da sua reserva");
			System.out.println("CheckIn ");
			checkIn = sdf.parse(sc.next());
			System.out.println("CheckOut ");
			checkOut = sdf.parse(sc.next());
			
			res.updateDates(checkIn, checkOut);
			
			System.out.println("Atualização: "+res.toString());
			
		}
		catch (ParseException e) {
			System.out.println("Data informada de forma incorreta");
		}
		catch (DomainException  e) {
			System.out.println("Erro: "+e.getMessage());
		}
		catch (RuntimeException e) {
			sc.next();
			System.out.println("Erro inesperado\n"+e.getMessage());
		}
		
		sc.close();
		
	}
}
