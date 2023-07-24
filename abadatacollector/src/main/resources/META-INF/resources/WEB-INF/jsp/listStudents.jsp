<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h1>List of Students</h1>
	<table class="table">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Birth Date</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${students}" var="student">
				<tr>
					<td>${student.firstName}</td>
					<td>${student.lastName}</td>
					<td>${student.birthDate}</td>
					<td><a href="delete-student?id=${student.studentId}"
						class="btn btn-warning">Delete</a></td>
					<td><a href="update-student?id=${student.studentId}"
						class="btn btn-success">Update</a></td>
					<td><a href="list-targets-from-students-page?id=${student.studentId}" 
						class="btn btn-warning">View Targets</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-student" class="btn btn-success">Add Student</a>
</div>
<%@ include file="common/footer.jspf"%>
