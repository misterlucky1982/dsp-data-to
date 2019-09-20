package by.mlend.data.to;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemainderListTO implements Iterable<RemainderTO>, ListTO<RemainderTO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<RemainderTO> remainders = new ArrayList<>();
	
	@Override
	public Iterator<RemainderTO> iterator() {
		return this.remainders.iterator();
	}

	@Override
	public boolean add(RemainderTO t) {
		return t!=null?this.remainders.add(t):false;
	}

	@Override
	public RemainderTO get(int index) {
		return this.remainders.get(index);
	}

	@Override
	public int size() {
		return this.remainders.size();
	}

	@Override
	public List<RemainderTO> toList() {
		return this.remainders;
	}

	

}
