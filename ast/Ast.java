package ast;

public abstract class Ast
{
    public abstract <T> T accept(Visitor<T> visitor);
}
