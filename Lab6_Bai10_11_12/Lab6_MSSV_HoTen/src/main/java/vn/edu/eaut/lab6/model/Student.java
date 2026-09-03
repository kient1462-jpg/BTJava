package vn.edu.eaut.lab6.model;

public class Student {
    private String id;
    private String name;
    private String className;
    private double score;

    public Student() {}

    public Student(String id, String name, String className, double score) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.score = score;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }
}
