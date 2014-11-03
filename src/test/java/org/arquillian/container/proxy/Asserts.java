package org.arquillian.container.proxy;

import java.io.IOException;
import java.net.URL;

import org.arquillian.extension.xrebel.IOUtil;
import org.junit.Assert;

public final class Asserts {

	private Asserts() {}
	
	public static void assertResponseEquals(String expected, URL target) {
		try {
			Assert.assertEquals(expected, IOUtil.asUTF8String(target.openStream()));
		} catch (IOException e) {
			throw new RuntimeException("Failed to assertEquals [" + expected + "]", e);
		}
	}
}
