import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Main m=new Main();
		m.play();	
	}
	public void play()
	{
		Scanner s= new Scanner(System.in);
		System.out.println("Welcome To Honai Tower.....!");
		System.out.println("How many beams do you want:");
		int n=s.nextInt();
		int[] i=new int[2];
		HonaiTower h= new HonaiTower(n);
		while(h.count3!=n)
		{
			System.out.println();
			h.print();
			System.out.println();
			i=h.input();
			while(!h.change(i[0], i[1]))
			{
				System.out.println("Not Possible to move,Enter valid move");
				i=h.input();
			}
		}
		System.out.println();
		h.print();
		System.out.println();
		System.out.println("Congratulations The Game is Completed🥳");
		s.close();
	}
	
}

public class HonaiTower {
	Scanner s=new Scanner(System.in);
	int[][] a=new int[3][];
	int count=0;
	int count1=0;
	int count2=0;
	int count3=0;
	public HonaiTower(int n)
	{
		a[0]=new int[n+3];
		a[1]=new int[n+3];
		a[2]=new int[n+3];
		a[0][0]=n+1;
		a[1][0]=n+1;
		a[2][0]=n+1;
		count=5+n*4;
		int p=n;
		for(int i=1;i<=n;i++)
		{
			a[0][i]=p;
			p-=1;
		}
		count1=n;
	}
	public void display()
	{
		for(int[] i:a)
		{
			for(int j:i)
			{
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	public void print()
	{
		for(int i=a[0].length-1;i>0;i--)
		{
		   for(int j=0;j<a.length;j++)
		   {
			   for(int m=1;m<=(count/2)-(2*a[j][i]);m++)
			   {
				   System.out.print(" ");
			   }
			   for(int m=1;m<=2*a[j][i];m++)
			   {
				   System.out.print("-");
			   }
			   System.out.print("|");
			   for(int m=1;m<=2*a[j][i];m++)
			   {
				   System.out.print("-");
			   }
			   for(int m=1;m<=(count/2)-(2*a[j][i]);m++)
			   {
				   System.out.print(" ");
			   }
		   }
		   System.out.println();
		}
		for(int i=0;i<3*count;i++)
		{
			System.out.print("=");
		}
	}
	public int peek(int n)
	{
		if(n==0) return a[n][count1];
		else if(n==1) return a[n][count2];
		else return a[n][count3];
	}
	public boolean change(int x,int y)
	{
		if(x==0 && y==1)
		{
			if(peek(x)<peek(y))
			{
				int temp=a[x][count1];
				a[x][count1--]=0;
				a[y][++count2]=temp;
				return true;
			}
		}
		if(x==0 && y==2)
		{
			if(peek(x)<peek(y))
			{
				int temp=a[x][count1];
				a[x][count1--]=0;
				a[y][++count3]=temp;
				return true;
			}
		}
		if(x==1 && y==0)
		{
			if(peek(x)<peek(y))
			{
				int temp=a[x][count2];
				a[x][count2--]=0;
				a[y][++count1]=temp;
				return true;
			}
		}
		if(x==1 && y==2)
		{
			if(peek(x)<peek(y))
			{
				int temp=a[x][count2];
				a[x][count2--]=0;
				a[y][++count3]=temp;
				return true;
			}
		}
		if(x==2 && y==0)
		{
			if(peek(x)<peek(y))
			{
				int temp=a[x][count3];
				a[x][count3--]=0;
				a[y][++count1]=temp;
				return true;
			}
		}
		if(x==2 && y==1)
		{
			if(peek(x)<peek(y))
			{
				int temp=a[x][count3];
				a[x][count3--]=0;
				a[y][++count2]=temp;
				return true;
			}
		}
		return false;
	}
	public int[] input()
	{
		int[] i=new int[2];
		System.out.print("Change from:");
		int a=0;
		while(true)
		{
			a=s.nextInt()-1;
			if(a==0 || a==1 || a==2) break;
			else 
			{
				System.out.println("Enter between 1 and 3");
				System.out.print("Change from:");
			}
		}
		System.out.print("Change to:");
		int b=0;
		while(true)
		{
			b=s.nextInt()-1;
			if(b==0 || b==1 || b==2) break;
			else 
			{
				System.out.println("Enter between 1 and 3");
				System.out.print("Change from:");
			}
		}
		i[0]=a;
		i[1]=b;
		return i;
	}
}
