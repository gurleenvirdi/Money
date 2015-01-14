package sample.money;
import java.util.Iterator;
import java.util.Vector;


public class MoneyBag
{
	 private Vector<Money> fMonies= new Vector<Money>();

	 	//constructor for MoneyBag class
	 	MoneyBag()
	 	{
	 		this.fMonies=null;
	 	}
	   
	 	//constructor for 2 Money Objects
	 	MoneyBag(Money m1, Money m2) {
	        appendMoney(m1);
	        appendMoney(m2);
	    }

	 	//constructor for array of Money Objects
	    MoneyBag(Money bag[]) {
	        for (int i= 0; i < bag.length; i++)
	            appendMoney(bag[i]);
	    }
	    
	    //constructor for 1 MoneyBag Object
	    MoneyBag(MoneyBag bag) {
	        this.fMonies=bag.fMonies;
	    }
	    
	    public void appendMoney(Money aMoney)
	    {
	    	boolean flag=false;
	    	Iterator<Money> it=this.fMonies.iterator();
	    	Money money;
	    	if(this.fMonies.size()==0)
	    		this.fMonies.add(aMoney);
	    	else
	    	{
	    		while(it.hasNext())
	    		{
	    			money=it.next();
	    			if(  money.currency().equals(aMoney.currency()) )
	    			{
	    				flag=true;
	    				this.fMonies.add(aMoney.add(money));
	    				this.fMonies.remove(money);
	    				break;
	    			}
	    		}
	    		if(flag==false)
	    			this.fMonies.add(aMoney);
	    	}
	    }
	    
	    public void display()
	    {
	    	if(fMonies==null)
	    	{
	    		System.out.println("<Empty>");
	    		return;
	    	}
	    	Iterator<Money> it=fMonies.iterator();
	    	Money money=null;
	    	//System.out.println("Into the function\n");
	    	System.out.println("Bag size : "+fMonies.size());
	    	while(it.hasNext())
	    	{
	    		money=it.next();
	    		System.out.println(" "+money.amount()+money.currency());
	    		//System.out.println(money.amount()+"+"+money.currency());
	    	}
	    }
	    
	    public boolean equals(Object bag)
	    {
	    	//boolean isEquals=false;
	    	int equalCount=0;
	    	Iterator<Money> thisIT;
	    	Iterator<Money> bagIT;
	    	Money thisMoney,bagMoney;
	    	
	    	if(bag instanceof MoneyBag )
	    	{
	    		if(this.fMonies==null || ((MoneyBag)bag).fMonies==null)
		    	{
		    		//isEquals=false;
		    		return false;//isEquals;
		    	}
	    		
	    		if(this.fMonies.size()==((MoneyBag)bag).fMonies.size())
	    		{
	    			thisIT=this.fMonies.iterator();
	    			while(thisIT.hasNext())
	    			{
	    				thisMoney=thisIT.next();
	    				bagIT=((MoneyBag)bag).fMonies.iterator();
	    				while(bagIT.hasNext())
	    				{
	    					bagMoney=bagIT.next();
	    					if(thisMoney.equals(bagMoney))
	    						equalCount++;
	    				}
	    				
	    			}
	    			if(equalCount==this.fMonies.size())
	    				return true;//isEquals=true;
	    		}
	    	}
	    	return false;//isEquals;
	    }
	    
	    public static void main(String args[])
	    {
	    	Money m1=new Money(12,"CHF");
 	    	Money m2=new Money(14,"USD");
	    	Money m3=new Money(10,"USD");
	    	Money bag[]={m1,m2,m3};
	    	Money bag2[]={m2,m3};
	    	
	    	MoneyBag mb=new MoneyBag(bag);
	    	MoneyBag mb2=new MoneyBag(bag2);
	    	MoneyBag mb3=new MoneyBag();
	    	
	    	System.out.println("\nMoneyBag mb :");
	    	mb.display();
	    	System.out.println("MoneyBag mb2 :");
	    	mb2.display();
	    	System.out.println("MoneyBag mb3 :");
	    	mb3.display();
	    	
	    	System.out.println("Checking equality of moneyBags : \n\nmb V/S mb2");
	    	System.out.println(mb.equals(mb2));
	    	
	    	System.out.println("\n\nmb2 V/S mb3");
	    	System.out.println(mb2.equals(mb3));
	    	
	    	System.out.println("\n\nmb3 V/S mb");
	    	System.out.println(mb3.equals(mb));
	    }
}
