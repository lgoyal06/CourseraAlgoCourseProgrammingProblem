package com.lalit.coursera.week4;

import java.util.Random;

public class Test1 {
	public static void main(String ...s){
		Random generator = new Random();
		for(int i=0;i<100;++i){
			System.out.println(generator.nextInt(100));
		}
	}
}
