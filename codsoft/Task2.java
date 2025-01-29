//STUDENT GRADE CALCULATOR


import java.util.Scanner;

class Task2
{
    public static void main(String args[]) 
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int n=s.nextInt();
        int[] marks=new int[n];
        for (int i=0;i<n;i++) 
        {
            System.out.print("Enter marks for subject "+(i+1)+":");
            marks[i]=s.nextInt();
        }
        int totalMarks=0;
        for (int i=0;i<n;i++)
        {
            totalMarks+=marks[i];
        }
        double percentage=(double)totalMarks/n;
        String grade;
        if (percentage>=90)
        {
            grade="A+";
        }
        else if (percentage>=80) 
        {
            grade="A";
        } 
        else if (percentage>=70)
        {
            grade="B";
        } 
        else if (percentage>=60)
        {
            grade="C";
        } 
        else if (percentage>=50) 
        {
            grade="D";
        } 
        else {
            grade="F";
        }
        System.out.println("Total Marks: "+totalMarks);
        System.out.println("Average Percentage: "+percentage+"%");
        System.out.println("Grade: "+grade);
    }
}
