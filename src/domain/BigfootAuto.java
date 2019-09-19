package domain;

public class BigfootAuto extends Automata{
	private States q0 = new States("Big Foot $30", "q0", machState.Start);
	private States q1 = new States("Current: $5", "q1", machState.Normal);
	private States q2 = new States("Current: $10", "q2", machState.Normal);
	private States q3 = new States("Current: $15", "q3", machState.Normal);
	private States q4 = new States("Current: $20", "q4", machState.Normal);
	private States q5 = new States("Current: $25", "q5", machState.Normal);
	private States q6 = new States("Current: $30", "q6", machState.Normal);
	private States q7 = new States("Current: $35, accepted, Change = $0", "q7", machState.Final);
	private States q8 = new States("Current: $40, accepted, Change = $5", "q8", machState.Final);
	private States q9 = new States("Current: $45, accepted, Change = $10", "q9", machState.Final);
	
	public BigfootAuto(){
		sState = q0;
		curState = sState;
	}

	@Override
	public States CoinValue(domain.CoinValue co) {
	
		
		if(curState == q0){
			switch(co)
			{
			case Twenty:
			{
				curState = q4;
				return curState;
			}
			case Ten:
			{
				curState = q2;
				return curState;
			}
			
			case Five:
			{
				curState = q1;
				return curState;
			}
			default:
			{
				return null;
			}
			}
		}
		
		if(curState == q1){
			switch(co)
			{
			case Twenty:
			{
				curState = q5;
				return curState;
			}
			case Ten:
			{
				curState = q3;
				return curState;
			}
			
			case Five:
			{
				curState = q2;
				return curState;
			}
			default:
			{
				return null;
			}
			}
		}
		
		if(curState == q2){
			switch(co)
			{
			case Twenty:
			{
				curState = q6;
				return curState;
			}
			case Ten:
			{
				curState = q4;
				return curState;
			}
			
			case Five:
			{
				curState = q3;
				return curState;
			}
			default:
			{
				return null;
			}
			}
		}
		
		if(curState == q3){
			switch(co)
			{
			case Twenty:
			{
				curState = q7;
				return curState;
			}
			case Ten:
			{
				curState = q5;
				return curState;
			}
			
			case Five:
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
		
		if(curState == q4){
			switch(co)
			{
			case Twenty:
			{
				curState = q8;
				return curState;
			}
			case Ten:
			{
				curState = q6;
				return curState;
			}
			
			case Five:
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
		
		if(curState == q5){
			switch(co)
			{
			case Twenty:
			{
				curState = q9;
				return curState;
			}
			case Ten:
			{
				curState = q7;
				return curState;
			}
			
			case Five:
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
	

