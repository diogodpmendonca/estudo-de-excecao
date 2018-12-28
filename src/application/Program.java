package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	
	public static void main(String[] arg) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Qual Quarto Deseja? ");
		int roomNumber = sc.nextInt();
		System.out.println("Quando fará checkIn? Exemplo dd/mm/yyy");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Quando fará checkOut? Exemplo dd/mm/yyy");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Reserva com erro: a data de Check-Out é anteriaor a data de Check-in");
		}else {
			Reservation res = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reserva: "+res.toString());
			
			System.out.println("Informe as novas datas da sua reserva");
			System.out.println("CheckIn ");
			checkIn = sdf.parse(sc.next());
			System.out.println("CheckOut ");
			checkOut = sdf.parse(sc.next());
			Date now = new Date();
			
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Atualização de Reserva com erro: Atualizações só pódem ser "
						+ "realizadas para datas futuras");
			}else if( !checkOut.after(checkIn)) {
				System.out.println("Atualização de Reserva com erro: a data de Check-Out é anteriaor a data de Check-in");
			}else {
				res.updateDates(checkIn, checkOut);
				System.out.println("Atualização: "+res.toString());
			}
		}
		
		sc.close();
		
	}
}
