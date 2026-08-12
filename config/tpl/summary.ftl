<#-- Text template for Telegram -->
<b><#if base.project??>${base.project}<#else>Allure Report</#if></b>
<#if base.environment??><i>Environment: ${base.environment}</i></#if>

<b>Результаты прогона:</b>
<#if result.failed?? && (result.failed > 0)>❌ Failed: ${result.failed}</#if>
<#if result.broken?? && (result.broken > 0)>💥 Broken: ${result.broken}</#if>
<#if result.passed?? && (result.passed > 0)>✅ Passed: ${result.passed}</#if>
<#if result.skipped?? && (result.skipped > 0)>⏭ Skipped: ${result.skipped}</#if>
<b>Total:</b> ${result.total} tests

<b>Время выполнения:</b> ${time.duration}
<#if base.reportLink??><a href="${base.reportLink}">📊 Открыть Allure Report</a></#if>