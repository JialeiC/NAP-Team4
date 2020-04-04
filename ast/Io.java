package ast;

public class Io extends Instruction
{
  public TypeDef specification = null;
  public String name = null;
  public Expression expr = null;
  public Io( TypeDef spec, String name )
  {
    this.specification = spec;
    this.name = name;
  }
  public Io( Expression e )
  {
    this.expr = e;
  }
  public <Type> Type accept(Visitor<Type> visitor)
  {
    return visitor.visit(this);
  }
}
