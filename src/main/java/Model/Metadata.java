package Model;
import java.util.List;

public class Metadata {
    public Integer id;
    public String type;
    public String title;
    public String description;
    public String license;
    public List<String> subjects;
    public List<Resource> resources;

    public Integer getId() {
        return id;
    }

    public Metadata setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public Metadata setType(String type) {
        this.type = type;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Metadata setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Metadata setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLicense() {
        return license;
    }

    public Metadata setLicense(String license) {
        this.license = license;
        return this;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public Metadata setSubjects(List<String> subjects) {
        this.subjects = subjects;
        return this;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public Metadata setResources(List<Resource> resources) {
        this.resources = resources;
        return this;
    }
}
