package net.sourceforge.cilib.functions.continuous;

import net.sourceforge.cilib.type.types.MixedVector;
import net.sourceforge.cilib.type.types.Real;
import net.sourceforge.cilib.type.types.Vector;

import org.junit.Before;
import org.junit.Test;
import org.nfunk.jep.JEP;

import static org.junit.Assert.*;

public class ExpressionFunctionTest {
	
	private JEP jep;
	
	@Before
	public void setup() {
		jep = new JEP();
	}
	
	@Test
	public void compareWithSpherical() {
		jep.addVariable("x", 20);
		jep.parseExpression("x^2");
		
		assertEquals(400.0, jep.getValue());
	}
	
	@Test
	public void compareWithRastrigin() {
		jep.addVariable("x", 5);
		jep.addStandardConstants();
		jep.addStandardFunctions();
		
		jep.parseExpression("10 + x^2 - 10*cos(2*pi*x)");
		
		Rastrigin rastrigin = new Rastrigin();
		rastrigin.setDomain("R(-5.12,5.12)^1");
		Vector vector = new MixedVector();
		vector.add(new Real(5.0));
		
		assertEquals(rastrigin.evaluate(vector), jep.getValue());
	}

}