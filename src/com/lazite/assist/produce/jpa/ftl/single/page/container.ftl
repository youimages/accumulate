<div class="page-container">
	<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">			
					<div class="portlet box light-blue">
						<div class="portlet-title">
							<div class="caption">
						<#if captions?exists>
							<#list captions as caption>
								<a href="javascript:refresh('${caption.script_url}');">
									<#if caption_index == 0>
										<i class="fa fa-home"></i>
									</#if>
									<#if caption_index != 0>
										${caption.caption_name}
									</#if>
									<#if caption_has_next>
										<i class="fa fa-angle-right"></i>
									</#if>
								</a>
							</#list>
						</#if>
							</div>
						</div>
						
						<div class="portlet-body">
							<div class="table-toolbar">
								<div class="btn-group">
									<#if btns?exists>
										<#list btns as btn>
											<button id="${btn.id}" class="${btn.btnClass}" 
												<#if btn.type == 'model'>
													data-target="#${btn.model_id}" data-toggle="modal"
												</#if>>
												${btn.value} <i class="${btn.icon}"></i>
											</button>	
										</#list>
									</#if>
								</div>
							</div>
							
							<table class="table table-striped table-bordered table-hover" id="${table.id}">
								<thead>
									<tr>
										<#if table.hasChecked>
											<th class="table-checkbox">
												<input type="checkbox" class="group-checkable" data-set="#table_sysRole .checkboxes"/>
											</th>
										</#if>
										<#if table.attributes?exists>
											<#list table.attributes as attribute>
												<th style="${attribute.width}">${attribute.nameCN}</th>
											</#list>
										</#if>
										<th style="">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${r'${values not empty}'}">
									<c:forEach var="values" items="${r'${values}'}" varStatus="status">
										<tr class="odd gradeX">
											<#if table.hasChecked>
												<th class="table-checkbox">
														<td><input type="checkbox" class="checkboxes" value="${r'${values.id}'}"/></td>
												</th>
											</#if>
											<#if table.attributes?exists >
												<#list table.attributes as attribute>
													<td>${r'${values.name}'}</td>
												</#list>
											</#if>
											<#if table.itags?exists >
												<#list table.itags as itag>
													&nbsp;<i id="${itag.id}" 
																class="${itag.iclass}   
																		<#if itag.type == 'click'>
																			forwardHandleUrl
																		</#if>" title="${itag.prompt}"
																url="${itag.url}">
															</i>
												</#list>
											</#if>
										</tr>
									</c:forEach>
									</c:if>
								</tbody>
							</table>
							
							<!-- 分页 参数名不可更改 -->
							<input type="hidden" id="totalPages" name="totalPages" value="${r'${totalPages}'}"/>
							<!--以下为分页插件,固定样式,不要更改    -->
							<div class="f-pages-div row-fluid" style="text-align: center;">
								<ul class="pagination"></ul>
							</div>
							
						</div>
					</div>
				</div>
			</div>		
		</div>
	</div>
</div>