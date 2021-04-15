package SHU;

import java.io.FileInputStream;
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
        InputStream inputStream = System.in;
        Worker worker = new Worker();
        Scanner scanner;

        if (inputFile != null)
        {
            System.out.println("// source file is "+ inputFile);
            inputStream = new FileInputStream(inputFile);

            ANTLRInputStream input = new ANTLRInputStream(inputStream);
            pdlLexer lexer = new pdlLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            pdlParser parser = new pdlParser(tokens);

            ParseTree tree = parser.program();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(worker, tree);

            System.out.println();
        }else
        {
            System.out.println("Usage: java pdl.pdl <source>");
        }



        //TODO: The parse tree can be a (valid) subset of an entire program.
        //      BUILDS SUBTREE BUT STILL STARTING FROM PROGRAM

        //TODO: The output may be a useful intermediate representation such as
        //  S-expressions, JSON documents, or XML structures

        //TODO: Search criteria can be entered and chained.
        //TODO: Searches return results where those results are available.
        //TODO: Results are presented clearly and usefully.
        //TODO: No matching data is still treated as a valid result.

        //TODO: Subtrees are found and displayed.
        //TODO: Code for searching and displaying trees is re-used sensibly.


        String input;
        int userInput, userInput2;

//        worker.node.DisplayStack();
        do {
            System.out.println("\nWelcome!\nWhat would you like to do?\n" +
                                    "1) View the stack\n" +
                                    "2) Search the parse tree\n" +
                                    "3) Build a new subtree\n" +
                                    "4) Nothing");
            scanner = new Scanner(System.in);
            userInput = scanner.nextInt();
            switch (userInput)
            {
                case 1:
                    System.out.println("\nVIEWING STACK...\n");
                    worker.node.DisplayStack();
                    break;
                case 2:
                    /*System.out.println("Would you like to;\n " +
                            "(1)search a node\n " +
                            "(2)a node's contents\n " +
                            "(3)or both?\n " +
                            "ANSWER WITH 1,2 OR 3!");
                    scanner = new Scanner(System.in);
                    userInput2 = scanner.nextInt();
*/
                    System.out.println("Input a node you would like to search for!");
                    scanner = new Scanner(System.in);
                    input = scanner.nextLine();

                    System.out.println("\nSEARCHING TREE...\n");
                    worker.FindNode(input, 1);
                    break;
                case 3:
                    System.out.println("Input a root node for the subtree");
                    input = scanner.nextLine();

                    System.out.println("\nCREATING SUBTREE...\n");
                    worker.tree.SubTree(input);
                    break;
                case 4:
                    break;
            }
        }while(userInput != 4);

    }

}
