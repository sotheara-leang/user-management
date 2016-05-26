<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="text-center">
	<h4><spring:message code="department.list"/></h4>
</div>
<div class="row well well-sm no-margin">
	<div class="pull-right">
		<button class="btn btn-default" id="btnNewDepartment"><spring:message code="department.btn.new" /></button>
		<button class="btn btn-default" id="btnDeleteDepartment" disabled="disabled"><spring:message code="btn.delete"/></button>
	</div>
</div>
<div class="panel panel-default margin-top-1">
	<div class="panel-heading"><spring:message code="btn.search"/></div>
	<div class="panel-body">
		<div class="form-horizontal">
			<div class="form-group">
				<label for="searchName" class="col-sm-2 control-label"><spring:message code="department.name"/></label>
				<div class="col-sm-2">
					<input type="text" class="form-control" id="searchName">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-3">
					<button class="btn btn-default" id="btnSearch"><spring:message code="btn.search"/></button>
					<button class="btn btn-default" id="btnReset"><spring:message code="btn.reset"/></button>
				</div>
			</div>
		</div>
	</div>
</div>
<div>
	<table id="departmentGrid"></table>
	<div id="departmentGridPager"></div>
</div>
<div class="modal fade" id="departmentModel" tabindex="-1" role="dialog" aria-labelledby="departmentModelLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="departmentModelTitle"></h4>
			</div>
			<div class="modal-body">
				<div class="form-horizontal">
					<input type="hidden" id="id">
					<div class="form-group required">
						<label for="name" class="col-sm-4 control-label"><spring:message code="department.name"/></label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="name">
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal"><spring:message code="btn.cancel"/></button>
				<button type="button" class="btn btn-primary" id="btnSaveDepartment"><spring:message code="btn.save"/></button>
			</div>
		</div>
	</div>
</div>