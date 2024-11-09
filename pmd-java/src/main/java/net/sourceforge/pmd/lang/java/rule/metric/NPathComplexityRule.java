/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.rule.metric;


import net.sourceforge.pmd.lang.java.ast.ASTExecutableDeclaration;
import net.sourceforge.pmd.lang.java.metrics.JavaMetrics;
import net.sourceforge.pmd.lang.metrics.Metric;

import java.math.BigInteger;

/**
 * N-path complexity rule.
 *
 * @author Maximilian Waidelich
 */
public class NPathComplexityRule extends AbstractMethodMetricRule<BigInteger> {
    @Override
    protected String getMetricName() {
        return "NPATH_COMPLEXITY";
    }

    @Override
    protected Metric<ASTExecutableDeclaration, BigInteger> getMetric() {
        return JavaMetrics.NPATH;
    }
}

