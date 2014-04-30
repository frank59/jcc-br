package com.soku.wangheng.jccbr.test;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LoadFileTester {

	public static void main(String[] args) throws IOException {
		List<Character> content = new ArrayList<Character>();
		Map<Character, Character> ts = new HashMap<Character, Character>();
		
		BufferedReader in = new BufferedReader(
			new InputStreamReader(LoadFileTester.class.getResourceAsStream("/cfg/ts.tab"), "UTF-8")
		);
		int c;
		while((c = in.read()) != -1) {
			content.add((char) c);
		}
		for(int i=0; i<content.size(); i=i+2) {
			if(!content.get(i).equals(content.get(i+1))) {
				ts.put(content.get(i), content.get(i+1));
			}
		}
		
		FileWriter writer = new FileWriter("D:/ts.dat");
		try {
			
			for (Entry<Character, Character> entry : ts.entrySet()) {
				writer.write(((char)entry.getKey() + "") + (char)entry.getValue() + "\n");
			}
		} finally {
			writer.close();
		}

	}

}
