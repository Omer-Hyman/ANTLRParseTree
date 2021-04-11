package SHU;
import org.antlr.v4.runtime.ParserRuleContext;
import parseTree.*;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class Worker extends pdlBaseListener{

    Tree tree = new Tree();

    public void printNodeContents(ParserRuleContext ctx){
        tree.setLevel(1);
        for (int i = 0; i < ctx.getChildCount();i++)
        {
            tree.NewNode(ctx.getChild(i).getText());
        }
        tree.setLevel(-1);



    }

    public String FindNode(String name) {
        return tree.searchTree(name);
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        //System.out.println("Enter every rule " + ctx.getText());
        tree.setLevel(1);
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        //System.out.println("Exit every rule " + ctx.getText());
        tree.setLevel(-1);
    }

    @Override public void enterProgram(pdlParser.ProgramContext ctx) {
        System.out.println("Enter program");
        tree.CreateTree("Program", ctx.getText());
        printNodeContents(ctx);
        tree.getCtx(ctx.getText());

        TreeNode node = new TreeNode("program", ctx.getText());

    }

    @Override public void exitProgram(pdlParser.ProgramContext ctx) {
        System.out.println("Exit program");
        for (int i = 0; i < tree.getTree().getRowCount(); i++) {
            tree.getTree().expandRow(i);
        }
    }

    @Override public void enterProgramHeader(pdlParser.ProgramHeaderContext ctx) {
        System.out.println("Enter program header");
        tree.NewNode("program header");
        printNodeContents(ctx);

        TreeNode node = new TreeNode("program header", ctx.getText());
    }

    @Override public void exitProgramHeader(pdlParser.ProgramHeaderContext ctx) {
        System.out.println("Exit program header");
    }

    @Override public void enterBlock(pdlParser.BlockContext ctx) {
        System.out.println("Enter block");
        tree.NewNode("block");
        printNodeContents(ctx);
    }

    @Override public void exitBlock(pdlParser.BlockContext ctx) {
        System.out.println("Exit block");
    }

    @Override public void enterOutputStatement(pdlParser.OutputStatementContext ctx) {
        System.out.println("Enter output statement");
        tree.NewNode("output");
        printNodeContents(ctx);
    }

    @Override public void exitOutputStatement(pdlParser.OutputStatementContext ctx) {
        System.out.println("Exit output statement");
    }

    @Override public void enterGlobals(pdlParser.GlobalsContext ctx) {
        System.out.println("Enter globals");
        tree.NewNode("globals");
        printNodeContents(ctx);
    }

    @Override public void exitGlobals(pdlParser.GlobalsContext ctx) {
        System.out.println("Exit globals");
    }

    @Override public void enterProgramEnds(pdlParser.ProgramEndsContext ctx) {
        System.out.println("Enter program ends");
        tree.NewNode("program ends");
        printNodeContents(ctx);
    }

    @Override public void exitProgramEnds(pdlParser.ProgramEndsContext ctx) {
        System.out.println("Exit program ends");
    }


    @Override public void enterProcDefun(pdlParser.ProcDefunContext ctx) {
        System.out.println("Enter proc defun");
        tree.NewNode("proc defun");
        printNodeContents(ctx);
    }

    @Override public void exitProcDefun(pdlParser.ProcDefunContext ctx) {
        System.out.println("Exit proc defun");
    }

    @Override public void enterComparator(pdlParser.ComparatorContext ctx) {
        System.out.println("Enter comparator");
        tree.NewNode("comparator");
        printNodeContents(ctx);
    }

    @Override public void exitComparator(pdlParser.ComparatorContext ctx) {
        System.out.println("Exit comparator");
    }

    @Override public void enterMath(pdlParser.MathContext ctx) {
        System.out.println("Enter math: " + ctx.getText());
        tree.NewNode("math");
        printNodeContents(ctx);
    }

    @Override public void exitMath(pdlParser.MathContext ctx) {
        System.out.println("Exit math: " + ctx.getText());
    }

    @Override public void enterInputStatement(pdlParser.InputStatementContext ctx) {
        System.out.println("Enter input statement: ");
        tree.NewNode("Input");
        printNodeContents(ctx);
    }

    @Override public void exitInputStatement(pdlParser.InputStatementContext ctx) {
        System.out.println("Exit input statement: ");
    }

    @Override public void enterProcedureCall(pdlParser.ProcedureCallContext ctx) {
        System.out.println("Enter procedure call: " + ctx.getText());
        tree.NewNode("procedure call");
        printNodeContents(ctx);
    }

    @Override public void exitProcedureCall(pdlParser.ProcedureCallContext ctx) {
        System.out.println("Exit procedure call: " + ctx.getText());
    }

    @Override public void enterExpr(pdlParser.ExprContext ctx) {
        System.out.println("Enter expression: " + ctx.getText());
        tree.NewNode("expression");
        printNodeContents(ctx);
    }

    @Override public void exitExpr(pdlParser.ExprContext ctx) {
        System.out.println("Exit expression: " + ctx.getText());
    }

    @Override public void enterAssignment(pdlParser.AssignmentContext ctx) {
        System.out.println("Enter assignment: " + ctx.getText());
        tree.NewNode("assignment");
        printNodeContents(ctx);
    }

    @Override public void exitAssignment(pdlParser.AssignmentContext ctx) {
        System.out.println("Exit assignment: " + ctx.getText());
    }

    @Override public void enterWhileLoop(pdlParser.WhileLoopContext ctx) {
        System.out.println("Enter while loop: " + ctx.getText());
        tree.NewNode("while loop");
        printNodeContents(ctx);
    }

    @Override public void exitWhileLoop(pdlParser.WhileLoopContext ctx) {
        System.out.println("Exit while loop: " + ctx.getText());
    }

    @Override public void enterIfElse(pdlParser.IfElseContext ctx) {
        System.out.println("Enter if else: " + ctx.getText());
        tree.NewNode("if else");
        printNodeContents(ctx);
    }

    @Override public void exitIfElse(pdlParser.IfElseContext ctx) {
        System.out.println("Exit if else: " + ctx.getText());
    }

    @Override public void enterValue(pdlParser.ValueContext ctx) {
        System.out.println("Enter value: " + ctx.getText());
        tree.NewNode("value");
        printNodeContents(ctx);

    }

    @Override public void exitValue(pdlParser.ValueContext ctx) {
        System.out.println("Exit value: " + ctx.getText());
    }





}
