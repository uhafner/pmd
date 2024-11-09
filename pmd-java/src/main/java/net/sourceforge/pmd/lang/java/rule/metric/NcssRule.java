/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.rule.metric;

import net.sourceforge.pmd.lang.java.ast.JavaNode;
import net.sourceforge.pmd.lang.java.metrics.JavaMetrics;
import net.sourceforge.pmd.lang.java.metrics.JavaMetrics.NcssOption;
import net.sourceforge.pmd.lang.metrics.Metric;
import net.sourceforge.pmd.lang.metrics.MetricOptions;
import net.sourceforge.pmd.properties.PropertyDescriptor;
import net.sourceforge.pmd.properties.PropertyFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * NCSS rule: Counts the number of statements in a class or operation. That’s roughly
 * equivalent to counting the number of semicolons and opening braces
 * in the program.
 *
 * @author Maximilian Waidelich
 */
public class NcssRule extends AbstractMetricRule<Integer> {
    private static final PropertyDescriptor<List<NcssOption>> NCSS_OPTIONS_DESCRIPTOR;

    static {
        Map<String, NcssOption> options = new HashMap<>();
        options.put(NcssOption.COUNT_IMPORTS.valueName(), NcssOption.COUNT_IMPORTS);

        NCSS_OPTIONS_DESCRIPTOR = PropertyFactory.enumListProperty("ncssOptions", options)
                .desc("Choose options for the computation of Ncss")
                .emptyDefaultValue()
                .build();
    }

    public NcssRule() {
        super();

        definePropertyDescriptor(NCSS_OPTIONS_DESCRIPTOR);
    }

    @Override
    protected MetricOptions getMetricOptions() {
        return MetricOptions.ofOptions(getProperty(NCSS_OPTIONS_DESCRIPTOR));
    }

    @Override
    protected String getMetricName() {
        return "NCSS";
    }

    @Override
    protected Metric<JavaNode, Integer> getMetric() {
        return JavaMetrics.NCSS;
    }
}
