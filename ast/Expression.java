package ast;

public abstract class Expression extends Instruction
{
  public abstract <T> T accept(eVisitor<T> visitor);
}
