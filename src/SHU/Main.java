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
        System.out.println("Would you like to search for a node? Answer Y/N.");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();

        while(userInput.equals("y")) {
            switch (userInput) {
                case "y" -> {
                    System.out.println("Input a node you would like to search for!");
                    scanner = new Scanner(System.in);
                    String userInput2 = scanner.nextLine();
                    String nodeFind = worker.FindNode(userInput2);
                    if (nodeFind != null)
                        System.out.println( nodeFind);
                    else
                        System.err.println("NODE NOT FOUND!");
                }
                case "n" -> System.out.println("OK, I won't search the tree!");
                default -> System.out.println("Tree not searched");
            }
            System.out.println("Would you like to search for a node? Answer Y/N.");
            scanner = new Scanner(System.in);
            userInput = scanner.next();
        }

    }



}

//VISITOR
       /* try{
            System.out.println("Enter your greeting");
            input = new ANTLRInputStream(System.in);

            omerLanguageLexer lexer = new omerLanguageLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            omerLanguageParser parser = new omerLanguageParser(tokens);
            ParseTree tree = parser.variable();

            //System.out.println(tree.toStringTree(parser));

            Worker worker = new Worker();
            Integer result = worker.visit(tree);
            //System.out.println("The result was " + result);


        }catch (IOException e)
        {
            e.printStackTrace();
        }*/