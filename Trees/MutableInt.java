package Trees;

public class MutableInt {
	private int value=0;
	MutableInt(int _value){
		value=_value;
	}
	public void setValue(int _value){
		value=_value;
	}
	public int getValue(){
		return value;
	}
}
