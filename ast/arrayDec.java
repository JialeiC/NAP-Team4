package ast;
import java.util.*;


public class arrayDec extends VariableDec
{
  public TypeDef arrType;
  public String arrName;
  public TypeDef valType = null;
  public String valVarName = null;
  public int len = null;
  public List<Var> arrVars = null;
  // declare array and add objects by hand
  public arrayDec( TypeDef type, String name, List<Var> vars )
  {
    this.arrType = type;
    this.arrName = name;
    this.arrVars = vars;
    this.len = vars.length();
  }
  // declare emtpy array with int size of n
  public arrayDec( TypeDef type, String name, TypeDef valType, int len )
  {
    this.arrType = type;
    this.arrName = name;
    this.valType = valType;
    this.len = len;
  }
  // declare empty array with size of saved var
  public arrayDec( TypeDef type, String name, TypeDef vType, String vname )
  {
    this.arrType = type;
    this.arrName = name;
    this.valType = vType;
    this.valVarName = vname;
  }
  public <Type> Type accept(Visitor<Type> visitor)
  {
    return visitor.visit(this);
  }
}
