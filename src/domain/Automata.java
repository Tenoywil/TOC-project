package domain;

public abstract class Automata {
protected States curState;
protected States sState;



public States getsState() {
	return sState;
}

public abstract States CoinValue(CoinValue co);
}
