package ast;

public class binExp extends Expression
{
  public Expression left;
  public Expression right;
  public Operator op;
  public compOp cop;
  public simpleOp sop;
  public boolOp bop;
  public binExp( Expression l, Expression r, Operator o )
  {
    this.left = l;
    this.right = r;
    this.op = o;
  }
  public binExp( Expression l, Expression r, compOp o )
  {
    this.left = l;
    this.right = r;
    this.cop = o;
  }
  public binExp( Expression l, Expression r, simpleOp o )
  {
    this.left = l;
    this.right = r;
    this.sop = o;
  }
  public binExp( Expression l, Expression r, boolOp o )
  {
    this.left = l;
    this.right = r;
    this.bop = o;
  }
  public <T> T accept(eVisitor<T> visitor)
  {
    return visitor.visit(this);
  }
}
