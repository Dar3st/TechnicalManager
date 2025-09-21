package com.techmanager.models;

import java.util.ArrayList;
import java.util.List;

public class TechniqueList {
    private List<Technique> techniques = new ArrayList<>();

    // Метод добавление техники
    public void addTechnique(Technique technique){
        techniques.add(technique);
    }


    public boolean isIdExists(int id){
        return techniques.stream().anyMatch(t -> t.getId() == id);
    }

    // Получаем весь список техники в списке techniques
    public List<Technique> getAll(){
        return new ArrayList<>(techniques);
    }
    // Проверяем пустой ли список
    public boolean isEmpty(){
        return techniques.isEmpty();
    }
    // Метод для получения кол-во техники
    public int size(){
        return techniques.size();
    }
    public void removeTechnique(int id) {
        techniques.removeIf(t -> t.getId() == id);
    }

    // Создаём метод возращающий поиск по списку из ID
    public Technique findById(int id){
        return techniques.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
