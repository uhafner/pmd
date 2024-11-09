/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.rule.metric;

import net.sourceforge.pmd.lang.java.ast.ASTExecutableDeclaration;
import net.sourceforge.pmd.lang.java.metrics.JavaMetrics;
import net.sourceforge.pmd.lang.java.metrics.JavaMetrics.CycloOption;
import net.sourceforge.pmd.lang.metrics.Metric;
import net.sourceforge.pmd.lang.metrics.MetricOptions;
import net.sourceforge.pmd.properties.PropertyDescriptor;
import net.sourceforge.pmd.properties.PropertyFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Cyclomatic complexity rule.
 *
 * @author Maximilian Waidelich
 */
public class CyclomaticComplexityRule extends AbstractMethodMetricRule<Integer> {
    private static final Map<String, CycloOption> OPTION_MAP;

    static {
        OPTION_MAP = new HashMap<>();
        OPTION_MAP.put(CycloOption.IGNORE_BOOLEAN_PATHS.valueName(), CycloOption.IGNORE_BOOLEAN_PATHS);
        OPTION_MAP.put(CycloOption.CONSIDER_ASSERT.valueName(), CycloOption.CONSIDER_ASSERT);
    }

    private static final PropertyDescriptor<List<CycloOption>> CYCLO_OPTIONS_DESCRIPTOR
            = PropertyFactory.enumListProperty("cycloOptions", OPTION_MAP)
            .desc("Choose options for the computation of Cyclo")
            .emptyDefaultValue()
            .build();


    public CyclomaticComplexityRule() {
        super();

        definePropertyDescriptor(CYCLO_OPTIONS_DESCRIPTOR);
    }

    @Override
    protected String getMetricName() {
        return "CYCLOMATIC_COMPLEXITY";
    }

    @Override
    protected Metric<ASTExecutableDeclaration, Integer> getMetric() {
        return JavaMetrics.CYCLO;
    }

    @Override
    protected MetricOptions getMetricOptions() {
        return MetricOptions.ofOptions(getProperty(CYCLO_OPTIONS_DESCRIPTOR));
    }
}
