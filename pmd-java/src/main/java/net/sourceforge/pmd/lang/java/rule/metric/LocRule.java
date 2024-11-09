/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.rule.metric;

import net.sourceforge.pmd.lang.java.ast.JavaNode;
import net.sourceforge.pmd.lang.java.metrics.JavaMetrics;
import net.sourceforge.pmd.lang.metrics.Metric;

/**
 * LOC rule: counts the number of lines in a class or method.
 *
 * @author Ullrich Hafner
 */
public class LocRule extends AbstractMetricRule<Integer> {
    @Override
    protected String getMetricName() {
        return "LOC";
    }

    @Override
    protected Metric<JavaNode, Integer> getMetric() {
        return JavaMetrics.LINES_OF_CODE;
    }
}
