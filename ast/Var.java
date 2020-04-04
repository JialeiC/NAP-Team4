package ast;

public class Var extends Expression
{
  public TypeDef type;
  public String name;
  public Expression expr;
  public Basic b;
  public Var( TypeDef t, String str )
  {
    this.type = t;
    this.name = str;
  }
  public Var( Expression e )
  {
    this.expr = e;
  }
  public Var( Basic bas )
  {
      this.b = bas;
  }
  public <T> T accept(eVisitor<T> visitor)
  {
    return visitor.visit(this);
  }
}
