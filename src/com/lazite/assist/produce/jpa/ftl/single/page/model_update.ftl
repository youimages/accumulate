<div id="update${module.name?cap_first}Model" class="modal fade" tabindex="-1" data-focus-on="input:first">
	<div class="modal-header modal-head-mis">
		<button type="button" class="close modal-head-close" data-dismiss="modal" aria-hidden="true"></button>
		<h4 class="modal-title">添加栏目</h4>
	</div>
	<div class="modal-body">
		<form action="<%=basePath%>${module.name}/add" class="form-horizontal" method="post">
			<div class="form-body">
				<div class="form-group">
					<label class="col-md-3 control-label">名称:</label>
					<div class="col-md-8">
						<input type="text" name="name" class="form-control " placeholder="输入栏目名称" data-tabindex="1">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label" for="title">父级栏目:</label>
					<div class="col-md-8">
						
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">链接地址:</label>
					<div class="col-md-8">
						<input type="text" name="url" class="form-control " placeholder="输入链接地址" data-tabindex="2">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">图标:</label>
					<div class="col-md-8">
						<input type="text" name="imgUrl" class="form-control " placeholder="选择栏目图标" data-tabindex="3">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">是否显示:</label>
					<div class="col-md-8">
						<div class="col-md-4" style="margin-top:5px;">
							<input id="option1" type="radio" name="isDisplay" value="1" class="make-switch switch-radio1" checked="checked">
							<label for="option1">显示</label>
						</div>
						<div class="col-md-4" style="margin-top:5px;">
							<input id="option2" type="radio" name="isDisplay" value="-1" class="make-switch switch-radio1">
							<label for="option2">不显示</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">排序:</label>
					<div class="col-md-8">
						<input type="text" name="place" class="form-control " placeholder="输入排序位置" data-tabindex="5">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">备注:</label>
					<div class="col-md-8">
						<textarea name="remark" class="form-control " placeholder="输入说明文本" data-tabindex="6"></textarea>
					</div>
				</div>
			</div>
			<div class="modal-footer  modal-footer-mis">
				<button type="button"  data-dismiss="modal"  class="btn btn-default modal-footer-mis">取  消</button>
				<button type="submit" class="btn btn-primary modal-footer-mis">保  存</button>
			</div>
		</form>
	</div>
</div>
