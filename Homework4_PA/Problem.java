package org.example;

import java.util.*;

public class Problem {

    private static Map<Student, List<Project>> prefMap = new HashMap<>();
    private Map<Student, Project> solvedMap = new HashMap<>();

   List<Project> list = new ArrayList<>();

    public Map<Student, List<Project>> getPrefMap() {
        return prefMap;
    }


    public static double averageValue(){
        double nrOfProjects = 0;
        for(Map.Entry<Student, List<Project>> entry : prefMap.entrySet()){
            nrOfProjects = nrOfProjects + entry.getValue().size();
        }
        return nrOfProjects / prefMap.size();
    }
    public static boolean computeUnderAverageStudent(Map.Entry<Student, List<Project>> line){
        return line.getValue().size() < averageValue();
    }

    public int computeMaximProject(){
        int a = 0;
        for (Map.Entry<Student, List<Project>> entry : prefMap.entrySet()) {
            if (entry.getValue().size() > a){
                a = entry.getValue().size();
            }
        }
        return a;
    }

    public boolean verif(List<Project> list, Project p){ //a simple function, not the best, which verify if an object is already in a list
        for (Project project : list) {
            if (project == p) {
                return false;
            }
        }
        return true;
    }

    public void completeList(){ //creating a list with all projects, when a project is taken it disappear from this list.

        for (Map.Entry<Student, List<Project>> entry : prefMap.entrySet()) {
            for (Project p : entry.getValue()){
                if (verif(list, p)){
                    list.add(p);
                }
            }
        }
    }

    public Project verifII(List <Project> list1, List <Project> list2){ //with this function I verify if a project was taken of not.
        for (Project project1 : list1){
            for(Project project2: list2){
                if (project2 == project1){
                    list2.remove(project2);
                    return project1;
                }
            }
        }
        return null;
    }
    public Map<Student, Project> solveWithGreedy(){
        completeList();
        int a = 1;
        while(a <= computeMaximProject()){
            for (Map.Entry<Student, List<Project>> entry : prefMap.entrySet()) {
                if(entry.getValue().size() == a){
                    solvedMap.put(entry.getKey(), verifII(entry.getValue(), list));
                }
            }
            a++;
        }
        System.out.println(solvedMap);
        return solvedMap;
    }
}
