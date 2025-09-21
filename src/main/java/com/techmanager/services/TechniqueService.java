package com.techmanager.services;

import com.techmanager.models.Technique;
import com.techmanager.models.TechniqueList;

public class TechniqueService {
    private TechniqueList techniqueList = new TechniqueList();

    public void addTechnique(Technique technique) throws IllegalArgumentException{
        if(techniqueList.isIdExists(technique.getId())){
            throw new IllegalArgumentException("Техника с ID " + technique.getId() + " уже существует!");
        }

        if (technique.getId() <= 0){
            throw new IllegalArgumentException("ID олжен быть положительным числом");
        }

        if(technique.getHours() < 0 || technique.getHours() > 24){
            throw new IllegalArgumentException("Часы должны быть между 0 и 24");
        }

        if(technique.getNumber() == null || technique.getNumber().trim().isEmpty()){
            throw new IllegalArgumentException("Номер не может быть пустым");
        }

        techniqueList.addTechnique(technique);
    }

    public TechniqueList getTechniqueList() {
        return techniqueList;
    }

    public boolean removeTechnique(int id){
        Technique technique = techniqueList.findById(id);
        if(technique != null){
            techniqueList.removeTechnique(id);
            return true;
        }
        return false;
    }
}
