package ar.uba.fi.tdd.rulogic.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fact {
    private String name;
    private List<String> args;

    public Fact(String name, List<String> args) {
        this.name = name;
        this.args = args;
    }
    
    public Fact(String str) {
    	str = str.replace(")","");
        String[] fact = str.split("\\(");
        this.name = fact[0];
        this.args = new ArrayList<String>(Arrays.asList(fact[1].split(",")));
    }


    public Fact(Fact fact) {
        this.name = fact.name;
        this.args = new ArrayList<String>();
        this.args.addAll(fact.getArgs());
    }

    public String getName() {
        return this.name;
    }

    public List<String> getArgs() {
        return this.args;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fact fact = (Fact) o;
        return getName().equals(fact.getName()) && getArgs().equals(fact.getArgs());
    }
}
