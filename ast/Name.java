package ast;

public class Name extends Expression
{
  pulbic String name;
  public Name( String str )
  {
    this.name = str;
  }
  public <T> T accept(eVisitor<T> visitor)
  {
    return visitor.visit(this);
  }
}
