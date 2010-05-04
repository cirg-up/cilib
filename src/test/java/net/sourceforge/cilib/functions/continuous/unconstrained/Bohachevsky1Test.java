/**
 * Computational Intelligence Library (CIlib)
 * Copyright (C) 2003 - 2010
 * Computational Intelligence Research Group (CIRG@UP)
 * Department of Computer Science
 * University of Pretoria
 * South Africa
 *
 * This library is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, see <http://www.gnu.org/licenses/>.
 */
package net.sourceforge.cilib.functions.continuous.unconstrained;

import static org.junit.Assert.assertEquals;
import net.sourceforge.cilib.functions.ContinuousFunction;
import net.sourceforge.cilib.type.types.Real;
import net.sourceforge.cilib.type.types.container.Vector;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Andries Engelbrecht
 */


public class Bohachevsky1Test {

    private ContinuousFunction function;

    public Bohachevsky1Test() {

    }

    @Before
    public void instantiate() {
        this.function = new Bohachevsky1();
    }

    /** Test of evaluate method, of class za.ac.up.cs.ailib.Functions.Bohachevsky1. */
    @Test
    public void testEvaluate() {
//        function.setDomain("R(-100,100)^2");
        Vector x = new Vector();
        x.add(Real.valueOf(1.0));
        x.add(Real.valueOf(2.0));

        assertEquals(9.6, function.apply(x), 0.0);

        x.setReal(0, 0.0);
        x.setReal(1, 0.0);
        assertEquals(0.0, function.apply(x), 0.0);
    }

    @Test
    public void minimum() {
        Assert.assertEquals(0.0, function.getMinimum().doubleValue(), 0.0001);
    }
}


