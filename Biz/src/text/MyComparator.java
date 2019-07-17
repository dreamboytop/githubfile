package text;

import java.util.Comparator;

public class MyComparator implements Comparator<Student>  {
	int flag; 
	@Override 
	public int compare(Student o1, Student o2) 
	{ 
		switch(flag)
	{ 
		case 1:{ 
			if(o1.getAvgscore()>o2.getAvgscore())
				return 1; 
			else if(o1.getAvgscore()<o2.getAvgscore()) 
				return -1; 
			else return 0; 
		} 
		default:{
			if(o1.getAvgscore()<o2.getAvgscore())
				return 1; 
			else if(o1.getAvgscore()>o2.getAvgscore()) 
				return -1; 
			else return 0; 
		}
		
	}
    }
	MyComparator(int flag){
		this.flag=flag;
	}
}
