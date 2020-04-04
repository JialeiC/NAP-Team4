package ast;
import java.util.*;


public class Conditional extends Instruction
{
  public List<Instruction> block1;
  public List<Instruction> block2 = null;
  public Expression condExpr = null;
  public List<Expression> forExpr = null;
  // For if->then, while, and do while
  public Conditional( List<Instruction> block, Expression condExpr )
  {
    this.block1 = block;
    this.condExpr = condExpr;
  }
  // For if->then->else
  public Conditional( List<Instruction> block1, List<Instruction> block2,
                                    Expression condExpr)
  {
    this.block1 = block1;
    this.block2 = block2;
    this.condExpr = condExpr;
  }
  // For for loops
  public Conditional( List<Instruction> block, List<Expression> forExprs )
  {
    this.block1 = block;
    this.forExpr = forExprs;
  }
  public <Type> Type accept(Visitor<Type> visitor)
  {
    return visitor.visit(this);
  }
}
