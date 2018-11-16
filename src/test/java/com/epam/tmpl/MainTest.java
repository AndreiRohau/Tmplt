package com.epam.tmpl;

import com.epam.tmpl.Main;
import static org.junit.Assert.*;


import org.junit.Test;

public class MainTest {

	@Test
	public void test() {
		
		Main m = new Main();
		assertEquals(1, m.i(1));
	}

}
