package domain;

public class BagJuiceAuto extends Automata{

	
	
	
	private States q0 = new States("Bag Juice Selected. Cost is $15", "q0", machState.Start);
	private States q1 = new States("Current: $5", "q1", machState.Normal);
	private States q2 = new States("Current: $10", "q2", machState.Normal);
	private States q3 = new States("Current: $15, accepted, Change = $0", "q3", machState.Final);
	private States q4 = new States("Current: $20, accepted, Change = $5", "q4", machState.Final);
	private States q5 = new States("Current: $25, accepted, Change = $10", "q5", machState.Final);
	private States q6 = new States("Current: $30, accepted, Change = $15", "q6", machState.Final);
	public BagJuiceAuto(){
		sState = q0;
		curState = sState;
	}
	@Override
	public States CoinValue(domain.CoinValue co) {
		if(curState == q0){
			switch(co)
			{
			case Five:
			{
				curState = q1;
				return curState;
			}
			case Ten:
			{
				curState = q2;
				return curState;
			}
			case Twenty:
			{
				curState = q4;
				return curState;
			}
			default:
			{
				return null;
			}
			}
		}
		
		if(curState == q1)
		{
			switch(co)
			{
			case Five:
			{
				curState = q2;
				return curState;
			}
			case Ten:
			{
				curState = q3;
				return curState;
			}
			case Twenty:
			{
				curState = q5;
				return curState;
			}
			default:
			{
				return null;
			}
			}
		}
		
		if(curState == q2)
		{
			switch(co)
			{
			case Five:
			{
				curState = q3;
				return curState;
			}
			case Ten:
			{
				curState = q4;
				return curState;
			}
			case Twenty:
			{
				curState = q6;
				return curState;
			}
			default:
			{
				return null;
			}
			}
		}
		
		return null;
	}
	

}
