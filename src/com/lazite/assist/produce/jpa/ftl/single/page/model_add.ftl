<div id="add${module.name?cap_first}Model" class="modal fade" tabindex="-1" data-focus-on="input:first">
	<div class="modal-header modal-head-mis">
		<button type="button" class="close modal-head-close" data-dismiss="modal" aria-hidden="true"></button>
		<h4 class="modal-title">添加${module.nameCN}</h4>
	</div>
	<div class="modal-body">
		<#include "${module.formUrl}"/>
	</div>
</div>
