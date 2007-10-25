/*******************************************************************************
 * Copyright (c) 1998, 2007 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Contributors:
 *     Oracle - initial API and implementation from Oracle TopLink
 ******************************************************************************/  
package org.eclipse.persistence.testing.oxm.inheritance;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List vehicles;

    public ParkingLot() {
        vehicles = new ArrayList();
    }

    public void setVehicles(List vehicles) {
        this.vehicles = vehicles;
    }

    public List getVehicles() {
        return vehicles;
    }

    public boolean equals(Object theObject) {
        if (theObject instanceof ParkingLot) {
            int size = getVehicles().size();
            if (size == ((ParkingLot)theObject).getVehicles().size()) {
                for (int i = 0; i < size; i++) {
                    Object nextVehicle = getVehicles().get(i);
                    Object nextOtherVehicle = ((ParkingLot)theObject).getVehicles().get(i);
                    if (nextVehicle.getClass() != nextOtherVehicle.getClass()) {
                        return false;
                    }

                    if (!(nextVehicle.equals(nextOtherVehicle))) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        String returnString = "ParkingLot has " + vehicles.size() + " vehicles:";
        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle nextVehicle = (Vehicle)vehicles.get(i);
            returnString += (" " + nextVehicle.toString());
        }
        return returnString;
    }
}