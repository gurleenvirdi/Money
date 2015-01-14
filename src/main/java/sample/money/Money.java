package sample.money;

public class Money 
{
	private int fAmount;
    private String fCurrency;
    
    //constructor for Money class
    public Money(int amount, String currency) {
        fAmount= amount;
        fCurrency= currency;
        //System.out.println("Money : "+amount()+""+currency());
    }

    public int amount() {
        return fAmount;
    }

    public String currency() {
        return fCurrency;
    }
    
    //method to add 2 Money objects
    public Money add(Money m) {
        return new Money(amount()+m.amount(), currency());
    }

    public boolean equals(Object anObject) {
        if (anObject instanceof Money) {
            Money aMoney= (Money)anObject;
            return aMoney.currency().equals(currency())
                && amount() == aMoney.amount();
        }
        return false;
    }
}
