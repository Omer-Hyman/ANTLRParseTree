package SHU;

import org.antlr.v4.runtime.tree.ParseTree;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import parseTree.pdlBaseListener;
import parseTree.pdlParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Compiler extends pdlBaseListener {
    private StringBuilder sb = new StringBuilder();
    String programName;
    public String getProgram() {return programName.toString();}

    STGroup stg = new STGroupFile("./pdl.stg");
    public String toString() { return sb.toString(); }

    ArrayList<String> converted = new ArrayList<>();
    TreeNode node = new TreeNode();

    @Override public void enterProgram(pdlParser.ProgramContext ctx) {
        System.out.println("SUCCESS! NOW COMPILING!");
    }

    @Override public void exitProgram(pdlParser.ProgramContext ctx){
//        System.out.println("Printing program children\n");
//        for (int i = 0; i < ctx.getChildCount(); i++)
//            System.out.println(i + ": " + ctx.getChild(i).getText());

        ST st = stg.getInstanceOf("exitProgram");
        st.add("v", programName);
        sb.append(st.render());
    }

    @Override
    public void enterProgramHeader(pdlParser.ProgramHeaderContext ctx) {
        programName= ctx.getChild(1).getText();
        ST st = stg.getInstanceOf("enterProgram");
        st.add("v", programName);
        sb.append(st.render());
    }

    @Override
    public void exitProgramHeader(pdlParser.ProgramHeaderContext ctx) {
//        System.out.println("\nPrinting program header children");
//        for (int i = 0; i < ctx.getChildCount(); i++)
//            System.out.println(i + ": " + ctx.getChild(i).getText());
    }

    @Override
    public void exitProgramEnds(pdlParser.ProgramEndsContext ctx) {
        //turn into string
        //converted.add(string);
//        System.out.println("\nPrinting program ends children");
//        for (int i = 0; i < ctx.getChildCount(); i++)
//            System.out.println(i + ": " + ctx.getChild(i).getText());
    }

    @Override
    public void enterProcDefun(pdlParser.ProcDefunContext ctx) {
        ST st = stg.getInstanceOf("enterProcedure");
        st.add("v", ctx.getChild(1));
        sb.append(st.render());
    }

    @Override
    public void exitBlock(pdlParser.BlockContext ctx) {
//        System.out.println("\nPrinting block children");
//        for (int i = 0; i < ctx.getChildCount(); i++)
//            System.out.println(i + ": " + ctx.getChild(i).getText());
    }

    @Override
    public void exitExpr(pdlParser.ExprContext ctx) {
       /* ST st = stg.getInstanceOf("expr");

        if (ctx.getChildCount() > 1) {
            for (int i = 0; i < ctx.getChildCount(); i++)
                System.out.println(i + ": " + ctx.getChild(i).getText());

            st.add("i", ctx.getChild(1).getText());
            st.add("m", ctx.getChild(2).getText());
            st.add("v", ctx.getChild(3).getText());
        }
        sb.append(st.render());*/
    }


    @Override
    public void exitInputStatement(pdlParser.InputStatementContext ctx) {
//        System.out.println("\nPrinting input children");
//        for (int i = 0; i < ctx.getChildCount(); i++)
//            System.out.println(i + ": " + ctx.getChild(i).getText());

        ST st = stg.getInstanceOf("input");
        st.add("v", ctx.getChild(2));
        sb.append(st.render());
    }

    @Override
    public void exitOutputStatement(pdlParser.OutputStatementContext ctx) {
        ArrayList<String> valueNames = new ArrayList<String>();
        for(int i=2; i<ctx.getChildCount(); i+=2)
            valueNames.add(ctx.getChild(i).getText());

        ST st = stg.getInstanceOf("output");
        st.add("v", valueNames);
        sb.append(st.render());
    }

    @Override
    public void exitAssignment(pdlParser.AssignmentContext ctx) {
//        System.out.println("\nPrinting assignment children");
//        for (int i = 0; i < node.getStack().size(); i++)
//        {
//            System.out.println(node.getStack().get(i).getNodeName());
//        }

        ST st = stg.getInstanceOf("assignment");
        st.add("ident", ctx.getChild(1).getText());
        st.add("value", ctx.getChild(3).getText());
        sb.append(st.render());
    }

    @Override
    public void exitGlobals(pdlParser.GlobalsContext ctx) {
        ArrayList<String> valueNames = new ArrayList<String>();

        for(int i=1; i<ctx.getChildCount(); i+=2)
            valueNames.add(ctx.getChild(i).getText());

        ST st = stg.getInstanceOf("globals");
        st.add("values", valueNames);
        sb.append(st.render());
    }

    @Override public void exitProcedureCall(pdlParser.ProcedureCallContext ctx) {
        ST st = stg.getInstanceOf("procCall");

        ArrayList<String> valueNames = new ArrayList<String>();
        for(int i=3; i<ctx.getChildCount(); i+=2)// maybe 4
            valueNames.add(ctx.getChild(i).getText());

//        for (int i = 0; i < ctx.getChildCount(); i++)
//            System.out.println(i + ": " + ctx.getChild(i).getText());

        st.add("v", ctx.getChild(1).getText());
        if (ctx.getChildCount() > 2)
            st.add("values", valueNames);
        sb.append(st.render());
    }

    @Override
    public void enterIfElse(pdlParser.IfElseContext ctx) {
        String comparator = ctx.getChild(3).getText();
        if (comparator.equals(0))
            comparator = "==";

        ST st = stg.getInstanceOf("ifClause");
        st.add("operand1", ctx.getChild(2).getText());
        st.add("comparator", comparator);
        st.add("operand2", ctx.getChild(4).getText());
        st = stg.getInstanceOf("elseClause");


        sb.append(st.render().trim());

        for (int i = 0; i < ctx.getChildCount(); i++)
          System.out.println(i + ": " + ctx.getChild(i).getText());

        if (ctx.getChildCount() > 8 )
        {

            st = stg.getInstanceOf("elseClause");
        }

    }

    @Override
    public void exitIfElse(pdlParser.IfElseContext ctx) {
        ST st = stg.getInstanceOf("elseClause");
        sb.append(st.render());
    }

    @Override
    public void exitProcDefun(pdlParser.ProcDefunContext ctx) {
//        System.out.println("\nPrinting proc defun children");
//        for (int i = 0; i < ctx.getChildCount(); i++)
//          System.out.println(i + ": " + ctx.getChild(i).getText());
        sb.append("}");
    }

    @Override
    public void enterWhileLoop(pdlParser.WhileLoopContext ctx) {
        ST st = stg.getInstanceOf("whileLoop");
        st.add("operand1", ctx.getChild(2).getText());
        st.add("comparator", ctx.getChild(3).getText());
        st.add("operand2", ctx.getChild(4).getText());
        sb.append(st.render());
    }

    @Override
    public void exitWhileLoop(pdlParser.WhileLoopContext ctx) {
        sb.append("}");

    }


}
