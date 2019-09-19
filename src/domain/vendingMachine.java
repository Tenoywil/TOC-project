package domain;

public class vendingMachine {
private int coin;
private String item;
private int total;
private int currentStat;

public vendingMachine() {
	total = 0;
	coin = 0;
	item = "Straw";
	currentStat = 0;
}

public vendingMachine(int c, String i) {
	this.coin = c;
	this.item = i;
}

public vendingMachine(vendingMachine obj) {
	obj.coin = coin;
	obj.item = item;
	
}

public int getCoin() {
	return coin;
}

public void setCoin(int coin) {
	this.coin = coin;
}

public String getItem() {
	return item;
}

public void setItem(String item) {
	this.item = item;
}

public int getTotal() {
	return total;
}

public void setTotal(int total) {
	this.total = total;
}

public int getCurrentStat() {
	return currentStat;
}

public void setCurrentStat(int currentStat) {
	this.currentStat = currentStat;
}

@Override
public String toString() {
	return "vendingMachine [coin=" + coin + ", item=" + item + "]";
}

public int itemSelected(String item) {
	int price = 0;
	
	if (item.compareToIgnoreCase("doritos")==0) {
		price = 50;
	}else if(item.compareToIgnoreCase("bagjuice")==0) {
		price = 15;
	}else if (item.compareToIgnoreCase("cranwata")==0) {
		price = 40;
	}else if (item.compareToIgnoreCase("pepsi")==0) {
		price = 35;
	}else if (item.compareToIgnoreCase("bigfoot")==0) {
		price = 30;
	}
	return price;
}

public void coinValidation(int coin) {
	if(coin != 5 || coin != 10 || coin != 20) {
		System.out.println("Invalid Coin Entered plz try again");
	}
}
public int calculations(String coinValue, int numclicks) {
	
	for (numclicks = 0; numclicks > 0; numclicks--) {
		if(coinValue.compareToIgnoreCase("10")==0) {
			total = total + 10;
		}else if(coinValue.compareToIgnoreCase("5")==0) {
			total = total + 5;
		}else if(coinValue.compareToIgnoreCase("20")==0) {
			total = total + 20;
		
	}
	
}
	return total;

}
public int currentState(String coinValue) {
	
	int value = Integer.valueOf(coinValue);
	
	currentStat = currentStat + value;
	return currentStat;
}
public void Balance(int total,int itemPrice) {
	@SuppressWarnings("unused")
	int balance = 0;
	balance = itemPrice - total;
}

}

