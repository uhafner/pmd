package net.sourceforge.pmd.lang.java.rule.metric;

import net.sourceforge.pmd.lang.java.ast.ASTExecutableDeclaration;
import net.sourceforge.pmd.lang.java.ast.JavaNode;
import net.sourceforge.pmd.lang.java.ast.internal.PrettyPrintingUtil;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRulechainRule;
import net.sourceforge.pmd.lang.metrics.Metric;
import net.sourceforge.pmd.lang.metrics.MetricOptions;
import net.sourceforge.pmd.lang.metrics.MetricsUtil;
import net.sourceforge.pmd.lang.rule.MetricRule;
import net.sourceforge.pmd.reporting.RuleContext;
import net.sourceforge.pmd.util.AssertionUtil;

/**
 * Base class for metric rules that run on methods.
 *
 * @author Ullrich Hafner
 */
public abstract class AbstractMethodMetricRule<R extends Number> extends AbstractJavaRulechainRule implements MetricRule {
    protected AbstractMethodMetricRule() {
        super(ASTExecutableDeclaration.class);
    }

    protected abstract Metric<ASTExecutableDeclaration, R> getMetric();

    protected abstract String getMetricName();

    protected MetricOptions getMetricOptions() {
        return MetricOptions.emptyOptions();
    }

    @Override
    public Object visitJavaNode(JavaNode node, Object data) {
        if (node instanceof ASTExecutableDeclaration) {
            visitMethod((ASTExecutableDeclaration) node, (RuleContext) data);
        } else {
            throw AssertionUtil.shouldNotReachHere("node is not handled: " + node);
        }
        return data;
    }

    protected void visitMethod(ASTExecutableDeclaration node, RuleContext data) {
        if (getMetric().supports(node)) {
            R methodSize = MetricsUtil.computeMetric(getMetric(), node, getMetricOptions());

            MetricRule.addViolation(node, asCtx(data), getMetricName(), Type.METHOD,
                    PrettyPrintingUtil.displaySignature(node), String.valueOf(methodSize));
        }
    }
}
