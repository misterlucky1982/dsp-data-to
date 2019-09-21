package by.mlend.util;

import java.sql.Date;
import java.util.Iterator;

import by.mlend.data.to.ContractorListTO;
import by.mlend.data.to.ContractorTO;
import by.mlend.data.to.RemainderListTO;
import by.mlend.data.to.RemainderTO;
import by.mlend.data.to.StorageLocationListTO;
import by.mlend.data.to.StorageLocationTO;
import by.mlend.data.to.TOException;
import by.mlend.data.to.TransferObject;

public class Transfer {
	
	private final static int ID_LENGTH = 16;
	private final static int ID_START_POSITION = 0;
	private final static int COLOR_LENGTH = 16;
	private final static int COLOR_START_POSITION = 16;
	private static final int STORAGE_LENGTH = 16;
	private static final int STORAGE_START_POSITION = 32;
	private static final int CONTRACTOR_LENGTH = 16;
	private static final int CONTRACTOR_START_POSITION = 48;
	private static final int HEIGHT_LENGTH = 3;
	private static final int HEIGHT_START_POSITION = 64;
	private static final int WIDTH_LENGTH = 3;
	private static final int WIDTH_START_POSITION = 67;
	private static final int THICKNESS_LENGTH = 2;
	private static final int THICKNESS_START_POSITION = 70;
	private static final int DATE_LENGTH = 10;
	private static final int ARRIVAL_START_POSITION = 72;
	private static final int LEAVING_START_POSITION = 82;
	private static final int NAME_ID_COUNT_LENGTH = 3;
	private static final int NAME_ID_COUNT_START_POSITION = 92;
	private static final String EMPTY_DATE = "          ";
	

	
	private final static int ID_LENGTH_ST_LOC = 16;
	private final static int ID_START_POSITION_ST_LOC = 0;
	
	private final static int ID_LENGTH_CONTR = 16;
	private final static int ID_START_POSITION_CONTR = 0;
	
	private static final String SPLITTER = "x";
	private static final String REMAINDERLISTTO_SPLITTER = ":";
	private static final String STORAGELOCATIONLISTTO_SPLITTER = "!";
	private static final String CONTRACTORLISTTO_SPLITTER = "X";
	
	public static String toTranferString(TransferObject ob){
		if(ob==null)return null;
		if(ob instanceof RemainderTO)return writeRemainderTO((RemainderTO)ob);
		if(ob instanceof RemainderListTO)return writeRemainderListTO((RemainderListTO)ob);
		if(ob instanceof StorageLocationTO)return writeStorageLocationTO((StorageLocationTO)ob);
		if(ob instanceof StorageLocationListTO)return writeStorageLocationListTO((StorageLocationListTO)ob);
		if(ob instanceof ContractorTO)return writeContractorTO((ContractorTO)ob);
		if(ob instanceof ContractorListTO)return writeContractorListTO((ContractorListTO)ob);
		return null;
	}
	
	private static String writeRemainderTO(RemainderTO to){
		StringBuilder sb = new StringBuilder();
		String temp = Long.toHexString(to.getId());
		sb.append(temp);
		sb.append(spaces(ID_LENGTH-temp.length()));
		temp = to.getColor()!=0?Long.toHexString(to.getColor()):"";
		sb.append(temp);
		sb.append(spaces(COLOR_LENGTH-temp.length()));
		temp = to.getStorage()!=0?Long.toHexString(to.getStorage()):"";
		sb.append(temp);
		sb.append(spaces(STORAGE_LENGTH-temp.length()));
		temp = to.getContractor()!=0?Long.toHexString(to.getContractor()):"";
		sb.append(temp);
		sb.append(spaces(CONTRACTOR_LENGTH-temp.length()));
		temp = Long.toHexString(to.getHeight());
		sb.append(temp);
		sb.append(spaces(HEIGHT_LENGTH-temp.length()));
		temp = Long.toHexString(to.getWidth());
		sb.append(temp);
		sb.append(spaces(WIDTH_LENGTH-temp.length()));
		temp = Long.toHexString(to.getThickness());
		sb.append(temp);
		sb.append(spaces(THICKNESS_LENGTH-temp.length()));
		temp = to.getDateOfArival()!=null?to.getDateOfArival().toString():"";
		sb.append(temp);
		sb.append(spaces(DATE_LENGTH-temp.length()));
		temp = to.getDateOfLeaving()!=null?to.getDateOfLeaving().toString():"";
		sb.append(temp);
		sb.append(spaces(DATE_LENGTH-temp.length()));
		temp = byteString(to.getName()!=null?to.getName():"");
		String temp2 = Long.toHexString(temp.length());
		sb.append(temp2);
		sb.append(spaces(NAME_ID_COUNT_LENGTH-temp2.length()));
		sb.append(temp);
		sb.append(byteString(to.getRemark()!=null?to.getRemark():""));
		return sb.toString();
	}
	
	private static char[] spaces(int num){
		char[]chars = new char[num];
		for(int i=0;i<chars.length;i++)chars[i]=' ';
		return chars;
	}
	
	private static String byteString(String line){
		byte[]bytes = line.getBytes();
		StringBuilder sb = new StringBuilder();
		for(byte b:bytes)sb.append(SPLITTER+Byte.toString(b));
		if(sb.length()>0)sb.deleteCharAt(0);
		return sb.toString();
	}
	
	private static String fromByteString(String line){
		if(line==null||line.length()==0)return line;
		String[]strings = line.split(SPLITTER);
		byte[]bytes = new byte[strings.length];
		for(int i=0;i<bytes.length;i++)bytes[i]=Byte.parseByte(strings[i]);
		return new String(bytes);
	}
	
	public static RemainderTO remainderTO(String line) throws TOException{
		try{
			RemainderTO to = new RemainderTO();
			String temp = line.substring(ID_START_POSITION, ID_START_POSITION+ID_LENGTH);
			to.setId(Long.decode("0x"+temp.trim()));
			temp = line.substring(COLOR_START_POSITION, COLOR_LENGTH+COLOR_START_POSITION);
			if(!emptyString(temp))to.setColor(Long.decode("0x"+temp.trim()));
			temp = line.substring(STORAGE_START_POSITION, STORAGE_START_POSITION+STORAGE_LENGTH);
			if(!emptyString(temp))to.setStorage(Long.decode("0x"+temp.trim()));
			temp = line.substring(CONTRACTOR_START_POSITION, CONTRACTOR_LENGTH+CONTRACTOR_START_POSITION);
			if(!emptyString(temp))to.setContractor(Long.decode("0x"+temp.trim()));
			temp = line.substring(HEIGHT_START_POSITION, HEIGHT_LENGTH+HEIGHT_START_POSITION);
			to.setHeight(Integer.decode("0x"+temp.trim()));
			temp = line.substring(WIDTH_START_POSITION, WIDTH_LENGTH+WIDTH_START_POSITION);
			to.setWidth(Integer.decode("0x"+temp.trim()));
			temp = line.substring(THICKNESS_START_POSITION, THICKNESS_LENGTH+THICKNESS_START_POSITION);
			to.setThickness(Integer.decode("0x"+temp.trim()));
			temp = line.substring(ARRIVAL_START_POSITION, ARRIVAL_START_POSITION+DATE_LENGTH);
			if(!EMPTY_DATE.equals(temp))to.setDateOfArival(Date.valueOf(temp.trim()));
			temp = line.substring(LEAVING_START_POSITION, LEAVING_START_POSITION+DATE_LENGTH);
			if(!EMPTY_DATE.equals(temp))to.setDateOfLeaving(Date.valueOf(temp.trim()));
			int nameStart = NAME_ID_COUNT_START_POSITION+NAME_ID_COUNT_LENGTH;
			temp = line.substring(NAME_ID_COUNT_START_POSITION, nameStart);
			int nameLength = Integer.decode("0x"+temp.trim());
			String name = line.substring(nameStart,nameStart+nameLength);
			if(name.length()>0)to.setName(fromByteString(name));
			String remark = line.substring(nameStart+nameLength);
			if(remark.length()>0)to.setRemark(fromByteString(remark));
			return to;
		}catch(RuntimeException e){
			e.printStackTrace();
			throw new TOException();
		}
	}
	
	private static String writeRemainderListTO(RemainderListTO to){
		Iterator<RemainderTO> it = to.iterator();
		StringBuilder sb = new StringBuilder();
		while(it.hasNext()){
			if(sb.length()>0)sb.append(REMAINDERLISTTO_SPLITTER);
			sb.append(writeRemainderTO(it.next()));
		}
		return sb.toString();
	}

	public static RemainderListTO remainderListTO(String line) throws TOException{
		try{
			RemainderListTO listTO = new RemainderListTO();
			String lines[] = line.split(REMAINDERLISTTO_SPLITTER);
			for(String to:lines)listTO.add(remainderTO(to));
			return listTO;
		}catch(RuntimeException|TOException e){
			e.printStackTrace();
			throw new TOException();
		}
	}
	
	private static String writeStorageLocationTO(StorageLocationTO to){
		StringBuilder sb = new StringBuilder();
		sb.append(Long.toHexString(to.getId()));
		sb.append(spaces(ID_LENGTH_ST_LOC-sb.length()));
		sb.append(byteString(to.getName()));
		return sb.toString();
	}
	
	public static StorageLocationTO storageLocationTO(String line) throws TOException{
		try{
			StorageLocationTO to = new StorageLocationTO();
			String temp = line.substring(ID_START_POSITION_ST_LOC,ID_LENGTH_ST_LOC);
			to.setId(Long.decode("0x"+temp.trim()));
			temp = line.substring(ID_LENGTH_ST_LOC);
			to.setName(fromByteString(temp));
			return to;
		}catch(RuntimeException e){
			e.printStackTrace();
			throw new TOException();
		}
	}
	
	private static String writeStorageLocationListTO(StorageLocationListTO listTO){
		StringBuilder sb = new StringBuilder();
		Iterator<StorageLocationTO> it = listTO.iterator();
		while(it.hasNext()){
			if(sb.length()!=0)sb.append(STORAGELOCATIONLISTTO_SPLITTER);
			sb.append(writeStorageLocationTO(it.next()));
		}
		return sb.toString();
	}
	
	public static StorageLocationListTO storageLocationListTO(String line) throws TOException{
		try{
			String lines[] = line.split(STORAGELOCATIONLISTTO_SPLITTER);
			StorageLocationListTO listTO = new StorageLocationListTO();
			for(String s:lines)listTO.add(storageLocationTO(s));
			return listTO;
		}catch(RuntimeException|TOException e){
			e.printStackTrace();
			throw new TOException();
		}
	}
	
	private static String writeContractorTO(ContractorTO to){
		StringBuilder sb = new StringBuilder();
		sb.append(Long.toHexString(to.getId()));
		sb.append(spaces(ID_LENGTH_CONTR-sb.length()));
		sb.append(byteString(to.getName()));
		return sb.toString();
	}
	
	public static ContractorTO contractorTO(String line) throws TOException{
		try{
			ContractorTO to = new ContractorTO();
			String temp = line.substring(ID_START_POSITION_CONTR,ID_LENGTH_CONTR);
			to.setId(Long.decode("0x"+temp.trim()));
			temp = line.substring(ID_LENGTH_CONTR);
			to.setName(fromByteString(temp));
			return to;
		}catch(RuntimeException e){
			e.printStackTrace();
			throw new TOException();
		}
	}
	
	public static ContractorListTO contractorListTO(String line) throws TOException{
		try{
			String lines[] = line.split(CONTRACTORLISTTO_SPLITTER);
			ContractorListTO listTO = new ContractorListTO();
			for(String s:lines)listTO.add(contractorTO(s));
			return listTO;
		}catch(RuntimeException|TOException e){
			e.printStackTrace();
			throw new TOException();
		}
	}
	
	private static String writeContractorListTO(ContractorListTO listTO){
		StringBuilder sb = new StringBuilder();
		Iterator<ContractorTO> it = listTO.iterator();
		while(it.hasNext()){
			if(sb.length()!=0)sb.append(CONTRACTORLISTTO_SPLITTER);
			sb.append(writeContractorTO(it.next()));
		}
		return sb.toString();
	}
	
	private static boolean emptyString(String line){
		return line==null||line.trim().length()==0;
	}
}
