<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>医生信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/doctorflow/doctorFlow/">医生信息列表</a></li>
		<shiro:hasPermission name="doctorflow:doctorFlow:edit"><li><a href="${ctx}/doctorflow/doctorFlow/form">医生信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="doctorFlow" action="${ctx}/doctorflow/doctorFlow/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>create_date：</label>
				<input name="createDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${doctorFlow.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>d_name：</label>
				<form:input path="dName" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>d_code：</label>
				<form:input path="dCode" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>update_date</th>
				<th>remarks</th>
				<th>d_name</th>
				<th>d_code</th>
				<shiro:hasPermission name="doctorflow:doctorFlow:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="doctorFlow">
			<tr>
				<td><a href="${ctx}/doctorflow/doctorFlow/form?id=${doctorFlow.id}">
					<fmt:formatDate value="${doctorFlow.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${doctorFlow.remarks}
				</td>
				<td>
					${doctorFlow.dName}
				</td>
				<td>
					${doctorFlow.dCode}
				</td>
				<shiro:hasPermission name="doctorflow:doctorFlow:edit"><td>
    				<a href="${ctx}/doctorflow/doctorFlow/form?id=${doctorFlow.id}">修改</a>
					<a href="${ctx}/doctorflow/doctorFlow/delete?id=${doctorFlow.id}" onclick="return confirmx('确认要删除该医生信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>