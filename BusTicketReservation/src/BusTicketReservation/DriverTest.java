package BusTicketReservation;
import java.util.*;

class TicketCounter{
	String name;
	int availableSeats=3;
	
	TicketCounter(){
		
		
	}
	
	void bookTicket(String name, int seats){	
		if(seats>0 && availableSeats>=seats) {
			
			System.out.print(name+" :");
			System.out.print("Seats booked successfully\n");
			availableSeats-=seats;
			
			
		}else {
			System.out.println("Not available for " +name);
		}
		
	}
	
	
}

class TicketBooking extends Thread{
	String name;
	int seats;
	TicketCounter t;
	
	TicketBooking(TicketCounter t,String name, int seats){
		
		this.t=t;
		this.name=name;
		this.seats=seats;
	}
	
	
	
	
	@Override 
	public synchronized void run() {
		
		
		t.bookTicket(name, seats);
		try {
			Thread.sleep(100);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
}


public class DriverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketCounter tc = new TicketCounter();
		TicketBooking t = new TicketBooking(tc,"ansu",1);
		TicketBooking t1 = new TicketBooking(tc,"maxine",1);
		TicketBooking t2 = new TicketBooking(tc,"brock",3);
		t.start();
		t1.start();
		t2.start();

	}

}
