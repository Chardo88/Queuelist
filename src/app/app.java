package app;

import Queue.Queue;

public class app {

	public static void main(String[] args) {
		Queue<String> names = new Queue<>(5);
		
		try{
			names.enQueue("Jose");
			names.enQueue("Ana");
			names.enQueue("Pepe");
			names.enQueue("Loli");
			names.enQueue("Lalo");
			
			
			names.deQueue();
			
			names.enQueue("Ric");
			
			
			names.deQueue();
			names.deQueue();
			names.deQueue();
			names.deQueue();
			names.deQueue();
			
			names.enQueue("Rosa");
			names.enQueue("Mario");
			names.enQueue("Jocy");
			names.enQueue("Raul");
			names.enQueue("Lupe");
			
			for(String string: names){
				System.out.println(string);
			}
			
//			System.out.println("Encontrado: "+names.Search("Jocy").getValue());
			
//			names.clear();
			
			names.deQueue();
			names.deQueue();
			names.deQueue();
			names.deQueue();
			names.deQueue();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
