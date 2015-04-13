package model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class StudentProfile implements Iterable<Module>, Serializable{

	private String pNumber;
	private Name studentName;
	private Course course;
	private Set<Module> selectedModules;
	private Set<Module> reservedModules;
	
	public StudentProfile() {
		pNumber = "";
		studentName = new Name();
		course = null;
		selectedModules = new TreeSet<Module>();
		reservedModules = new TreeSet<Module>();
	}
	
	public String getpNumber() {
		return pNumber;
	}
	
	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}
	
	public Name getStudentName() {
		return studentName;
	}
	
	public void setStudentName(Name studentName) {
		this.studentName = studentName;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public boolean addSelectedModule(Module m) {
		return selectedModules.add(m);
	}
	
	
	public Set<Module> getSelectedModules() {
		return selectedModules;
	}
	
	public void clearSelectedModules() {
		selectedModules.clear();
	}
	
	public boolean addReservedModule(Module m){
		return reservedModules.add(m);
	}
	
	public Set<Module> getReservedModules(){
		return reservedModules;
	}
	
	public void clearReservedModules(){
		reservedModules.clear();
	}
	
	@Override
	public String toString() {
		return "StudentProfile:[pNumber=" + pNumber + ", studentName="
				+ studentName + ", course=" + course.actualToString() 
				+ ", selectedModules=" + selectedModules + "]";
	}

	@Override
	public Iterator<Module> iterator() {
		return selectedModules.iterator();
	}

	
	
}
