
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String [] temp;
		List<Product> customerPurchases = new ArrayList<>();
		while(input.hasNextLine()){
			temp = input.nextLine().split(" ");
			if(temp[0].equals("#")){
				break;
			}
			customerPurchases.add(new Product(temp[0], temp[1]));
		}
		
		/*for(Product p : customerPurchases){
			System.out.println(p);
		}*/
		input.close();
		Solution sol = new Solution();
		int result = sol.solveProducts(customerPurchases);
		System.out.println(result);
		
	}

	private int solveProducts(List<Product> customerPurchases) {
		HashMap<String, Product> visitedCustomers = new HashMap<>();
		
		for(Product p : customerPurchases){
			if(!visitedCustomers.containsKey(p.getId())){
				visitedCustomers.put(p.getId(), p);
			}
			else{
				visitedCustomers.remove(p.getId());
			}
		}
		
		TreeMap<String, Integer> customers = new TreeMap<>();
		
		for(Map.Entry<String, Product> cp : visitedCustomers.entrySet()){
			if(cp.getValue() != null){
				if(customers.get(cp.getValue().getProductCategory()) == null){
					customers.put(cp.getValue().getProductCategory(), 1);
	            }
	            else{
	                int value = customers.get(cp.getValue().getProductCategory()).intValue();
	                customers.put(cp.getValue().getProductCategory(), ++value);
	            }
			}
			
		}
		
		int max_ = 0;
		for(Map.Entry<String, Integer> entry : customers.entrySet()){
			if(entry.getValue() > max_){
				max_ = entry.getValue();
			}
		}
		System.out.println(customers);
//		return customers.get(customers.lastKey());
		return max_;
	}

}
