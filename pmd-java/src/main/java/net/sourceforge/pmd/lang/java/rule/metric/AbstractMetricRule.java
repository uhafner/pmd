package net.sourceforge.pmd.lang.java.rule.metric;

import net.sourceforge.pmd.lang.java.ast.ASTExecutableDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTTypeDeclaration;
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
 * Base class for metric rules that run on classes and methods.
 *
 * @author Ullrich Hafner
 */
public abstract class AbstractMetricRule<R extends Number> extends AbstractJavaRulechainRule implements MetricRule {
    protected AbstractMetricRule() {
        super(ASTExecutableDeclaration.class, ASTTypeDeclaration.class);
    }

    protected abstract Metric<JavaNode, R> getMetric();

    protected abstract String getMetricName();

    protected MetricOptions getMetricOptions() {
        return MetricOptions.emptyOptions();
    }

    @Override
    public final Object visitJavaNode(JavaNode node, Object data) {
        if (node instanceof ASTTypeDeclaration) {
            visitTypeDecl((ASTTypeDeclaration) node, (RuleContext) data);
        } else if (node instanceof ASTExecutableDeclaration) {
            visitMethod((ASTExecutableDeclaration) node, (RuleContext) data);
        } else {
            throw AssertionUtil.shouldNotReachHere("node is not handled: " + node);
        }
        return data;
    }

    private void visitTypeDecl(ASTTypeDeclaration node, RuleContext data) {
        if (getMetric().supports(node)) {
            R classSize = MetricsUtil.computeMetric(getMetric(), node, getMetricOptions());

            MetricRule.addViolation(node, asCtx(data), getMetricName(), Type.CLASS,
                    node.getSimpleName(), String.valueOf(classSize));
        }
    }

    private void visitMethod(ASTExecutableDeclaration node, RuleContext data) {
        if (getMetric().supports(node)) {
            R methodSize = MetricsUtil.computeMetric(getMetric(), node, getMetricOptions());

            MetricRule.addViolation(node, asCtx(data), getMetricName(), Type.METHOD,
                    PrettyPrintingUtil.displaySignature(node), String.valueOf(methodSize));
        }
    }
}
