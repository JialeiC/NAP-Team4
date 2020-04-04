package ast;

public class unaryExp extends Expression
{
  public String addO = "++";
  public String subO = "--";
  public String not = "!";
  public String operation;
  public Expression epxr;
  public unaryExp( Expression e, String op )
  {
    this.expr = e;
    if( op == addO )
    {
      this.operation = addO;
    }
    else if( op == subO )
    {
      this.operation = subO;
    }
    else if( op == not )
    {
      this.operation = not;
    }
  }
  public <T> T accept(eVisitor<T> visitor)
  {
    return visitor.visit(this);
  }
}
