package ast;

public class arrAccess extends Var
{
  public String arrName;
  public String accessVar;
  public int accessInt;
  public arrAccess( String name, String var )
  {
    this.arrName = name;
    this.accessVar = var;
  }
  public arrAccess( String name, int i )
  {
    this.arrName = name;
    this.accessInt = i;
  }
  public <T> T accept(eVisitor<T> visitor)
  {
    return visitor.visit(this);
  }
}
