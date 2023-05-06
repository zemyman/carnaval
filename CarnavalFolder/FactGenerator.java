package CarnavalFolder;
import javax.swing.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class FactGenerator {
    protected List<String> facts;

    public FactGenerator() {
        facts = new ArrayList<String>();
        addFacts();
    }

    protected abstract void addFacts();

    public String getRandomFact() {
        Random random = new Random();
        int index = random.nextInt(facts.size());
        return facts.get(index);
    }
}

class ComputerSoftwareFactGenerator extends FactGenerator {
    @Override
    protected void addFacts() {
        facts.add("The first computer virus was created in 1983.");
        facts.add("JavaScript was developed in just 10 days.");
        facts.add("The first website went live in 1991.");
        facts.add("Java was originally called Oak.");
        facts.add("The first computer programmer was a woman named Ada Lovelace.");
    }
}

class ComputerHardwareFactGenerator extends FactGenerator {
    @Override
    protected void addFacts() {
        facts.add("The first hard disk drive was created in 1956.");
        facts.add("The first computer mouse was invented in 1964.");
        facts.add("The first computer printer was invented in 1953.");
        facts.add("The first computer modem was invented in 1962.");
        facts.add("The first computer processor was the Intel 4004, introduced in 1971.");
    }
}