package com.company.inheritance;

public class App {

    public static void main(String[] args) {
        Developer dev = new Developer();
        TeamLead lead = new TeamLead();
        Architect arch = new Architect();

        // Type in:
        // dev.
        // lead.
        // arch.
        //
        // and use Intellisense to show how these classes inherit methods from the base classes

        dev.estimateStoryPoints();
        lead.estimateStoryPoints();

        Developer dev2 = new TeamLead();
        Developer dev3 = new Architect();

        // Type in:
        // dev2.
        // dev3.
        //
        // and use Intellisense to show what methods are available on these objects
    }
}
