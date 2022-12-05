package com.company;
import java.util.*;
import java.util.Scanner;

/*
    Class Project4 - This class will act as the main source for
    the disjoint set maze for the overall project. The class contains
    necessary subclasses and methods which will be used in the program.

    Written by Anish Gajera for CS 3345.001 on Thursday, November 17, 2022
 */

public class Project4
{
    //subclass/inner class for box of maze
    class box
    {
        public boolean left;
        public boolean right;
        public boolean down;
        public boolean up;

        //default constructor
        public box()
        {
            //set right and down to true (will be useful later)
            right = true;
            down = true;
        }

        public void print()
        {
            //if right is true
            if(right == true)
            {
                System.out.print("|");
            }
            else
            {
                //else
                System.out.print(" ");
            }
            //if down is true
            if(down == true)
            {
                System.out.print("_");
            }
            else
            {
                //else
                System.out.print(" ");
            }
        }
    }

    //create box object
    private box[] one;
    //variables for column, length, and row (sizes)
    private int col;
    private int len;
    private int row;

    //constructor for a maze object (classified as "project4" in my code)
    public Project4(int row, int col)
    {
        //use this keyword to set each variable to its corresponding value
        this.row = row;
        this.col = col;
        this.len = row * col;

        //set the box to a new box with the calculated length
        this.one = new box[this.len];

        //for loop to set values in maze box to new box
        for(int i = 0; i < this.len; i++)
        {
            one[i] = new box();
        }

        //disjoint set class object
        DisjSets set = new DisjSets(len);

        //counter variable
        int counter = 0;
        //flag for maze
        boolean flag;
        //when counter is 1 and its less than length - 1
        for(counter = 1; counter <= len - 1;)
        {
            //while the flag is false, till its not false
            for(flag = false; !flag;)
            {
                //variables for determining where each part of rows and cols goes in maze, there are multiple if statements below
                //to account for the different rows and columns
                int j;
                //cast k to an int of Math.random() * length (len)
                int k = (int) (Math.random() * len);
                int p;
                //if k is 0
                if(k == 0)
                {
                    //cast j to be an int of a random number times 2
                    j = (int) (Math.random() * 2);
                    if(j == 0)
                    {
                        p = k + 1;
                    }
                    else
                    {
                        p = k + col;
                    }
                }
                //if k is col - 1
                else if(k == col - 1)
                {
                    //cast j to be an int of a random number times 2
                    j = (int) (Math.random() * 2);
                    if(j == 0)
                    {
                        p = k - 1;
                    }
                    else
                    {
                        p = k + col;
                    }
                }
                //if k is len - col
                else if(k == len - col)
                {
                    //cast j to be an int of a random number times 2
                    j = (int) (Math.random() * 2);
                    if(j == 0)
                    {
                        p = k - col;
                    }
                    else
                    {
                        p = k + 1;
                    }
                }
                //if k == len - 1
                else if(k == len - 1)
                {
                    //cast j to be an int of a random number times 2
                    j = (int) (Math.random() * 2);
                    if(j == 0)
                    {
                        p = k - 1;
                    }
                    else
                    {
                        p = k - col;
                    }
                }
                //if k > 0 && k < col - 1
                else if(k > 0 && k < col - 1)
                {
                    //cast j to be an int of a random number times 2
                    j = (int) (Math.random() * 2);
                    if(j == 0)
                    {
                        p = k - 1;
                    }
                    else if(j == 1)
                    {
                        p = k + 1;
                    }
                    else
                    {
                        p = k + col;
                    }
                }
                //if k % col == 0
                else if(k % col == 0)
                {
                    //cast j to be an int of a random number times 2
                    j = (int) (Math.random() * 2);
                    if(j == 0)
                    {
                        p = k - col;
                    }
                    else if(j == 1)
                    {
                        p = k + 1;
                    }
                    else
                    {
                        p = k + col;
                    }
                }
                else if(k > (len - col) && k < (len - 1))
                {
                    //cast j to be an int of a random number times 2
                    j = (int) (Math.random() * 2);
                    if(j == 0)
                    {
                        p = k - col;
                    }
                    else if(j == 1)
                    {
                        p = k - 1;
                    }
                    else
                    {
                        p = k + 1;
                    }
                }
                else if(k % col == col - 1)
                {
                    //cast j to be an int of a random number times 2
                    j = (int) (Math.random() * 2);
                    if(j == 0)
                    {
                        p = k - col;
                    }
                    else if(j == 1)
                    {
                        p = k - 1;
                    }
                    else
                    {
                        p = k + col;
                    }
                }
                //last/base case
                else
                {
                    //cast j to be an int of a random number times 2
                    j = (int) (Math.random() * 2);
                    if(j == 0)
                    {
                        p = k - col;
                    }
                    else if(j == 1)
                    {
                        p = k - 1;
                    }
                    else if(j == 2)
                    {
                        p = k + 1;
                    }
                    else
                    {
                        p = k + col;
                    }
                }
                //find k in disjoint set
                int set2 = set.find(k);
                //find p in disjoint set
                int set3 = set.find(p);

                //if k and p are not equal
                if(set2 != set3)
                {
                    //union the disjoint sets
                    set.union(set2, set3);
                    //test the different values of p and for each case which is true, set the corresponding cell value to false
                    if(p == k - 1)
                    {
                    this.one[p].right  = false;
                    }
                    else if(p == k - col)
                    {
                        this.one[p].down  = false;
                    }
                    else if(p == k + 1)
                    {
                        this.one[k].right = false;
                    }
                    else if(p == k + col)
                    {
                        this.one[k].down = false;
                    }
                }
                //set flag to true
                flag = true;
                //increment counter
                counter++;
            }
        }
    }

    /*
        else if(k == len - col)
                {
                    //cast j to be an int of a random number times 2
                    j = (int) (Math.random() * 2);
                    if(j == 0)
                    {
                        p = k - col;
                    }
                    else
                    {
                        p = k + 1;
                    }
                }
     */

    //method to print out maze
    public void printmaze()
    {
        System.out.print("\t");
        for(int i = 2; i < this.col; i++)
        {
            System.out.print(" _");
        }
        System.out.print("\n");

        //for loop for printing maze properly (proper spacing and walls)
        for(int i = 0; i < this.len; i++)
        {
            if (i % this.col == 0)
            {
                if (i == 0)
                {
                    System.out.print(" ");
                }
                else
                {
                    System.out.print(" |");
                }
            }
            //invoke print method in DisjSet class to print
            this.one[i].print();
            //print new line if the columns are less than by 1
            if(i % this.col == this.col - 1)
            {
                System.out.print("\n");
            }
        }
    }
}
