package ast;
import java.util.*;

public class Program extends Ast
{
  public List<Instruction> Main;
  public List<Function> functions;
  public Program(List<Instruction> Main, List<Function> fxns)
  {
    this.Main = Main;
    this.functions = fxns;
  }
  public <Type> Type accept(Visitor<Type> visitor)
  {
    return visitor.visit(this);
  }
}
