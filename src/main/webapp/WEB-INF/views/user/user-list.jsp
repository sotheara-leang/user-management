<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="text-center">
	<h4><spring:message code="user.list"/></h4>
</div>
<div class="row well well-sm no-margin">
	<div class="pull-left">
		<div class="btn-group">
			<button type="button" class="btn btn-default dropdown-toggle"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<spring:message code="general.export"/> <span class="caret"></span>
			</button>
			<ul class="dropdown-menu" id="btnExportUsers">
			    <li><a href="#" data-format="pdf"><spring:message code="general.export.pdf"/></a></li>
			    <li><a href="#" data-format="xls"><spring:message code="general.export.excel"/></a></li>
			    <li><a href="#" data-format="html"><spring:message code="general.export.html"/></a></li>
	  		</ul>
		</div>
	</div>
	<div class="pull-right">
		<button class="btn btn-default" id="btnNewUser"><spring:message code="user.btn.new" /></button>
		<button class="btn btn-default" id="btnDeleteUser" disabled="disabled"><spring:message code="btn.delete"/></button>
	</div>
</div>
<div class="panel panel-default margin-top-1">
	<div class="panel-heading"><spring:message code="btn.search"/></div>
	<div class="panel-body">
		<div class="form-horizontal">
			<div class="form-group">
				<label for="searchUsername" class="col-sm-2 control-label"><spring:message code="general.username"/></label>
				<div class="col-sm-2">
					<input type="text" class="form-control" id="searchUsername">
				</div>
			</div>
			<div class="form-group">
				<label for="searchRole" class="col-sm-2 control-label"><spring:message code="general.role"/></label>
				<div class="col-sm-2">
					<select id="searchRole" class="form-control">
						<option value=""></option>
						<option value="ROLE_USER">User</option>
						<option value="ROLE_ADMIN">Admin</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="searchEmail" class="col-sm-2 control-label"><spring:message code="general.email"/></label>
				<div class="col-sm-2">
					<input type="email" class="form-control" id="searchEmail">
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
	<table id="userGrid"></table>
	<div id="userGridPager"></div>
</div>
<div class="modal fade" id="userModel" tabindex="-1" role="dialog" aria-labelledby="userModelLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="userModelTitle"></h4>
			</div>
			<div class="modal-body">
				<div class="form-horizontal">
					<input type="hidden" id="id">
					<div class="form-group required">
						<label for="username" class="col-sm-4 control-label"><spring:message code="general.username"/></label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="username">
						</div>
					</div>
					<div class="form-group required">
						<label for="role" class="col-sm-4 control-label"><spring:message code="general.role"/></label>
						<div class="col-sm-3">
							<select id="role" class="form-control">
								<option value="ROLE_USER">User</option>
								<option value="ROLE_ADMIN">Admin</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="role" class="col-sm-4 control-label"><spring:message code="general.department"/></label>
						<div class="col-sm-4">
							<select id="department" class="form-control"></select>
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-4 control-label"><spring:message code="general.email"/></label>
						<div class="col-sm-5">
							<input type="email" class="form-control" id="email">
							<div class="checkbox">
							    <label>
							      <input id="allowLoginEmailNotification" type="checkbox"><spring:message code="user.notify.login"></spring:message>
							    </label>
							  </div>
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-4 control-label"><spring:message code="general.password"/></label>
						<div class="col-sm-5">
							<input type="password" class="form-control" id="password">
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal"><spring:message code="btn.cancel"/></button>
				<button type="button" class="btn btn-primary" id="btnSaveUser"><spring:message code="btn.save"/></button>
			</div>
		</div>
	</div>
</div>