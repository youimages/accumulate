<body>

<#include "${body.container}"/>

<#if body.models?exists>
	<#list body.models as model>
		
		<#include "${model}"/>
		
	</#list>
</#if>

<#include "${body.scrpitLabel}"/>

<#include "${body.scrpitDefined}"/>

</body>