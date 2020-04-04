package ast;

public abstract class Instruction extends Ast
{
  public abstract <Type> Type accept(Visitor<Type> visitor);
}
