package com.exampleIntregration.demoInt.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Apis {
    @Id
    private Integer count;
    private String entries[][];

    public Apis() {
    }

    public Apis(Integer count, String[][] entries) {
        this.count = count;
        this.entries = entries;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String[][] getEntries() {
        return entries;
    }

    public void setEntries(String[][] entries) {
        this.entries = entries;
    }
}
