package ma.znagui.Model;

import ma.znagui.Enum.ComponentType;

public abstract class Component {
    private int id;
    private String name;
    private int tva;
    private ComponentType type;
    private Project project;


    public Component() {

    }

    public Component(int id, String name, int tva, ComponentType type, Project project) {
        this.id = id;
        this.name = name;
        this.tva = tva;
        this.type = type;
        this.project = project;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public int getTva() {
        return tva;
    }
    public void setTva(int tva) {
        this.tva = tva;
    }


    public ComponentType getType() {
        return type;
    }
    public void setType(ComponentType type) {
        this.type = type;
    }

    public Project getProject() {
        return project;
    }
    public void setProject(Project project) {
        this.project = project;
    }

    public String toString() {
        return "Composant N° : " + id + " Projet --> " + project.getProjectName() + " || Nom:  " + name + ", TVA :  " + tva + ", type : " + type;
    }
}
