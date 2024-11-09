/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.rule.metric;

import net.sourceforge.pmd.lang.java.ast.JavaNode;
import net.sourceforge.pmd.lang.java.metrics.JavaMetrics;
import net.sourceforge.pmd.lang.metrics.Metric;

/**
 * Access to foreign data rule: number of usages of foreign attributes, both directly and through accessors.
 *
 * @author Ullrich Hafner
 */
public class AccessToForeignDataMetric extends AbstractMetricRule<Integer> {
    @Override
    protected String getMetricName() {
        return "ACCESS_TO_FOREIGN_DATA";
    }

    @Override
    protected Metric<JavaNode, Integer> getMetric() {
        return JavaMetrics.ACCESS_TO_FOREIGN_DATA;
    }
}
