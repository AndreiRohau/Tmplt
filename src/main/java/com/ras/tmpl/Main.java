package com.ras.tmpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {

	private Properties properties;

	public static void main(String[] args) {

		System.out.println("tmpl prj");

		Main inst = new Main();
		System.out.println(inst.get("tmpl"));

		System.out.println("chain : " + new Main().get("tmpl"));
	}

	public int i(int i) {
		return i;
	}

	public Main() {
		loadProperties();
	}

	public String get(String name) {
		return properties.getProperty(name);
	}

	private void loadProperties() {
		try (InputStream is = getClass().getClassLoader().getResourceAsStream("main.properties")) {
			properties = new Properties();
			properties.load(is);
		} catch (IOException e) {
			System.out.println("Error while getting properties...");
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
