/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.scala.ast;

import scala.meta.Term;

/**
 * The ASTTermPartialFunction node implementation.
 */
public final class ASTTermPartialFunction extends AbstractScalaNode<Term.PartialFunction> {

    ASTTermPartialFunction(Term.PartialFunction scalaNode) {
        super(scalaNode);
    }

    @Override
    protected <P, R> R acceptVisitor(ScalaParserVisitor<? super P, ? extends R> visitor, P data) {
        return visitor.visit(this, data);
    }
}
