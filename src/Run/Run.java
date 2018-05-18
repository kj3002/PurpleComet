package Run;

import FindClasses.JavaClassFinder;
import Programs.BaseProgram;
import General.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		JavaClassFinder classFinder = new JavaClassFinder();
		List<Class<? extends BaseProgram>> classes = classFinder.findAllMatchingTypes(BaseProgram.class);
		ArrayList<String> classNames = new ArrayList<>();
		for (int in = 0; in < classes.size(); in++) {
			Class<? extends BaseProgram> c = classes.get(in);
			if (!c.getSimpleName().equals("BaseProgram")) {
				classNames.add(c.getSimpleName());
				int lastIn = classNames.size() - 1;
				System.out.println(classNames.get(lastIn));
				classNames.set(lastIn, classNames.get(lastIn).toLowerCase());
			} else {
				classes.remove(c);
				in--;
			}
		}
		String programName = GetInfo.getSpecialString(Conversions.stringListToStringArray(classNames), "Which of the above programs would you like to run? ", scan);
		int index = classNames.indexOf(programName);
		Class<? extends BaseProgram> programClass = classes.get(index);
		try {
			programClass.newInstance().run(scan);
		} catch (IllegalAccessException e) {
			System.out.println("Access denied: " + e.getMessage());
		} catch (InstantiationException e) {
			System.out.println("Cannont instantiate: " + e.getMessage());
		}
	}
}
