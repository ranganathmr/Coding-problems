package dynamicprogramming;
import java.util.ArrayList;
import java.util.List;

public class Knapsack
{

	List<Item> items;
	
	public Knapsack(List<Item> items)
	{
		this.items = items; 
	}
	
	public static void main(String[] args) {
		List<Item> items = new ArrayList<Item>();
		items.add(new Item(1, 1, "Brush"));
		items.add(new Item(2, 1, "Ear-Ring"));
		items.add(new Item(2, 2, "Box"));
		items.add(new Item(10, 4, "Fan"));
		items.add(new Item(4, 12, "Motor"));
		
		Knapsack sack = new Knapsack(items);
		System.out.println(sack.compute(15));
	}
	
	public List<Item> compute(int weight){
		int maxValue = 0;
		List<Item> maxItems = new ArrayList<Item>();		
		for(Item i: items) {
			List<Item> localItems = new ArrayList<Item>();
			int localMax = 0;
			if(weight - i.getWeight() == 0) {
				localMax = i.getValue();				
			}
			else if(weight - i.getWeight() > 0) {
				localItems = compute(weight - i.getWeight());
				localMax = i.getValue();
				for(Item g: localItems) {
					localMax += g.getValue();
				}
			}
			
			if(localMax > maxValue) {
				maxValue = localMax;
				maxItems = localItems;
				maxItems.add(i);
			}

		}
		return maxItems;
	}
	
	private static class Item {
		private int value;
		private int weight;	
		private String name;
		
		public Item(int value, int weight, String name)
		{
			super();
			this.value = value;
			this.weight = weight;
			this.name = name;
		}
		
		public int getValue()
		{
			return value;
		}
		public int getWeight()
		{
			return weight;
		}
		public String getName()
		{
			return name;
		}
		
		public String toString() {
			return name;
		}
	}
}