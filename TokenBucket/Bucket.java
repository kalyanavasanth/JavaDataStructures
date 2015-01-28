package TokenBucket;

import LinkedList.*;

/**
 * @author kalyan This class creates a bucket that hold tokens as a queue
 */
public class Bucket {
	private int DEPTH = 0; // sets the depth of bucket
	Queue<Token> BucketQueue;

	/**
	 * @param _depth
	 *            sets the depth of bucket object on bucket creation
	 */
	public Bucket(int _depth) {
		this.DEPTH = _depth;
		/* Create a queue upon object creation to hold tokens */
		BucketQueue = new Queue<Token>();
	}
	
	public int GetDepth(){
		/* returns the depth of the bucket */
		return DEPTH;
	}
	
	public void AddToken(){
		/* Creates a new token and adds it to the queue */
		Token NewToken=new Token();
		BucketQueue.enqueue(NewToken);
	}
	
	public void TransferToken(){
		/* Dequeues a token from bucket */
		BucketQueue.dequeue();
	}
	
	public int TokensCount(){
		/* Returns the number of tokens in the bucket at present */
		return BucketQueue.getSize();
	}

}