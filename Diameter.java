package my_algo2;

//308361476

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

public class Diameter {
	

	ArrayList<LinkedList<Integer>> G;
	Queue<Integer> q = new LinkedList<>();
	int size;
	int degree[];
	int last_elem_in_q;
	public Diameter(boolean[][] adj_matrix)
	{
		size=adj_matrix.length;
		degree=new int[size];
		G=InitializeGraph(adj_matrix);
		
	}
	
	public int get_diam()
	{

		int R=0;
		int burn=0;
		int FromWhereToBurn=0;
		int count=degree.length;
		
		   
			while(!q.isEmpty())
			{
			
				burn=q.poll();
				if(G.get(burn).size()==1) //get in arraylist O(1)
				{
					
					FromWhereToBurn=G.get(burn).getLast(); //get in arraylist O(1), get last element in linkedlist O(1). 
					
					G.get(FromWhereToBurn).remove(new Integer(burn)); //get in arraylist O(1), remove by value in linkedlist O(1).

					degree[burn]--; //O(1)
					degree[FromWhereToBurn]--; //O(1)
				}
				
				if(FromWhereToBurn==last_elem_in_q)
					break;
				
				if(degree[FromWhereToBurn]==1)
					q.add(FromWhereToBurn);

				if(degree[burn]==0)
					count--;
				
				if(burn==last_elem_in_q)
				{
					R++;
					last_elem_in_q=FromWhereToBurn;
					
				}

			}


			
		if(count==1)
		   return R*2;
		else
			return (R+1)*2-1;
	}

	private  ArrayList<LinkedList<Integer>> InitializeGraph(boolean[][] adj_matrix)
	{
		ArrayList<LinkedList<Integer>> G = new ArrayList<LinkedList<Integer>>();
	
		for (int i = 0; i < size; i++) {
			G.add(new LinkedList<Integer>()); //add in arraylist O(1)
			for (int j = 0; j < size; j++) {
				if(adj_matrix[i][j]==true)
					G.get(i).add(j); //get in arraylist O(1) , add in linkedlist O(1)
			}
			degree[i]=G.get(i).size(); //O(1)
			if(degree[i]==1)
			{
				q.add(i);
				last_elem_in_q=i;
			}
				
		}
			

		return G;
	}
	

	
	public static void main(String[] args) {
		
		
		boolean[][] mat = {{false,true,false,false,false,false,false,false,false},
							{true,false,true,true,false,false,false,false,false},
							{false,true,false,false,false,false,false,false,false},
							{false,true,false,false,true,true,true,false,false},
							{false,false,false,true,false,false,false,false,false},
							{false,false,false,true,false,false,false,false,false},
							{false,false,false,true,false,false,false,true,false},
							{false,false,false,false,false,false,true,false,true},
							{false,false,false,false,false,false,false,true,false}};

		boolean[][] mat1= {{false,true,false,false,false,false,false,false},
							{true,false,true,true,false,false,false,false},
							{false,true,false,false,false,false,false,false},
							{false,true,false,false,true,true,true,false},
							{false,false,false,true,false,false,false,false},
							{false,false,false,true,false,false,false,false},
							{false,false,false,true,false,false,false,true},
							{false,false,false,false,false,false,true,false}};

		boolean[][] mat2= {{false,true,false,false,false,false},
							{true,false,true,true,false,false},
							{false,true,false,false,false,false},
							{false,true,false,false,true,true},
							{false,false,false,true,false,false},
							{false,false,false,true,false,false}};
		
		boolean[][] mat3=  {{false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
							{true,false,true,false,true,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false},
							{false,true,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
							{false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
							{false,true,false,false,false,true,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
							{false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
							{false,false,false,false,true,false,false,true,true,false,false,false,false,false,false,false,false,false,false,false,false},
							{false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
							{false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
							{false,true,false,false,false,false,false,false,false,false,true,false,false,true,false,false,false,false,false,false,false},
							{false,false,false,false,false,false,false,false,false,true,false,true,true,false,false,true,false,false,false,false,false},
							{false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false},
							{false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false},
							{false,false,false,false,false,false,false,false,false,true,false,false,false,false,true,false,false,false,false,false,false},
							{false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false},
							{false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,true,false,true,true,false},
							{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,true,false,false,false},
							{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,true},
							{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false},
							{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false},
							{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false}};


		Diameter d=new Diameter(mat3); 
		System.out.println("rank: "+ d.get_diam());

		
		
	}
	
}
