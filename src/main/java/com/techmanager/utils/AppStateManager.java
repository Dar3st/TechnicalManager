package com.techmanager.utils;

import com.techmanager.models.TechniqueList;

public class AppStateManager {
    private static AppStateManager instance;
    private final TechniqueList techniqueList;

    private AppStateManager() {
        techniqueList = new TechniqueList();
    }

    public static AppStateManager getInstance() {
        if (instance == null) {
            instance = new AppStateManager();
        }
        return instance;
    }

    public TechniqueList getTechniqueList() {
        return techniqueList;
    }
}