/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.rule.metric;

import net.sourceforge.pmd.lang.java.ast.ASTTypeDeclaration;
import net.sourceforge.pmd.lang.java.metrics.JavaMetrics;
import net.sourceforge.pmd.lang.metrics.Metric;

/**
 * Weight of a class rule: Number of “functional” public methods divided by the total number
 * of public methods. Our definition of “functional method” excludes
 * constructors, getters, and setters.
 *
 * @author Ullrich Hafner
 */
public class WeightOfClassRule extends AbstractClassMetricRule<Double> {
    @Override
    protected String getMetricName() {
        return "WEIGHT_OF_CLASS";
    }

    @Override
    protected Metric<ASTTypeDeclaration, Double> getMetric() {
        return JavaMetrics.WEIGHT_OF_CLASS;
    }
}
