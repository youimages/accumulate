<form class="form-horizontal" id="class="${form.id}"" action="${form.url}"  method="${form.post}">
	<div class="form-body">
		<#if form.attributes?exists>
		<#list fg as form.attributes>
			<div class="${form.id}">
				<label class="col-md-3 control-label">${fg.nameCN}:</label>
				<div class="col-md-8">
					<!--文本框-->
					<#if test=${fg.inputType='text'}>
					<input class="form-control" name="${fg.name}" type="text" placeholder="${fg.placeholder}" data-tabindex="${fg_index+1}">
					</#if>
					<!--area文本框-->
					<#if test=${fg.inputType='textarea'}>
					<input class="form-control" name="${fg.name}" type="textarea" placeholder="${fg.placeholder}" data-tabindex="${fg_index+1}">
					</#if>
					<!--radio-->
					<#if test=${fg.inputType='radio'}>
					<#if fg.ars?exists>
					<#list fgars as fg.ars>
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