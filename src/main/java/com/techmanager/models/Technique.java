package com.techmanager.models;

public class Technique {
    private int id;
    private int hours;
    private String number;

    public Technique(){

    }

    public Technique(int id, int hours, String number){
        setId(id);
        setHours(hours);
        setNumber(number);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String toString(){
        return String.format("ID : %d | Номер: %s | Часы: %d", id, number, hours);
    }

    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Technique technique = (Technique) obj;
        return id == technique.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
