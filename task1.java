import java.util.*;
abstract class loginBankFunctions
{
	abstract void withdrawl(long amt,ArrayList<Details>a,String name);
	abstract void deposit(long amt,ArrayList<Details>a,String name);
	abstract void view(ArrayList<Details>a,String name);
	abstract void logintoexistinguser(ArrayList<Details>AccountHolders);
} 
class MAINe
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER THE NUMBER OF USERS");
		int n=sc.nextInt();
		ArrayList<Details>AccountHolders=new ArrayList<Details>();
		for(int i=1;i<=n;i++)
		{
			System.out.println("SELECT FROM THE BELOW");
			System.out.println("1.CREATE A NEW ACCOUNT");
			System.out.println("2.LOGIN TO EXISTING ACCOUNT");
			int choice=sc.nextInt();
			switch(choice)
			{
				case 1:CreateAccount a=new CreateAccount();
					  a.createnewaccount(AccountHolders);
					break;
				case 2:loginAccount a1=new loginAccount();
					 a1.logintoexistinguser(AccountHolders);
					//break;
				default:System.out.println("INVALID CHOICE");
			}
		}
	}
}
class CreateAccount extends loginAccount
{
	public  void createnewaccount(ArrayList<Details>AccountHolders)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Details");
		System.out.println("Please Enter your name:");
		String name=sc.nextLine();
		System.out.println("Please Set your password");
		String password=sc.nextLine();
		System.out.println("Please Enter your deposit amount");
		long amount=sc.nextLong();
		Details d=new Details();
		d.setname(name);
		d.setpassword(password);
		d.setamount(amount);
		AccountHolders.add(d);
		System.out.println("ACCOUNT CREATION SUCCESSULL");
		System.out.println();
		CreateAccount c=new CreateAccount();
		c.view(d);
	}
	public void view(Details d)
	{
		System.out.println("Username : "+d.getname());
	}
}
class loginAccount extends loginBankFunctions
{
	public void logintoexistinguser(ArrayList<Details>AccountHolders)
	{
		Scanner sc=new Scanner(System.in);
		loginAccount a=new loginAccount();
		System.out.println("Enter the Username");
		String username=sc.nextLine();
		System.out.println("Enter the password");
		String password=sc.nextLine();
		for(int i=0;i<AccountHolders.size();i++)
		{
			if(AccountHolders.get(i).getname().equals(username))
			{
				if(AccountHolders.get(i).getpassword().equals(password))
				{
					//int i=0;
					System.out.println("Hi "+username);
					while(true)
					{
						System.out.println("PLEASE SELECT YOUR CHOICE");
						System.out.println("1.CheckBalance");
						System.out.println("2.withdrawl");
						System.out.println("3.Deposit");
						int c=sc.nextInt();
						switch(c)
						{
							case 1:a.view(AccountHolders,username);
							       break;

							case 2:long amt=sc.nextLong();
								   a.withdrawl(amt,AccountHolders,username);
							      break;
							case 3:long amt1=sc.nextLong();
								a.deposit(amt1,AccountHolders,username);
							      break;
						    default:System.out.println("Invalid Choice");
						}
						System.out.println("DO YOU WANT TO CONTINUE OPERATION");
						System.out.println("1.YES");
						System.out.println("2.NO");
						int x=sc.nextInt();
						if(x!=1)
						{
							break;
						}
					}
				}
			}
		}
	}
	public void withdrawl(long amt,ArrayList<Details>a,String name)
	{
		for(int i=0;i<a.size();i++)
		{
			if(name.equals(a.get(i).getname()))
			{
				long r=a.get(i).getamount()-amt;
				if(r>0)
				{
					a.get(i).setamount(r);
					System.out.println("Withdrawl successfull");
				}
				else{
					System.out.println("Insufficient Balance");
				}
			}
		}
	}
	public void deposit(long amt,ArrayList<Details>a,String name)
	{
		for(int i=0;i<a.size();i++)
		{
			if(name.equals(a.get(i).getname()))
			{
				long r=a.get(i).getamount()+amt;
			    a.get(i).setamount(r);
			    System.out.println("deposit successfull");
			}
		}
	}
	public void view(ArrayList<Details>a,String name)
	{
		for(int i=0;i<a.size();i++)
		{
			if(name.equals(a.get(i).getname()))
			{
				System.out.println("USERNAME: "+a.get(i).getname());
				System.out.println("AMOUNT: "+a.get(i).getamount());
				break;
			}
		}
	}
}
class Details
{
	private String name;
	private String password;
	private long amount;
	public void setname(String name)
	{
		this.name=name;
	}
	public void setpassword(String password)
	{
		this.password=password;
	}
	public void setamount(long amount)
	{
		this.amount=amount;
	}
	public String getname()
	{
		return name;
	}
	public String getpassword()
	{
		return password;
	}
	public long getamount()
	{
		return amount;
	}

}
