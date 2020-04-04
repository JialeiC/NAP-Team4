package ast;
import java.util.*;


public class retFunc extends Instruction
{
  public String name;
  public List<Var> vars = null;
  public retFunc( String name )
  {
    this.name = name;
  }
  public retFunc( String name, List<Var> vars )
  {
    this.name = name;
    this.vars = vars;
  }
  public <Type> Type accept(Visitor<Type> visitor)
  {
    return visitor.visit(this);
  }
}
