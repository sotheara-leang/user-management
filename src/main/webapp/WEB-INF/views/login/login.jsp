<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-sm-4 col-sm-offset-4">
		<div class="panel panel-default margin-top-1">
			<div class="panel-heading"><spring:message code="general.login"/></div>
			<div class="panel-body">
				<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
					<div class="alert alert-danger" role="alert">
						<c:choose>
							<c:when test="${SPRING_SECURITY_LAST_EXCEPTION.getClass().simpleName eq 'UsernameNotFoundException'}">
								<spring:message code="login.username.incorrect"/>
							</c:when>
							<c:when test="${SPRING_SECURITY_LAST_EXCEPTION.getClass().simpleName eq 'BadCredentialsException'}">
								<spring:message code="login.password.incorrect"/>
							</c:when>
							<c:when test="${SPRING_SECURITY_LAST_EXCEPTION.getClass().simpleName eq 'SessionAuthenticationException'}">
								<spring:message code="login.exceed.max.session"/>
							</c:when>
							<c:otherwise>
								<spring:message code="error.internal.auth"/>
							</c:otherwise>
						</c:choose>
					</div>
					<c:remove var="SPRING_SECURITY_LAST_EXCEPTION"/>
				</c:if>
				<form class="form-horizontal" action="<c:url value='/login' />" method="post">
					<div class="form-group">
						<label for="username" class="col-sm-4 control-label"><spring:message code="general.username"/></label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="username" id="username">
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-4 control-label"><spring:message code="general.password"/></label>
						<div class="col-sm-7">
							<input type="password" class="form-control" name="password" id="password">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-7 col-sm-offset-4">
							<div class="checkbox">
								<label><input type="checkbox" name="remember-me"><spring:message code="general.remember.me"/></label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-7 col-sm-offset-4">
							<button type="submit" class="btn btn-default" id="btnLogin"><spring:message code="general.login"/></button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>