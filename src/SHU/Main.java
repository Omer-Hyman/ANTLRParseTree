package SHU;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
//import org.antlr.runtime.ANTLRInputStream;
import  org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import parseTree.*;

public class Main {

    public static void main(String[] args) throws Exception {

        //LISTENER

        String inputFile = "sample program.pdl";
        InputStream inputStream = new FileInputStream(inputFile);

        Scanner scanner;

        String userInput;
        int userInputInt, userInput2Int;
        TreeNode node = new TreeNode();

        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        pdlLexer lexer = new pdlLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        pdlParser parser = new pdlParser(tokens);
        pdlBaseListener worker;
        ParseTreeWalker walker = new ParseTreeWalker();
        ParseTree tree = parser.program();


        do {
            System.out.println("\nWelcome!\nWhat would you like to do?\n" +
                    "1) Display the tree\n" +
                    "2) Search the tree\n" +
                    "3) Print the stack\n" +
                    "4) Compile the tree\n" +
                    "5) Build a new subtree\n" +
                    "6) Nothing");
            scanner = new Scanner(System.in);
            userInputInt = scanner.nextInt();
        /*    if (inputFile != null) {

            }
            else {
                System.err.println("input file path was incorrect");
            }*/


            //worker = new Worker();
            //walker.walk(worker, tree);
            //in all cases

            switch (userInputInt) {
                case 1:
                    System.out.println("\nDISPLAYING THE TREE...\n");
                    worker = new Worker();
                    walker.walk(worker, tree);
                    Tree trees = new Tree();
                    trees.DisplayTree();
                    break;
                case 2:
                    System.out.println("\nSEARCHING THE TREE...\n");
                    /*System.out.println("Would you like to;\n " +
                            "(1)search a node\n " +
                            "(2)a node's contents\n " +
                            "(3)or both?\n " +
                            "ANSWER WITH 1,2 OR 3!");
                    scanner = new Scanner(System.in);
                    userInput2 = scanner.nextInt();*/
                    System.out.println("Input a node you would like to search for!");
                    scanner = new Scanner(System.in);
                    userInput = scanner.nextLine();
                    worker = new Worker();
                    ((Worker) worker).SearchTree(userInput, 1);
                    break;
                case 3:
                    System.out.println("\nPRINTING THE STACK...\n");
                    worker = new Worker();
                    walker.walk(worker, tree);
                    ((Worker) worker).DisplayStack();
                    break;
                case 4:
                    System.out.println("\nCOMPILING...\n");
                    worker = new Compiler();
                    walker.walk(worker, tree);
                    FileWriter writer = new FileWriter("output.js");
                    writer.write("");
                    writer.write(worker.toString());
                    writer.close();
                    break;
                case 5:
                    System.out.println("\nBUILDING SUBTREE...\n");
                    System.out.println("Input a root node for the subtree");
                    userInput = scanner.nextLine();
                    /*worker = new Worker();

                    System.out.println("\nCREATING SUBTREE...\n");
                    ((Worker) worker).tree.SubTree(userInput);*/
                    break;
                case 6:
                    System.out.println("\nNOTHING...\n");
                    break;
            }

            //TODO: RETHINK SEARCH FUNCTION, SHOULD OPTION BE A PARAMETER?


            //TODO: Search criteria can be entered and chained.
            //TODO: Results are highlighted in tree.
            //TODO: OPEN WINDOWS EXPLORER FOR FILE SELECTION AT START
            //TODO: Subtrees are found and displayed.
            //TODO: Code for searching and displaying trees is re-used sensibly.
            // TODO: The parse tree can be a (valid) subset of an entire program.
            //      BUILDS SUBTREE BUT STILL STARTING FROM PROGRAM


            //=== is value and type in JS

            //search, display, compile

        }while (userInputInt != 6);

    }


}
