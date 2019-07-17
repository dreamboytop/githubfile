package text;
import java.io.Serializable;

public class Student implements Serializable {
   private String name;

private String id;
   private String birthday;
   private String description;
   private int avgscore;

 public Student(String id,String name, int avgscore) {
	    this.name = name;
		this.id = id;
		this.avgscore = avgscore;
}
public Student(String name, String id, String birthday, String description, int avgscore) {
	this.name = name;
	this.id = id;
	this.birthday = birthday;
	this.description = description;
	this.avgscore = avgscore;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBirthday() {
	return birthday;
}
public void setBirthday(String birthday) {
	this.birthday = birthday;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getAvgscore() {
	return avgscore;
}
public void setAvgscore(int avgscore) {
	this.avgscore = avgscore;
}
@Override
public String toString() {
    return "Student{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", birthday='" + birthday + '\'' +
            ", description='" + description + '\'' +
            ", avgscore='" + avgscore + '\'' +
            '}';
}

   
}
