package com.soku.wangheng.jccbr.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class NewJCCTester {
	
	

	public static void main(String[] args) throws IOException {
		test01();
	}

	private static void test01() throws IOException {
		
		Map<Character, Character> ts = new HashMap<Character, Character>();
		Map<Character, Character> st = new HashMap<Character, Character>();
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(NewJCCTester.class.getResourceAsStream("/cfg/ts.dat"), "UTF-8"));
		try {
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (line.trim().equals("")) {
					continue;
				}
				
				char[] chararry = line.toCharArray();
				if (chararry.length != 2) {
					throw new IllegalStateException("读取到错误的行 line = " + line);
				}
				if (chararry[0] != chararry[1]) {
					ts.put(chararry[0], chararry[1]);
					ts.put(chararry[1], chararry[0]);
				}
			}
		} finally {
			reader.close();
		}
		
		System.out.println(ts.size());
	}

}
