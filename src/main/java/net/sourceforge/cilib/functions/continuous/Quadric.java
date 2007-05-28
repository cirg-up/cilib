/*
 * Quadric.java
 *
 * Created on January 12, 2003, 3:46 PM
 *
 * 
 * Copyright (C) 2003 - 2006 
 * Computational Intelligence Research Group (CIRG@UP)
 * Department of Computer Science 
 * University of Pretoria
 * South Africa
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA 
 *   
 */

package net.sourceforge.cilib.functions.continuous;

import net.sourceforge.cilib.functions.ContinuousFunction;
import net.sourceforge.cilib.type.types.Vector;

/**
 *
 * @author  Edwin Peer
 */
public class Quadric extends ContinuousFunction {
    private static final long serialVersionUID = -2555670302543357421L;

	public Quadric() {
        setDomain("R(-100, 100)^30");
    }
    
    public Object getMinimum() {
        return new Double(verticalShift);
    }
    
    public Object getMaximum() {
    	return new Double(1248.2);
    }
    
    public double evaluate(Vector x) {
        double sumsq = 0;
        for (int i = 0; i < getDimension(); ++i) {
            double sum = 0;
            for (int j = 0; j <= i; ++j) {
                sum += x.getReal(j);
            }
            sumsq += (sum+horizontalShift) * (sum+horizontalShift);
        }
        return sumsq + verticalShift;
    }
}