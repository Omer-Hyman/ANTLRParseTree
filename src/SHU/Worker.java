package SHU;
import org.antlr.v4.runtime.ParserRuleContext;
import parseTree.*;

public class Worker extends pdlBaseListener{

    Tree tree = new Tree();

    public void FindNode(String name, int option) {
        tree.searchTree(name, option);
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        tree.setLevel(1);
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        tree.setLevel(-1);
    }

    @Override public void enterProgram(pdlParser.ProgramContext ctx) {
        System.out.println("Enter program " + ctx.getChildCount());
        tree.setCtx(ctx.getText());
        tree.CreateTree(new TreeNode("program", ctx.getText()));
    }

    @Override public void exitProgram(pdlParser.ProgramContext ctx) {
        System.out.println("Exit program");
        for (int i = 0; i < tree.getTree().getRowCount(); i++) {
            tree.getTree().expandRow(i);
        }
        tree.DisplayStack();
        /*for (int i = 0; i < node.getStack().size(); i++)
        {
            tree.NewNode(node.getStack().get(i));
        }*/
    }

    @Override public void enterProgramHeader(pdlParser.ProgramHeaderContext ctx) {
        System.out.println("Enter program header " + ctx.getChildCount());
        tree.NewNode(new TreeNode("program header", ctx.getText()));
    }

    @Override public void enterBlock(pdlParser.BlockContext ctx) {
        System.out.println("Enter block " + ctx.getChildCount());
        tree.NewNode(new TreeNode("block", ctx.getText()));
    }

    @Override public void enterOutputStatement(pdlParser.OutputStatementContext ctx) {
        System.out.println("Enter output statement " + ctx.getChildCount());
        tree.NewNode(new TreeNode("output", ctx.getText()));
    }

    @Override public void enterGlobals(pdlParser.GlobalsContext ctx) {
        System.out.println("Enter globals");
        tree.NewNode(new TreeNode("globals", ctx.getText()));
    }

    @Override public void enterProgramEnds(pdlParser.ProgramEndsContext ctx) {
        System.out.println("Enter program ends");
        tree.NewNode(new TreeNode("program ends", ctx.getText()));
    }

    @Override public void enterProcDefun(pdlParser.ProcDefunContext ctx) {
        System.out.println("Enter proc defun");
        tree.NewNode(new TreeNode("proc defun", ctx.getText()));
    }

    @Override public void exitProgramHeader(pdlParser.ProgramHeaderContext ctx) {
        System.out.println("Exit program header");
    }

    @Override public void enterComparator(pdlParser.ComparatorContext ctx) {
        System.out.println("Enter comparator");
        tree.NewNode(new TreeNode("comparator", ctx.getText()));
    }

    @Override public void enterMath(pdlParser.MathContext ctx) {
        System.out.println("Enter math: " + ctx.getText());
        tree.NewNode(new TreeNode("math", ctx.getText()));
    }

    @Override public void enterInputStatement(pdlParser.InputStatementContext ctx) {
        System.out.println("Enter input statement: ");
        tree.NewNode(new TreeNode("input", ctx.getText()));
    }

    @Override public void enterProcedureCall(pdlParser.ProcedureCallContext ctx) {
        System.out.println("Enter procedure call: " + ctx.getText());
        tree.NewNode(new TreeNode("procedure call", ctx.getText()));
    }

    @Override public void enterExpr(pdlParser.ExprContext ctx) {
        System.out.println("Enter expression: " + ctx.getText());
        tree.NewNode(new TreeNode("expression", ctx.getText()));
    }

    @Override public void enterAssignment(pdlParser.AssignmentContext ctx) {
        System.out.println("Enter assignment: " + ctx.getText());
        tree.NewNode(new TreeNode("assignment", ctx.getText()));
    }

    @Override public void enterWhileLoop(pdlParser.WhileLoopContext ctx) {
        System.out.println("Enter while loop: " + ctx.getText());
        tree.NewNode(new TreeNode("while loop", ctx.getText()));
    }

    @Override public void enterIfElse(pdlParser.IfElseContext ctx) {
        System.out.println("Enter if else: " + ctx.getText());
        tree.NewNode(new TreeNode("if else", ctx.getText()));
    }

    @Override public void enterValue(pdlParser.ValueContext ctx) {
        System.out.println("Enter value: " + ctx.getText());
        tree.NewNode(new TreeNode("value", ctx.getText()));
    }

    @Override public void exitBlock(pdlParser.BlockContext ctx) {
        System.out.println("Exit block");
    }

    @Override public void exitOutputStatement(pdlParser.OutputStatementContext ctx) {
        System.out.println("Exit output statement");
    }

    @Override public void exitGlobals(pdlParser.GlobalsContext ctx) {
        System.out.println("Exit globals");
    }

    @Override public void exitProgramEnds(pdlParser.ProgramEndsContext ctx) {
        System.out.println("Exit program ends");
    }

    @Override public void exitProcDefun(pdlParser.ProcDefunContext ctx) {
        System.out.println("Exit proc defun");
    }

    @Override public void exitComparator(pdlParser.ComparatorContext ctx) {
        System.out.println("Exit comparator");
    }

    @Override public void exitMath(pdlParser.MathContext ctx) {
        System.out.println("Exit math: " + ctx.getText());
    }

    @Override public void exitInputStatement(pdlParser.InputStatementContext ctx) {
        System.out.println("Exit input statement: ");
    }

    @Override public void exitProcedureCall(pdlParser.ProcedureCallContext ctx) {
        System.out.println("Exit procedure call: " + ctx.getText());
    }

    @Override public void exitExpr(pdlParser.ExprContext ctx) {
        System.out.println("Exit expression: " + ctx.getText());
    }

    @Override public void exitAssignment(pdlParser.AssignmentContext ctx) {
        System.out.println("Exit assignment: " + ctx.getText());
    }

    @Override public void exitWhileLoop(pdlParser.WhileLoopContext ctx) {
        System.out.println("Exit while loop: " + ctx.getText());
    }

    @Override public void exitIfElse(pdlParser.IfElseContext ctx) {
        System.out.println("Exit if else: " + ctx.getText());
    }

    @Override public void exitValue(pdlParser.ValueContext ctx) {
        System.out.println("Exit value: " + ctx.getText());
    }

}
