package by.mlend.data.to;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StorageLocationListTO implements Iterable<StorageLocationTO>, ListTO<StorageLocationTO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<StorageLocationTO> listStTO = new ArrayList<>();

	@Override
	public Iterator<StorageLocationTO> iterator() {
		return this.listStTO.iterator();
	}

	@Override
	public boolean add(StorageLocationTO t) {
		return t!=null?this.listStTO.add(t):false;
	}

	@Override
	public StorageLocationTO get(int index) {
		return this.listStTO.get(index);
	}

	@Override
	public int size() {
		return this.listStTO.size();
	}

	@Override
	public List<StorageLocationTO> toList() {
		return this.listStTO;
	}

	
	
}
