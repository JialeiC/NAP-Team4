package ast;

public class Basic extends Expression
{
  public int Integer;
  public char c;
  public Bool b;
  public float f;
  public byte by;
  public Basic( int i )
  {
    this.Integer = i;
  }
  public Basic( char i )
  {
    this.c = i;
  }
  public Basic( Bool i )
  {
    this.b = i;
  }
  public Basic( float i )
  {
    this.f = i;
  }
  public Basic( byte i )
  {
    this.by = i;
  }
  public <T> T accept(eVisitor<T> visitor)
  {
    return visitor.visit(this);
  }
}
