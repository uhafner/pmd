/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.rule.metric;

import net.sourceforge.pmd.lang.java.ast.JavaNode;
import net.sourceforge.pmd.lang.java.metrics.JavaMetrics;
import net.sourceforge.pmd.lang.metrics.Metric;

/**
 * Fan out rule: counts the number of other classes a given class or operation
 * relies on.
 *
 * @author Ullrich Hafner
 */
public class FanOutRule extends AbstractMetricRule<Integer> {
    @Override
    public String getMetricName() {
        return "FAN_OUT";
    }

    @Override
    protected Metric<JavaNode, Integer> getMetric() {
        return JavaMetrics.FAN_OUT;
    }
}
