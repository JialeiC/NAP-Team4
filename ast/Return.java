package ast;
import java.util.*;


public class Return extends Instruction
{
  public Expression retExp = null;
  public retFunc function = null;
  public String var = null;
  public Return( Expression e )
  {
    this.retExp = e;
  }
  public Return( retFunc f )
  {
    this.function = f;
  }
  public Return( String s )
  {
    this.var = s;
  }
  public <Type> Type accept(Visitor<Type> visitor)
  {
    return visitor.visit(this);
  }
}
