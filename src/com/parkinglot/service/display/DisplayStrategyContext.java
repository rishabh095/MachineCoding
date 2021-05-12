package com.parkinglot.service.display;

import com.parkinglot.model.display.DisplayTypeEnum;

public class DisplayStrategyContext {

    public DisplayStrategy getDisplayStrategy(DisplayTypeEnum displayType) {
        switch (displayType) {
            case FREE_SLOT:
                return new FreeSlotDisplay();
            case FREE_COUNT:
                return new FreeCountDisplay();
            case OCCUPIED_SLOT:
                return new OccupiedSlotDisplay();
            default:
                return null;
        }
    }
}
