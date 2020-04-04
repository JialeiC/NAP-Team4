package ast;

public class Assignment extends Instruction
{
  public String name;
  public arrAccess array;
  public Expresssion e;
  public Assignment( String name, Expression expr )
  {
    this.name = name;
    this.e = expr;
  }
  public Assignment( arrAccess arr, Expression expr )
  {
    this.array = arr;
    this.e = expr;
  }
  public <Type> Type accept(Visitor<Type> visitor)
  {
    return visitor.visit(this);
  }
}
