package tictac;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		char p1=' ';
		char p2=' ';
		char k=49;
		char[][] a=new char[3][3];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				a[i][j]=k;
				k++;
			}
		}
		System.out.println("WELCOME TO THE TIC-TAC-TOE GAME");
		System.out.println("Player1 choose 'X' or 'O' :" );
		boolean input=true;
		while(input)
		{
			p1=s.next().charAt(0);
			if(p1=='X' || p1=='O')
			{
				input=false;
				break;
			}
			System.out.println("invalid,Choose 'X' or 'O':");
		}
		if(p1=='X')
			p2='O';
		else 
			p2='X';
		System.out.println("player1 is:"+p1+"\t"+"player2 is:"+p2);
		print(a);
		play(p1,p2,a);
		s.close();
	}
	public static void play(char p1,char p2,char[][] a)
	{
		Scanner s = new Scanner(System.in);
		boolean game=true;
		int[] num = {1,2,3,4,5,6,7,8,9};
		int n=0;
		while(true)
		{
		System.out.print("player1 enter one number(1-9):");
		boolean valid1=true;
		while(valid1)
		{
			n=s.nextInt();
			for(int i=0;i<num.length;i++)
			{
				if(num[i]==n)
				{
					valid1=false;
					num[i]=0;
					break;
				}
			}
			if(valid1)
				System.out.println("Invalid move,choose another space:");
		}
		a=change(n,p1,a);
		print(a);
		game=check(a);
		if(game==false)
		{
			System.err.println("Player 1 is the  winner🥳");
			s.close();
			return ;
		}
		if(Drawcheck(a))
		{
			System.out.println("The match is Draw");
			s.close();
			return ;
		}
		System.out.print("player2 enter the number(1-9):");
		boolean valid2=true;
		while(valid2)
		{
			n=s.nextInt();
			for(int i=0;i<num.length;i++)
			{
				if(num[i]==n)
				{
					valid2=false;
					num[i]=0;
					break;
				}
			}
			if(valid2)
				System.out.println("Invalid move,choose another space:");
		}
		a=change(n,p2,a);
		print(a);
		game=check(a);
		if(game==false)
		{
			System.err.println("Player 2 is the winner🥳.");
			s.close();
			return;
		}
		if(Drawcheck(a))
		{
			System.out.println("The match is a Draw");
			s.close();
			return ;
		}
		}
	}
	public static boolean Drawcheck(char[][] a)
	{
		boolean flag = true;
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length;j++)
			{
				if(a[i][j]>='1' && a[i][j]<='9')
					flag=false;
			}
		}
		return flag;
	}
	public static boolean check (char[][] a)
	{
		boolean game=true;
		if(((a[0][0] == 'X')&&(a[0][1]=='X')&& (a[0][2]=='X')) || ((a[0][0] == 'O')&&(a[0][1]=='O')&& (a[0][2]=='O')) )
			game=false;
		else if(((a[1][0] == 'X')&&(a[1][1]=='X')&& (a[1][2]=='X')) || ((a[1][0] == 'O')&&(a[1][1]=='O')&& (a[1][2]=='O')))
			game=false;
		else if(((a[2][0] == 'X')&&(a[2][1]=='X')&& (a[2][2]=='X')) || ((a[2][0] == 'O')&&(a[2][1]=='O')&& (a[2][2]=='O')))
			game=false;
		else if(((a[0][0] == 'X')&&(a[1][0]=='X')&& (a[2][0]=='X')) || ((a[0][0] == 'O')&&(a[1][0]=='O')&& (a[2][0]=='O')))
			game=false;
		else if(((a[0][1] == 'X')&&(a[1][1]=='X')&& (a[2][1]=='X')) || ((a[0][1] == 'O')&&(a[1][1]=='O')&& (a[2][1]=='O')))
			game=false;
		else if(((a[0][2] == 'X')&&(a[1][2]=='X')&& (a[2][2]=='X')) || ((a[0][2] == 'O')&&(a[1][2]=='O')&& (a[2][2]=='O')))
			game=false;
		else if(((a[0][0] == 'X')&&(a[1][1]=='X')&& (a[2][2]=='X')) || ((a[0][0] == 'O')&&(a[1][1]=='O')&& (a[2][2]=='O')))
			game=false;
		else if(((a[0][2] == 'X')&&(a[1][1]=='X')&& (a[2][0]=='X')) || ((a[0][2] == 'O')&&(a[1][1]=='O')&& (a[2][0]=='O')))
			game=false;
		return game;
	}
	public static char[][] change(int n,char p,char[][] b)
	{
		char[][] a=b.clone();
		switch(n)
		{
		case 1: a[0][0]=p;
		break;
		case 2: a[0][1]=p;
        break;
		case 3: a[0][2]=p;
        break;
		case 4: a[1][0]=p;
        break;
		case 5: a[1][1]=p;
        break;
		case 6: a[1][2]=p;
        break;
		case 7: a[2][0]=p;
        break;
		case 8: a[2][1]=p;
        break;
		case 9: a[2][2]=p;
        break;
		}
		return a;
	}
	public static void print(char[][] a)
	{
//		for(char[] i:a)
//		{
//			System.out.println(Arrays.toString(i));
//		}
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length;j++)
			{
				System.out.print(" "+a[i][j]+" ");
			}
			System.out.println();
		}
	}
}

