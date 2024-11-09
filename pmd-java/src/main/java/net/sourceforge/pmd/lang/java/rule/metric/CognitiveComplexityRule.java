/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.rule.metric;

import net.sourceforge.pmd.lang.java.ast.ASTExecutableDeclaration;
import net.sourceforge.pmd.lang.metrics.Metric;
import net.sourceforge.pmd.lang.rule.MetricRule;

import static net.sourceforge.pmd.lang.java.metrics.JavaMetrics.COGNITIVE_COMPLEXITY;

/**
 * Cognitive complexity rule: a measure of how challenging it is for humans
 * to read and understand a method.
 *
 * @author Maximilian Waidelich
 */
public class CognitiveComplexityRule extends AbstractMethodMetricRule<Integer> implements MetricRule {
    @Override
    protected String getMetricName() {
        return "COGNITIVE_COMPLEXITY";
    }

    @Override
    protected Metric<ASTExecutableDeclaration, Integer> getMetric() {
        return COGNITIVE_COMPLEXITY;
    }
}
