<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title><spring:message code="app.title"/></title>

<link rel="stylesheet" type="text/css" href="<c:url value='/resources/bootstrap/bootstrap.min.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/fontawesome/font-awesome.min.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/datepicker/bootstrap-datepicker3.min.css'/>"/>
<link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/themes/redmond/jquery-ui.css"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/jqgrid/ui.jqgrid.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/jstree/jstree.min.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/main.css'/>"/>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<c:url value='/resources/bootstrap/bootstrap.min.js'/>"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.min.js"></script>
<script type="text/javascript" src="<c:url value='/resources/jqgrid/jquery.jqGrid.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/jqgrid/grid.locale-en.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/datepicker/bootstrap-datepicker.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/datepicker/bootstrap-datepicker.en-GB.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/jstree/jstree.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/Url.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/i18n/messages-${pageContext.response.locale}.js'/>"></script>