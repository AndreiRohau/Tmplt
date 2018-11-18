package com.ras.tmpl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

public class MainTest {

	private Properties properties;

	@Test
	public void test() {
		System.out.println("TEST! tmpl prj");

		Main m = new Main();
		assertEquals(1, m.i(1));
	}

	@Test
	public void testProps() {
		Main m1 = new Main();
		System.out.println(m1.get("tmpl"));

		MainTest m = new MainTest();
		String prop = m.get("tmpl");

		System.out.println(prop);

	}

	public MainTest() {
		loadProperties();
	}

	public String get(String name) {
		return properties.getProperty(name);
	}

	private void loadProperties() {
		try (InputStream is = this.getClass().getClassLoader().getResourceAsStream("test.properties")) {
			properties = new Properties();
			properties.load(is);
		} catch (IOException e) {
			System.out.println("Error while getting properties...");
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
