package com.zzl.test;
import java.io.File;
import java.io.IOException;

public class test1 {
	public static void main(String[] args) throws IOException {
		System.out.println(System.getProperty("user.dir"));
		System.out.println((new File(System.getProperty("user.dir"), "..")).getCanonicalPath());
	}
}
