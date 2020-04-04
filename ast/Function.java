package ast;
import java.util.*;

public class Function extends Ast
{
  public List<Var> vars;
  public List<Instruction> instructions;
  public String name;
  public TypeDef retType;
  public Function(List<Var> vars, List<Instruction> inst, String name, TypeDef ret)
  {
    this.vars = vars;
    this.instructions = inst;
    this.name = name;
    this.retType = ret;
  }
  public <Type> Type accept(Visitor<Type> visitor)
  {
    return visitor.visit(this);
  }
}
