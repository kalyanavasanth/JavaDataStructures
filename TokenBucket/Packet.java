package TokenBucket;

import java.util.Date;

/**
 * @author kalyan 
 * This class creates a packet. Packet take tokens from token
 *         bucket if it is eligible for transmission.
 */
public class Packet {
	private int ELIGIBILITY=0;
	/* References for holding time stamps */
	private Date created=null;
	private Date moved=null;
	/* Variable that holds packet ID */
	private static int ID = 0;

	public Packet() {
		/* adds time stamp of creation */
		created = new Date();
		ID = ID + 1;
	}
	
	public void SetEligibleTokens(int _limit){
	/* used to set the numbers of tokens that make the packet eligible for transmission */
		ELIGIBILITY=_limit;
	}
	
	public int GetEligibleTokens(){
		/* return numbers of tokens that are needed to make the packet eligible for transmission */
		return ELIGIBILITY;
	}
	
	public int GetID(){
	/* returns packet ID */
		return ID;
	}
	
	public void SetMovedTime(){
		moved=new Date();
	}
	
	public Date getCreatedTime(){
		return created;
	}
	
	public Date getMovedTime(){
		return moved;
	}

}
