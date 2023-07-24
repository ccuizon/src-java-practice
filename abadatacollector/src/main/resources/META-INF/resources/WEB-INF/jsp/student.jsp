
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h1>Enter User Details</h1>
	<form:form method="post" modelAttribute="student">
		<fieldset class="mb-3">
			<!-- mb stands for margin at the bottom of the field -->
			<form:label path="firstName">First Name</form:label>
			<form:input type="text" path="firstName" required="required" size="20"/>
			<form:errors path="firstName" cssClass="text-warning" />
		</fieldset>

		<fieldset class="mb-3">
			<form:label path="lastName">Last Name</form:label>
			<form:input type="text" path="lastName" required="required" size="20"/>
			<form:errors path="lastName" cssClass="text-warning" />
		</fieldset>
		
		<fieldset class="mb-3">
			<form:label path="birthDate">Birth Date</form:label>
			<form:input type="text" path="birthDate" />
			<form:errors path="birthDate" cssClass="text-warning" />
		</fieldset>

		<form:input type="hidden" path="studentId" />
		<input type="submit" class="btn btn-success" />

	</form:form>
</div>

<%@ include file="common/footer.jspf"%>

<script type="text/javascript">
	$('#birthDate').datepicker({
		format : 'yyyy-mm-dd'
	});
</script>
