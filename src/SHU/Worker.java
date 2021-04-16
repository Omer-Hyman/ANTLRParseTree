package SHU;
import org.antlr.v4.runtime.ParserRuleContext;
import parseTree.*;

import java.util.Stack;
import java.util.regex.Pattern;

public class Worker extends pdlBaseListener{

    int level = -2;

    public int getLevel() {
        return level;
    }

    private static Stack<TreeNode> stack = new Stack<>();

    public Stack<TreeNode> getStack() {
        return stack;
    }

    public void DisplayStack()
    {
        for (int i = 0; i < stack.size();i++)
        {
            System.out.println("\nNode: " + stack.get(i).getNodeName()+ "\nNode Contents: " + stack.get(i).getNodeContents());
        }
        System.out.println("\nStack size: " + stack.size());
    }

    public void SearchTree(String nodeName, int option)
    {
//        Pattern regex = Pattern.compile(nodeName, Pattern.CASE_INSENSITIVE);//search for
//        Matcher matcher = regex.matcher(node.getStack().toString());//in this text
//        //Pattern.matches(nodeName, node.getStack().toString());
//
//        boolean matchFound = matcher.find();

        for (int i = 0; i < stack.size(); i++)//works for node names
        {
            if(Pattern.matches(nodeName, stack.get(i).getNodeName())) {
                System.out.println("Match found at index " + i);
            } else if(i == stack.size() - 1) {
                System.out.println("Match not found");
            }
        }
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        level++;
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        level--;
    }

    @Override public void enterProgram(pdlParser.ProgramContext ctx) {
//        System.out.println("Enter program ");
        //tree.setCtx(ctx.getText());
        new TreeNode("program", ctx.getText(), level);
    }

    @Override public void exitProgram(pdlParser.ProgramContext ctx) {
//        System.out.println("Exit program");
    }

    @Override public void enterProgramHeader(pdlParser.ProgramHeaderContext ctx) {
//        System.out.println("Enter program header ");
        new TreeNode("program header", ctx.getText(), level);
    }

    @Override public void enterBlock(pdlParser.BlockContext ctx) {
//        System.out.println("Enter block ");
        new TreeNode("block", ctx.getText(), level);
    }

    @Override public void enterOutputStatement(pdlParser.OutputStatementContext ctx) {
//        System.out.println("Enter output statement ");
        new TreeNode("output", ctx.getText(), level);
    }

    @Override public void enterGlobals(pdlParser.GlobalsContext ctx) {
//        System.out.println("Enter globals");
        new TreeNode("globals", ctx.getText(), level);
    }

    @Override public void enterProgramEnds(pdlParser.ProgramEndsContext ctx) {
//        System.out.println("Enter program ends");
        new TreeNode("program ends", ctx.getText(), level);
    }

    @Override public void enterProcDefun(pdlParser.ProcDefunContext ctx) {
//        System.out.println("Enter proc defun");
        new TreeNode("proc defun", ctx.getText(), level);
    }

    @Override public void exitProgramHeader(pdlParser.ProgramHeaderContext ctx) {
//        System.out.println("Exit program header");
    }

    @Override public void enterComparator(pdlParser.ComparatorContext ctx) {
//        System.out.println("Enter comparator");
        new TreeNode("comparator", ctx.getText(), level);
    }

    @Override public void enterMath(pdlParser.MathContext ctx) {
//        System.out.println("Enter math: ");
        new TreeNode("math", ctx.getText(), level);
    }

    @Override public void enterInputStatement(pdlParser.InputStatementContext ctx) {
//        System.out.println("Enter input statement: ");
        new TreeNode("input", ctx.getText(), level);
    }

    @Override public void enterProcedureCall(pdlParser.ProcedureCallContext ctx) {
//        System.out.println("Enter procedure call: ");
        new TreeNode("procedure call", ctx.getText(), level);
    }

    @Override public void enterExpr(pdlParser.ExprContext ctx) {
//        System.out.println("Enter expression: ");
        new TreeNode("expression", ctx.getText(), level);
    }

    @Override public void enterAssignment(pdlParser.AssignmentContext ctx) {
//        System.out.println("Enter assignment: ");
        new TreeNode("assignment", ctx.getText(), level);
    }

    @Override public void enterWhileLoop(pdlParser.WhileLoopContext ctx) {
//        System.out.println("Enter while loop: ");
        new TreeNode("while loop", ctx.getText(), level);
    }

    @Override public void enterIfElse(pdlParser.IfElseContext ctx) {
//        System.out.println("Enter if else: ");
        new TreeNode("if else", ctx.getText(), level);
    }

    @Override public void enterValue(pdlParser.ValueContext ctx) {
//        System.out.println("Enter value: ");
        new TreeNode("value", ctx.getText(), level);
    }

//    @Override public void exitBlock(pdlParser.BlockContext ctx) {
//        System.out.println("Exit block");
//    }

    @Override public void exitOutputStatement(pdlParser.OutputStatementContext ctx) {
//        System.out.println("Exit output statement");
    }

//    @Override public void exitGlobals(pdlParser.GlobalsContext ctx) {
//        System.out.println("Exit globals");
//    }

//    @Override public void exitProgramEnds(pdlParser.ProgramEndsContext ctx) {
//        System.out.println("Exit program ends");
//    }

//    @Override public void exitProcDefun(pdlParser.ProcDefunContext ctx) {
//        System.out.println("Exit proc defun");
//    }

//    @Override public void exitComparator(pdlParser.ComparatorContext ctx) {
//        System.out.println("Exit comparator");
//    }

//    @Override public void exitMath(pdlParser.MathContext ctx) {
//        System.out.println("Exit math: ");
//    }

    @Override public void exitInputStatement(pdlParser.InputStatementContext ctx) {
//        System.out.println("Exit input statement: ");
    }

    @Override public void exitProcedureCall(pdlParser.ProcedureCallContext ctx) {
//        System.out.println("Exit procedure call: ");
    }

//    @Override public void exitExpr(pdlParser.ExprContext ctx) {
//        System.out.println("Exit expression: ");
//    }

//    @Override public void exitAssignment(pdlParser.AssignmentContext ctx) {
//        System.out.println("Exit assignment: ");
//    }

//    @Override public void exitWhileLoop(pdlParser.WhileLoopContext ctx) {
//        System.out.println("Exit while loop: ");
//    }

//    @Override public void exitIfElse(pdlParser.IfElseContext ctx) {
//        System.out.println("Exit if else: ");
//    }

//    @Override public void exitValue(pdlParser.ValueContext ctx) {
//        System.out.println("Exit value: ");
//    }

}
