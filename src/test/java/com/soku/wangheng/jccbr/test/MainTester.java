package com.soku.wangheng.jccbr.test;

import java.io.IOException;

import com.soku.wangheng.jccbr.JChineseConvertor;

public class MainTester {
	
	public static void main(String[] args) throws IOException {
		test01();
	}

	private static void test01() throws IOException {
		
		System.out.println(JChineseConvertor.getInstance().t2s("什么"));
		System.out.println(JChineseConvertor.getInstance().t2s("曉說"));
		System.out.println(JChineseConvertor.getInstance().t2s("是什麼"));
		System.out.println(JChineseConvertor.getInstance().t2s("國語"));
		System.out.println(JChineseConvertor.getInstance().t2s("視頻"));
		
		System.out.println(JChineseConvertor.getInstance().s2t("什么"));
		System.out.println(JChineseConvertor.getInstance().s2t("晓说"));
		System.out.println(JChineseConvertor.getInstance().s2t("国语"));
		System.out.println(JChineseConvertor.getInstance().s2t("视频"));
	}

}
