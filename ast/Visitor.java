package ast;

public interface Visitor<Type>{
    public Type visit(Program program);
    public Type visit(Function func);
    public Type visit(Return ret);
    public Type visit(retFunc rF);
    public Type visit(Assignment assign);
    public Type visit(Io inOut);
    public Type visit(Conditional cond);
    public Type visit(VariableDec var);
    public Type visit(arrayDec arr);
}
