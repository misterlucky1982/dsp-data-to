package by.mlend.data.to;

import java.util.List;

public interface ListTO<T> extends TransferObject{
	
	boolean add(T t);
	T get(int index);
	int size();
	List<T> toList();
}
