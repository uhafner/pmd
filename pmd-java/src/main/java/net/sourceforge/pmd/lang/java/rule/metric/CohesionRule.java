/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.rule.metric;

import net.sourceforge.pmd.lang.java.ast.ASTTypeDeclaration;
import net.sourceforge.pmd.lang.java.metrics.JavaMetrics;
import net.sourceforge.pmd.lang.metrics.Metric;

/**
 * Tight class cohesion rule: The relative number of method pairs in a class that access in common
 * at least one attribute of the measured class.
 *
 * @author Ullrich Hafner
 */
public class CohesionRule extends AbstractClassMetricRule<Double> {
    @Override
    protected String getMetricName() {
        return "COHESION";
    }

    @Override
    protected Metric<ASTTypeDeclaration, Double> getMetric() {
        return JavaMetrics.TIGHT_CLASS_COHESION;
    }
}
