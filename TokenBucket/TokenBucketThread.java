package TokenBucket;

/**
 * @author kalyan
 *This thread controls the token bucket
 */
public class TokenBucketThread extends Thread{
	/* Variable that holds the incoming rate of tokens */
	private int INCOMING_RATE_R=0;
	/* Reference to the token bucket that has to be processed */
	private Bucket TokenBucket;
	
	public TokenBucketThread(Bucket _bucket, int _rate){
		/* Initialize the incoming rate on thread creation */
		INCOMING_RATE_R=_rate;
		TokenBucket=_bucket;
	}
	
	public void run(){
		try {
			while(true){
			/* create and add token to bucket at INCOMING_RATE_R */
				TokenBucket.AddToken();
				System.out.println("Token Arrived");
				sleep(INCOMING_RATE_R);
			}
		} catch (InterruptedException e) {
			System.err.println("Token Bucket Thread Interrupted");
		}
	}
}
