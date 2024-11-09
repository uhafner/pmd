/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.rule.metric;

import net.sourceforge.pmd.lang.java.ast.ASTTypeDeclaration;
import net.sourceforge.pmd.lang.java.metrics.JavaMetrics;
import net.sourceforge.pmd.lang.metrics.Metric;

/**
 * Weighted method count rule: sums the statistical complexity of the operations in a class.
 *
 * @author Ullrich Hafner
 */
public class WeightedMethodCountRule extends AbstractClassMetricRule<Integer> {
    @Override
    protected String getMetricName() {
        return "WEIGHED_METHOD_COUNT";
    }

    @Override
    protected Metric<ASTTypeDeclaration, Integer> getMetric() {
        return JavaMetrics.WEIGHED_METHOD_COUNT;
    }
}
