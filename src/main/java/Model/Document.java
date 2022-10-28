package Model;
import java.util.List;

public class Document {
    public Integer id;
    public String type;
    public String title;
    public String description;
    public String license;
    public List<String> subjects;
    public List<Resource> resources;
}
