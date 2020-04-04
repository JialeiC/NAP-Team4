package ast;

public interface eVisitor<T>
{
  public T visit(binExp binary);
  public T visit(unaryExp unary);
  public T visit(arrAccess array);
  public T visit(Var variable);
  public T visit(Basic base);
  public T visit(Name name);
}
