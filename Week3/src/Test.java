import java.util.TreeMap;

public class Test {

	public static void main(String[] args) {
		Test t = new Test();
		
		int []result = new int[10];
		result = t.generateArr(result);
		System.out.println("Printing original array - ");
		t.printArr(result);
		System.out.println();
		
		
		TreeMap<String, Integer> map = new TreeMap<>();
		map.put("a", 1);
		map.put("c", 3);
		map.put("b", 2);
		System.out.println("Map b  ---" + map.get("b"));
		System.out.println("Entry" + map.get(map.lastKey()));

		result = t.mergeSort(result);
		
		System.out.println("Printing sorted array - ");
		t.printArr(result);
		System.out.println();
		
		System.out.println("The maximum value is " + t.findMaximum(result));
		System.out.println("The minimum value is " + t.findMinimum(result));
		
		
	}
	
	private int findMaximum(int[] result){
		int max_ = 0;
		for(int i = 0; i < result.length; i++){
			if(result[i] > max_){
				max_ = result[i];
			}
		}
		return max_;
	}

	private int findMinimum(int[] result){
		int min_ = result[0];
		for(int i = 1; i < result.length; i++){
			if(result[i] < min_){
				min_ = result[i];
			}
		}
		return min_;
	}
	
	private int[] mergeSort(int[] result) {
		
		if(result.length <= 1){
			return result;
		}
		
		int mid = result.length / 2;
		
		int[] left = new int[mid];
		int[] right;
		
		if(result.length % 2 == 0){
			right = new int[mid];
		}
		else{
			right = new int[mid + 1];
		}
		
		int[] finalResult = new int[result.length];
		
		for (int i = 0; i < mid; i++) {
			left[i] = result[i];
		}
		
		int counter = 0;
		for (int j = mid; j < result.length; j++) {
			if(counter < result.length){
				right[counter] = result[j];
				counter++;
			}			
		}
		
		left = mergeSort(left);
		right = mergeSort(right);
		
		finalResult = mergeHelper(left, right);
		
		return finalResult;
	}
	
	private int[] mergeHelper(int[] left, int[] right){
		
		int totalLength = left.length + right.length;
		int[] finalResult = new int[totalLength];
		int leftIndex = 0, rightIndex = 0, resultIndex = 0;
		
		while(leftIndex < left.length || rightIndex < right.length){
			
			if(leftIndex < left.length && rightIndex < right.length){
				if(left[leftIndex] <= right[rightIndex]){
					finalResult[resultIndex] = left[leftIndex];
					resultIndex++;
					leftIndex++;
				}
				else{
					finalResult[resultIndex] = right[rightIndex];
					resultIndex++;
					rightIndex++;
				}
			}
			else if(leftIndex < left.length){
				finalResult[resultIndex] = left[leftIndex];
				resultIndex++;
				leftIndex++;
			}
			else if(rightIndex < right.length){
				finalResult[resultIndex] = right[rightIndex];
				resultIndex++;
				rightIndex++;
			}
		}
		
		return finalResult;
	}
	
	private String performBFS(int[][] graph, int startRow, int startCol, int endRow, int endCol){
		
		return "Does Not have path";
	}
	

	private void printArr(int [] result) {
		for(int i = 0; i < result.length; i++){
			System.out.print(result[i] + " ");
		}
	}

	private int[] generateArr(int [] result) {
		
		for(int i = 0; i < result.length; i++){
			result[i] = (int) (Math.random() * 100);
		}
		return result;
	}

}
