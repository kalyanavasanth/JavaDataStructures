package TokenBucket;

import LinkedList.*;

public class Test {
	public static void main(String args[]){
		Queue<Packet> Q1=new Queue<Packet>();
		Queue<Packet> Q2=new Queue<Packet>();
		Bucket bucket=new Bucket(10);
		Server server=new Server();
		
		TokenBucketThread BucketThread = new TokenBucketThread(bucket, 500);
		QueueTwoOutThread ServerThread=new QueueTwoOutThread(Q2, server, 3000);
		QueueOneInThread Q1InThread=new QueueOneInThread(Q1,1000);
		QueueOneOutThread Q1OutThread=new QueueOneOutThread(Q1, Q2, ServerThread, bucket, 1000);
		
		BucketThread.start();
		Q1InThread.start();
		ServerThread.start();
		Q1OutThread.start();
	}
}
