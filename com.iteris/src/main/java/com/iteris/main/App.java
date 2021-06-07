package com.iteris.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.iteris.classes.Table;

public class App {

	private static final String CSV_FILE_PATH = "C:\\Users\\paulo.bernardo\\vendasEstoque.csv";
	
	private static Map<String, Table> linkedTableFields = new LinkedHashMap<String, Table>();
	
	public static void main(String[] args) {
		
		FileReader fr;
		try {
			fr = new FileReader(new File(CSV_FILE_PATH));
			BufferedReader br = new BufferedReader(fr);
			
			String line = br.readLine();
			while(line != null) {
				String[] split =  line.split(";");

				Table tableInfos = new Table(split[1], split[2], split[3], split[4], split[5]);
				
				linkedTableFields.put(split[1].toUpperCase(), tableInfos);
				
				line = br.readLine();
			}
			
			// construir campos
			
			Set<String> keys = linkedTableFields.keySet();
	
			
			List<String> fields = new ArrayList<String>();
			
			for(String key : keys) {
				Table table = linkedTableFields.get(key);

				String type = table.getType();
				if(type.equals("SMALLINT")) {
					type = "INTEGER";
				}

				String field = table.getName() + " " + type + generateLenghtAndScale(table) + table.getNotNull() + ",";
				fields.add(field);
			}
			
			for(String field : fields) {
				System.out.println(field);
			}
			
			System.out.println();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String generateLenghtAndScale(Table table) {
		
		if (table.getType().equals("CHAR")) {
			return "(" + table.getLenght() + ")";
		}
		
		if (table.getType().equals("INTEGER") || table.getType().equals("SMALLINT") ) {
			return "";
		}
		
		if (table.getLenght().equals("null") && table.getScale().equals("null")) {
			return "";
		}
		
		if (!table.getLenght().equals("null") && table.getScale().equals("null")) {
			return "(" + table.getLenght() + "," + 0+ ")";
		}
		
		
		return "(" + table.getLenght() + "," + table.getScale() + ")";
	}
	
}
