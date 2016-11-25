<!--${module.nameCN}修改的模态弹出层-->
<div id="update${module.name?cap_first}Model" class="modal fade" tabindex="-1" data-focus-on="input:first">
	<div class="modal-header modal-head-mis">
		<button type="button" class="close modal-head-close" data-dismiss="modal" aria-hidden="true"></button>
		<h4 class="modal-title">添加${module.nameCN}</h4>
	</div>
	
	<div class="modal-body">
	<form class="form-horizontal" id="${model_add.form.id}" action="${model_add.form.url}"  method="${model_add.form.method}">
			<div class="form-body">
				<#if model_add.form.attributes?exists>
				<#list model_add.form.attributes as fg>
					<div class="${model_add.form.id}">
						<label class="col-md-3 control-label">${fg.nameCN}:</label>
						<div class="col-md-8">
							<#--文本框-->
							<#if fg.inputType=='text'>
							<input class="form-control" name="${fg.name}" type="text" placeholder="${fg.placeholder}" data-tabindex="${fg_index+1}">
							</#if>
							<#--area文本框-->
							<#if fg.inputType=='textarea'>
							<input class="form-control" name="${fg.name}" type="textarea" placeholder="${fg.placeholder}" data-tabindex="${fg_index+1}">
							</#if>
							<#--radio-->
							<#if fg.inputType=='radio'>
								<#if fg.ars?exists>
								<#list fg.ars as fgars>
									<div class="col-md-4" style="margin-top:5px;">
										<input id="${fg.name}_option_${fgars_index+1}" type="radio" name="${fg.name}" value="${fgars.value}" class="make-switch switch-radio1" checked="checked">
										<label for="option1">${fgars.lable}</label>
									</div>
								</#list>
								</#if>
							</#if>
						</div>
					</div>
				</#list>
				</#if>
			</div>
			
			<div class="modal-footer  modal-footer-mis">
				<button type="button"  data-dismiss="modal"  class="btn btn-default modal-footer-mis">取  消</button>
				<button type="submit" class="btn btn-primary modal-footer-mis">保  存</button>
			</div>
		</form>
	</div>
</div>
