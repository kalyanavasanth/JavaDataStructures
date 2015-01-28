package TokenBucket;

/**
 * @author kalyan
 *This class is used for instantiating tokens, which are contained in the bucket
 */
public class Token {
	private static int id=0;     //maintains token ID
	public Token(){
/* Increments ID every time a token is created 
 * so that every token has unique ID
 * */
		id=id+1;                
	}
	public int getID(){
	/* return token ID */
		return id;
	}
}