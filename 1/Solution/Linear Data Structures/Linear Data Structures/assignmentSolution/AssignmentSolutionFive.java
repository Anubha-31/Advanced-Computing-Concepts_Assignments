package assignmentSolution;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import searchtrees.AVLTree;
import searchtrees.BinarySearchTree;
import searchtrees.RedBlackBST;
import searchtrees.SplayTree;

public class AssignmentSolutionFive {
	
	private static Map<Long, List<Long>> timeTaken = new Hashtable<>();

	public static void main(String[] args) {

		AssignmentSolutionFive sol = new AssignmentSolutionFive();

		BinarySearchTree<Integer> bTree = new BinarySearchTree<>();
		System.out.println("Binary Search Tree");
		System.out.println("Insertion");
		System.out.println("---------");
		bTree = sol.insertToBTree(bTree);
		System.out.println("Deletion");
		System.out.println("---------");
		sol.deleteBTree(bTree);

		AVLTree<Integer> avlTree = new AVLTree<Integer>();
		System.out.println("\nAVL Tree");
		System.out.println("Insertion");
		System.out.println("---------");
		avlTree = sol.insertToAVLTree(avlTree);
		System.out.println("Deletion");
		System.out.println("---------");
		sol.deleteAvlTree(avlTree);

		RedBlackBST<Integer, Integer> rbTree = new RedBlackBST<>();
		System.out.println("\nRed-Black Tree");
		System.out.println("Insertion");
		System.out.println("---------");
		rbTree = sol.insertToRedBlackTree(rbTree);
		System.out.println("Deletion");
		System.out.println("---------");
		sol.deleteRedBlackTree(rbTree);

		SplayTree<Integer> sTree = new SplayTree<Integer>();
		System.out.println("\nSplay Tree");
		System.out.println("Insertion");
		System.out.println("---------");
		sTree = sol.insertToSplayTree(sTree);
		System.out.println("Deletion");
		System.out.println("---------");
		sol.deleteSplayTree(sTree);

		List<String> headers = new ArrayList<String>();
		headers.add("Type Of Tree");
		headers.add("Random Insertion Average Time");
		headers.add("Random Insertion Worst Time");

		headers.add("Random Deletion Average Time");
		headers.add("Random Deletion Worst Time");

		AssignmentSolutionFour.insertToExcel("Question_Five", timeTaken, headers);

	}

	private void deleteSplayTree(SplayTree<Integer> sTree) {
		long avgTime = 0;
		long worstTime = 0;
		for (int i = 1; i <= 100000; i++) {
			int randInt = (int) (Math.random() * (10000));
			long startTime = System.nanoTime();
			sTree.remove(randInt);
			long endTime = System.nanoTime();
			long timetaken = endTime - startTime;
			if(worstTime < timetaken) {
				worstTime = timetaken;
			}
			avgTime += timetaken;
			//System.out.println("Time Taken to remove " + randInt + " is: " + timetaken);

		}
		System.out.println("Worst case time :"+ worstTime);
		System.out.println("average time taken: " + avgTime/100000);
		List<Long> list = timeTaken.get((long)4);
		list.add(avgTime/100000);
		list.add(worstTime);
		
		
	}

	private SplayTree<Integer> insertToSplayTree(SplayTree<Integer> sTree) {
		long insertAvgTime = 0;
		long worstTime = 0;
		for (int i = 1; i <= 100000; i++) {
			int randInt = (int) (Math.random() * (10000));
			Long startTime = System.nanoTime();
			sTree.insert(randInt);
			Long endTime = System.nanoTime();
			Long timeTaken = endTime - startTime;
			if(worstTime < timeTaken) {
				worstTime = timeTaken;
			}
			insertAvgTime += timeTaken;
			//System.out.println("Time Taken To Insert entry " + randInt + " is " + timeTaken);
		}
		System.out.println("Worst case time :"+ worstTime);
		System.out.println("Avg Time Taken " + insertAvgTime / 100000);
		List<Long> list = new ArrayList<Long>();
		list.add(insertAvgTime / 100000);
		list.add(worstTime);
		timeTaken.put((long)4, list);
		return sTree;
	}

	private void deleteRedBlackTree(RedBlackBST<Integer, Integer> rbTree) {
		long avgTime = 0;
		long worstTime = 0;
		for (int i = 1; i <= 100000; i++) {

			int randInt = (int) (Math.random() * (10000));
			long startTime = System.nanoTime();
			rbTree.delete(randInt);
			long endTime = System.nanoTime();
			long timetaken = endTime - startTime;
			if(worstTime < timetaken) {
				worstTime = timetaken;
			}
			avgTime += timetaken;
			//System.out.println("Time Taken to remove " + randInt + " is: " + timetaken);

		}
		System.out.println("Worst case time :"+ worstTime);
		System.out.println("average time taken: " + avgTime/100000);
		List<Long> list = timeTaken.get((long)3);
		list.add(avgTime/100000);
		list.add(worstTime);
		timeTaken.replace((long)3, list);
		
	}

	private RedBlackBST<Integer, Integer> insertToRedBlackTree(RedBlackBST<Integer, Integer> rbTree) {
		long insertAvgTime = 0;
		long worstTime = 0;
		for (int i = 1; i <= 100000; i++) {
			int randInt = (int) (Math.random() * (10000));
			Long startTime = System.nanoTime();
			rbTree.put(randInt, i);
			Long endTime = System.nanoTime();
			Long timeTaken = endTime - startTime;
			if(worstTime < timeTaken) {
				worstTime = timeTaken;
			}
			insertAvgTime += timeTaken;
			//System.out.println("Time Taken To Insert entry " + randInt + " is " + timeTaken);
		}
		System.out.println("Worst case time :"+ worstTime);
		System.out.println("Avg Time Taken " + insertAvgTime / 100000);
		List<Long> list = new ArrayList<Long>();
		list.add(insertAvgTime / 100000);
		list.add(worstTime);
		timeTaken.put((long)3, list);
		return rbTree;
	}

	private void deleteAvlTree(AVLTree<Integer> avlTree) {
		long avgTime = 0;
		long worstTime = 0;
		for (int i = 1; i <= 100000; i++) {

			int randInt = (int) (Math.random() * (10000));
			long startTime = System.nanoTime();
			avlTree.remove(randInt);
			long endTime = System.nanoTime();
			long timetaken = endTime - startTime;
			if(worstTime < timetaken) {
				worstTime = timetaken;
			}
			avgTime += timetaken;
			//System.out.println("Time Taken to remove " + randInt + " is: " + timetaken);

		}
		System.out.println("Worst case time :"+ worstTime);
		System.out.println("average time taken: " + avgTime/100000);
		List<Long> list = timeTaken.get((long)2);
		list.add(avgTime/100000);
		list.add(worstTime);
		timeTaken.replace((long)2, list);
		
	}

	private AVLTree<Integer> insertToAVLTree(AVLTree<Integer> avlTree) {
		long insertAvgTime = 0;
		long worstTime = 0;
		for (int i = 1; i <= 100000; i++) {
			int randInt = (int) (Math.random() * (10000));
			Long startTime = System.nanoTime();
			avlTree.insert(randInt);
			Long endTime = System.nanoTime();
			Long timeTaken = endTime - startTime;
			if(worstTime < timeTaken) {
				worstTime = timeTaken;
			}
			insertAvgTime += timeTaken;
			//System.out.println("Time Taken To Insert entry " + randInt + " is " + timeTaken);
		}
		System.out.println("Worst case time :"+ worstTime);
		System.out.println("Avg Time Taken " + insertAvgTime / 100000);
		List<Long> list = new ArrayList<Long>();
		list.add(insertAvgTime / 100000);
		list.add(worstTime);
		timeTaken.put((long)2, list);
		return avlTree;
	}

	private void deleteBTree(BinarySearchTree<Integer> bTree) {
		long avgTime = 0;
		long worstTime = 0;
		for (int i = 1; i <= 100000; i++) {

			int randInt = (int) (Math.random() * (10000));
			long startTime = System.nanoTime();
			bTree.remove(randInt);
			long endTime = System.nanoTime();
			long timetaken = endTime - startTime;
			if(worstTime < timetaken) {
				worstTime = timetaken;
			}
			avgTime += timetaken;
			//System.out.println("Time Taken to remove " + randInt + " is: " + timetaken);

		}
		System.out.println("Worst case time :"+ worstTime);
		System.out.println("average time taken: " + avgTime/100000);
		List<Long> list = timeTaken.get((long)1);
		list.add(avgTime/100000);
		list.add(worstTime);
		timeTaken.replace((long)1, list);
		
	}

	private BinarySearchTree<Integer> insertToBTree(BinarySearchTree<Integer> bTree) {
		
		long insertAvgTime = 0;
		long worstTime = 0;
		for (int i = 1; i <= 100000; i++) {
			int randInt = (int) (Math.random() * (10000));
			Long startTime = System.nanoTime();
			bTree.insert(randInt);
			Long endTime = System.nanoTime();
			Long timeTaken = endTime - startTime;
			if(worstTime < timeTaken) {
				worstTime = timeTaken;
			}
			insertAvgTime += timeTaken;
			//System.out.println("Time Taken To Insert entry " + randInt + " is " + timeTaken);
		}
		System.out.println("Worst case time :"+ worstTime);
		System.out.println("Avg Time Taken " + insertAvgTime / 100000);
		
		List<Long> list = new ArrayList<Long>();
		list.add(insertAvgTime / 100000);
		list.add(worstTime);
		timeTaken.put((long)1, list);
		return bTree;
	}

}
