package edu.neu.ccs.cs5010;
import java.util.Random;

/**
 * RandomHomework selects a random course to display to user.
 *
 * @author Zhenyan Lin
 */
public class RandomHomework {
    /**
     * Uses a RandomHomework object to print a random course to the console.
     */
    public static void main(String[] args){
        RandomHomework randomH = new RandomHomework();
        System.out.println(randomH.getCourse());
    }

    /**
     * Randomly return a course from a list of four courses
     * @return a random course name from a list of four possible courses
     */
    public String getCourse(){
        String[] course = new String[4];
        course[0] = "PDP";
        course[1] = "Algorithms";
        course[2] = "Mobile Application";
        course[3] = "Web Application";
        Random random = new Random();
        int n = random.nextInt(4);
        return course[n];
    }
}
