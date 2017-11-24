package Queue;

import java.util.Iterator;

import Queue.iQueue;
import node.node;

public class Queue<T extends Comparable<T>> implements iQueue<T>,Iterable<T> {
	
	private node<T> start = null, end = null;
	node<T> back;
	node<T> front;
	int count = 0;
	int size  = 10;
	
	
	public Queue(){
		start = new node<T>();
		start.setIndex(-1);
		end = new node<T>();
		end.setIndex(-1);
		node<T> n = new node<T>();
		start.setNext(n);
		n.setBack(start);
		node<T> tmp = start.getNext();
		for (int i = 1; i< size; i++){
			node<T> nuevo = new node<T>();
			tmp.setNext(nuevo);
			nuevo.setBack(tmp);
			tmp=tmp.getNext();
		}
		end.setBack(tmp);
		index();
		front = start.getNext();
		back = start.getNext();
	}
	
	
	public Queue(int size){
		this.size = size;
		start = new node<T>();
		start.setIndex(-1);
		end = new node<T>();
		end.setIndex(-1);
		node<T> n = new node<T>();
		start.setNext(n);
		n.setBack(start);
		node<T> tmp = start.getNext();
		for (int i = 1; i< size; i++){
			node<T> nuevo = new node<T>();
			tmp.setNext(nuevo);
			nuevo.setBack(tmp);
			tmp=tmp.getNext();
		}
		end.setBack(tmp);
		index();
		front = start.getNext();
		back = start.getNext();
	}
	
	public void index(){
		node<T> tmp = start;
		int i = 0;
		while (tmp.getNext()!=null) {
			tmp = tmp.getNext();
			tmp.setIndex(i);
			i++;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			node<T> tmp = back.getBack();
			int i = 0;
			@Override
			public boolean hasNext() {
				if(tmp.getNext() == null)
					tmp = start.getNext();
				else
					tmp = tmp.getNext();
				return (i++ != count)?true:false;
			}
			@Override
			public T next() {
				return tmp.getValue();
			}
		};
	}


	@Override
	public void enQueue(T value) throws QueueFullException {
		if(IsFull()) throw new QueueFullException("La cola está llena");
		front.setValue(value);
		count++;
		if(front.getNext() == null)
			front = start.getNext();
		else
			front = front.getNext();
		
	}


	@Override
	public T deQueue() throws QueueEmptyException {
		if(IsEmpty()) throw new QueueEmptyException("La cola está vacía");
		T tmp=back.getValue();
		back.setValue(null);
		count--;
		if(back.getNext() == null)
			back = start.getNext();
		else
			back = back.getNext();
		return tmp;
	}


	@Override
	public boolean IsEmpty() {
		return (count == 0);
	}


	@Override
	public boolean IsFull() {
		return (count == size);
	}


	@Override
	public T front() throws QueueEmptyException {
		if(IsEmpty()) throw new QueueEmptyException("La cola está vacía");
		return back.getValue();
	}


	@Override
	public node<T> Search(T value) throws QueueEmptyException {
		if(IsEmpty()) throw new QueueEmptyException("Pila vacía");	
		node<T> tmp = back;
		int i = 0;
		while (i<=count){
			i++;
			if (tmp.getValue().equals(value))
				return tmp;
			if(tmp.getNext() == null)
				tmp = start.getNext();
			else
				tmp = tmp.getNext();
		}
		return null;
	}


	@Override
	public void clear() {
		while(!IsEmpty())
			try {
				deQueue();
			} catch (QueueEmptyException e) {
				e.printStackTrace();
			}
	}


	@Override
	public int size() {
		return count;
	}
	
	

}
