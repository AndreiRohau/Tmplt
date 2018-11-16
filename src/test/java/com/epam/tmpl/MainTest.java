package com.epam.tmpl;

import com.epam.tmpl.Main;
import static org.junit.Assert.*;

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
		
		MainTest m = new MainTest();
		String prop = m.get("tmpl");
		
		System.out.println(prop);
		
	}
	
	public MainTest() {
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
		try (InputStream is = MainTest.class.getClassLoader().getResourceAsStream("test.properties")) {
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
