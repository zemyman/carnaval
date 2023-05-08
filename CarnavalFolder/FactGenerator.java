package CarnavalFolder;
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
// The FactGenerator abstract class defines a common behavior for generating
// random facts.
// It contains a list of facts and a method for getting a random fact from the
// list.
// The addFacts method is abstract and must be implemented by its subclasses.
// The FactGenerator class is extended by two concrete classes:
// ComputerSoftwareFactGenerator and ComputerHardwareFactGenerator.
// These two classes implement the addFacts method and provide their own list of
// facts related to software and hardware, respectively.
// This is an example of inheritance in which the two concrete classes inherit
// the common behavior defined by FactGenerator.

// This code uses polymorphism by defining an abstract class FactGenerator with
// a method
// addFacts() that is implemented differently in its subclasses
// ComputerSoftwareFactGenerator and ComputerHardwareFactGenerator. The
// getRandomFact() method is then called on an instance of one of these
// subclasses,
// allowing it to randomly select and return a fact from its respective list of
// facts.