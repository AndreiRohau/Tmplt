package com.epam.tmpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {

	private Properties properties;

	public static void main(String[] args) {

		System.out.println("tmpl prj");

		Main inst = new Main();
		String prop = inst.get("tmpl");
		System.out.println(prop);

	}

	public int i(int i) {
		return i;
	}

	public Main() {
		try {
			loadProperties();
		} catch (IOException e) {
			System.out.println("Error while Main.class initialization...");
			e.printStackTrace();
		}
	}
	
	public String get(String name) {
		return properties.getProperty(name);
	}

	private void loadProperties() throws IOException {
		try (InputStream is = Main.class.getClassLoader().getResourceAsStream("main.properties")) {
			properties = new Properties();
			properties.load(is);
			is.close();
		} catch (IOException e) {
			System.out.println("Error while getting properties...");
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
