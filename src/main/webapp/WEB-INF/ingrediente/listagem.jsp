<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${titulo}</title>
<c:set var="path" value="${pageContext.request.contextPath}"
	scope="request" />
<style type="text/css">
@IMPORT url("${path}/static/bootstrap/css/bootstrap.min.css");

@IMPORT url("${path}/static/bootstrap/css/bootstrap-theme.min.css");
</style>
</head>
<body>
	<section class="container">
		<table
			class="table table-houver table-condensed table-striped table-bordered ">
			<thead>
				<tr>
					<td>Id</td>
					<td>Nome</td>
					<td>Categoria</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ingredientes}" var="ingrediente">
					<tr>
						<td>${ingrediente.id}</td>
						<td>${ingrediente.nome}</td>
						<td>${ingrediente.categoria}</td>
					</tr>
				</c:forEach>

			</tbody>
			<tfoot>
				<tr>
					<td colspan="3">Ingredientes cadastrados:
						${ingredientes.size()}</td>
				</tr>
			</tfoot>
		</table>
	</section>

</body>
</html>