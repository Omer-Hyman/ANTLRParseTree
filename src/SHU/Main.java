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



        String input;

        do {
            System.out.println("Would you like to view the stack? Answer Y/N.");
            scanner = new Scanner(System.in);
            input = scanner.next();
            if (input.matches("n|N"))
                break;
            worker.node.DisplayStack();
        }while(input.matches("y|Y"));

        do {
            System.out.println("Would you like to build a new subtree? Answer Y/N.");
            scanner = new Scanner(System.in);
            input = scanner.next();
            if (input.matches("n|N"))
                break;
            System.out.println("input root node for subtree");
            input = scanner.nextLine();
            worker.tree.SubTree(input);
        }while(input.matches("y|Y"));


        String userInput = "y";

        /*do {
            System.out.println("Would you like to search the tree? Answer Y/N.");
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.next();

            switch (userInput) {
                case "y" -> {
                    System.out.println("Would you like to;\n (1)search a node\n (2)a node's contents\n (3)or both?\n ANSWER WITH 1,2 OR 3!");
                    scanner = new Scanner(System.in);
                    int userInput2 = scanner.nextInt();

                    System.out.println("Input a node you would like to search for!");
                    scanner = new Scanner(System.in);
                    String userInput3 = scanner.nextLine();

                    worker.FindNode(userInput3, userInput2);

                }
                case "n" -> System.out.println("OK, I won't search the tree!");
                default -> System.out.println("Tree not searched");
            }
        }while(userInput.equals("y"));*/

    }

}
