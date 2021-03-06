package com.soku.wangheng.jccbr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * This is a tool convert Traditional Chinese character to Simplified. 
 * The character source is other encoding (e.g. gbk or gb2313) 
 * have to convert to Unicode before performing conversion.
 * 
 * Thanks Joe Choi(joechoi48@gmail.com) for the code of JChineseConvertor!
 * The project URL of Joe Choi's JChineseConvertor is 
 * http://code.google.com/p/jcc/
 * @author WangHeng
 */
public class JChineseConvertor {
	
	private static final String DEF_SRC_FILE = "/jcc_cfg/ts.dat";
	
	private static JChineseConvertor instance = null;
	
	/**
	 * 繁体转简体Map Traditional to Simplified
	 */
	private Map<Character, Character> ts ;
	/**
	 * 简体转繁体Map Simplified to Traditional
	 */
	private Map<Character, Character> st ;
	
	/**
	 * Singleton Constructor
	 * @param srcFile The source file path
	 * @throws UnsupportedEncodingException 
	 */
	private JChineseConvertor(String srcFile) throws Exception {
		ts = new HashMap<Character, Character>();
		st = new HashMap<Character, Character>();
		
		//load source file
		BufferedReader reader = new BufferedReader(new InputStreamReader(JChineseConvertor.class.getResourceAsStream(srcFile), "UTF-8"));
		try {
			String line = null;
			int lineNum = 0;
			while ((line = reader.readLine()) != null) {
				lineNum++;
				if (line.trim().equals("")) {
					continue;
				}
				char[] chararry = line.toCharArray();
				if (chararry.length != 2) {
					throw new IllegalStateException("One line in file '"+ srcFile + "' has wrong info. lineNum(" + lineNum + "):" + line );
				}
				if (chararry[0] != chararry[1]) {
					ts.put(chararry[0], chararry[1]);
					st.put(chararry[1], chararry[0]);
				}
			}
		} finally {
			reader.close();
		}
	}
	
	/**
	 * Get the single instance
	 * @return instance
	 */
	public static JChineseConvertor getInstance() {
		if (instance == null) {
			try {
				instance = new JChineseConvertor(DEF_SRC_FILE);
			} catch (Exception e) {
				throw new IllegalStateException("Can not create new instance of JChineseConvertor : " + e.getMessage(), e);
			}
		}
		return instance;
	}
	
	/**
	 * Traditional to Simplified
	 * @param str
	 * @return Simplified result
	 */
	public String t2s(String str) {
		char[] result = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			char tchar = str.charAt(i);
			Character schar = ts.get(tchar);
			if (schar != null) {
				result[i] = schar;
			} else {
				result[i] = tchar;
			}
		}
		return new String(result);
	}
	
	
	/**
	 * Simplified to Traditional
	 * @param str
	 * @return Traditional result
	 */
	public String s2t(String str) {
		char[] result = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			char schar = str.charAt(i);
			Character tchar = st.get(schar);
			if (tchar != null) {
				result[i] = tchar;
			} else {
				result[i] = schar;
			}
		}
		return new String(result);
	}

}