package com.company;
import java.util.*;
import java.util.Scanner;

/*
    Class Prohject4Driver acts as a driver/tester class for the Disjoint set maze
    created for project 4. This class has the main method which will prompt the user
    to enter in the size of the maze they want (rows and cols) and will then do the
    necessary tasks to invoke the DisjSets class through our project4 class and
    print out the maze.

    Written by Anish Gajera for CS 3345.001 on Thursday, November 17, 2022
 */

public class Project4Driver
{
    public static void main(String [] args)
    {
        //variable which will hold row and col value
        int row, col;
        //scanner object
        Scanner scan = new Scanner(System.in);
        //prompt user to enter values for row/col
        System.out.print("Enter rows and columns for maze: ");
        //set the variables to the corresponding values
        row = scan.nextInt();
        col = scan.nextInt();
        //create new Maze object ("Project4" object in my case) using the row and col values inputted by user
        Project4 maze1 = new Project4(row, col);
        //call printmaze() function which prints the maze, written in class Project4
        maze1.printmaze();
    }


}
