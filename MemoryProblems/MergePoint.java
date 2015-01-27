package MemoryProblems;

public class MergePoint<T> {
	private MergedList<T> mergedList;
	public void process(MergedList<T> _mergedList){
		mergedList=_mergedList;
		InsecureLinkedListHelper<T>.Node Head1=mergedList.GetHeadOne();
		InsecureLinkedListHelper<T>.Node Head2=mergedList.GetHeadTwo();
		InsecureLinkedListHelper<T>.Node TempRef1=Head1;
		InsecureLinkedListHelper<T>.Node TempRef2=Head2;
		int count=0,traversals=0;
		while(TempRef1.getNext()!=null && TempRef2.getNext()!=null){
			TempRef1=TempRef1.getNext();
			TempRef2=TempRef2.getNext();
		}
		if(TempRef1.getNext()==null){
			while(!TempRef2.equals(TempRef1)){
				TempRef2=TempRef2.getNext();
				++count;
			}
			TempRef1=Head1;
			TempRef2=Head2;
			for(int index=0;index<count;++index){
				TempRef2=TempRef2.getNext();
			}
		}
		if(TempRef2.getNext()==null){
			while(!TempRef1.equals(TempRef2)){
				TempRef1=TempRef1.getNext();
				++count;
			}
			TempRef1=Head1;
			TempRef2=Head2;
			for(int index=0;index<count;++index){
				TempRef1=TempRef1.getNext();
			}
		}
		while(!TempRef1.equals(TempRef2)){
			TempRef1=TempRef1.getNext();
			TempRef2=TempRef2.getNext();
			++traversals;
		}
		System.out.println("Merge point is:"+traversals+" w.r.t one Head and "+(traversals+count)+" w.r.t other Head");
	}
}
