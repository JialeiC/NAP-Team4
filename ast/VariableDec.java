package ast;

public class VariableDec extends Instruction
{
  public String name;
  public TypeDef type;
  public String var = null;
  public Expression expr = null;
  public VariableDec( String n, TypeDef typeSpec )
  {
    this.name = n;
    this.type = typeSpec;
  }
  public VariableDec( String n, TypeDef typeSpec, String varName )
  {
    this.name = n;
    this.type = typeSpec;
    this.var = varName;
  }
  public VariableDec( String str, TypeDef typeSpec, Expression e )
  {
    this.name = str;
    this.type = typeSpec;
    this.expr = e;
  }
  public <Type> Type accept(Visitor<Type> visitor)
  {
    return visitor.visit(this);
  }
}
