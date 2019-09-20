package by.mlend.data.to;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContractorListTO implements ListTO<ContractorTO>, Iterable<ContractorTO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ContractorTO> listTO = new ArrayList<>();

	@Override
	public boolean add(ContractorTO t) {
		return t!=null?this.listTO.add(t):false;
	}

	@Override
	public ContractorTO get(int index) {
		return this.listTO.get(index);
	}

	@Override
	public int size() {
		return this.listTO.size();
	}

	@Override
	public List<ContractorTO> toList() {
		return this.listTO;
	}

	@Override
	public Iterator<ContractorTO> iterator() {
		return this.listTO.iterator();
	}

}
