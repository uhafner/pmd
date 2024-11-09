/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.rule.metric;

import net.sourceforge.pmd.lang.java.ast.ASTTypeDeclaration;
import net.sourceforge.pmd.lang.java.metrics.JavaMetrics;
import net.sourceforge.pmd.lang.metrics.Metric;

/**
 * Number of accessors rule: counts the number of getters and setters.
 *
 * @author Ullrich Hafner
 */
public class NumberOfAccessorsRule extends AbstractClassMetricRule<Integer> {
    @Override
    protected String getMetricName() {
        return "NUMBER_OF_ACCESSORS";
    }

    @Override
    protected Metric<ASTTypeDeclaration, Integer> getMetric() {
        return JavaMetrics.NUMBER_OF_ACCESSORS;
    }
}
