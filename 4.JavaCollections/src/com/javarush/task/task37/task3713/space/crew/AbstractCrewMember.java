package com.javarush.task.task37.task3713.space.crew;

public abstract class AbstractCrewMember {
    public enum CompetencyLevel {
        NOVICE,
        INTERMEDIATE,
        ADVANCED,
        EXPERT
    }

    protected CompetencyLevel competencyLevel;

    protected AbstractCrewMember nextCrewMember;

    public void setNextCrewMember(AbstractCrewMember nextCrewMember) {
        this.nextCrewMember = nextCrewMember;
    }

    public void handleRequest(CompetencyLevel competencyLevel, String request) {
        if (this.competencyLevel.compareTo(competencyLevel) >= 0) {
            doTheJob(request);
        } else if (nextCrewMember != null) {
            System.out.println("The request " + request + " can't be handled by the " + getClass().getSimpleName() + ". Passing it higher!");
            nextCrewMember.handleRequest(competencyLevel, request);
        } else {
            System.out.println("The request can't be handled due to the lack of competence.");
        }
    }

    protected abstract void doTheJob(String request);
}
