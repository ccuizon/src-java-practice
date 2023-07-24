<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h1>Your Targets</h1>
	<table class="table">
		<thead>
			<tr>
				<th>Description</th>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Outcome</th>
				<th>Is Active?</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${targets}" var="target">
				<tr>
					<td>${target.description}</td>
					<td>${target.startDate}</td>
					<td>${target.endDate}</td>
					<td>${target.outcome}</td>
					<td>${target.active}</td>
					<td><a href="delete-target?id=${target.targetId}"
						class="btn btn-warning">Delete</a></td>
					<td><a href="update-target?id=${target.targetId}"
						class="btn btn-success">Update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-target" class="btn btn-success">Add Target</a>
</div>
<%@ include file="common/footer.jspf"%>
