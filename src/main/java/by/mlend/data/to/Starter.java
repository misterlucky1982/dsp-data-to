package by.mlend.data.to;

import java.sql.Date;

import by.mlend.util.Transfer;

public class Starter {

	public static void main(String[] args) throws TOException {
		
		ContractorTO to = new ContractorTO();
		to.setId(6454646);
		to.setName("Виктор Михайлович Уваров");
		ContractorTO to2 = new ContractorTO();
		to2.setId(7899);
		to2.setName("Василий Петрович Мукакайкин");
		ContractorTO to3 = new ContractorTO();
		to3.setId(1089999);
		to3.setName("Валентин Павлович Череззаборногузадерищенко");
		ContractorListTO list = new ContractorListTO();
		list.add(to);
		list.add(to2);
		list.add(to3);
		String line = Transfer.toTranferString(list);
		System.out.println(line);
		ContractorListTO listTO = Transfer.contractorListTO(line);
		for(ContractorTO cto:listTO){
			System.out.println(cto);
		}
	}

}
